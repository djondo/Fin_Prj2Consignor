package com.rudolf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by rudi on 12/12/2015.
 */

class ConsignorInfoGUI extends JFrame implements WindowListener {
    private JPanel rootPanel;
    private JTable consignorTable;
    private JButton deleteButton;
    private JButton quitButton;
    private JTextField ConsignorIDTextField;
    private JTextField NameTextField;
    private JTextField PhoneNumberTextField;
    private JTextField emailTextField;
    private JTextField balanceOwedTextField;
    private JButton addConsignorButton;

    public ConsignorInfoGUI(ConsignorModel cig) {
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(this);
        setVisible(true);

        setSize(300, 150);

        //Create a data model and tell our table to use it
        // ConsignorDataModel consignorModel = new ConsignorDataModel();
        consignorTable.setModel(cig);
        //Grid color default is white, change it so we can see it
        consignorTable.setGridColor(Color.BLACK);
        //Also make the columns wider
        consignorTable.getColumnModel().getColumn(0).setWidth(300);
        //Quit application when user closes window, otherwise app keeps running
        //Sometimes this is what you want, sometimes it isn't.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Close button code.
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Call Main's shutdown method - one class is the entry and exit point of the program
                System.exit(0);
            }
        });

        addConsignorButton.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                //Call Main's shutdown method - one class is the entry and exit point of the program
                int ConsignorID = Integer.parseInt(ConsignorIDTextField.getText());;
                String Name = NameTextField.getText();
                int PhoneNumber = Integer.parseInt(PhoneNumberTextField.getText());
                String email = emailTextField.getText();
                double balanceOwed = Integer.parseInt(balanceOwedTextField.getText());
                Consignor newConsignor = new Consignor(1, Name, PhoneNumber, email, balanceOwed);
                com.rudolf.dbConnection.addNewConsignor(newConsignor);


            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //  int currentRow = Album.getSelectedRow()

            }

        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

//



    //Method provided by WindowListener interface
    //Called when user clicks button to close application
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
        //Main.shutdown();
    }

    //A WindowListener is required to provide these methods
    //We can choose what they do - in this case, nothing
    public void windowClosed(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

}






