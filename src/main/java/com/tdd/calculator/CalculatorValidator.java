package com.tdd.calculator;

import java.util.Arrays;
import java.util.function.ToIntFunction;

import static java.lang.Integer.parseInt;

public class CalculatorValidator implements ToIntFunction<String> {

    @Override
    public int applyAsInt(String numbers) {
        if(numbers.contains(",")){
            String[] arr = numbers.split("[/!\"#$%&'*+,.:;=?@^_`|-~\n]");
            int[] intArray = Arrays.stream(arr).mapToInt(num -> (num.isEmpty()||parseInt(num)>1000) ? 0 : parseInt(num)).toArray();

            //To get Negative Numbers and Throw exception
            StringBuilder negatives = new StringBuilder();
            for (int a:intArray) if(a<0) negatives.append(a).append(" ");
            if(negatives.length() > 0) throw new RuntimeException(String.valueOf(negatives));

            //Return sum of numbers
            return Arrays.stream(intArray).sum();
        }
        else {
            //For empty string and single value
            ToIntFunction<String> defaultValue = a -> a.isEmpty() ? 0 : parseInt(a);
            return defaultValue.applyAsInt(numbers);
        }
    }
}
