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

public class Update_Driver extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_textbox;
	private JTextField gender_textbox;
	private JTextField car_comp_textbox;
	private JTextField car_model_textbox;
	private JButton update_button,check_button,exit_button;
	private JTextField age_textbox;
	private JLabel availability_text;
	private JTextField availability_textbox;
	private JLabel id_text;
	private JTextField id_textbox;


	public Update_Driver() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_textbox = new JTextField();
		name_textbox.setBounds(174, 110, 142, 20);
		contentPane.add(name_textbox);
		name_textbox.setColumns(10);
		
		JLabel name_text = new JLabel("Name:");
		name_text.setBounds(55, 113, 91, 14);
		contentPane.add(name_text);
		
		JLabel age_text = new JLabel("Age:");
		age_text.setBounds(55, 145, 91, 14);
		contentPane.add(age_text);
		
		gender_textbox = new JTextField();
		gender_textbox.setColumns(10);
		gender_textbox.setBounds(174, 174, 142, 20);
		contentPane.add(gender_textbox);
		
		JLabel gender_text = new JLabel("Gender:");
		gender_text.setBounds(55, 177, 91, 14);
		contentPane.add(gender_text);
		
		car_comp_textbox = new JTextField();
		car_comp_textbox.setColumns(10);
		car_comp_textbox.setBounds(174, 213, 142, 20);
		contentPane.add(car_comp_textbox);
		
		JLabel car_comp_text = new JLabel("Car Company:");
		car_comp_text.setBounds(55, 216, 91, 14);
		contentPane.add(car_comp_text);
		
		car_model_textbox = new JTextField();
		car_model_textbox.setColumns(10);
		car_model_textbox.setBounds(174, 260, 142, 20);
		contentPane.add(car_model_textbox);
		
		JLabel car_model_text = new JLabel("Car Model:");
		car_model_text.setBounds(55, 263, 91, 14);
		contentPane.add(car_model_text);
		
		JLabel title_text = new JLabel("UPDATE DRIVER INFO");
		title_text.setFont(new Font("Tahoma", Font.BOLD, 21));
		title_text.setBounds(65, 25, 261, 39);
		contentPane.add(title_text);
		
		check_button = new JButton("Check");
		check_button.addActionListener(this);
		check_button.setBounds(42, 337, 89, 23);
		contentPane.add(check_button);
		
		update_button = new JButton("Update");
		update_button.addActionListener(this);
		update_button.setBounds(167, 337, 89, 23);
		contentPane.add(update_button);
		
		exit_button = new JButton("Back");
		exit_button.addActionListener(this);
		exit_button.setBounds(284, 337, 89, 23);
		contentPane.add(exit_button);
		
		age_textbox = new JTextField();
		age_textbox.setColumns(10);
		age_textbox.setBounds(174, 142, 142, 20);
		contentPane.add(age_textbox);
		
		availability_text = new JLabel("Availability:");
		availability_text.setBounds(55, 291, 91, 14);
		contentPane.add(availability_text);
		
		availability_textbox = new JTextField();
		availability_textbox.setColumns(10);
		availability_textbox.setBounds(174, 288, 142, 20);
		contentPane.add(availability_textbox);
		
		id_text = new JLabel("ID:");
		id_text.setBounds(55, 81, 91, 14);
		contentPane.add(id_text);
		
		id_textbox = new JTextField();
		id_textbox.setColumns(10);
		id_textbox.setBounds(174, 78, 142, 20);
		contentPane.add(id_textbox);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==update_button){
			String id = id_textbox.getText();
			String name = name_textbox.getText();
			String age = (String)age_textbox.getText();
			String gender = gender_textbox.getText();
			String car_company = car_comp_textbox.getText();
			String car_model= car_model_textbox.getText();
			String avail= availability_textbox.getText();
			int result=updatebutton_connection(id,name,age,gender,car_company,car_model,avail);
			if (result==1) {
				JOptionPane.showMessageDialog(null, "Driver Successfully Updated");
			}
			else {
				JOptionPane.showMessageDialog(null, "Driver Update Failed");
			}
		}
		else if(e.getSource()==check_button) {
			String[] driver_data=checkbutton_connection();
			//id_textbox.setText(driver_data[0]);
			name_textbox.setText(driver_data[1]);
			age_textbox.setText(driver_data[2]);
			gender_textbox.setText(driver_data[3]);
			car_comp_textbox.setText(driver_data[4]);
			car_model_textbox.setText(driver_data[5]);
			availability_textbox.setText(driver_data[6]);
			
		}
		else if(e.getSource() == exit_button) {
			setVisible(false);
		}
	}
	
	
	public String[] checkbutton_connection(){
		 
		String query = "SELECT * FROM driver WHERE ID='"+id_textbox.getText()+"'";
		String [] data = new String[7];
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	ResultSet rs = stmt.executeQuery();     	
         	         	 
         	 while(rs.next()) { 
         		 String id = rs.getString("ID");
         		 String name = rs.getString("D_name"); 
             	 String age= rs.getString("Age"); 
             	 String gender =rs.getString("Gender"); 
             	 String car_comp= rs.getString("Car_company"); 
             	 String car_model= rs.getString("Car_model");
             	String avail= rs.getString("Availability");
             	data[0]=id;
             	 data[1]=name;
             	 data[2]=age;
             	 data[3]=gender;
             	 data[4]=car_comp;
             	 data[5]=car_model;
             	 data[6]=avail;
             	 }
         	 rs.close();
         	 c.getC().close();
         	 }
         catch (Exception e) {
			e.printStackTrace();
		}
         return data;
	
	}
	
	public int updatebutton_connection(String id,String name, String age,String gender,String car_company,String car_model,String avail){
		 
		String query = "UPDATE driver SET D_name=?,Age=?,Gender=?,Car_company=?,Car_model=?,Availability=? WHERE ID='"+id+"'";
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	stmt.setString(1,name);
         	stmt.setString(2, age);
         	stmt.setString(3, gender);
         	stmt.setString(4, car_company);
         	stmt.setString(5,car_model);
         	stmt.setString(6,avail);
 
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
