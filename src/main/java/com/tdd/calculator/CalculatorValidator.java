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
            return Arrays.stream(arr).mapToInt(num -> num.isEmpty() ? 0 : parseInt(num)).sum();
        }
        else {
            return parseInt(numbers);
        }
    }
}
