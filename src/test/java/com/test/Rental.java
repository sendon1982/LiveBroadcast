package com.test;

import com.test.strategy.MovieAmountStrategy;
import com.test.strategy.MovieAmountStrategyFactory;

/**
 * Created by mjiang on 9/06/16.
 */
public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }


    public double calculateMovieAmount() {
        MovieAmountStrategy movieAmountStrategy = MovieAmountStrategyFactory.create(this);
        return movieAmountStrategy.calculateAmount(this);
    }

    public int calculateFrequentPoints() {
        // add frequent renter points
        int frequentRenterPoints = 1;

        // add bonus for a two day new release rental
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDaysRented() > 1) {
            frequentRenterPoints++;
        }

        return frequentRenterPoints;
    }

}
