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

public class Update_Customer extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField document_textbox;
	private JTextField name_textbox;
	private JTextField gender_textbox;
	private JTextField country_textbox;
	private JButton update_button,check_button,exit_button;
	private JTextField phonenum_textbox;
	private JTextField roomnum_textbox;
	private JTextField checkin_textbox;
	private JTextField checkout_textbox;
	private JTextField deposit_textbox;
	private JTextField id_textbox;
	private JLabel id_text;


	public Update_Customer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		document_textbox = new JTextField();
		document_textbox.setBounds(175, 118, 142, 20);
		contentPane.add(document_textbox);
		document_textbox.setColumns(10);
		
		JLabel document_text = new JLabel("Document Type:");
		document_text.setBounds(56, 121, 91, 14);
		contentPane.add(document_text);
		
		JLabel phonenum_text = new JLabel("Phone Number:");
		phonenum_text.setBounds(56, 180, 91, 14);
		contentPane.add(phonenum_text);
		
		name_textbox = new JTextField();
		name_textbox.setColumns(10);
		name_textbox.setBounds(175, 149, 142, 20);
		contentPane.add(name_textbox);
		
		JLabel name_text = new JLabel("Name:");
		name_text.setBounds(56, 152, 91, 14);
		contentPane.add(name_text);
		
		gender_textbox = new JTextField();
		gender_textbox.setColumns(10);
		gender_textbox.setBounds(175, 208, 142, 20);
		contentPane.add(gender_textbox);
		
		JLabel gender_text = new JLabel("Gender:");
		gender_text.setBounds(56, 211, 91, 14);
		contentPane.add(gender_text);
		
		country_textbox = new JTextField();
		country_textbox.setColumns(10);
		country_textbox.setBounds(175, 239, 142, 20);
		contentPane.add(country_textbox);
		
		JLabel country_text = new JLabel("Country:");
		country_text.setBounds(56, 242, 91, 14);
		contentPane.add(country_text);
		
		JLabel title_text = new JLabel("UPDATE CUSTOMER INFO");
		title_text.setFont(new Font("Tahoma", Font.BOLD, 21));
		title_text.setBounds(42, 28, 331, 39);
		contentPane.add(title_text);
		
		check_button = new JButton("Check");
		check_button.addActionListener(this);
		check_button.setBounds(42, 414, 89, 23);
		contentPane.add(check_button);
		
		update_button = new JButton("Update");
		update_button.addActionListener(this);
		update_button.setBounds(167, 414, 89, 23);
		contentPane.add(update_button);
		
		exit_button = new JButton("Back");
		exit_button.addActionListener(this);
		exit_button.setBounds(284, 414, 89, 23);
		contentPane.add(exit_button);
		
		phonenum_textbox = new JTextField();
		phonenum_textbox.setColumns(10);
		phonenum_textbox.setBounds(175, 177, 142, 20);
		contentPane.add(phonenum_textbox);
		
		roomnum_textbox = new JTextField();
		roomnum_textbox.setColumns(10);
		roomnum_textbox.setBounds(175, 270, 142, 20);
		contentPane.add(roomnum_textbox);
		
		JLabel roomnum_text = new JLabel("Room Number:");
		roomnum_text.setBounds(56, 273, 91, 14);
		contentPane.add(roomnum_text);
		
		checkin_textbox = new JTextField();
		checkin_textbox.setColumns(10);
		checkin_textbox.setBounds(175, 301, 142, 20);
		contentPane.add(checkin_textbox);
		
		JLabel checkin_text = new JLabel("Check-in Time:");
		checkin_text.setBounds(56, 304, 91, 14);
		contentPane.add(checkin_text);
		
		checkout_textbox = new JTextField();
		checkout_textbox.setColumns(10);
		checkout_textbox.setBounds(175, 332, 142, 20);
		contentPane.add(checkout_textbox);
		
		JLabel checkout_text = new JLabel("Check-out Time:");
		checkout_text.setBounds(56, 335, 91, 14);
		contentPane.add(checkout_text);
		
		deposit_textbox = new JTextField();
		deposit_textbox.setColumns(10);
		deposit_textbox.setBounds(175, 363, 142, 20);
		contentPane.add(deposit_textbox);
		
		JLabel deposit_text = new JLabel("Deposit:");
		deposit_text.setBounds(56, 366, 91, 14);
		contentPane.add(deposit_text);
		
		id_textbox = new JTextField();
		id_textbox.setColumns(10);
		id_textbox.setBounds(175, 87, 142, 20);
		contentPane.add(id_textbox);
		
		id_text = new JLabel("ID:");
		id_text.setBounds(56, 90, 91, 14);
		contentPane.add(id_text);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==update_button){
			String id=id_textbox.getText();
			String document = document_textbox.getText();
			String pnum = (String)phonenum_textbox.getText();
			String name = name_textbox.getText();
			String gender = gender_textbox.getText();
			String country= country_textbox.getText();
			String roomnum= roomnum_textbox.getText();
			String checkin= checkin_textbox.getText();
			String checkout= checkout_textbox.getText();
			String deposit= deposit_textbox.getText();
			
			int result=updatebutton_connection(id,document,name,pnum,gender,country,roomnum,checkin,checkout,deposit);
			if (result==1) {
				JOptionPane.showMessageDialog(null, "Customer Successfully Updated");
			}
			else {
				JOptionPane.showMessageDialog(null, "Customer Update Failed");
			}
		}
		else if(e.getSource()==check_button) {
			String[] customer_data=checkbutton_connection();
			//id_textbox.setText(customer_data[0]);
			document_textbox.setText(customer_data[1]);
			phonenum_textbox.setText(customer_data[2]);
			name_textbox.setText(customer_data[3]);
			gender_textbox.setText(customer_data[4]);
			country_textbox.setText(customer_data[5]);
			roomnum_textbox.setText(customer_data[6]);
			checkin_textbox.setText(customer_data[7]);
			checkout_textbox.setText(customer_data[8]);
			deposit_textbox.setText(customer_data[9]);
		}
		else if(e.getSource() == exit_button) {
			setVisible(false);
		}
	}
	
	
	public String[] checkbutton_connection(){
		 
		String query = "SELECT * FROM customer WHERE id='"+id_textbox.getText()+"'";
		String [] data = new String[10];
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	ResultSet rs = stmt.executeQuery();     	
         	         	 
         	 while(rs.next()) { 
         		 String id = rs.getString("ID");
         		 String document = rs.getString("Document");
         		String name =rs.getString("C_name"); 
             	 String pnum= rs.getString("Phone"); 
             	 String gender= rs.getString("Gender"); 
             	 String country= rs.getString("Country");
             	String roomnum= rs.getString("Roomnumber");
             	String checkin= rs.getString("Checkin_time");
             	String checkout= rs.getString("Checkout_time");
             	String deposit= rs.getString("Deposit");
             	data[0]=id;
             	 data[1]=document;
             	 data[2]=pnum;
             	 data[3]=name;
             	 data[4]=gender;
             	 data[5]=country;
             	data[6]=roomnum;
             	data[7]=checkin;
             	data[8]=checkout;
             	data[9]=deposit;
            	 
             	 }
         	 rs.close();
         	 c.getC().close();
         	 }
         catch (Exception e) {
			e.printStackTrace();
		}
         return data;
	
	}
	
	public int updatebutton_connection(String id,String document,String name,String pnum,String gender,String country,String roomnumber,String checkin,String checkout, String deposit){
		 
		String query = "UPDATE customer SET Document=?,C_name=?,Phone=?,Gender=?,Country=?,Roomnumber=?,Checkin_time=?,Checkout_time=?,Deposit=? WHERE ID='"+id+"'";
		
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	stmt.setString(1,document);
         	stmt.setString(2, name);
         	stmt.setString(3, pnum);
         	stmt.setString(4, gender);
         	stmt.setString(5,country);
         	stmt.setString(6,roomnumber);
         	stmt.setString(7,checkin);
         	stmt.setString(8,checkout);
         	stmt.setString(9,deposit);
         	
         	stmt.executeUpdate();
         	 c.getC().close();
         	 return 1;
         	 }
         catch (Exception e) {
			e.printStackTrace();
		}
        
	return -1;
	}

	
	public static void main(String[] args) {
		new Update_Customer();
	}
}
