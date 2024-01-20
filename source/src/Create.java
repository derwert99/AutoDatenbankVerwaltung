package Programiertechniken_Projekt;

import com.sun.source.doctree.StartElementTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Create extends JFrame implements ActionListener {
    JLabel lblCreate = new JLabel("Create");
    JLabel lblKennzeichen = new JLabel("Kennzeichen");
    JLabel lblMarke = new JLabel("Marke");
    JLabel lblModell = new JLabel("Modell");
    JLabel lblFarbe = new JLabel("Farbe");
    JLabel lblPS = new JLabel("PS");
    JLabel lblKraftstoff = new JLabel("Kraftstoff");
    JLabel lblGetriebe = new JLabel("Getriebe");
    JTextField txtKennzeichen = new JTextField("");
    JTextField txtMarke = new JTextField("");
    JTextField txtModell = new JTextField("");
    JTextField txtfarbe = new JTextField("");
    JTextField txtPS = new JTextField("");
    JComboBox <String> Kraftstoff = new JComboBox<>(kraftstoffe);
    JComboBox <String> Getriebe = new JComboBox<>(getriebe);
    JButton Hinzufuegen = new JButton("Hinzufügen");
    static String[] kraftstoffe = {"Benzin", "Diesel", "Wasserstoff", "Hybrid", "Elektro"};

    static String[] getriebe = {"Automatik", "5-Gang", "6-Gang", "7-Gang"};


    public Create (){
        super("Create");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        lblCreate.setBounds(450, 100, 100, 50);
        add(lblCreate);
        Hinzufuegen.setBounds(450, 850, 100, 50);
        Hinzufuegen.addActionListener(this);
        add(Hinzufuegen);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Überprüfungen durchführen & zu Datenbank hinzufügen
    }
}
