import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ShowEmployees extends JFrame{
	JTable table;
	public ShowEmployees() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(450, 200, 1100, 600);
			JPanel contentPane = new JPanel();
			this.setTitle("EMPLOYEES INFORMATION");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setVisible(true);
		            
	        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
	        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
	        ImageIcon i2 = new ImageIcon(i3);
	        JLabel l1 = new JLabel(i2);
	        l1.setBounds(500,0,600,600);
	        add(l1);
	        
	        JButton btnNewButton = new JButton("Back");
			
			  btnNewButton.addActionListener(new ActionListener() { public void
			  actionPerformed(ActionEvent e) { new Reception().setVisible(true);
			  setVisible(false); } });
			 
    		btnNewButton.setBounds(180, 470, 120, 30);
            btnNewButton.setBackground(Color.BLACK);
            btnNewButton.setForeground(Color.WHITE);
    		contentPane.add(btnNewButton);
    		
	     
            getContentPane().setBackground(Color.WHITE);
    
            table = new JTable();
                        
            String query = "SELECT * FROM employee";
         
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
            	
            	String[] columns= {"Name","Age","Gender","Job","Salary","Phone","Email"};
            	for (int i = 0; i < columns.length; i++) {
            		table.getColumnModel().getColumn(i).setHeaderValue(columns[i]);
				}
           
            	 
            	 while(rs.next()) { 
            		 String name = rs.getString("name"); 
                	 String age= rs.getString("age"); 
                	 String gender = rs.getString("gender"); 
                	 String job= rs.getString("job"); 
                	 String salary = rs.getString("salary"); 
                	 String phone= rs.getString("phone"); 
                	 String email= rs.getString("email"); 
                	  
                	 
                	//save these values in array format
                	 String [] data = {name,age,gender,job,salary,phone,email};
                	 tblData.addRow(data);
                	 
                	 }
            	 
            	 JScrollPane scrollPane = new JScrollPane(table);
            	    scrollPane.setBounds(12, 40, 480, 400); // Adjust the bounds as needed
            	    contentPane.add(scrollPane);              	
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
}
public static void main(String[] args) {
	new ShowEmployees();
}
}
