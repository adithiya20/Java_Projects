import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddCustomer extends JFrame implements ActionListener {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField number_textbox,name_textbox,country_textbox,t4,checkin_time_textbox,deposit_textbox;
	private JLabel lblName,ID_text,number_text,name_text,gender_text,country_text,room_num_text, checkin_time_text,deposit_text;
    private JComboBox ID_type;
    private JRadioButton r1,r2;
    private JComboBox room_num_textbox;
    private JButton exit_button;
    private JButton add_button;
    String radio;
    ArrayList<String> available_rooms_list = new ArrayList<String>();

	public AddCustomer() {
			
	        setBounds(530, 200, 850, 550);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			
	        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
	        Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
	        ImageIcon i2 = new ImageIcon(i3);
	        JLabel l1 = new JLabel(i2);
	        l1.setBounds(480,10,300,500);
	        getContentPane().add(l1);
			
			lblName = new JLabel("NEW CUSTOMER FORM");
			lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
			lblName.setBounds(118, 11, 260, 53);
			contentPane.add(lblName);
	                
	        ID_text = new JLabel("ID :");
			ID_text.setBounds(35, 76, 200, 14);
			contentPane.add(ID_text);
	                
	        ID_type = new JComboBox(new String[] {"Passport","Driving license","Other"});
			ID_type.setBounds(271, 73, 150, 20);
			contentPane.add(ID_type);
	                
	        number_text = new JLabel("Phone Number :");
			number_text.setBounds(35, 111, 200, 14);
			contentPane.add(number_text);
	                
	        number_textbox = new JTextField();
			number_textbox.setBounds(271, 111, 150, 20);
			contentPane.add(number_textbox);
			number_textbox.setColumns(10);
			
			name_text = new JLabel("Name :");
			name_text.setBounds(35, 151, 200, 14);
			contentPane.add(name_text);
			
			name_textbox = new JTextField();
			name_textbox.setBounds(271, 151, 150, 20);
			contentPane.add(name_textbox);
			name_textbox.setColumns(10);
	
	                
			gender_text = new JLabel("Gender :");
			gender_text.setBounds(35, 191, 200, 14);
			contentPane.add(gender_text);
	                
	        r1 = new JRadioButton("Male");
	        r1.setFont(new Font("Raleway", Font.BOLD, 14));
	        r1.setBackground(Color.WHITE);
	        r1.setBounds(271, 191, 80, 12);
	        getContentPane().add(r1);
	        
	        r2 = new JRadioButton("Female");
	        r2.setFont(new Font("Raleway", Font.BOLD, 14));
	        r2.setBackground(Color.WHITE);
	        r2.setBounds(350, 191, 100, 12);
			getContentPane().add(r2);
	                
			country_text = new JLabel("Country :");
			country_text.setBounds(35, 231, 200, 14);
			contentPane.add(country_text);
			
			room_num_text = new JLabel("Allocated Room Number :");
			room_num_text.setBounds(35, 274, 200, 14);
			contentPane.add(room_num_text);
			
			  try{
     	        	String query =  "SELECT * FROM room WHERE availability='Available'";
     	        	Connection_demo c = new Connection_demo();
     	    		PreparedStatement stmt=c.getC().prepareStatement(query);
     	            ResultSet rs = stmt.executeQuery();
     	            while(rs.next()){
     	                
     	                available_rooms_list.add(rs.getString("roomnumber"));    
     	            }
     	        }catch(Exception e1){
     	        	e1.printStackTrace();
     	        }
			  
	        room_num_textbox = new JComboBox(available_rooms_list.toArray());
	        room_num_textbox.setBounds(271, 274, 150, 20);
			contentPane.add(room_num_textbox);
			
			checkin_time_text = new JLabel("Checked-In :");
			checkin_time_text.setBounds(35, 316, 200, 14);
			contentPane.add(checkin_time_text);
			
			deposit_text = new JLabel("Deposit :");
			deposit_text.setBounds(35, 359, 200, 14);
			contentPane.add(deposit_text);
		
			country_textbox = new JTextField();
			country_textbox.setBounds(271, 231, 150, 20);
			contentPane.add(country_textbox);
			country_textbox.setColumns(10);
			
			
			checkin_time_textbox = new JTextField();
			checkin_time_textbox.setBounds(271, 316, 150, 20);
			contentPane.add(checkin_time_textbox);
			checkin_time_textbox.setColumns(10);
			
			deposit_textbox = new JTextField();
			deposit_textbox.setBounds(271, 359, 150, 20);
			contentPane.add(deposit_textbox);
			deposit_textbox.setColumns(10);
            
            exit_button = new JButton("Back");
            exit_button.addActionListener(this);
            exit_button.setBounds(262, 434, 89, 23);
            contentPane.add(exit_button);
            
            add_button = new JButton("Add");
            add_button.addActionListener(this);
            add_button.setBounds(118, 434, 89, 23);
            contentPane.add(add_button);
			       
            if(r1.isSelected()){radio ="M";}
            else if(r2.isSelected()){radio = "F";} 
        	this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id= (String) ID_type.getSelectedItem();
		String phone_num=number_textbox.getText();
		String name = name_textbox.getText();
		String gender = radio;
		String country = country_textbox.getText();
		String room_number = (String)room_num_textbox.getSelectedItem();
		String checkin_time = checkin_time_textbox.getText();
		String deposit = deposit_textbox.getText();
		
		
		if(e.getSource() == add_button){
    		String query =  "INSERT INTO customer(document, phone_number,name,gender,country,roomnumber,checkin_time,deposit) VALUES(?,?,?,?,?,?,?,?)";
    		String q2 = "UPDATE room SET availability = 'Occupied' WHERE roomnumber = '"+room_number+"'";
    		try {
    		Connection_demo c = new Connection_demo();
    		PreparedStatement stmt=c.getC().prepareStatement(query);
    		stmt.setString(1,id);
    		stmt.setString(2, phone_num);
    		stmt.setString(3, name);
    		stmt.setString(4, gender);
    		stmt.setString(5, country);
    		stmt.setString(6, room_number);
    		stmt.setString(7, checkin_time);
    		stmt.setString(8, deposit);
    		
    		int myRs = stmt.executeUpdate();
    		PreparedStatement stmt2=c.getC().prepareStatement(q2);
    		stmt2.executeUpdate();
    		c.getC().close();
    		}
    		catch (Exception e1) {
				e1.printStackTrace();	
				}
    		
            JOptionPane.showMessageDialog(null, "Customer Successfully Added");
            new Reception();
            this.setVisible(false);
            }
            else if(e.getSource() == exit_button){
            	new Reception();
            	this.setVisible(false);
                
            }
		
	}
}
