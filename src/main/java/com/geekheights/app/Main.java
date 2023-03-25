package com.geekheights.app;

import com.geekheights.app.consts.AppConstants;
import com.geekheights.app.consts.Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/test/java/resources/correctData/sample1.txt";

        final Customer customer = new Customer();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach((line)->{
                if(line.startsWith(String.valueOf(Commands.ALLOT_WATER))){
                    //System.out.println(line);
                    String[] chunks = line.split(" ");
                    if(chunks.length == 3){
                        if(chunks[1].equals("2"/*AppConstants.fromAppConstantstoString(AppConstants._2BHK)*/)){
                                if(chunks[2].contains(":")){
                                    String[] ratioChunks = chunks[2].split(":");
                                    customer.setStrategy(ResidentConsumptionStrategy._2BHKStrategy());
                                    customer.setRatio(Double.parseDouble(ratioChunks[0]),Double.parseDouble(ratioChunks[1]));
                                } else {
                                    throw  new RuntimeException("Missing propotion");
                                }
                        }
                        if(chunks[1].equals(AppConstants._3BHK.name())){
                            if(chunks[2].contains(":")){
                                String[] ratioChunks = chunks[2].split(":");
                                customer.setStrategy(ResidentConsumptionStrategy._3BHKStrategy());
                                customer.setRatio(Double.parseDouble(ratioChunks[0]),Double.parseDouble(ratioChunks[1]));
                            } else {
                                throw  new RuntimeException("Missing propotion");
                            }
                        }
                    }
                }
                else if(line.startsWith(String.valueOf(Commands.ADD_GUESTS))) {
                    String[] chunks = line.split(" ");
                    if(chunks.length == 2){
                        customer.add(Integer.parseInt(chunks[1]));
                        customer.setTotalGuests(customer.getTotalGuests() +  Integer.parseInt(chunks[1]));
                    }
                }
                else if(line.startsWith(String.valueOf(Commands.BILL))){
                    System.out.println(customer);
                    customer.printBill();
                }

                //System.out.println(customer);
            });



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
