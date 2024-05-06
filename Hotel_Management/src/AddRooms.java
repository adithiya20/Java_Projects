import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddRooms extends JFrame implements ActionListener {

private JPanel contentPane;
private JLabel heading, room_number, available, cleaning_status, price, bed_type;
private JTextField room_num,price_num;
private JComboBox availability_options, bedtype_options,cleaningstatus_options;
private JButton add_room, cancel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	AddRooms(){
		//set frame parameters
		setBounds(450, 200, 1000, 450);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l15 = new JLabel(i2);
        l15.setBounds(400,30,500,370);
        getContentPane().add(l15);
	        
        //add labels
        heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(112, 11, 120, 22);
		contentPane.add(heading);
	        	        
		room_number = new JLabel("Room Number");
		room_number.setForeground(new Color(25, 25, 112));
		room_number.setFont(new Font("Tahoma", Font.BOLD, 14));
		room_number.setBounds(64, 70, 102, 22);
		contentPane.add(room_number);
	        
	   	available = new JLabel("Availability");
		available.setForeground(new Color(25, 25, 112));
		available.setFont(new Font("Tahoma", Font.BOLD, 14));
		available.setBounds(64, 110, 102, 22);
		contentPane.add(available);
	        
		cleaning_status = new JLabel("Cleaning Status");
		cleaning_status.setForeground(new Color(25, 25, 112));
		cleaning_status.setFont(new Font("Tahoma", Font.BOLD, 14));
		cleaning_status.setBounds(64, 150, 102, 22);
		contentPane.add(cleaning_status);
	        
		price = new JLabel("Price");
		price.setForeground(new Color(25, 25, 112));
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		price.setBounds(64, 190, 102, 22);
		contentPane.add(price);
		
		bed_type = new JLabel("Bed Type");
		bed_type.setForeground(new Color(25, 25, 112));
		bed_type.setFont(new Font("Tahoma", Font.BOLD, 14));
		bed_type.setBounds(64, 230, 102, 22);
		contentPane.add(bed_type);
		
		//add text fields and combo boxes
	    room_num = new JTextField();
		room_num.setBounds(174, 70, 156, 20);
		contentPane.add(room_num);
	        
	    price_num = new JTextField();
		price_num.setBounds(174, 190, 156, 20);
		contentPane.add(price_num);

        availability_options = new JComboBox(new String[] { "Available", "Occupied" });
		availability_options.setBounds(176, 110, 154, 20);
		contentPane.add(availability_options);
		
	    cleaningstatus_options = new JComboBox(new String[] { "Cleaned", "Dirty" });
		cleaningstatus_options.setBounds(176, 150, 154, 20);
		contentPane.add(cleaningstatus_options);

	    bedtype_options = new JComboBox(new String[] { "Single Bed", "Double Bed"});
		bedtype_options.setBounds(176, 230, 154, 20);
		contentPane.add(bedtype_options);

		//add buttons 
		add_room = new JButton("Add");
		add_room.addActionListener(this);
		add_room.setBounds(64, 321, 111, 33);
	    add_room.setBackground(Color.BLACK);
	    add_room.setForeground(Color.WHITE);
		contentPane.add(add_room);

		cancel = new JButton("Back");
		cancel.addActionListener(this);
		cancel.setBounds(198, 321, 111, 33);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
		contentPane.add(cancel);

		
        contentPane.setBackground(Color.WHITE);
	}
	    
	    
	    public void actionPerformed(ActionEvent ae){
	    	String room = room_num.getText() ;
            String availability = (String) availability_options.getSelectedItem();
            String status = (String)cleaningstatus_options.getSelectedItem();
            String price  =(price_num.getText());
            String type = (String)bedtype_options.getSelectedItem();
            
            
	    	
	    	if(ae.getSource() == add_room){
	    		String query =  "INSERT INTO room VALUES(?,?,?,?,?)";
	    		try {
	    		Connection_demo c = new Connection_demo();
	    		PreparedStatement stmt=c.getC().prepareStatement(query);
	    		stmt.setString(1, room);
	    		stmt.setString(2, availability);
	    		stmt.setString(3, status);
	    		stmt.setString(4, price);
	    		stmt.setString(5, type);
	    		
	    		int myRs = stmt.executeUpdate();
	    		c.getC().close();
	    		}
	    		catch (Exception e) {
					e.printStackTrace();
				}
	            
	            JOptionPane.showMessageDialog(null, "Room Successfully Added");
	            new Reception();
	            this.setVisible(false);
	            }
	            else if(ae.getSource() == cancel){
	            	new Reception();
	                this.setVisible(false);
	            }
	        }
	    
}