package com.test.strategy;

import com.test.Rental;

/**
 * Created by mjiang on 10/06/16.
 */
public class ChildrenMoiveAmountStrategy implements MovieAmountStrategy {

    @Override
    public double calculateAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }
}
