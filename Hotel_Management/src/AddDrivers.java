import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddDrivers extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel heading, driver_name_text, driver_age_text, gender_text, car_company_text, car_brand_text, availability_text;
    private JTextField name_textbox,age_textbox,car_company_textbox,car_brand_textbox;
    private JComboBox gender_textbox, availability_textbox;
    JButton add_driver,exit_button;
    Choice c1;
    private JLabel id_text;
    private JTextField id_textbox;

	AddDrivers(){
		setBounds(450, 200, 1000, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane.setLayout(null);
	        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        getContentPane().add(l15);
	    
        //frame heading
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(110, 30, 120, 22);
		contentPane.add(heading);
	        
		//adding labels
		driver_name_text = new JLabel("Name");
		driver_name_text.setForeground(new Color(25, 25, 112));
		driver_name_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		driver_name_text.setBounds(67, 110, 102, 22);
		contentPane.add(driver_name_text);
		
		driver_age_text = new JLabel("Age");
		driver_age_text.setForeground(new Color(25, 25, 112));
		driver_age_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		driver_age_text.setBounds(67, 150, 102, 22);
		contentPane.add(driver_age_text);

		gender_text = new JLabel("Gender");
		gender_text.setForeground(new Color(25, 25, 112));
		gender_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		gender_text.setBounds(67, 190, 102, 22);
		contentPane.add(gender_text);
		
		car_company_text = new JLabel("Car Company");
		car_company_text.setForeground(new Color(25, 25, 112));
		car_company_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		car_company_text.setBounds(67, 230, 102, 22);
		contentPane.add(car_company_text);
		
	    car_brand_text = new JLabel("Car Brand");
		car_brand_text.setForeground(new Color(25, 25, 112));
		car_brand_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		car_brand_text.setBounds(67, 270, 102, 22);
		contentPane.add(car_brand_text);
		
		availability_text = new JLabel("Available");
		availability_text.setForeground(new Color(25, 25, 112));
		availability_text.setFont(new Font("Tahoma", Font.BOLD, 14));
		availability_text.setBounds(67, 310, 102, 22);
		contentPane.add(availability_text);
	        
	    //adding textfields and combo boxes
	    name_textbox = new JTextField();
		name_textbox.setBounds(177, 110, 156, 20);
		contentPane.add(name_textbox);
	       	        
	    age_textbox = new JTextField();
		age_textbox.setBounds(177, 150, 156, 20);
		contentPane.add(age_textbox);
	        
	    gender_textbox = new JComboBox(new String[] { "Male", "Female" });
		gender_textbox.setBounds(179, 190, 154, 20);
		contentPane.add(gender_textbox);
		
	    car_company_textbox = new JTextField();
		car_company_textbox.setBounds(177, 230, 156, 20);
		contentPane.add(car_company_textbox);

	    car_brand_textbox = new JTextField();
		car_brand_textbox.setBounds(177, 270, 156, 20);
		contentPane.add(car_brand_textbox);

	    availability_textbox = new JComboBox(new String[] { "Yes", "No" });
		availability_textbox.setBounds(179, 310, 154, 20);
		contentPane.add(availability_textbox);
	        
		
		//adding buttons
		add_driver = new JButton("Add Driver");
		add_driver.addActionListener(this);
		add_driver.setBounds(67, 353, 111, 33);
	    add_driver.setBackground(Color.BLACK);
	    add_driver.setForeground(Color.WHITE);
		contentPane.add(add_driver);

		exit_button = new JButton("Back");
		exit_button.addActionListener(this);
		exit_button.setBounds(201, 353, 111, 33);
        exit_button.setBackground(Color.BLACK);
        exit_button.setForeground(Color.WHITE);
		contentPane.add(exit_button);

		
	    contentPane.setBackground(Color.WHITE);
	    
	    id_text = new JLabel("ID:");
	    id_text.setForeground(new Color(25, 25, 112));
	    id_text.setFont(new Font("Tahoma", Font.BOLD, 14));
	    id_text.setBounds(67, 69, 102, 22);
	    contentPane.add(id_text);
	    
	    id_textbox = new JTextField();
	    id_textbox.setBounds(177, 69, 156, 20);
	    contentPane.add(id_textbox);
	    setVisible(true);
	    

	}
		
	//controlling SQL query and button action
	  public void actionPerformed(ActionEvent ae) {    
          String query = "INSERT INTO driver VALUES(?,?,?,?,?,?,?)";

	      if(ae.getSource() == add_driver){
	    	  String id = id_textbox.getText();
	    	  String name = name_textbox.getText();
	          String age = age_textbox.getText();
	          String gender = (String)gender_textbox.getSelectedItem();
	          String company  = car_company_textbox.getText();
	          String brand = car_brand_textbox.getText();
	          String available = (String)availability_textbox.getSelectedItem();
	    	  try{
	    		  Connection_demo c = new Connection_demo();
		    	  PreparedStatement stmt=c.getC().prepareStatement(query);
		    	  stmt.setString(1, id);
		    	  stmt.setString(2, name);
		    	  stmt.setString(3, age);
		    	  stmt.setString(4, gender);
		    	  stmt.setString(5, company);
		    	  stmt.setString(6, brand);
		    	  stmt.setString(7, available);
		    		
		    	  int myRs = stmt.executeUpdate();
		    	  c.getC().close();
		    		
	              }catch (Exception e) {
	            	  e.printStackTrace();
					}
	    	  
	    	  JOptionPane.showMessageDialog(null, "Driver Successfully Added");
    		  this.setVisible(false);
	            }
	            else if(ae.getSource() == exit_button){
	                this.setVisible(false);
	            }
	        }

}
