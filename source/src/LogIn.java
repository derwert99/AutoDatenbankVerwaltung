package Programiertechniken_Projekt;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LogIn extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new LogIn();
    }
    JLabel lblLogIn = new JLabel("Log-In");
    JLabel lblBenutzername = new JLabel("Benutzername");
    JLabel lblPasswort = new JLabel("Passwort");
    JTextField txtBenutzername = new JTextField();
    JTextField txtPaswort = new JTextField();
    JButton Enter = new JButton("Enter");
    public LogIn(){
        super("LogIn");
        setLayout(null);
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        lblLogIn.setBounds(450, 100, 100, 50);
        add(lblLogIn);
        lblBenutzername.setBounds(375, 250, 100, 50);
        add(lblBenutzername);
        lblPasswort.setBounds(375, 400, 100, 50);
        add(lblPasswort);
        txtBenutzername.setBounds(525, 250, 150, 50);
        add(txtBenutzername);
        txtPaswort.setBounds(525, 400, 150, 50);
        add(txtPaswort);
        Enter.setBounds(300, 550, 400, 300);
        Enter.addActionListener(this);
        add(Enter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (txtBenutzername.getText() != null && txtPaswort.getText() != null){
            new Menu();
            setVisible(false);
        }
    }
}
