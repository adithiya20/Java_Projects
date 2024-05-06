import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Dashboard extends JFrame {
	JLabel welcome_text;
	JMenu HOTEL_STAFF,HOTEL_MANAGEMENT;
	JMenuItem RECEPTION,ADD_ROOM,ADD_EMPLOYEE,ADD_DRIVER;
	
	public Dashboard() {
        super("HOTEL MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setForeground(Color.CYAN);
        setLayout(null); 

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(0, 0, 1950, 1000); 
        add(NewLabel);
        
        welcome_text = new JLabel("THE CONTINENTAL WELCOMES YOU");
        welcome_text.setForeground(Color.WHITE);
        welcome_text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        welcome_text.setBounds(600, 60, 1000, 85);
        NewLabel.add(welcome_text);
		
		//creating a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
		
        //adding categories to menu bar
        JMenu HOTEL_MANAGEMENT = new JMenu("HOTEL MANAGEMENT");
        HOTEL_MANAGEMENT.setForeground(Color.BLUE);
        menuBar.add(HOTEL_MANAGEMENT);
        JMenu HOTEL_STAFF = new JMenu("HOTEL STAFF");
        HOTEL_STAFF.setForeground(Color.RED);
        menuBar.add(HOTEL_STAFF);
		
        //adding sub menu item to each menu bar category
        JMenuItem RECEPTION = new JMenuItem("RECEPTION");
        HOTEL_MANAGEMENT.add(RECEPTION);
		
        JMenuItem ADD_EMPLOYEE = new JMenuItem("ADD EMPLOYEE");
        HOTEL_STAFF.add(ADD_EMPLOYEE);
        
        JMenuItem ADD_ROOMS = new JMenuItem("ADD ROOMS");
        HOTEL_STAFF.add(ADD_ROOMS);
        
        JMenuItem ADD_DRIVER = new JMenuItem("ADD DRIVERS");
        HOTEL_STAFF.add(ADD_DRIVER);
        
        
        
        
        //CREATING ACTION LISTENER EVENTS FOR EACH MENUITEM
        RECEPTION.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent ae){
                new Reception();
            }
        });
        
        
        
        ADD_EMPLOYEE.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent ae){
                new AddEmployee().setVisible(true);}
	});
        
        
        ADD_ROOMS.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent ae){
        		new AddRooms().setVisible(true);}
        });
        
        
        ADD_DRIVER.addActionListener(new ActionListener(){
        	@Override
            public void actionPerformed(ActionEvent ae){
            	new AddDrivers().setVisible(true);}
        });
        
		
        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
	
	
	
	  public static void main(String[] args) {new Dashboard(); }
	 
	
}
