/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.awt.Color;
import java.sql.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	JButton login, signup, password, Loading;
	JTextField tfusername, tfpassword;
	Login() {
		setSize(1000, 400);
		setLocation(450, 300);
		setLayout(null);

		getContentPane().setBackground(Color.WHITE);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(0, 51, 102));
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/logo.png"));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50, 40, 300, 300);
		p1.add(image);

		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(460, 30, 450, 300);
		add(p2);

		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(60, 30, 100, 25);
		lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p2.add(lblusername);

		tfusername = new JTextField();
		tfusername.setBounds(60, 65, 300, 30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);

		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(60, 110, 100, 25);
		lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p2.add(lblpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(60, 145, 300, 30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);

		login = new JButton("Login");
		login.setBackground(new Color(196, 196, 196));
		login.setForeground(Color.BLACK);
		login.setBounds(60, 200, 130, 30);
		login.setBorder(new LineBorder(new Color(138, 138, 138)));
		login.addActionListener(this);
		p2.add(login);

		signup = new JButton("Sign-up");
		signup.setBackground(new Color(196, 196, 196));
		signup.setForeground(Color.BLACK);
		signup.setBounds(230, 200, 130, 30);
		signup.setBorder(new LineBorder(new Color(138, 138, 138)));
		signup.addActionListener(this);
		p2.add(signup);

		password = new JButton("Forget Password");
		password.setBackground(new Color(238, 238, 238));
		password.setForeground(Color.blue);
		password.setBounds(200, 250, 130, 30);
		password.setBorder(BorderFactory.createEmptyBorder());
		password.addActionListener(this);
		p2.add(password);

		JLabel text = new JLabel("Trouble logging in? Try.. ");
		text.setBounds(60, 250, 150, 30);
		text.setForeground(Color.red);
		p2.add(text);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			try {
				String username = tfusername.getText();
				String pass = tfpassword.getText();

				String query = "select * from account where username = '"+username+"' AND password = '"+pass+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					new Loading(username);
				} 
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (ae.getSource() == signup) {
			setVisible(false);
			new Signup();
		}
		else if (ae.getSource() == password) {
			setVisible(false);
			new ForgetPassword();
		}
	}

	public static void main(String[] args) {
		new Login(); //anonymous object
	}
}