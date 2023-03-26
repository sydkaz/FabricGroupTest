package com.geekheights.app;

import com.geekheights.app.consts.Commands;
import com.geekheights.app.strategy.ResidentConsumptionStrategy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LoadAndParse {

    private static void allot_water_command(String line,Customer customer){
        String[] chunks = line.split(" ");
        if(chunks.length == 3){
            if(chunks[1].equals("2") || chunks[1].equals("3")){
                if(chunks[2].contains(":")){
                    String[] ratioChunks = chunks[2].split(":");
                    customer.setStrategy(ResidentConsumptionStrategy.getStrategy(chunks[1]));
                    customer.setRatio(Double.parseDouble(ratioChunks[0]),Double.parseDouble(ratioChunks[1]));
                } else {
                    throw  new RuntimeException("Missing propotion");
                }
            }
        }else {
            throw  new RuntimeException("Incorrect data format please make sure data is in 'ALLOT_WATER <apartment-type> <a:b>' format");
        }
    }
    private static void add_guests_command(String line,Customer customer){
        String[] chunks = line.split(" ");
        if(chunks.length == 2){
            customer.add(Integer.parseInt(chunks[1]));
        } else
            throw  new RuntimeException("Incorrect data format please make sure data is in ' ADD_GUESTS ##' format");
    }

    public static Customer run(String fileName, Customer customer) {

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((line)->{
                if(line.startsWith(String.valueOf(Commands.ALLOT_WATER))){
                    allot_water_command(line,customer);
                }
                else if(line.startsWith(String.valueOf(Commands.ADD_GUESTS))) {
                    add_guests_command(line,customer);
                }
                else if(line.startsWith(String.valueOf(Commands.BILL))){
                    customer.printBill();
                }
            });
            return customer;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
