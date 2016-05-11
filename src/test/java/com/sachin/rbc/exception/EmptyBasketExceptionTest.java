package com.sachin.rbc.exception;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class EmptyBasketExceptionTest {

    private EmptyBasketException target;

    @Test
    public void shouldTestTheExcetionIsCreatedCorrectly() {
        //GIVEN
        String errorMessage = "The basket is empty";
        target = new EmptyBasketException(errorMessage);
        //WHEN
        String actualMessage = target.getMessage();
        //THEN
        assertThat(actualMessage, is(errorMessage));
    }

}