package com.tdd.calculator;

import java.util.Arrays;
import java.util.function.ToIntFunction;

import static java.lang.Integer.parseInt;

public class CalculatorValidator implements ToIntFunction<String> {

    @Override
    public int applyAsInt(String numbers) {
        if(numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.contains(",")){
            String[] arr = numbers.split("[/!\"#$%&'*+,.:;=?@^_`|-~\n]");
            StringBuilder negatives = new StringBuilder();
            int[] intArray = Arrays.stream(arr).mapToInt(num -> (num.isEmpty()||parseInt(num)>1000) ? 0 : parseInt(num)).toArray();
            for (int a:intArray) {
                if(a<0){
                    negatives.append(a).append(" ");
                }
            }
            return Arrays.stream(intArray)
                    .filter(num -> {
                        try{
                            if(negatives.length() > 0){
                                throw new RuntimeException();
                            }
                            return true;
                        }catch (RuntimeException exception){
                            throw new RuntimeException(String.valueOf(negatives));
                        }
                    })
                    .sum();
        }
        else {
            return parseInt(numbers);
        }
    }
}
