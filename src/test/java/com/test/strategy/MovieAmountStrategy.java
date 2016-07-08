package com.test.strategy;

import com.test.Rental;

/**
 * Created by mjiang on 10/06/16.
 */
public interface MovieAmountStrategy {

    public double calculateAmount(int daysRented);
}
