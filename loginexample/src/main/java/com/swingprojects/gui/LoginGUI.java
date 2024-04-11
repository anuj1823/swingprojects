package com.swingprojects.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.swingprojects.services.DatabaseService;
import com.swingprojects.servicesImpl.DatabaseServiceImpl;

public class LoginGUI extends JFrame implements ActionListener
{
	private JTextField userName;
	private JPasswordField password;
	private JLabel userNameLabel,passwordLabel,msg;
	private JButton login;
	/*------- Constructor to initialize the components--------*/
	public LoginGUI()
	{
		/*--- Initializing the JLabel for username---*/
		userNameLabel = new JLabel("Username");
		/*---setting the position---*/
		userNameLabel.setBounds(10,10,60,25);
		/*------------------------------------------------*/
		/*--- Initializing the JTextField for username---*/
		userName = new JTextField();
		/*---setting the position---*/
		userName.setBounds(75,10,80,25);
		/*------------------------------------------------*/
		/*--- Initializing the JLabel for password---*/
		passwordLabel = new JLabel("Password");
		/*---setting the position---*/
		passwordLabel.setBounds(10,40,60,25);
		/*------------------------------------------------*/
		/*--- Initializing the JTextField for password---*/
		password = new JPasswordField();
		/*---setting the position---*/
		password.setBounds(75,40,80,25);
		/*------------------------------------------------*/
		/*--- Initializing the JButton for loginButton---*/
		login = new JButton("Login");
		/*---setting the position---*/
		login.setBounds(45,80,80,25);
		/*------------------------------------------------*/
		/*--- Initializing the Message for showing result of login---*/
		msg = new JLabel("");
		/*---setting the position---*/
		msg.setBounds(25,110,200,25);
		/*----- Adding components into frame--------*/
		add(userNameLabel);
		add(userName);
		add(passwordLabel);
		add(password);
		add(login);
		add(msg);
		/*------------------------------------------------------*/
		/*----- adding actionlistener with button-----
		 * It will enable clickevent on button
		 * */		
		login.addActionListener(this);
		/*------------------------------------------------*/
		/*------- Setting title, dimension, layout and visibility of the frame--------*/
		setTitle("Login Form");
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
	}
	/*---- Method get notified when user clicks the button--------*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*---- Fetch data from textfield--------*/
		String uName = userName.getText();//uName stands for username that is fetched from usernametextfield
		String uPass = new String(password.getPassword());//uPass stands for password that is fetched from password field
		String result="";
		DatabaseService dbservice=new DatabaseServiceImpl();
		/*----- fetching data from database------------------*/
		result=dbservice.loginCheck(uName, uPass);
		/*---- Setting result to message Label-----*/
		msg.setText(result);
	}
}
