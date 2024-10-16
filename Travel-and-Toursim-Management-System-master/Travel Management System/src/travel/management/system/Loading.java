package travel.management.system;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Font;
import java.awt.Image;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum(); //100
                int value = bar.getValue();
                if (value < max) { //101 < 100
                    bar.setValue(bar.getValue() + 1);
                } else {
                    i = 102;
                    setVisible(false);
                    new Home(username).setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        t = new Thread(this);
        setBounds(700, 350, 500, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/loading.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 500, 500);
        add(NewLabel);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(25, 20, 600, 40);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Roboto", Font.BOLD, 30));
        NewLabel.add(text);

        bar = new JProgressBar();
        bar.setBounds(90, 85, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading... please wait");
        loading.setBounds(170, 120, 170, 40);
        loading.setForeground(Color.BLUE);
        loading.setFont(new Font("Poppins", Font.BOLD, 15));
        NewLabel.add(loading);

        JLabel lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(140, 380, 600, 40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Montserrat", Font.BOLD, 20));
        NewLabel.add(lblusername);

        t.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");
    }
}