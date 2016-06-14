package com.test;

/**
 * Created by mjiang on 10/06/16.
 */
public class MainApp {

    public static void main(String[] args) {

        Customer customer = new Customer("Wings");
        customer.addRental(new Rental(new Movie("Matrix", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("Warcraft III", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Kids", Movie.CHILDREN), 3));

        System.out.print(customer.createSummaryStatement());
    }

}
