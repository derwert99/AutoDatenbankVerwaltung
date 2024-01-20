package Programiertechniken_Projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menu extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Menu();
    }
    JButton Create = new JButton("Create");
    JButton Read = new JButton("Read");
    JButton Update = new JButton("Update");
    JButton Delete = new JButton("Delete");
    public Menu(){
        super("Menu");
        setLayout(null);
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Create.setBounds(100, 100, 350, 350);
        Create.addActionListener(this);
        add(Create);
        Read.setBounds(550, 100, 350, 350);
        Read.addActionListener(this);
        add(Read);
        Update.setBounds(100, 550, 350, 350);
        Update.addActionListener(this);
        add(Update);
        Delete.setBounds(550, 550, 350, 350);
        Delete.addActionListener(this);
        add(Delete);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        switch (e.getActionCommand()){
            case "Create" -> new Create();
            case "Read" -> new Read();
            case "Update" -> new Update();
            case "Delete" -> new Delete();
        }
    }
}
