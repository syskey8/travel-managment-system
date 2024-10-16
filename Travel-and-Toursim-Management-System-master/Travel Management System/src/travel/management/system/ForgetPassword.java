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
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{

	JButton search, retrieve, back;
	JTextField tfname, tfusername, tfquestion, tfpassword, tfanswer;
	Choice security;

	ForgetPassword() {
		setBounds(490, 200, 960, 540);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel p1= new JPanel();
		p1.setBackground(new Color(0, 51, 102));
		p1.setBounds(0, 0, 575, 600);
		p1.setLayout(null);
		add(p1);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/pass.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(610, 75, 300, 300);
		add(image);

		JLabel lblhead = new JLabel("Forget Password Page");
		lblhead.setBounds(120, 50, 300, 80);
		lblhead.setForeground(Color.white);
		lblhead.setFont(new Font("SAN SERIF", Font.PLAIN, 30));
		p1.add(lblhead);

		JLabel lblusername = new JLabel("Username:");
		lblusername.setBounds(50, 150, 125, 25);
		lblusername.setForeground(Color.white);
		lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblusername);

		tfusername = new JTextField();
		tfusername.setBounds(220, 150, 180, 25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);

		JLabel lblname = new JLabel("Name:");
		lblname.setBounds(50, 190, 125, 25);
		lblname.setForeground(Color.white);
		lblname.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblname);

		tfname = new JTextField();
		tfname.setBounds(220, 190, 180, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);

		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setBounds(50, 310, 125, 25);
		lblpassword.setForeground(Color.white);
		lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(220, 310, 180, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);

		JLabel lblsecurity = new JLabel("Security Question:");
		lblsecurity.setBounds(50, 230, 125, 25);
		lblsecurity.setForeground(Color.white);
		lblsecurity.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblsecurity);

		tfquestion = new JTextField();
		tfquestion.setBounds(220, 230, 180, 25);
		tfquestion.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfquestion);

		JLabel lblanswer = new JLabel("Answer:");
		lblanswer.setBounds(50, 270, 165, 25);
		lblanswer.setForeground(Color.white);
		lblanswer.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p1.add(lblanswer);

		tfanswer = new JTextField();
		tfanswer.setBounds(220, 270, 180, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);

		search = new JButton("Search");
		search.setBackground(new Color(196, 196, 196));
		search.setForeground(Color.BLACK);
		search.setBounds(420, 150, 130, 30);
		search.setBorder(new LineBorder(new Color(138, 138, 138)));
		search.addActionListener(this);
		p1.add(search);

		retrieve = new JButton("Retrieve");
		retrieve.setBackground(new Color(196, 196, 196));
		retrieve.setForeground(Color.BLACK);
		retrieve.setBounds(420, 310, 130, 30);
		retrieve.setBorder(new LineBorder(new Color(138, 138, 138)));
		retrieve.addActionListener(this);
		p1.add(retrieve);

		back = new JButton("Back");
		back.setBackground(new Color(196, 196, 196));
		back.setForeground(Color.BLACK);
		back.setBounds(200, 400, 130, 30);
		back.setBorder(new LineBorder(new Color(138, 138, 138)));
		back.addActionListener(this);
		p1.add(back);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {
			try {
				String query = "select * from account where username = '"+tfusername.getText()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfquestion.setText(rs.getString("security"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if (ae.getSource() == retrieve) {
			try {
				String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfpassword.setText(rs.getString("password"));
				}
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
		new ForgetPassword();
	}
}
