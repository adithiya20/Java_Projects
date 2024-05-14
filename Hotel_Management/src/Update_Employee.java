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

public class Update_Employee extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_textbox;
	private JTextField gender_textbox;
	private JButton update_button,check_button,exit_button;
	private JTextField age_textbox;
	private JTextField job_textbox;
	private JLabel job_text;
	private JTextField salary_textbox;
	private JLabel salary_text;
	private JTextField phone_textbox;
	private JLabel phone_num_text;
	private JTextField email_textbox;
	private JLabel email_text;
	private JTextField id_textbox;
	private JLabel id_text;


	public Update_Employee() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_textbox = new JTextField();
		name_textbox.setColumns(10);
		name_textbox.setBounds(171, 106, 142, 20);
		contentPane.add(name_textbox);
		
		JLabel name_text = new JLabel("Name:");
		name_text.setBounds(52, 109, 91, 14);
		contentPane.add(name_text);
		
		gender_textbox = new JTextField();
		gender_textbox.setColumns(10);
		gender_textbox.setBounds(171, 166, 142, 20);
		contentPane.add(gender_textbox);
		
		JLabel gender_text = new JLabel("Gender:");
		gender_text.setBounds(52, 169, 91, 14);
		contentPane.add(gender_text);
		
		JLabel title_text = new JLabel("UPDATE EMPLOYEE INFO");
		title_text.setFont(new Font("Tahoma", Font.BOLD, 21));
		title_text.setBounds(66, 28, 331, 39);
		contentPane.add(title_text);
		
		check_button = new JButton("Check");
		check_button.addActionListener(this);
		check_button.setBounds(42, 341, 89, 23);
		contentPane.add(check_button);
		
		update_button = new JButton("Update");
		update_button.addActionListener(this);
		update_button.setBounds(167, 341, 89, 23);
		contentPane.add(update_button);
		
		exit_button = new JButton("Back");
		exit_button.addActionListener(this);
		exit_button.setBounds(284, 341, 89, 23);
		contentPane.add(exit_button);
		
		JLabel age_text = new JLabel("Age:");
		age_text.setBounds(52, 138, 91, 14);
		contentPane.add(age_text);
		
		age_textbox = new JTextField();
		age_textbox.setColumns(10);
		age_textbox.setBounds(171, 135, 142, 20);
		contentPane.add(age_textbox);
		
		job_textbox = new JTextField();
		job_textbox.setColumns(10);
		job_textbox.setBounds(171, 197, 142, 20);
		contentPane.add(job_textbox);
		
		job_text = new JLabel("Job:");
		job_text.setBounds(52, 200, 91, 14);
		contentPane.add(job_text);
		
		salary_textbox = new JTextField();
		salary_textbox.setColumns(10);
		salary_textbox.setBounds(171, 228, 142, 20);
		contentPane.add(salary_textbox);
		
		salary_text = new JLabel("Salary:");
		salary_text.setBounds(52, 231, 91, 14);
		contentPane.add(salary_text);
		
		phone_textbox = new JTextField();
		phone_textbox.setColumns(10);
		phone_textbox.setBounds(171, 259, 142, 20);
		contentPane.add(phone_textbox);
		
		phone_num_text = new JLabel("Phone Number:");
		phone_num_text.setBounds(52, 262, 91, 14);
		contentPane.add(phone_num_text);
		
		email_textbox = new JTextField();
		email_textbox.setColumns(10);
		email_textbox.setBounds(171, 290, 142, 20);
		contentPane.add(email_textbox);
		
		email_text = new JLabel("Email:");
		email_text.setBounds(52, 293, 91, 14);
		contentPane.add(email_text);
		
		id_textbox = new JTextField();
		id_textbox.setColumns(10);
		id_textbox.setBounds(171, 75, 142, 20);
		contentPane.add(id_textbox);
		
		id_text = new JLabel("ID:");
		id_text.setBounds(52, 78, 91, 14);
		contentPane.add(id_text);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==update_button){
			String id = id_textbox.getText();			
			String name = name_textbox.getText();
			String age = age_textbox.getText();
			String gender = gender_textbox.getText();
			String job= job_textbox.getText();
			String salary= salary_textbox.getText();
			String pnum= phone_textbox.getText();
			String email= email_textbox.getText();
			
			int result=updatebutton_connection(id,name, age, gender, job, salary, pnum, email);
			if (result==1) {
				JOptionPane.showMessageDialog(null, "Employee Successfully Updated");
			}
			else {
				JOptionPane.showMessageDialog(null, "Employee Update Failed");
			}
		}
		else if(e.getSource()==check_button) {
			String[] employee_data=checkbutton_connection();
			//id_textbox.setText(employee_data[0]);
			name_textbox.setText(employee_data[1]);
			age_textbox.setText(employee_data[2]);
			gender_textbox.setText(employee_data[3]);
			job_textbox.setText(employee_data[4]);
			salary_textbox.setText(employee_data[5]);
			phone_textbox.setText(employee_data[6]);
			email_textbox.setText(employee_data[7]);
		}
		else if(e.getSource() == exit_button) {
			setVisible(false);
		}
	}
	
	
	public String[] checkbutton_connection(){
		 
		String query = "SELECT * FROM employee WHERE ID='"+id_textbox.getText()+"'";
		String [] data = new String[8];
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	ResultSet rs = stmt.executeQuery();     
         	         	 
         	 while(rs.next()) { 
         		 String id = rs.getString("ID");
             	 String name =rs.getString("E_name"); 
             	 String age=rs.getString("Age");
             	 String gender= rs.getString("Gender"); 
             	 String job= rs.getString("Job");
             	String salary= rs.getString("Salary");
             	String pnum= rs.getString("Phone");
             	String email= rs.getString("Email");
             	data[0]=id;
             	 data[1]=name;
             	 data[2]=age;
             	 data[3]=gender;
             	 data[4]=job;
             	 data[5]=salary;
             	data[6]=pnum;
             	data[7]=email;            	 
             	 }
         	 rs.close();
         	 c.getC().close();
         	 }
         catch (Exception e) {
			e.printStackTrace();
		}
         return data;
	
	}
	
	public int updatebutton_connection(String id,String name,String age,String gender,String job,String salary,String pnum,String email){
		 
		String query = "UPDATE employee SET E_name=?,Age=?,Gender=?,Job=?,Salary=?,Phone=?,Email=? WHERE ID='"+id+"'";
		
         try {
         	Connection_demo c = new Connection_demo();
         	PreparedStatement stmt=c.getC().prepareStatement(query);
         	stmt.setString(1,name);
         	stmt.setString(2, age);
         	stmt.setString(3, gender);
         	stmt.setString(4, job);
         	stmt.setString(5,salary);
         	stmt.setString(6,pnum);
         	stmt.setString(7,email);
         	
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
		new Update_Employee();
	}
}
