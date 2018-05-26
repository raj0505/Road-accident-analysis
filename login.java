//package raj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame implements ActionListener {

	 JPanel contentPane;
	 JTextField t;
	 JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
			}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
                contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoadAccidentAnalysis = new JLabel("         ROAD ACCIDENT ANALYSIS");
		lblRoadAccidentAnalysis.setForeground(Color.RED);
		lblRoadAccidentAnalysis.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblRoadAccidentAnalysis.setBounds(122, 11, 253, 39);
		contentPane.add(lblRoadAccidentAnalysis);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblUserName.setBounds(152, 172, 69, 14);
		contentPane.add(lblUserName);
		
		t = new JTextField();
		t.setBounds(246, 169, 86, 20);
		contentPane.add(t);
		t.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(187, 236, 46, 14);
		contentPane.add(label);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(152, 219, 69, 14);
		contentPane.add(lblPassword);
		
		t1 = new JTextField();
		t1.setBounds(246, 216, 86, 20);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
		btnLogin.setBounds(180, 255, 89, 23);
		contentPane.add(btnLogin);
                btnLogin.addActionListener(this);
	}
@Override
public void actionPerformed(ActionEvent ae)
{
//TODO Auto-generated method stub
try
{
if("LOGIN".equals(ae.getActionCommand()))
{
String value1=t.getText();
String value2=t1.getText();
if(value1.equals("raj")&&value2.equals("rk"))
{

mymenu obj=new mymenu();
//obj.show();
}

else 
{
System.out.println("enter valid username and password");
}
}
}catch(Exception e)
	{
		System.out.println("error,................");
}	
}}
