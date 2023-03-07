package org.TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

//package org.TicTacToeGame;

public class TicTacToe implements ActionListener{

    //we'll determine who's turn is next randomly
    Random random = new Random();
    JFrame frame = new JFrame();

    //creates panel to hold the title.
    JPanel title_panel = new JPanel();

    //Another panel to hold all the buttons
    JPanel button_panel = new JPanel();

    /*label to serve as text field to display message
       of some sort of Jlabel  */
    JLabel textfield = new JLabel();

    //array of 9 jbutton .
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
//    boolean player2_turn;


    //below we create a constructor of this class
     public TicTacToe(){
       //we'll start with creating the JFrame first.
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(800,800);//sets the size
         frame.getContentPane().setBackground(Color.ORANGE); //sets the color -use this if you want rgb //(50,50,50));
         frame.setLayout(new BorderLayout());   //sets layout for this frame
         frame.setVisible(true); //sets the frame visibility



         //text fields.
         textfield.setBackground(new Color(50,50,50));
         textfield.setForeground(new Color(215, 214, 229));//sets the text color
         textfield.setFont(new Font("Ink Free", Font.BOLD,95));//sets the  font size and kind
         textfield.setHorizontalAlignment(JLabel.CENTER);//horizontal alignment
                //**** Let's some text
         textfield.setText("Tic-Tac-Toe"); //title of the game.
         textfield.setOpaque(true);

                //** Title Panel ****
         title_panel.setLayout(new BorderLayout());
         title_panel.setBounds(0,0,800,100);//set the balance

         //BUTTON PANEL
         button_panel.setLayout(new GridLayout(3,3));
         button_panel.setBackground(new Color(150,150,150));

         //lets add our buttons, by creating a for loop.
         for (int i = 0; i < 9; i++) {
             buttons[i] = new JButton();
              button_panel.add(buttons[i]);//let add this specific button we're working on
              buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));// let's set the font and then within we can specify
              buttons[i].setFocusable(false); // we set the buttons to focusable to false
              buttons[i].addActionListener(this); //add actionListener to each of these buttons

         }


         //add out text fields to our title panel and panel to our frame.
         title_panel.add(textfield);
         frame.add(title_panel,BorderLayout.NORTH);

         //add out button panel to our frame
         frame.add(button_panel);

       //now let's determine to see whose turn it is first below *
         //call the firstTurn Method
         firstTurn();
     }

    //Action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
    // run a for loop, so it runs 9x whenever a button is clicked.
       for ( int i = 0; i < 9; i++){
      //basically we're checking each or our 9 buttons

           if (e.getSource()== buttons[i]) {
               if (player1_turn){
                   if(buttons[i].getText()=="") {
                       buttons[i].setForeground(new Color(255,0,0)); //set the 'X' turns to red
                       buttons[i].setText("X");
                       player1_turn = false;
                       textfield.setText("O turn");
                       check();
                   }
               }
               else {
                   if(buttons[i].getText()=="") {
                       buttons[i].setForeground(new Color(0,0,255));// set the 'X' turns to blue
                       buttons[i].setText("O");
                       player1_turn = true;
                       textfield.setText("X turn");
                       check();
                   }
               }
               }
           }
       }



    //Method that'll determine who's turn is next
    //first turn method.
    public void firstTurn(){
        /*to have the title display for a lil bit before assigning
          a turn for somebody we can do the below*/
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
              e.printStackTrace(); //this try code adds delay before assigning someone
        }

        // have the random class pick a random int between 0 and 1. weather is X or O turn
        if ( random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("0 turn");
        }

    }

    //method that will check if there's any winning
    //condition, or if any player has currently won
    public void check(){
    //method to check if 'X' wins
        if      ((buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);

        }
        if      ((buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);

        }
        if      ((buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);

        }
        if      ((buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);

        }
        if      ((buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);

        }
        if      ((buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);

        }
        if      ((buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);

        }
        if      ((buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);

        }

        //check to see if 'O' wins
        if      ((buttons[0].getText()=="O") &&
                (buttons[1].getText()=="O") &&
                (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);

        }
        if      ((buttons[3].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);

        }
        if      ((buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);

        }
        if      ((buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);

        }
        if      ((buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);

        }
        if      ((buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);

        }
        if      ((buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);

        }
        if      ((buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);

        }

     }


    public void xWins(int a, int b, int c){
      //background will turn green Indicate that the player x has won.
       buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0; i<9; i++) {
            buttons[i].setEnabled(false); //buttons are disabled after we have a win from 'X'
        }
        textfield.setText("X Won");
    }


    public void oWins(int a, int b, int c){
         //background turns to orange Indicate that the player O has won.
        buttons[a].setBackground(Color.orange);
        buttons[b].setBackground(Color.orange);
        buttons[c].setBackground(Color.orange);

        for(int i=0; i<9; i++) {
            buttons[i].setEnabled(false); //buttons are disabled after we have a win from 'O'
        }
        textfield.setText("O Won");
    }
}
