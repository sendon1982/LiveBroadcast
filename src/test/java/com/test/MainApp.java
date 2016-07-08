package com.test;

import com.test.strategy.ChildrenMoiveAmountStrategy;
import com.test.strategy.NewReleaseMoiveAmountStrategy;
import com.test.strategy.RegularMoiveAmountStrategy;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by mjiang on 10/06/16.
 */
public class MainApp {

    public static void main(String[] args) {

        Customer customer = new Customer("Wings");
        customer.addRental(new Rental(new Movie("Matrix", Movie.REGULAR, new RegularMoiveAmountStrategy()), 1));
        customer.addRental(new Rental(new Movie("Warcraft III", Movie.NEW_RELEASE, new NewReleaseMoiveAmountStrategy()), 2));
        customer.addRental(new Rental(new Movie("Kids", Movie.CHILDREN, new ChildrenMoiveAmountStrategy()), 3));

        System.out.print(customer.createSummaryStatement());
    }

    void printOwing() {

        Vector _orders = new Vector();
        String _name = "";

        Enumeration e = _orders.elements();
        double outstanding = 0.0;

        // print banner
        printBanner();

        outstanding = calculateOutStanding(e, outstanding);

        //print details
        printDetails(_name, outstanding);
    }

    private void printBanner() {
        System.out.println("**************************");
        System.out.println("***** Customer Owes ******");
        System.out.println("**************************");
    }

    private double calculateOutStanding(Enumeration e, double outstanding) {
        // calculate outstanding
        while (e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    private void printDetails(String _name, double outstanding) {
        System.out.println("name:" + _name);
        System.out.println("amount" + outstanding);
    }

    private class Order {

        private double amount;

        public double getAmount() {
            return amount;
        }
    }


    int gamma (int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).invoke();
    }

    private int delta() {
        return 1;
    }

    private class Gamma {
        private MainApp gamma;
        private int inputVal;
        private int quantity;
        private int yearToDate;

        public Gamma(MainApp gamma, int inputVal, int quantity, int yearToDate) {
            this.gamma = gamma;
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }

        public int invoke() {
            int importantValue1 = (inputVal * quantity) + delta();
            int importantValue2 = (inputVal * yearToDate) + 100;
            if ((yearToDate - importantValue1) > 100)
                importantValue2 -= 20;
            int importantValue3 = importantValue2 * 7;
            // and so on.
            return importantValue3 - 2 * importantValue1;
        }
    }
}
