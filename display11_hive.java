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


public class display11_hive extends JFrame implements ActionListener {

	 JPanel contentPane;
	 
	 
         JLabel l1;
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					display11_hive frame = new display11_hive();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();}
                              }
		});
	}

	/**
	 * Create the frame.
	 */
	public display11_hive() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
setResizable(true);
		contentPane = new JPanel();
                JLabel l1 = new JLabel();
               
               l1.setIcon(new ImageIcon("k.jpg"));
              l1.setBounds(0,0,1500,600);
              


               //contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		JLabel lblRoadAccidentAnalysis = new JLabel("THANK YOU");
		lblRoadAccidentAnalysis.setForeground(Color.red);
		lblRoadAccidentAnalysis.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblRoadAccidentAnalysis.setBounds(150, 11, 500, 39);
		contentPane.add(lblRoadAccidentAnalysis);
		
	
		JButton btnexit = new JButton("exit");
		btnexit.setFont(new Font("TimesNewRoman", Font.BOLD, 12));
                btnexit.setForeground(Color.RED);
		btnexit.setBackground(Color.GREEN);
		btnexit.setBounds(500, 400, 89, 50);
		contentPane.add(btnexit);
                btnexit.addActionListener(this);
contentPane.add(l1);
                    //JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(""));
		//lblNewLabel.setBounds(100, 0, 500, 500);
		//contentPane.add(lblNewLabel);
 
	}
 
@Override

public void actionPerformed(ActionEvent ae)
{
//TODO Auto-generated method stub
try
{
if("exit".equals(ae.getActionCommand()))
{
	System.exit(0);

}}catch(Exception e)
	{
		System.out.println("error,................");}
	
}}



