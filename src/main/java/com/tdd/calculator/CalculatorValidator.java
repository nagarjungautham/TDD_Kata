package com.tdd.calculator;

public class CalculatorValidator {
    public int add(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.contains(",")){
            String[] arr = numbers.split(",");
            return Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
        }
        else {
            return Integer.parseInt(numbers);
        }
    }
}
