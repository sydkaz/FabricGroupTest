package com.geekheights.app;

public class Main {
    public static void main(String[] args) {
        if(args.length  == 1)
        {
            String fileName = args[0]; //"src/test/java/resources/correctData/sample1.txt"

            final Customer customer = new Customer();
            LoadAndParse.run(fileName,customer);
        } else {
            System.out.println("Please provide valid file path i.e src/test/java/resources/correctData/sample1.txt");
        }
    }


}
