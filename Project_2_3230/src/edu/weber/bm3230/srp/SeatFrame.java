package edu.weber.bm3230.srp;

import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

class SeatFrame extends JFrame
{
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private SeatReservation reservation = new SeatReservation();
    private ArrayList<Customer> customers = new ArrayList<Customer>(5);

    public SeatFrame(){
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        setTitle("Seat Reservation");
        for(int j = 0; j < 5; j++){
            customers.add(j, new Customer("Null", "Null", 0.00));
        }
        // The fields used to keep the program GUI intact
        final JLabel title = new JLabel("Seat Reservation Status:");
        final JLabel seatNumber = new JLabel("Seat Number: ");
        final JLabel firstName = new JLabel("First Name: ");
        final JLabel lastName = new JLabel("Last Name: ");

        final JLabel amountPaid = new JLabel("Amount Paid: ");
        final JTextField seatInput = new JTextField();
        final JTextField firstNameInput = new JTextField();
        final JTextField lastNameInput = new JTextField();
        final JTextField amountPaidInput = new JTextField();
        //Reserve Button
        // Quit Button
        add(title);

        JPanel reservationStatusPanel = new JPanel();
        JPanel userInputPanel = new JPanel();
        JPanel seatInfoPanel = new JPanel();

        JPanel seatInfoSeatPanel = new JPanel(new GridLayout(5,1));
        JPanel seatInfoFNamePanel = new JPanel(new GridLayout(5,1));
        JPanel seatInfoLNamePanel = new JPanel(new GridLayout(5,1));
        JPanel seatInfoPaidPanel = new JPanel(new GridLayout(5,1));
        seatInfoSeatPanel.setBackground(Color.LIGHT_GRAY);
        seatInfoSeatPanel.add(new JLabel("0"));
        seatInfoSeatPanel.add(new JLabel("1"));
        seatInfoSeatPanel.add(new JLabel("2"));
        seatInfoSeatPanel.add(new JLabel("3"));
        seatInfoSeatPanel.add(new JLabel("4"));

        //Labeling the first name of each seat.
        JLabel fNameSeat0 = new JLabel(customers.get(0).getFirstName());
        JLabel fNameSeat1 = new JLabel(customers.get(1).getFirstName());
        JLabel fNameSeat2 = new JLabel(customers.get(2).getFirstName());
        JLabel fNameSeat3 = new JLabel(customers.get(3).getFirstName());
        JLabel fNameSeat4 = new JLabel(customers.get(4).getFirstName());

        //Labeling the last name of each customers seat.
        JLabel lNameSeat0 = new JLabel(customers.get(0).getLastName());
        JLabel lNameSeat1 = new JLabel(customers.get(1).getLastName());
        JLabel lNameSeat2 = new JLabel(customers.get(2).getLastName());
        JLabel lNameSeat3 = new JLabel(customers.get(3).getLastName());
        JLabel lNameSeat4 = new JLabel(customers.get(4).getLastName());

        //Labeling the amount each customer paid.
        JLabel amtPaid0 = new JLabel(customers.get(0).getStringAmount());
        JLabel amtPaid1 = new JLabel(customers.get(1).getStringAmount());
        JLabel amtPaid2 = new JLabel(customers.get(2).getStringAmount());
        JLabel amtPaid3 = new JLabel(customers.get(3).getStringAmount());
        JLabel amtPaid4 = new JLabel(customers.get(4).getStringAmount());

        //Adding first name information to panel.
        seatInfoFNamePanel.add(fNameSeat0);
        seatInfoFNamePanel.add(fNameSeat1);
        seatInfoFNamePanel.add(fNameSeat2);
        seatInfoFNamePanel.add(fNameSeat3);
        seatInfoFNamePanel.add(fNameSeat4);

        //Adding last name information to panel.
        seatInfoLNamePanel.add(lNameSeat0);
        seatInfoLNamePanel.add(lNameSeat1);
        seatInfoLNamePanel.add(lNameSeat2);
        seatInfoLNamePanel.add(lNameSeat3);
        seatInfoLNamePanel.add(lNameSeat4);


        //Adding paid price information
        seatInfoPaidPanel.add(amtPaid0);
        seatInfoPaidPanel.add(amtPaid1);
        seatInfoPaidPanel.add(amtPaid2);
        seatInfoPaidPanel.add(amtPaid3);
        seatInfoPaidPanel.add(amtPaid4);


        //colors of application
        seatInfoFNamePanel.setBackground(Color.LIGHT_GRAY);
        seatInfoLNamePanel.setBackground(Color.LIGHT_GRAY);
        seatInfoPaidPanel.setBackground(Color.LIGHT_GRAY);

        //Adding panels to the main panel
        seatInfoPanel.add(seatInfoSeatPanel);
        seatInfoPanel.add(seatInfoFNamePanel);
        seatInfoPanel.add(seatInfoLNamePanel);
        seatInfoPanel.add(seatInfoPaidPanel);

        seatInfoPanel.setLayout(new GridLayout(1,4));
        reservationStatusPanel.setLayout(new GridLayout(1,4));
        userInputPanel.setLayout(new GridLayout(2,5));

        reservationStatusPanel.setBackground(Color.WHITE);
        reservationStatusPanel.setSize(WIDTH, HEIGHT/3);

        //Labeling each text box
        reservationStatusPanel.add(new JLabel("Seat Number: ") , BorderLayout.SOUTH);
        reservationStatusPanel.add(new JLabel("First Name: "), BorderLayout.SOUTH);
        reservationStatusPanel.add(new JLabel("Last Name: "), BorderLayout.SOUTH);
        reservationStatusPanel.add(new JLabel("Amount Paid: "), BorderLayout.SOUTH);

        seatInfoPanel.setSize(WIDTH, HEIGHT/3);

        //Buttons for program
        JButton reserve = new JButton("Reserve");
        reserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = Integer.parseInt(seatInput.getText());
                try {

                    if (reservation.isTaken(choice)) {
                        showMessageDialog(null, "This seat is not empty!");
                    } else {

                        reservation.setSeatTaken(choice);
                        customers.add(choice, new Customer(firstNameInput.getText(), lastNameInput.getText(), Double.parseDouble(amountPaidInput.getText())));

                        switch (choice) {
                            case 0:
                                fNameSeat0.setText(customers.get(choice).getFirstName());
                                lNameSeat0.setText(customers.get(choice).getLastName());
                                amtPaid0.setText(customers.get(choice).getStringAmount());
                                break;
                            case 1:
                                fNameSeat1.setText(customers.get(choice).getFirstName());
                                lNameSeat1.setText(customers.get(choice).getLastName());
                                amtPaid1.setText(customers.get(choice).getStringAmount());
                                break;
                            case 2:
                                fNameSeat2.setText(customers.get(choice).getFirstName());
                                lNameSeat2.setText(customers.get(choice).getLastName());
                                amtPaid2.setText(customers.get(choice).getStringAmount());
                                break;
                            case 3:
                                fNameSeat3.setText(customers.get(choice).getFirstName());
                                lNameSeat3.setText(customers.get(choice).getLastName());
                                amtPaid3.setText(customers.get(choice).getStringAmount());
                                break;
                            case 4:
                                fNameSeat4.setText(customers.get(choice).getFirstName());
                                lNameSeat4.setText(customers.get(choice).getLastName());
                                amtPaid4.setText(customers.get(choice).getStringAmount());
                                break;
                            default:
                        }

                    }

                }catch(IndexOutOfBoundsException exception) {

                    exception.getMessage();
                    showMessageDialog(null, "Please enter a valid seat number!");
                    System.out.println("Invalid Index");
                }
            }
        });

        JButton quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
            }
        });
        userInputPanel.setBackground(Color.WHITE);
        userInputPanel.add(seatNumber);
        userInputPanel.add(firstName);
        userInputPanel.add(lastName);
        userInputPanel.add(amountPaid);
        userInputPanel.add(reserve);
        userInputPanel.add(seatInput);
        userInputPanel.add(firstNameInput);
        userInputPanel.add(lastNameInput);
        userInputPanel.add(amountPaidInput);
        userInputPanel.add(quit);



        add(reservationStatusPanel, BorderLayout.NORTH);
        add(seatInfoPanel, BorderLayout.CENTER);
        add(userInputPanel, BorderLayout.SOUTH);
    }
    public void displaySeatInformation(ArrayList<Customer> customers, SeatReservation reservation){

    }

}


