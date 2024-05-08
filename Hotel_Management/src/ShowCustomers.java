import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ShowCustomers extends JFrame{
	JTable table;
	ShowCustomers(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(450, 200, 1100, 600);
			JPanel contentPane = new JPanel();
			this.setTitle("CUSTOMER INFORMATION");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setVisible(true);
            
			/*
			 * ImageIcon i1 = new
			 * ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg")); Image i3 =
			 * i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT); ImageIcon i2 =
			 * new ImageIcon(i3); JLabel l1 = new JLabel(i2); l1.setBounds(500,0,600,600);
			 * getContentPane().add(l1);
			 */
    	
                    
            getContentPane().setBackground(Color.WHITE);
            
            	
               JButton back_button = new JButton("Back");
               back_button.addActionListener(new ActionListener() {
               	public void actionPerformed(ActionEvent e) {
               		new Reception().setVisible(true);
                    setVisible(false);
               	}
               });
              
               back_button.setBounds(537, 462, 89, 23);
               contentPane.add(back_button);
            
            JScrollPane scrollPane = new JScrollPane(table);
    	    scrollPane.setBounds(12, 40, 1062, 400); // Adjust the bounds as needed
    	    contentPane.add(scrollPane);       
    	    table = new JTable();
            scrollPane.setViewportView(table);
    	    
                    
            String query = "SELECT * FROM customer";
            
            
            
            try {
            	Connection_demo c = new Connection_demo();
            	PreparedStatement stmt=c.getC().prepareStatement(query);
            	ResultSet rs = stmt.executeQuery();
            	java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            	DefaultTableModel tblData = (DefaultTableModel) table.getModel();
            	int cols = rsmd.getColumnCount();
            	String [] colName = new String[cols];
            	for (int i = 0; i < cols; i++) {
					colName[i]=rsmd.getColumnName(i+1);
					tblData.setColumnIdentifiers(colName);
				}
            	
            	String[] columns= {"Document Type","Phone Number","Name","Gender","Country","Room Number","Check-in Time","Check-out Time","Deposit"};
            	for (int i = 0; i < columns.length; i++) {
            		table.getColumnModel().getColumn(i).setHeaderValue(columns[i]);
				}
           
            	 
            	 while(rs.next()) { 
            		 String id = rs.getString("document"); 
                	 String number= rs.getString("phone_number"); 
                	 String name = rs.getString("name"); 
                	 String gender= rs.getString("gender"); 
                	 String country = rs.getString("country"); 
                	 String room_num= rs.getString("roomnumber"); 
                	 String check_in= rs.getString("checkin_time"); 
                	 String check_out= rs.getString("checkout_time");
                	 String deposit= rs.getString("deposit"); 
                	  
                	 
                	//save these values in array format
                	 String [] data = {id,number,name,gender,country,room_num,check_in,check_out,deposit};
                	 //System.out.println(Arrays.toString(data));
                	 tblData.addRow(data);
                	 }
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}

}
