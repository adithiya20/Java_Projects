import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Update_Room extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField roomnumber_textbox;
	private JTextField cleaning_status_textbox;
	private JTextField price_textbox;
	private JTextField bed_type_textbox;
	private JButton update_button,check_button,exit_button;
	private JTextField availability_textbox;


	public Update_Room() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		roomnumber_textbox = new JTextField();
		roomnumber_textbox.setBounds(174, 110, 142, 20);
		contentPane.add(roomnumber_textbox);
		roomnumber_textbox.setColumns(10);
		
		JLabel roomnumber_text = new JLabel("Room Number:");
		roomnumber_text.setBounds(55, 113, 91, 14);
		contentPane.add(roomnumber_text);
		
		JLabel availability_text = new JLabel("Availability:");
		availability_text.setBounds(55, 145, 91, 14);
		contentPane.add(availability_text);
		
		cleaning_status_textbox = new JTextField();
		cleaning_status_textbox.setColumns(10);
		cleaning_status_textbox.setBounds(174, 174, 142, 20);
		contentPane.add(cleaning_status_textbox);
		
		JLabel cleaning_status_text = new JLabel("Cleaning Status:");
		cleaning_status_text.setBounds(55, 177, 91, 14);
		contentPane.add(cleaning_status_text);
		
		price_textbox = new JTextField();
		price_textbox.setColumns(10);
		price_textbox.setBounds(174, 213, 142, 20);
		contentPane.add(price_textbox);
		
		JLabel price_text = new JLabel("Price:");
		price_text.setBounds(55, 216, 91, 14);
		contentPane.add(price_text);
		
		bed_type_textbox = new JTextField();
		bed_type_textbox.setColumns(10);
		bed_type_textbox.setBounds(174, 260, 142, 20);
		contentPane.add(bed_type_textbox);
		
		JLabel Bedtype_text = new JLabel("Bed Type:");
		Bedtype_text.setBounds(55, 263, 91, 14);
		contentPane.add(Bedtype_text);
		
		JLabel title_text = new JLabel("UPDATE ROOM INFO");
		title_text.setFont(new Font("Tahoma", Font.BOLD, 21));
		title_text.setBounds(112, 28, 261, 39);
		contentPane.add(title_text);
		
		check_button = new JButton("Check");
		check_button.addActionListener(this);
		check_button.setBounds(42, 319, 89, 23);
		contentPane.add(check_button);
		
		update_button = new JButton("Update");
		update_button.addActionListener(this);
		update_button.setBounds(167, 319, 89, 23);
		contentPane.add(update_button);
		
		exit_button = new JButton("Back");
		exit_button.addActionListener(this);
		exit_button.setBounds(284, 319, 89, 23);
		contentPane.add(exit_button);
		
		availability_textbox = new JTextField();
		availability_textbox.setColumns(10);
		availability_textbox.setBounds(174, 142, 142, 20);
		contentPane.add(availability_textbox);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==update_button){
			String room_num = roomnumber_textbox.getText();
			String avail = (String)availability_textbox.getText();
			String cleaning = cleaning_status_textbox.getText();
			String price = price_textbox.getText();
			String bed_type= bed_type_textbox.getText();
			int result=updatebutton_connection(room_num,avail,cleaning,price,bed_type);
			if (result==1) {
				JOptionPane.showMessageDialog(null, "Room Successfully Updated");
			}
			else {
				JOptionPane.showMessageDialog(null, "Room Update Failed");
			}
		}
		else if(e.getSource()==check_button) {
			String[] room_data=checkbutton_connection();
			//roomnumber_textbox.setText(room_data[0]);
			availability_textbox.setText(room_data[1]);
			cleaning_status_textbox.setText(room_data[2]);
			price_textbox.setText(room_data[3]);
			bed_type_textbox.setText(room_data[4]);
			
		}
		else if(e.getSource() == exit_button) {
			setVisible(false);
		}
	}
	
	
	public String[] checkbutton_connection(){
		 
		String query = "SELECT * FROM room WHERE Roomnumber='"+roomnumber_textbox.getText()+"'";
		String [] data = new String[5];
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	ResultSet rs = stmt.executeQuery();     	
         	         	 
         	 while(rs.next()) { 
         		 String room_number = rs.getString("Roomnumber"); 
             	 String avail= rs.getString("availability"); 
             	 String cleaning_status =rs.getString("cleaning_status"); 
             	 String price= rs.getString("price"); 
             	 String bed_type= rs.getString("bed_type");
             	 data[0]=room_number;
             	 data[1]=avail;
             	 data[2]=cleaning_status;
             	 data[3]=price;
             	 data[4]=bed_type;
            	 
             	 }
         	 rs.close();
         	 c.getC().close();
         	 }
         catch (Exception e) {
			e.printStackTrace();
		}
         return data;
	
	}
	
	public int updatebutton_connection(String roomnum, String avail,String cleaning_status,String price,String bed_type){
		 
		String query = "UPDATE room SET Availability=?,Cleaning_status=?,Price=?,Bed_type=? WHERE Roomnumber='"+roomnum+"'";
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	stmt.setString(1, avail);
         	stmt.setString(2, cleaning_status);
         	stmt.setString(3, price);
         	stmt.setString(4,bed_type);
         	stmt.executeUpdate();
         	 c.getC().close();
         	 return 1;
         	 }
         catch (Exception e) {
			e.printStackTrace();
		}
        
	return -1;
	}
	
}
