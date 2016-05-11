package com.sachin.rbc.data;

import com.sachin.rbc.exception.EmptyBasketException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class Basket {
    private final List<BasketItem> basketItems;

    public Basket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public final List<BasketItem> getBasketItems() {
        if (basketItems == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(basketItems);
    }

    /**
     * Total calculation is here to keep the domain model enriched.
     *
     * @return The grand total of the basket at any given point
     */
    public final double getTotal() {
        if (basketItems == null || basketItems.size() == 0) {
            throw new EmptyBasketException("The basket is empty");
        }
        Function<BasketItem, BigDecimal> totalMapper = basketItem -> {
            BigDecimal pricePerUnit = BigDecimal.valueOf(basketItem.getProduct().getPricePerUnit());
            BigDecimal quantity = BigDecimal.valueOf(basketItem.getQuantity());
            BigDecimal totalPriceOfABasketItem = pricePerUnit.multiply(quantity);
            totalPriceOfABasketItem.setScale(2, BigDecimal.ROUND_HALF_UP);
            return totalPriceOfABasketItem;
        };

        BigDecimal result = basketItems.parallelStream()
                .map(totalMapper).reduce(BigDecimal.ZERO, BigDecimal::add);
        result.setScale(2, BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();
    }
}
