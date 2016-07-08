package com.test;

import com.test.strategy.MovieAmountStrategy;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    private MovieAmountStrategy strategy;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public Movie(String title, int priceCode, MovieAmountStrategy strategy) {
        this.title = title;
        this.priceCode = priceCode;
        this.strategy = strategy;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double getTotalCharge(int daysRented) {
        double amount = strategy.calculateAmount(daysRented);
        return amount;
    }

}
