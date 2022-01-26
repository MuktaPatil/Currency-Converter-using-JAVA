package conversions;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import conversions.calc;
//import conversions.tab2;

public class conv extends JFrame implements ItemListener, ActionListener {
	
	static JFrame f;
	static JLabel l1, l2, l3;
	static JComboBox c1,c2;
	static JTextField t1;
	static String s1[] = { "Rupee", "USD", "Pounds", "Euro", "Won", "Yen" };
	static int no;
	static String cy,cx; //store values from textfield
	static float cxx;//to store returned values from conversion of rupee to usd
	static Font font = new Font("Arial", Font.PLAIN, 18);
	static JTabbedPane jt;
	static JButton b1;
	
	//for tab2
	static JFrame ft2;
	static JLabel lx1,lx2,lx3;
	static JTextField tx1;
	static JPanel jp;
	static JButton bx1;
	
	
	String capitalize(String x) {
		String words[]=x.split("\\s");
        String cs="";
 
        for(String word:words){
            // Capitalize first letter
            String firstLetter=word.substring(0,1);
            // Get remaining letter
            String remainingLetters=word.substring(1);
            cs+=firstLetter.toUpperCase()+remainingLetters+" ";
        }
        return cs;
		
	}

	public static void main(String[] args) {
		
		f = new JFrame("Currency Converter");
		JPanel p = new JPanel();//Panel to hold currency converter module
		p.setPreferredSize(new Dimension(390,270));
		
		jt = new JTabbedPane(); 
		jt.setPreferredSize(new Dimension(400,300));
		
		conv s = new conv();
		//conv sx = new conv();
		f.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
		BorderLayout b = new BorderLayout();
		
		t1 = new JTextField("1"); 
		t1.setPreferredSize(new Dimension(25,30));
		t1.setColumns(5);
		t1.setFont(font);
		
		l3 = new JLabel();
		l3.setForeground(Color.BLUE);
		
		c1 = new JComboBox(s1);
		c1.addItemListener(s);
		c1.setPreferredSize(new Dimension(110,40));
		c1.setFont(font);
		
		
		c2 = new JComboBox(s1);
		c2.addItemListener(s);
		c2.setPreferredSize(new Dimension(110,40));
		c2.setFont(font);
		

		l1 = new JLabel("TO");
		l1.setFont(font);
		l2 = new JLabel();

		
		//Declarations for tab2
		ft2 = new JFrame("Currency Finder");
		
		lx1 = new JLabel("Find the Currency of");
		lx1.setPreferredSize(new Dimension(90,40));
		jp = new JPanel();
		jp.setPreferredSize(new Dimension(390,270));
		jp.setLayout(b);
		//tab2 x = new tab2();
		
		tx1 = new JTextField();
		tx1.addActionListener(s);
		tx1.setPreferredSize(new Dimension(25,30));
		tx1.setColumns(5);
		tx1.setFont(font);
		
		bx1 = new JButton("Search");
		bx1.addActionListener(s);
		bx1.setPreferredSize(new Dimension(20,20));
		bx1.setFont(font);
		
		lx2 = new JLabel();
		lx2.setFont(font);
		lx2.setForeground(Color.BLUE);
		lx3 = new JLabel();
		lx3.setFont(font);
		lx3.setForeground(Color.BLUE);
		
		
		//JPanel p = new JPanel();
		//for tab1
		t1.addActionListener(s);;

		p.add(t1);
		p.add(c1);

		p.add(l1);
		//l1.setPreferredSize(new Dimension(30,50));
		p.add(c2);
		
		p.add(l2, BorderLayout.CENTER);
		
		p.add(l3, BorderLayout.AFTER_LAST_LINE);
		
		//for tab2
		jp.setLayout(new GridLayout(5,4, 20, 25));
		jp.add(lx1); 
		jp.add(tx1);
		jp.add(bx1);
		jp.add(lx2);
		jp.add(lx3);
		
		//ft2.add(jp);
		//ft2.setSize(500, 500);
		//ft2.setVisible(true);

		jt.addTab("Currency Converter",p);
		jt.addTab("Find Currency", jp);
		f.add(jt);
		// set the size of frame
		f.setSize(500, 500);

		f.show();	
		
	}
	
	public void actionPerformed(ActionEvent e){  
        int no = Integer.parseInt(t1.getText());
        
        if(tx1.getText()=="") {
        	lx1.setText("Please Enter A Value");
        }
        
        else if(e.getSource()==bx1 || e.getSource()==tx1) { 
			//if its a button from tab 2 execute the following function
			String country = tx1.getText();
			Connection conn = null;
			try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
	  	      conn = DriverManager.getConnection();//Enter datbase details
	  	//"jdbc:mysql://localhost:1520/db_name?" + "user=&password= "
	  	
	  	  	  String query = "SELECT * FROM currencies WHERE country LIKE '%"+ country +"%'";
	  	      Statement desc = conn.createStatement();
	  	      ResultSet rs = desc.executeQuery(query);
	  	      
	  	    if(rs.next()){
	  	    	String cx1 = rs.getString("country");
	  	    	String cx2 = rs.getString("curr");
	  	    	String c1 = capitalize(cx1);
	  	    	String c2 = capitalize(cx2);
	  	    	lx2.setText("Country : " + c1);
	  	    	lx3.setText("Currency : " + c2);
	  	    			}
	  	    else {
	  	    	lx2.setText("Country not found");
	  	    	lx3.setText("Please try again");
	  	    	
	  	    }
	    	  conn.close();
	  	      }
	  	   catch (SQLException ex) {
	  	      // handle any errors
	  	      System.out.println("SQLException: " + ex.getMessage());
	  	      System.out.println("SQLState: " + ex.getSQLState());
	  	      System.out.println("VendorError: " + ex.getErrorCode());
	  	  } catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	  	  	}
		}
	}
	
	public void itemStateChanged(ItemEvent e)		//This method is of COmbobox	
	{
		String cx = (String) c1.getSelectedItem();
		String cy = (String)c2.getSelectedItem();
		int i;
		l2.setFont(new Font("Arial", Font.PLAIN, 20));
		l2.setText("Converting from " + cx +" to "+ cy);
		 
		int no = Integer.parseInt(t1.getText());
		if(cx=="Rupee") {
			cxx = calc.rup_conv(no,cy);
	}
		
		else if(cx=="USD") {
			cxx = calc.usd_conv(no,cy);	
		}
		
		else if(cx=="Euro") {
			cxx = calc.euro_conv(no,cy);	
		}
		
		else if(cx=="Pounds") {
			cxx = calc.pnd_conv(no,cy);	
		}
		
		else if(cx=="Won") {
			cxx = calc.won_conv(no,cy);	
		}
		
		else {
			cxx = calc.yen_conv(no,cy);
		}
		String cxxx= Float.toString(cxx);
		l3.setFont(new Font("Arial", Font.PLAIN, 20));
		l3.setText(cxxx + " " + cy);
		
		}
		
		
	}
	
	
		



