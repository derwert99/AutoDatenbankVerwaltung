package Programiertechniken_Projekt;

import org.w3c.dom.Attr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

public class Read extends JFrame implements ActionListener {

    JLabel Headline = new JLabel("Read");
    JLabel lblAuswahl = new JLabel("Attribut für die Suche: ");
    JLabel lblSuchwort = new JLabel("Wert für die Suche: ");
    JTextField txtEingabe = new JTextField();
    JButton Suchen = new JButton("Suchen");
    JComboBox<String> Attribut = new JComboBox<>(options);
    JTextArea Ergebnis = new JTextArea();
    static String[] options = {"Kennzeichen", "Marke", "Modell", "Farbe", "PS", "Kraftstoff", "Getriebe"};
    static Font label = new Font("label", Font.PLAIN, 35);
    static Font headline = new Font("Headline", Font.BOLD, 100);


    public Read (){
        super("Read");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);

        Headline.setBounds(400, 0, 400, 200);
        Headline.setFont(headline);
        add(Headline);
        lblAuswahl.setBounds(100, 200,350, 150);
        lblAuswahl.setFont(label);
        add(lblAuswahl);
        Attribut.setBounds(550, 200, 350, 150);
        Attribut.setFont(label);
        add(Attribut);
        lblSuchwort.setBounds(100, 400, 350, 150);
        lblSuchwort.setFont(label);
        add(lblSuchwort);
        txtEingabe.setBounds(550, 400, 350, 150);
        txtEingabe.setFont(label);
        add(txtEingabe);
        Suchen.setBounds(300, 650, 400, 200);
        Suchen.addActionListener(this);
        Suchen.setFont(headline);
        add(Suchen);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Component[] eingabe = {lblSuchwort, txtEingabe, Attribut, Suchen};
        for (Component c : eingabe){
            c.setVisible(false);
        }
        lblAuswahl.setText("Ergebnis: ");
        Ergebnis.setBounds(100, 300, 800, 500);
        Ergebnis.setEditable(false);
        Ergebnis.setFont(label);
        add(Ergebnis);
    }
}
