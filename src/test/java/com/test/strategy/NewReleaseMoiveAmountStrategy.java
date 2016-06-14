package com.test.strategy;

import com.test.Rental;

/**
 * Created by mjiang on 10/06/16.
 */
public class NewReleaseMoiveAmountStrategy implements MovieAmountStrategy {

    @Override
    public double calculateAmount(Rental rental) {
        double amount = rental.getDaysRented() * 3;
        return amount;
    }
}
