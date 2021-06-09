package com.tdd.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private CalculatorValidator calValidator;

    @Before
    public void setUp(){
        calValidator = new CalculatorValidator();
    }

    @Test
    public void validateCalculatorForEmptyString(){
        assertEquals(0, calValidator.add(""));
    }

    @Test
    public void outputForStringWithOneNumber(){
        assertEquals(1, calValidator.add("1"));
    }

    @Test
    public void sumOfTwoNumbersDelimitedByComma(){
        assertEquals(3, calValidator.add("1,2"));
    }


}
