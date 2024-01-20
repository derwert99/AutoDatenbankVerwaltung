package Programiertechniken_Projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame implements ActionListener {
   JLabel Headline = new JLabel("Delete");
    JLabel lblKennzeichen = new JLabel("Kennzeichen: ");
    JTextField txtEingabe = new JTextField();
    JButton Button = new JButton("Löschen");
    static Font label = new Font("label", Font.PLAIN, 35);
    static Font headline = new Font("Headline", Font.BOLD, 100);


    public Delete (){
        super("Delete");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);

        Headline.setBounds(400, 0, 400, 200);
        Headline.setFont(headline);
        add(Headline);
        lblKennzeichen.setBounds(100, 200, 350, 150);
        lblKennzeichen.setFont(label);
        add(lblKennzeichen);
        txtEingabe.setBounds(550, 200, 350, 150);
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
        //wenn Kennzeichen vorhanden löschen, sonst Fehler anzeigen, danach zurück ins Menü
    }
}
