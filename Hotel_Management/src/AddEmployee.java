import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.PreparedStatement;

import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener{
	JTextField name_textbox,age_textbox,textField_2,salary_textbox,phone_textbox,textField_5,email_textbox;
    JComboBox job_textbox;
    JRadioButton NewRadioButton;
    JRadioButton Female;
    JButton add_button,exit_button;

    public AddEmployee(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("ADD EMPLOYEE DETAILS");
	 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);
		
        JLabel name_text = new JLabel("NAME");
        name_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        name_text.setBounds(60, 30, 150, 27);
        getContentPane().add(name_text);
        
        name_textbox = new JTextField();
        name_textbox.setBounds(200, 30, 150, 27);
        getContentPane().add(name_textbox);
		
        JLabel age_text = new JLabel("AGE");
        age_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        age_text.setBounds(60, 80, 150, 27);
        getContentPane().add(age_text);
		
        age_textbox = new JTextField();
        age_textbox.setBounds(200, 80, 150, 27);
        getContentPane().add(age_textbox);
        
        JLabel gender_text = new JLabel("GENDER");
        gender_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gender_text.setBounds(60, 120, 150, 27);
        getContentPane().add(gender_text);
	
        NewRadioButton = new JRadioButton("MALE");
        NewRadioButton.setBackground(Color.WHITE);
        NewRadioButton.setBounds(200, 120, 70, 27);
        getContentPane().add(NewRadioButton);

        Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(280, 120, 70, 27);
        getContentPane().add(Female);
        
        
        JLabel job_text = new JLabel("JOB");
        job_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        job_text.setBounds(60, 170, 150, 27);
        getContentPane().add(job_text);
		
        String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
        job_textbox = new JComboBox(course);
        job_textbox.setBackground(Color.WHITE);
        job_textbox.setBounds(200,170,150,30);
        getContentPane().add(job_textbox);
        		
        JLabel salary_text = new JLabel("SALARY");
        salary_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        salary_text.setBounds(60, 220, 150, 27);
        getContentPane().add(salary_text);
		
        salary_textbox = new JTextField();
        salary_textbox.setBounds(200, 220, 150, 27);
        getContentPane().add(salary_textbox);

        JLabel phone_text = new JLabel("PHONE");
        phone_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        phone_text.setBounds(60, 270, 150, 27);
        getContentPane().add(phone_text);

        phone_textbox = new JTextField();
        phone_textbox.setBounds(200, 270, 150, 27);
        getContentPane().add(phone_textbox);
        
        JLabel email_text = new JLabel("EMAIL");
        email_text.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email_text.setBounds(60, 319, 150, 27);
        getContentPane().add(email_text);
		
        email_textbox = new JTextField();
        email_textbox.setBounds(200, 319, 150, 27);
        getContentPane().add(email_textbox);

        setVisible(true);

        JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        getContentPane().add(AddPassengers);
		
 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(410,80,480,410);
        getContentPane().add(image);
        
        add_button = new JButton("Add");
        add_button.setBounds(86, 408, 89, 23);
        getContentPane().add(add_button);
        add_button.addActionListener(this);
        
        exit_button = new JButton("Back");
        exit_button.setBounds(212, 408, 89, 23);
        exit_button.addActionListener(this);
        getContentPane().add(exit_button);
        setSize(900,600);
        setVisible(true);
        setLocation(530,200);
    }

        	@Override
            public void actionPerformed(ActionEvent ae){
                String name = name_textbox.getText();
                String age = age_textbox.getText();
                String salary = salary_textbox.getText();
                String phone = phone_textbox.getText();
                String email = email_textbox.getText();
               
                String gender = null;
                
                if(NewRadioButton.isSelected()){
                    gender = "Male";
                
                }else if(Female.isSelected()){
                    gender = "Female";
                }

                        
                String job_role = (String)job_textbox.getSelectedItem();
                
                if(ae.getSource() == add_button) {
                String query = "INSERT INTO employee VALUES(?,?,?,?,?,?,?)";

                try {
                	Connection_demo c = new Connection_demo();
            		PreparedStatement stmt=c.getC().prepareStatement(query);
            		stmt.setString(1,name);
            		stmt.setString(2,age);
            		stmt.setString(3,gender);
            		stmt.setString(4,job_role);
            		stmt.setString(5,salary);
            		stmt.setString(6,phone);
            		stmt.setString(7,email);
            		
            		int myRs = stmt.executeUpdate();
            		c.getC().close();
                                    
                } catch (Exception e) {
                    e.printStackTrace();}
                
                
                JOptionPane.showMessageDialog(null,"Employee Added");
                new Reception();
                setVisible(false);
                }
                else if(ae.getSource() == exit_button){
                	new Reception();
                    this.setVisible(false);
                	
                }
            }
		  
}
