package com.test.strategy;

import com.test.Rental;

/**
 * Created by mjiang on 10/06/16.
 */
public class RegularMoiveAmountStrategy implements MovieAmountStrategy {

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }

        return amount;
    }
}
