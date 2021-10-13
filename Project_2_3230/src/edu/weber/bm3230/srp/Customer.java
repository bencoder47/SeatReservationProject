package edu.weber.bm3230.srp;

public class Customer {
    private String firstName;
    private String lastName;
    private double amountPaid;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
    public Customer(){}

    public Customer(String firstName, String lastName, double amountPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountPaid = amountPaid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getStringAmount(){
       return "$" + Double.toString(amountPaid);
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " Paid: " + amountPaid;
    }
    //Methods to add somewhere valid
    //    //ReserveSeat
    //    //Check if empty
    //    //Make seat empty


}
