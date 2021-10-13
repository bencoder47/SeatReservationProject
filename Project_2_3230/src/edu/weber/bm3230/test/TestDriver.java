package edu.weber.bm3230.test;

import edu.weber.bm3230.srp.Customer;
import edu.weber.bm3230.srp.SeatReservation;

import java.util.ArrayList;

public class TestDriver {


    public static void main(String[] args) {
        ArrayList<Customer> testCustomers = new ArrayList<Customer>(5);
        SeatReservation testSeats = new SeatReservation();
        //Setting all testCustomers first name to Jack, last name to Black, and amount paid to $21.00
        for(int i = 0; i < 5; i++){
            testCustomers.add(i, new Customer("Jack", "Black", 21.00) );
            System.out.println("Initial customer " + i + ":" + testCustomers.get(i).toString());
        }

        System.out.println("TESTING CUSTOMER MANIPULATION");
        //Testing to see if all customers can be changed from Jack Black to Black Jack and amount to 17
        for(int i = 0; i < 5; i++){
            testCustomers.set(i, new Customer("Black", "Jack", 17.00));
            System.out.println("Changed customer " + i + ":" + testCustomers.get(i).toString());
        }

        System.out.println();

        System.out.println("TESTING Seat Reservation from EMPTY to TAKEN");
        for(int i = 0; i < 5; i++){
            System.out.println("Seat " + i + ": " +testSeats.getSeat(i));
        }
        System.out.println("SETTINGS SEATS TO TAKEN");
        for(int i = 0; i < 5; i++){
            testSeats.setSeatTaken(i);
            System.out.println("Seat " + i + ": " +testSeats.getSeat(i));
        }
        System.out.println("END OF TESTING");
    }


}
