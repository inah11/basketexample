package com.sachin.rbc.data;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public final class Product {
    private final String name;
    private final double pricePerUnit;


    public Product(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(getPricePerUnit(), product.getPricePerUnit())
                .append(getName(), product.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(getName())
                .append(getPricePerUnit())
                .toHashCode();
    }
}
