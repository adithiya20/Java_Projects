import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Hotel_management extends JFrame implements ActionListener {

	Hotel_management(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setting welcome screen frame
		int window_x=1366;
		int window_y=565;
		JFrame f=new JFrame();
		setBounds(100,100, window_x,window_y);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,window_x,window_y); //image paste with respect to frame
		add(image);
		setVisible(true);
		
		//WELCOME BUTTON
	    JButton welcome_button = new JButton("WELCOME");
	    welcome_button.setBounds(910, 450, 200, 50);
		welcome_button.setBackground(Color.WHITE);
		welcome_button.setForeground(Color.BLACK);
		welcome_button.addActionListener(this);
		welcome_button.setFont(new Font("serif",Font.PLAIN,24));
		image.add(welcome_button);
		
		//setting text
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");	
        text.setBounds(30,400,1500,100);
        text.setForeground(Color.YELLOW);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);
		
		
		
		
		while(true){
            text.setVisible(false); 
        try{
            Thread.sleep(500); //1000 = 1 second
        }catch(Exception e){e.printStackTrace();} 
        try{text.setVisible(true);
            Thread.sleep(500);
        }catch(Exception e){e.printStackTrace();}
    }
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new Hotel_management();

	}

}
