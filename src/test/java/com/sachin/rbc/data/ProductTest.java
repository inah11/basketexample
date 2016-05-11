package com.sachin.rbc.data;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ProductTest {
    private Product target;

    @Before
    public void setup() {
        target = new Product("Banana", 0.65D);
    }

    @Test
    public void shoudlGetTheProductName() throws Exception {
        //GIVEN
        final String expectedProductName = "Banana";
        //WHEN
        final String actualProductName = target.getName();
        //THEN
        assertThat(actualProductName, is(expectedProductName));

    }

    @Test
    public void shouldGetThePricePerUnit() throws Exception {
        //GIVEN
        final double expectedPricePerUnit = 0.65D;
        //WHEN
        final double actualPricePerUnit = target.getPricePerUnit();
        //THEN
        assertThat(actualPricePerUnit, is(expectedPricePerUnit));
    }

    @Test
    public void twoEqualProductsShouldBeEqual() throws Exception {
        //GIVEN
        final Product target2 = new Product("Banana", 0.65D);
        //WHEN
        final boolean equals = target.equals(target2);
        //THEN
        assertThat(equals, is(true));
    }

    @Test
    public void twoUnEqualProductsShouldNotBeEqual() throws Exception {
        //GIVEN
        final Product target2 = new Product("Apple", 0.65D);
        //WHEN
        final boolean equals = target.equals(target2);
        //THEN
        assertThat(equals, is(false));
    }

    @Test
    public void twoEqualProductsShoudHaveAnEqualHashCode() throws Exception {
        //GIVEN
        final Product target2 = new Product("Banana", 0.65D);
        //WHEN
        final int hashCode = target.hashCode();
        //THEN
        assertThat(hashCode, is(target2.hashCode()));
    }

}