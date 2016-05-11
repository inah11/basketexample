package com.sachin.rbc.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public final class BasketItem {
    final private Product product;
    final double quantity;

    public BasketItem(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof BasketItem)) return false;

        BasketItem that = (BasketItem) o;

        return new EqualsBuilder()
                .append(getQuantity(), that.getQuantity())
                .append(getProduct(), that.getProduct())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getProduct())
                .append(getQuantity())
                .toHashCode();
    }
}
