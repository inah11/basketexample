package com.sachin.rbc.data;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasketItemTest {
    private BasketItem target;

    @Before
    public void setup() {
        final Product product = new Product("Banana", 0.65D);
        target = new BasketItem(product, 1.5D);
    }

    @Test
    public void shouldGetTheProduct() throws Exception {
        //GIVEN
        final Product expectedProduct = new Product("Banana", 0.65D);
        //WHEN
        final Product actualProduct = target.getProduct();
        //THEN
        assertThat(expectedProduct, is(actualProduct));
    }

    @Test
    public void shouldGetTheQuantity() throws Exception {
        //GIVEN
        final double expectedQuantity = 1.5D;
        //WHEN
        final double actualQuantity = target.getQuantity();
        //THEN
        assertThat(actualQuantity, is(expectedQuantity));
    }

    @Test
    public void equalBasketItemsShouldBeEqual() throws Exception {
        //GIVEN
        final BasketItem target2 = new BasketItem(new Product("Banana", 0.65D), 1.5D);
        //WHEN
        final boolean equals = target.equals(target2);
        //THEN
        assertThat(equals, is(true));
    }

    @Test
    public void unequalBasketItemsShouldNotBeEqual() throws Exception {
        //GIVEN
        final BasketItem target2 = new BasketItem(new Product("Banana", 0.65D), 2.0D);
        //WHEN
        final boolean equals = target.equals(target2);
        //THEN
        assertThat(equals, is(false));
    }

    @Test
    public void hashCodeShouldBeEqualForEqualBasketItems() throws Exception {
        //GIVEN
        final BasketItem target2 = new BasketItem(new Product("Banana", 0.65D), 1.5D);
        //WHEN
        final int hashCode = target.hashCode();
        //THEN
        assertThat(hashCode, is(target2.hashCode()));
    }

}