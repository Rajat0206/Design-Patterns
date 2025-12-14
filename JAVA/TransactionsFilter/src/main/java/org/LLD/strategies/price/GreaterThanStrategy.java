package org.LLD.strategies.price;

public class GreaterThanStrategy implements PriceComparisonStrategy {
    @Override
    public Boolean compare(Double price1, Double price2) {
        return price1 > price2;
    }
}
