package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mjiang on 9/06/16.
 */
public class Customer {

    private String name;

    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public double getTotalRentalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.calculateMovieAmount();
        }

        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.calculateFrequentPoints();
        }

        return frequentRenterPoints;
    }

    public String createSummaryStatement() {

        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.calculateMovieAmount() + "\n";
        }

        //add footer lines
        result += "Amount owed is " + getTotalRentalAmount() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    public String createHtmlSummaryStatement() {

        String result = "<H1>Rentals for <EM>" + getName() + "</EM></ H1><P>\n";

        for (Rental rental : rentals) {
            //show figures for each rental
            result += rental.getMovie().getTitle()+ ": " + String.valueOf(rental.calculateMovieAmount()) + "<BR>\n";
        }
        //add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalRentalAmount()) +
                        "</EM><P>\n";
        result += "On this rental you earned <EM>" + getFrequentRenterPoints() + "</EM> frequent renter points<P>";

        return result;
    }


}
