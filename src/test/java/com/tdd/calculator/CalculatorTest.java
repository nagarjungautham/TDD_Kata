package com.tdd.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private CalculatorValidator calValidator;

    @Before
    public void setUp(){
        calValidator = new CalculatorValidator();
    }

    @Test
    public void validateCalculatorForEmptyString(){
        assertEquals(0, calValidator.applyAsInt(""));
    }

    @Test
    public void outputForStringWithOneNumber(){
        assertEquals(1, calValidator.applyAsInt("1"));
    }

    @Test
    public void sumOfTwoNumbersDelimitedByComma(){
        assertEquals(3, calValidator.applyAsInt("1,2"));
    }

    @Test
    public void sumOfMultipleNumbersDelimitedByComma(){
        assertEquals(6, calValidator.applyAsInt("1,2,3"));
    }

    @Test
    public void acceptNewLineAndCommaDelimiter(){
        assertEquals(6, calValidator.applyAsInt("1,2\n3"));
    }

    @Test
    public void acceptNewLineAndColonDelimiter(){
        assertEquals(6, calValidator.applyAsInt("1:2\n3"));
    }

    @Test
    public void acceptDifferentDelimiter(){
        assertEquals(6, calValidator.applyAsInt("//;://1.:?,2\n3.;'"));
    }

    @Test
    public void ignoreNumberGreaterThan1000(){
        assertEquals(2, calValidator.applyAsInt("\n2,1001"));
    }

    @Test
    public void shouldGiveExceptionForNegative(){
        try{
            calValidator.applyAsInt("-1,2,-3");
        }catch (RuntimeException exception){
            System.out.println("Caught exception: Negative value "+exception.getMessage()+"is not allowed");
        }
    }

}
