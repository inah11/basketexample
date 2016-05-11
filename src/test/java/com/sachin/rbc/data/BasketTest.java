package com.sachin.rbc.data;

import com.sachin.rbc.exception.EmptyBasketException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class BasketTest {
    private Basket target;

    @Before
    public void setup() {
        final List<BasketItem> basketItems = prepareBasketItems();
        target = new Basket(basketItems);
    }

    private List<BasketItem> prepareBasketItems() {
        final List<BasketItem> basketItemList = new ArrayList<>();
        basketItemList.add(new BasketItem(new Product("Banana", 6D), 0.12D));
        basketItemList.add(new BasketItem(new Product("Orange", 12D), 0.10D));
        basketItemList.add(new BasketItem(new Product("Apple", 6D), 0.15D));
        basketItemList.add(new BasketItem(new Product("Lemon", 6D), 0.05D));
        basketItemList.add(new BasketItem(new Product("Peach", 6D), 0.07D));
        return basketItemList;
    }

    @Test
    public void getBasketItems() throws Exception {
        //GIVEN
        final List<BasketItem> expectedBasketItems = prepareBasketItems();
        //WHEN
        final List<BasketItem> actualBasketItems = target.getBasketItems();
        //THEN
        assertThat(actualBasketItems, is(expectedBasketItems));
    }

    @Test
    public void getTotal() throws Exception {
        //GIVEN
        final double expectedTotal = 3.54D;
        //WHEN
        double actualTotal = target.getTotal();
        //THEN
        assertThat(actualTotal, is(expectedTotal));
    }

    @Test
    public void shouldReturnEmptyListIfTheBasketIsEmpty() {
        //GIVEN
        final Basket emptyBasket = new Basket(new ArrayList<>());
        //WHEN
        final List<BasketItem> emptyBasketItems = emptyBasket.getBasketItems();
        //THEN
        assertThat(emptyBasketItems, notNullValue());
        assertThat(emptyBasketItems.size(), is(0));
    }

    @Test
    public void shouldReturnEmptyListIfTheBasketIsCreatedWithNullBasketItemList() {
        //GIVEN
        final Basket emptyBasket = new Basket(null);
        //WHEN
        final List<BasketItem> emptyBasketItems = emptyBasket.getBasketItems();
        //THEN
        assertThat(emptyBasketItems, notNullValue());
        assertThat(emptyBasketItems.size(), is(0));
    }

    @Test(expected = EmptyBasketException.class)
    public void shouldThrowEmptyBasketExceptionIfTheBasketIsEmpty() {
        //GIVEN
        final Basket emptyBasket = new Basket(new ArrayList<>());
        //WHEN
        emptyBasket.getTotal();
        //THEN
        //NOOP
    }

    @Test (expected = EmptyBasketException.class)
    public void shouldThrowEmptyBasketExceptionIfTheBasketIsCreatedWithNullBasketItemList() {
        //GIVEN
        final Basket emptyBasket = new Basket(null);
        //WHEN
        emptyBasket.getTotal();
        //THEN
        //NOOP
    }


}