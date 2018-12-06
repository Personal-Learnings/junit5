package com.sample.kata;


import java.util.Arrays;

public class CalculatorKata {
    public int calculate(String input) {

        int sum = 0;

        if(null == input || input.equals("")) {
            return sum;
        }
        else if(input.contains("-")) {
            throw new NumberFormatException("Cannot Calculate Negative Numbers");
        }
        else {
            String delimiter = getDelimiter(input);

            if(input.startsWith("//")) input = input.replaceFirst("//" + delimiter, "");

            String [] numbers = input.split(delimiter);
            return (numbers.length == 1)
                    ? new Integer(numbers[0])
                    : Arrays.stream(numbers).filter(i -> Integer.parseInt(i.trim()) <=1000).mapToInt(i -> Integer.parseInt(i.trim())).sum();
        }
    }

    private String getDelimiter(String input) {

        String delimiter = "";
        if(input.startsWith("//")) {

            for(int i = 0; i<input.length(); i++) {

                try {
                    Integer.parseInt(input.substring(i, i + 1));
                    break;
                }
                catch (NumberFormatException e) {
                    delimiter = delimiter + input.substring(i, i + 1);
                }
            }
            delimiter = delimiter.replace("//","");
        }
        else {
            delimiter = "[/\n,]";
        }
        return delimiter;
    }
}
