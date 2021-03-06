import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.sql.DriverManager;
import java.awt.geom.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.border.*; 
import java.awt.Container;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.beans.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.NumberFormat;
public class display8_hive
{ // begin of form
	static JLabel lblHeading,img;
	static JTable categoryTable;
	static JFrame frame;
	static String dataValues[][];
	static DefaultTableModel model;
	static JScrollPane scrollData;
	static JButton btnShow;
	static JButton btnExit;
	static Color color;
	static Color bgColor;
	static Color btnColor;
	static Vector rows;
        

	public static void createAndShowGUI()
	{ //begin of createAndShowGUI method
		try
		{
			frame = new JFrame("Category Master Form");
		    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    			Insets insets = frame.getInsets();
			frame.setBounds(0,0,screenSize.width,screenSize.height);
	                frame.setResizable(false);
		    	frame.setUndecorated(true);
		    	frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
                        img = new JLabel("");
                        img.setIcon(new ImageIcon("p6.jpg"));
		    	frame.setVisible(true);
		   	lblHeading = new JLabel("The Information Of Victum");
			btnShow = new JButton("Show");
			btnExit= new JButton("Exit");
                      
			frame.getContentPane().setLayout(null);
			Collection collData;
			Object blankobj1 = new Object();
			color = new Color(0,0,255);
			bgColor = new Color(96,204,252);
			lblHeading.setOpaque(true);
			lblHeading.setForeground(color.red);
			//lblHeading.setBackground(bgColor);
			lblHeading.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			addComponentToPane(frame.getContentPane(),lblHeading,200,50,0,0);
			addComponentToPane(frame.getContentPane(),btnShow,240,500,20,22,"Show");
			addComponentToPane(frame.getContentPane(),btnExit,340,500,20,18,"exit");
                        addComponentToPane(frame.getContentPane(),img,250,100,250,100);
		
		}
		catch(Exception e)
		{
			System.out.println("error-"+e.getMessage());
		}
	} // end of createAndShowGUI method

	public static void addComponentToPane(Container pane,JButton paneControl,int l, int t, int w, int h,String title) 
	{
		Insets insets = pane.getInsets();
		Dimension size = paneControl.getPreferredSize();
		size = paneControl.getPreferredSize();
	  	paneControl.setBounds(l + insets.left, t + insets.top, size.width+w, size.height+h );
		pane.add(paneControl);
		btnColor = new Color(153,51,0);
		paneControl.setForeground(btnColor.green);
		paneControl.setActionCommand(title);
		paneControl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		paneControl.addActionListener(new myAction());
	}
	public static void addComponentToPane(Container pane,JLabel paneControl,int l, int t, int w, int h) 
	{
		Insets insets = pane.getInsets();
		Dimension size = paneControl.getPreferredSize();
		size = paneControl.getPreferredSize();
	  	paneControl.setBounds(l + insets.left, t + insets.top, size.width+w, size.height+h );
		pane.add(paneControl);
	}
	public static void addComponentToPane(Container pane,JSeparator paneControl,int l, int t, int w, int h) 
	{
		Insets insets = pane.getInsets();
		Dimension size = paneControl.getPreferredSize();
		size = paneControl.getPreferredSize();
  		paneControl.setBounds(l + insets.left, t + insets.top, size.width+w, size.height+h );
		pane.add(paneControl);
	}
	public static void addComponentToPane(Container pane,JScrollPane paneControl,int l, int t, int w, int h) 
	{
		Insets insets = pane.getInsets();
		Dimension size = paneControl.getPreferredSize();
		size = paneControl.getPreferredSize();
	  	paneControl.setBounds(l + insets.left, t + insets.top, size.width+w, size.height+h );
		pane.add(paneControl);
	}

	private static class myAction implements ActionListener
	{
		public  void actionPerformed(ActionEvent e) 
		{
			if ("exit".equals(e.getActionCommand())) 
			{mymenu1 m10 = new mymenu1();
                              m10.show();
					
			}
                         
			if ("Show".equals(e.getActionCommand())) 
			{	
				display_data_in_table();
				addComponentToPane(frame.getContentPane(),scrollData,250,250,-150,-250);

			}
		}
   	}
   
	private static void prepare_table_data()
	{
		String driverName = "org.apache.hive.jdbc.HiveDriver";
		try
		{
	     	 	Class.forName(driverName);
			Connection con = DriverManager.getConnection("jdbc:hive2://localhost:10000/road_accidents", "hive","");
	        	Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
	        	String tableName ="people_affected";
	        	String sql = "select  acc_year,user_type,first_aid,sexcode,age from people_affected"; 
 
	        	System.out.println("Running: " + sql);
	    		ResultSet res = stmt.executeQuery(sql);
			int r=0;
			int cols = 2;
			rows = new Vector();
	    		while (res.next()) 
			{
				
				Vector newrow = new Vector();
				newrow.addElement(res.getObject("acc_year"));
                                newrow.addElement(res.getObject("user_type"));
                                newrow.addElement(res.getObject("first_aid"));
				newrow.addElement(res.getObject("sexcode"));
                                newrow.addElement(res.getObject("age"));
                                
				//newrow.addElement(res.getObject("a.not_injured"));
				rows.addElement(newrow);	
			}
			System.out.println("vector created");
		}
		catch(Exception e)
		{
			System.out.println("Error is table initialization -" + e.getMessage());
		
		}
	}
	private static void display_data_in_table()
	{
		prepare_table_data();
		String colNames[]={"acc_year"};
		Vector cname = new Vector();
		cname.addElement("acc_year");
                //String colNames[]={"killed"};
               // Vector cname = new Vector();
                cname.addElement("user_type");
                cname.addElement("first_aid");
		cname.addElement("sexcode");
                cname.addElement("age");
		
		
		model = new DefaultTableModel(rows,cname);
		categoryTable = new JTable(model){
		public boolean isCellEditable(int rowIndex, int colIndex) 
		{
			  return false; //Disallow the editing of any cell
	  	}
	  };
	scrollData = new JScrollPane(categoryTable );
	categoryTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
}

}
class h7
{
public static void main(String s[]) 
{
    javax.swing.SwingUtilities.invokeLater(new Runnable() 
   {
	 public void run() 
	{
		display8_hive h=new display8_hive();
		h.createAndShowGUI();
	}
});

  }
}	
	
