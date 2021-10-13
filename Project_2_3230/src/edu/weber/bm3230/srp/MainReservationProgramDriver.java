package edu.weber.bm3230.srp;

import javax.swing.*;
import java.awt.*;


//Main Driver
//Written by Benjamin Medrano
//This program can check to see if any of the 5 seats are empty
//This program can check if the seat is not a valid seat
//This program can assign names and prices to a seat

public class MainReservationProgramDriver {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SeatFrame frame = new SeatFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.getContentPane().setBackground(Color.BLACK);
            }
        });
    }
}
