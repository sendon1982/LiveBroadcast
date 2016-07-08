package com.test.strategy;

import com.test.Rental;

/**
 * Created by mjiang on 10/06/16.
 */
public class NewReleaseMoiveAmountStrategy implements MovieAmountStrategy {

    @Override
    public double calculateAmount(int daysRented) {
        double amount = daysRented * 3;
        return amount;
    }
}
