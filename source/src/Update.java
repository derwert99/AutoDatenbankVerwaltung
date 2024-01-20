package Programiertechniken_Projekt;

import org.w3c.dom.Attr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame implements ActionListener {
    JLabel Headline = new JLabel("Update");
    JLabel lblAuswahl = new JLabel("Zu ändernder Wert: ");
    JLabel lblKennzeichen = new JLabel("Kennzeichen: ");
    JTextField txtEingabe = new JTextField();
    JButton Button = new JButton("Ok");
    JComboBox<String> Attribut = new JComboBox<>(options);
    JTextArea Ergebnis = new JTextArea();
    static String[] options = {"Kennzeichen", "Marke", "Modell", "Farbe", "PS", "Kraftstoff", "Getriebe"};
    static Font label = new Font("label", Font.PLAIN, 35);
    static Font headline = new Font("Headline", Font.BOLD, 100);


    public Update (){
        super("Update");
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
        lblKennzeichen.setBounds(100, 400, 350, 150);
        lblKennzeichen.setFont(label);
        add(lblKennzeichen);
        txtEingabe.setBounds(550, 400, 350, 150);
        txtEingabe.setFont(label);
        add(txtEingabe);
        Button.setBounds(300, 650, 400, 200);
        Button.addActionListener(this);
        Button.setFont(headline);
        add(Button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Kennzeichen = txtEingabe.getText();
        String Auswahl = Attribut.getSelectedItem().toString();
        if(e.getActionCommand().equals("Ok")){
            Attribut.setVisible(false);
            lblAuswahl.setText(Auswahl);
            lblKennzeichen.setText("Neue" + Auswahl + ": ");
            txtEingabe.setText("");
            Button.setText("Ändern");
        } else {
            //Ändern und zurück ins Menü
        }
    }
}
