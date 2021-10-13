package edu.weber.bm3230.srp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SeatReservation
{
    private ArrayList<String> seats = new ArrayList<String>(5);
    private int seatAmount = 5;

    public SeatReservation() {
        System.out.println("Seats: ");
        for(int i = 0; i < seatAmount; i++){
           this.seats.add(i, "Empty");
        }
        System.out.println(seats);
    }

    public String getSeat(int i){
        return seats.get(i);
    }
    public void setSeatEmpty(int i){
        seats.set(i, "Empty" );
    }
    public void setSeatTaken(int i ){
        seats.set(i, "Taken");
    }

    public boolean isTaken(int i){
        return seats.get(i) == "Taken";
    }





}
