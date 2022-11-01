import javax.swing.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MovieReservationPage extends JFrame{
    private JPanel seatReservationPanel;
    private JLabel total;
    private JLabel tickets;
    private JLabel seats;
    private JButton bookNowButton;
    private JButton R1S1;
    private JButton R1S2;
    private JButton R1S3;
    private JButton R1S4;
    private JButton R1S5;
    private JButton R1S6;
    private JButton R1S7;
    private JButton R1S8;
    private JButton R1S9;
    private JButton R1S10;
    private JButton R2S1;
    private JButton R2S2;
    private JButton R2S3;
    private JButton R2S4;
    private JButton R2S5;
    private JButton R2S6;
    private JButton R2S7;
    private JButton R2S8;
    private JButton R2S9;
    private JButton R2S10;
    private JButton R4S1;
    private JButton R4S2;
    private JButton R4S3;
    private JButton R4S4;
    private JButton R4S5;
    private JButton R4S6;
    private JButton R4S7;
    private JButton R4S8;
    private JButton R5S1;
    private JButton R5S2;
    private JButton R5S3;
    private JButton R5S4;
    private JButton R5S5;
    private JButton R5S6;
    private JButton R5S7;
    private JButton R5S8;
    private JButton R5S9;
    private JButton R5S10;
    private JButton R6S1;
    private JButton R6S2;
    private JButton R6S3;
    private JButton R6S4;
    private JButton R6S5;
    private JButton R6S6;
    private JButton R6S7;
    private JButton R6S8;
    private JButton R6S9;
    private JButton R6S10;
    private JButton R7S1;
    private JButton R7S2;
    private JButton R7S3;
    private JButton R7S4;
    private JButton R7S5;
    private JButton R7S6;
    private JButton R7S7;
    private JButton R7S8;
    private JButton R7S9;
    private JButton R7S10;
    private JButton R8S1;
    private JButton R8S2;
    private JButton R8S3;
    private JButton R8S4;
    private JButton R8S5;
    private JButton R8S6;
    private JButton R8S7;
    private JButton R8S8;
    private JButton R8S9;
    private JButton R8S10;
    private JButton R9S1;
    private JButton R9S2;
    private JButton R9S3;
    private JButton R9S4;
    private JButton R9S5;
    private JButton R9S6;
    private JButton R9S7;
    private JButton R9S8;
    private JButton R9S9;
    private JButton R9S10;
    private JButton R10S3;
    private JButton R10S4;
    private JButton R10S5;
    private JButton R10S6;
    private JButton R10S7;
    private JButton R10S8;

    private int totalPrice=0;
    private int noOfSeats=0;
    private ArrayList<Integer> selectedSeats=new ArrayList<>();
    private ArrayList<Integer> SoldSeats=new ArrayList<>();
    private ArrayList<String> reservedSeats=new ArrayList<>();
    private ArrayList<JButton>allSeats=new ArrayList<JButton>(Arrays.asList(R1S1,R1S2,R1S3,R1S4,
            R1S5,R1S6,R1S7,R1S8,R1S9,R1S10,R2S1,R2S2,R2S3,R2S4,R2S5,R2S6,R2S7,R2S8,R2S9,R2S10,R4S1,R4S2,R4S3,R4S4,
            R4S5,R4S6,R4S7,R4S8,R5S1,R5S2,R5S3,R5S4,R5S5,R5S6,R5S7,R5S8,R5S9,R5S10,R6S1,R6S2,R6S3,R6S4,R6S5,R6S6,R6S7,
            R6S8,R6S9,R6S10,R7S1,R7S2,R7S3,R7S4,R7S5,R7S6,R7S7,R7S8,R7S9,R7S10,R8S1,R8S2,R8S3,R8S4,R8S5,R8S6,R8S7,R8S8,
            R8S9,R8S10,R9S1,R9S2,R9S3,R9S4,R9S5,R9S6,R9S7,R9S8,R9S9,R9S10,R10S3,R10S4,R10S5,R10S6,R10S7,R10S8));

    private final Color available=new Color(192, 192, 192);
    private final Color sold=new Color(255,0,0);
    private final Color selected=new Color(0,255,0);

    private void buttonAction (String seatName,int seatNo,int seatPrice){
        if(allSeats.get(seatNo).getBackground().getRGB()==available.getRGB()){
            allSeats.get(seatNo).setBackground(selected);
            noOfSeats++;
            totalPrice=totalPrice+seatPrice;
            reservedSeats.add(seatName);
            tickets.setText(": "+ noOfSeats);
            total.setText(": $"+ totalPrice);
        }
        else if (allSeats.get(seatNo).getBackground().getRGB()==selected.getRGB()) {
            allSeats.get(seatNo).setBackground(available);
            noOfSeats--;
            totalPrice = totalPrice - seatPrice;
            reservedSeats.remove(seatName);
            tickets.setText(":" + noOfSeats);
            total.setText(":$" + totalPrice);
        }
    }
    public MovieReservationPage() throws IOException {
        setContentPane(seatReservationPanel);
        setSize(800, 600);
        setTitle("Movie Seat Reservation Page");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bookNowButton.addActionListener(e -> {
            if(!bookNowButton.getText().equals("HouseFull"))
            {
                for(int ex:selectedSeats){
                    allSeats.get(ex).setBackground(sold);
                    SoldSeats.add(ex);
                }
                JOptionPane.showMessageDialog(null," Seats booked for $"+totalPrice);
                noOfSeats=0;
                totalPrice=0;
                reservedSeats.clear();
                selectedSeats.clear();
                tickets.setText(" :" + noOfSeats);
                total.setText(" :$" + totalPrice);
                if(SoldSeats.size()==84){
                    bookNowButton.setText("HouseFull");
                }
            }
        }
        );

        R1S1.addActionListener(e -> buttonAction("R1S1",1,12));
        R1S2.addActionListener(e -> buttonAction("R1S2",2,12));
        R1S3.addActionListener(e -> buttonAction("R1S3",3,12));
        R1S4.addActionListener(e -> buttonAction("R1S4",4,12));
        R1S5.addActionListener(e -> buttonAction("R1S5",5,12));
        R1S6.addActionListener(e -> buttonAction("R1S6",6,12));
        R1S7.addActionListener(e -> buttonAction("R1S7",7,12));
        R1S8.addActionListener(e -> buttonAction("R1S8",8,12));
        R1S9.addActionListener(e -> buttonAction("R1S9",9,12));
        R1S10.addActionListener(e -> buttonAction("R1S10",10,12));
        R2S1.addActionListener(e -> buttonAction("R2S1",11,12));
        R2S2.addActionListener(e -> buttonAction("R2S2",12,12));
        R2S3.addActionListener(e -> buttonAction("R2S3",13,12));
        R2S4.addActionListener(e -> buttonAction("R2S4",14,12));
        R2S5.addActionListener(e -> buttonAction("R2S5",15,12));
        R2S6.addActionListener(e -> buttonAction("R2S6",16,12));
        R2S7.addActionListener(e -> buttonAction("R2S7",17,12));
        R2S8.addActionListener(e -> buttonAction("R2S8",18,12));
        R2S9.addActionListener(e -> buttonAction("R2S9",19,12));
        R2S10.addActionListener(e -> buttonAction("R2S10",20,12));
        R4S1.addActionListener(e -> buttonAction("R4S1",21,12));
        R4S2.addActionListener(e -> buttonAction("R4S2",22,12));
        R4S3.addActionListener(e -> buttonAction("R4S3",23,12));
        R4S4.addActionListener(e -> buttonAction("R4S4",24,12));
        R4S5.addActionListener(e -> buttonAction("R4S5",25,12));
        R4S6.addActionListener(e -> buttonAction("R4S6",26,12));
        R4S7.addActionListener(e -> buttonAction("R4S7",27,12));
        R4S8.addActionListener(e -> buttonAction("R4S8",28,12));
        R5S1.addActionListener(e -> buttonAction("R5S1",29,12));
        R5S2.addActionListener(e -> buttonAction("R5S2",30,12));
        R5S3.addActionListener(e -> buttonAction("R5S3",31,12));
        R5S4.addActionListener(e -> buttonAction("R5S4",32,12));
        R5S5.addActionListener(e -> buttonAction("R5S5",33,12));
        R5S6.addActionListener(e -> buttonAction("R5S6",34,12));
        R5S7.addActionListener(e -> buttonAction("R5S7",35,12));
        R5S8.addActionListener(e -> buttonAction("R5S8",36,12));
        R5S9.addActionListener(e -> buttonAction("R5S9",37,12));
        R5S10.addActionListener(e -> buttonAction("R5S10",38,12));
        R6S1.addActionListener(e -> buttonAction("R6S1",39,12));
        R6S2.addActionListener(e -> buttonAction("R6S2",40,12));
        R6S3.addActionListener(e -> buttonAction("R6S3",41,12));
        R6S4.addActionListener(e -> buttonAction("R6S4",42,12));
        R6S5.addActionListener(e -> buttonAction("R6S5",43,12));
        R6S6.addActionListener(e -> buttonAction("R6S6",44,12));
        R6S7.addActionListener(e -> buttonAction("R6S7",45,12));
        R6S8.addActionListener(e -> buttonAction("R6S8",46,12));
        R6S9.addActionListener(e -> buttonAction("R6S9",47,12));
        R6S10.addActionListener(e -> buttonAction("R6S10",48,12));
        R7S1.addActionListener(e -> buttonAction("R7S1",49,12));
        R7S2.addActionListener(e -> buttonAction("R7S2",50,12));
        R7S3.addActionListener(e -> buttonAction("R7S3",51,12));
        R7S4.addActionListener(e -> buttonAction("R7S4",52,12));
        R7S5.addActionListener(e -> buttonAction("R7S5",53,12));
        R7S6.addActionListener(e -> buttonAction("R7S6",54,12));
        R7S7.addActionListener(e -> buttonAction("R7S7",55,12));
        R7S8.addActionListener(e -> buttonAction("R7S8",56,12));
        R7S9.addActionListener(e -> buttonAction("R7S9",57,12));
        R7S10.addActionListener(e -> buttonAction("R7S10",58,12));
        R8S1.addActionListener(e -> buttonAction("R8S1",58,12));
        R8S2.addActionListener(e -> buttonAction("R8S2",60,12));
        R8S3.addActionListener(e -> buttonAction("R8S3",61,12));
        R8S4.addActionListener(e -> buttonAction("R8S4",62,12));
        R8S5.addActionListener(e -> buttonAction("R8S5",63,12));
        R8S6.addActionListener(e -> buttonAction("R8S6",64,12));
        R8S7.addActionListener(e -> buttonAction("R8S7",65,12));
        R8S8.addActionListener(e -> buttonAction("R8S8",66,12));
        R8S9.addActionListener(e -> buttonAction("R8S9",67,12));
        R8S10.addActionListener(e -> buttonAction("R8S10",68,12));
        R9S1.addActionListener(e -> buttonAction("R9S1",69,12));
        R9S2.addActionListener(e -> buttonAction("R9S2",70,12));
        R9S3.addActionListener(e -> buttonAction("R9S3",71,12));
        R9S4.addActionListener(e -> buttonAction("R9S4",72,12));
        R9S5.addActionListener(e -> buttonAction("R9S5",73,12));
        R9S6.addActionListener(e -> buttonAction("R9S6",74,12));
        R9S7.addActionListener(e -> buttonAction("R9S7",75,12));
        R9S8.addActionListener(e -> buttonAction("R9S8",76,12));
        R9S9.addActionListener(e -> buttonAction("R9S9",77,12));
        R9S10.addActionListener(e -> buttonAction("R9S10",78,12));
        R10S3.addActionListener(e -> buttonAction("R10S3",79,20));
        R10S4.addActionListener(e -> buttonAction("R10S4",80,20));
        R10S5.addActionListener(e -> buttonAction("R10S5",81,20));
        R10S6.addActionListener(e -> buttonAction("R10S6",82,20));
        R10S7.addActionListener(e -> buttonAction("R10S7",83,20));
        R10S8.addActionListener(e -> buttonAction("R10S8",84,20));
    }

}
