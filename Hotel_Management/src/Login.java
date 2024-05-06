
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    private JLabel login_username_text,login_password_text;
    private JTextField username_textbox;
    private JPasswordField password_textbox;
    private JButton login_button,exit_button;

    Login(){
    	
        super("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        //labels
        login_username_text = new JLabel("Username");
        login_username_text.setBounds(40,20,100,30);
        login_password_text = new JLabel("Password");
        login_password_text.setBounds(40,70,100,30);
        getContentPane().add(login_username_text);
        getContentPane().add(login_password_text);
        
        //textfields
        username_textbox=new JTextField();
        username_textbox.setBounds(150,20,150,30);
        password_textbox=new JPasswordField();
        password_textbox.setBounds(150,70,150,30);
        getContentPane().add(username_textbox);
        getContentPane().add(password_textbox);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,10,150,150);
        getContentPane().add(l3);


        login_button = new JButton("Login");
        login_button.setBounds(40,140,120,30);
        login_button.setFont(new Font("serif",Font.BOLD,15));
        login_button.addActionListener(this);
        login_button.setBackground(Color.BLACK);
        login_button.setForeground(Color.WHITE);
        getContentPane().add(login_button);

        exit_button=new JButton("Cancel");
        exit_button.setBounds(180,140,120,30);
        exit_button.setFont(new Font("serif",Font.BOLD,15));
        exit_button.setBackground(Color.BLACK);
        exit_button.setForeground(Color.WHITE);
        getContentPane().add(exit_button);

        exit_button.addActionListener(this);
        
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(600,350);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login_button){
      
            String u = username_textbox.getText();
            String v = new String(password_textbox.getPassword());
            
            String query = "SELECT * FROM login WHERE username=? AND password=?";
      
            try {
            Connection_demo c = new Connection_demo();
		    PreparedStatement stmt=c.getC().prepareStatement(query);
		    stmt.setString(1, u);
		    stmt.setString(2, v);
		    
		    ResultSet rs= stmt.executeQuery();
            //EXECUTE QUERY - STEP 4 IN CONNECTION DEMO
            //IF RS QUERY GETS EXECUTED OPEN DASHBOARD AND CLOSE LOGIN FRAME
            if(rs.next()){ 
            	setVisible(false);
                new Dashboard();
                c.getC().close();
            }else{
            	//SHOW ERROR MESSAGE SAYING INVALID LOGIN CREDENTIALS
                JOptionPane.showMessageDialog(null, "Invalid login");
            	}
            }

            catch(Exception e){
                e.printStackTrace();}
            
        }
        else if(ae.getSource()==exit_button){
            System.exit(0);
        	}
        }


}
