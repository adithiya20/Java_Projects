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
	private JLabel lblName,document_text,number_text,name_text,gender_text,country_text,room_num_text, checkin_time_text,deposit_text;
    private JComboBox document_textbox;
    private JComboBox room_num_textbox;
    private JButton exit_button;
    private JButton add_button;
    private String radio;
    ArrayList<String> available_rooms_list = new ArrayList<String>();
    private JLabel id_text;
    private JTextField id_textbox;
    private JTextField gender_textbox;

	public AddCustomer() {
			
	        setBounds(530, 200, 850, 550);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
			
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
	                
	        document_text = new JLabel("Document:");
			document_text.setBounds(36, 119, 200, 14);
			contentPane.add(document_text);
	                
	        document_textbox = new JComboBox(new String[] {"Passport","Driving license","Other"});
			document_textbox.setBounds(272, 116, 150, 20);
			contentPane.add(document_textbox);
	                
	        number_text = new JLabel("Phone Number :");
			number_text.setBounds(36, 189, 200, 14);
			contentPane.add(number_text);
	                
	        number_textbox = new JTextField();
			number_textbox.setBounds(272, 189, 150, 20);
			contentPane.add(number_textbox);
			number_textbox.setColumns(10);
			
			name_text = new JLabel("Name :");
			name_text.setBounds(36, 158, 200, 14);
			contentPane.add(name_text);
			
			name_textbox = new JTextField();
			name_textbox.setBounds(272, 158, 150, 20);
			contentPane.add(name_textbox);
			name_textbox.setColumns(10);
	
	                
			gender_text = new JLabel("Gender :");
			gender_text.setBounds(36, 234, 200, 14);
			contentPane.add(gender_text);
	                
			country_text = new JLabel("Country :");
			country_text.setBounds(36, 274, 200, 14);
			contentPane.add(country_text);
			
			room_num_text = new JLabel("Allocated Room Number :");
			room_num_text.setBounds(36, 317, 200, 14);
			contentPane.add(room_num_text);
			
			  try{
     	        	String query =  "SELECT * FROM room WHERE Availability='Available' AND Cleaning_status='Cleaned'";
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
	        room_num_textbox.setBounds(272, 317, 150, 20);
			contentPane.add(room_num_textbox);
			
			checkin_time_text = new JLabel("Checked-In :");
			checkin_time_text.setBounds(36, 359, 200, 14);
			contentPane.add(checkin_time_text);
			
			deposit_text = new JLabel("Deposit :");
			deposit_text.setBounds(36, 402, 200, 14);
			contentPane.add(deposit_text);
		
			country_textbox = new JTextField();
			country_textbox.setBounds(272, 274, 150, 20);
			contentPane.add(country_textbox);
			country_textbox.setColumns(10);
			
			
			checkin_time_textbox = new JTextField();
			checkin_time_textbox.setBounds(272, 359, 150, 20);
			contentPane.add(checkin_time_textbox);
			checkin_time_textbox.setColumns(10);
			
			deposit_textbox = new JTextField();
			deposit_textbox.setBounds(272, 402, 150, 20);
			contentPane.add(deposit_textbox);
			deposit_textbox.setColumns(10);
            
            exit_button = new JButton("Back");
            exit_button.addActionListener(this);
            exit_button.setBounds(263, 477, 89, 23);
            contentPane.add(exit_button);
            
            add_button = new JButton("Add");
            add_button.addActionListener(this);
            add_button.setBounds(119, 477, 89, 23);
            contentPane.add(add_button);
            
            id_text = new JLabel("ID:");
            id_text.setBounds(36, 75, 200, 14);
            contentPane.add(id_text);
            
            id_textbox = new JTextField();
            id_textbox.setColumns(10);
            id_textbox.setBounds(272, 75, 150, 20);
            contentPane.add(id_textbox);
            
            gender_textbox = new JTextField();
            gender_textbox.setColumns(10);
            gender_textbox.setBounds(272, 231, 150, 20);
            contentPane.add(gender_textbox);      
        	this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = id_textbox.getText();
		String document= (String)document_textbox.getSelectedItem();
		String phone_num=number_textbox.getText();
		String name = name_textbox.getText();
		String gender = gender_textbox.getText();
		String country = country_textbox.getText();
		String room_number = (String)room_num_textbox.getSelectedItem();
		String checkin_time = checkin_time_textbox.getText();
		String deposit = deposit_textbox.getText();
		System.out.println(gender);
		
		
		if(e.getSource() == add_button){
    		String query =  "INSERT INTO customer(ID,Document,C_name,Phone,Gender,Country,Roomnumber,Checkin_time,Deposit) VALUES(?,?,?,?,?,?,?,?,?)";
    		String query2 = "UPDATE room SET Availability = 'Occupied' AND Cleaning_status = 'Dirty' WHERE Roomnumber = '"+room_number+"'";
    		try {
    		Connection_demo c = new Connection_demo();
    		PreparedStatement stmt=c.getC().prepareStatement(query);
    		stmt.setString(1,id);
    		stmt.setString(2, document);
    		stmt.setString(3, name);
    		stmt.setString(4, phone_num);
    		stmt.setString(5, gender);
    		stmt.setString(6, country);
    		stmt.setString(7, room_number);
    		stmt.setString(8, checkin_time);
    		stmt.setString(9, deposit);
    		
    		int myRs = stmt.executeUpdate();
    		PreparedStatement stmt2=c.getC().prepareStatement(query2);
    		stmt2.executeUpdate();
    		c.getC().close();
    		}
    		catch (Exception e1) {
				e1.printStackTrace();	
				}
    		
            JOptionPane.showMessageDialog(null, "Customer Successfully Added");
            this.setVisible(false);
            }
            else if(e.getSource() == exit_button){
            	this.setVisible(false);
                
            }
		
	}
}
