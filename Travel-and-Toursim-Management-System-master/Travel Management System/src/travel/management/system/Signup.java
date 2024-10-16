/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.management.system;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
public class Signup extends JFrame implements ActionListener{

	JButton create, back;
	JTextField tfname, tfusername, tfpassword, tfanswer;
	Choice security;

	Signup() {
		setBounds(490, 200, 960, 540);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel p1= new JPanel();
		p1.setBackground(new Color(0, 51, 102));
		p1.setBounds(0, 0, 575, 600);
		p1.setLayout(null);
		add(p1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/contact.png"));
		Image i2 = i1.getImage().getScaledInstance(245, 184, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(610, 40, 300, 300);
		add(image);

		JLabel lblhead2 = new JLabel("Create Account");
		lblhead2.setBounds(660, 280, 250, 90);
		lblhead2.setForeground(Color.black);
		lblhead2.setFont(new Font("SAN SERIF", Font.PLAIN, 30));
		add(lblhead2);

		JLabel lblhead = new JLabel("Sign-Up Page");
		lblhead.setBounds(180, 50, 200, 50);
		lblhead.setForeground(Color.white);
		lblhead.setFont(new Font("SAN SERIF", Font.PLAIN, 30));
		p1.add(lblhead);

		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(125, 140, 125, 25);
		lblusername.setForeground(Color.white);
		lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblusername);

		tfusername = new JTextField();
		tfusername.setBounds(250, 140, 180, 25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);

		JLabel lblname = new JLabel("Name:");
		lblname.setBounds(125, 180, 125, 25);
		lblname.setForeground(Color.white);
		lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblname);

		tfname = new JTextField();
		tfname.setBounds(250, 180, 180, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);

		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(125, 220, 125, 25);
		lblpassword.setForeground(Color.white);
		lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(250, 220, 180, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);

		JLabel lblsecurity = new JLabel("Security Question:");
		lblsecurity.setBounds(125, 260, 165, 25);
		lblsecurity.setForeground(Color.white);
		lblsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblsecurity);

		security = new Choice();
		security.add(" ");
		security.add("What is your favorite food?");
		security.add("What is your mother's maiden name?");
		security.add("What city were you born in?");
		security.add("What is the name of your first pet?");
		security.add("What is your favorite book/movie/band?");
		security.setBounds(250, 260, 180, 25);
		p1.add(security);

		JLabel lblanswer = new JLabel("Answer:");
		lblanswer.setBounds(125, 300, 125, 25);
		lblanswer.setForeground(Color.white);
		lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblanswer);

		tfanswer = new JTextField();
		tfanswer.setBounds(250, 300, 180, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);

		create = new JButton("Create");
		create.setBackground(new Color(196, 196, 196));
		create.setForeground(Color.BLACK);
		create.setBounds(100, 400, 130, 30);
		create.setBorder(new LineBorder(new Color(138, 138, 138)));
		create.addActionListener(this);
		p1.add(create);

		back = new JButton("Back");
		back.setBackground(new Color(196, 196, 196));
		back.setForeground(Color.BLACK);
		back.setBounds(317, 400, 130, 30);
		back.setBorder(new LineBorder(new Color(138, 138, 138)));
		back.addActionListener(this);
		p1.add(back);



		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == create) {
			String username = tfusername.getText();
			String name = tfname.getText();
			String password = tfpassword.getText();
			String question = security.getSelectedItem();
			String answer = tfanswer.getText();

			String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Account created Successfully");

				setVisible(false);
				new Login();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}
	public static void main(String[] args) {
		new Signup();
	}
}
