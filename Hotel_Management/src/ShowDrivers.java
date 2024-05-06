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

public class ShowDrivers extends JFrame{
	private JTable table;

	ShowDrivers(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(450, 200, 1100, 600);
			JPanel contentPane = new JPanel();
			this.setTitle("DRIVER INFORMATION");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setVisible(true);
            
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
            Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel l1 = new JLabel(i2);
            l1.setBounds(500,0,600,600);
            getContentPane().add(l1);
    	
                    
            getContentPane().setBackground(Color.WHITE);
            
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(33, 28, 452, 421);
            contentPane.add(scrollPane);
            
            table = new JTable();
            scrollPane.setViewportView(table);
            
            JButton back_button = new JButton("Back");
            back_button.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		new Reception().setVisible(true);
                    setVisible(false);
            	}
            });
            back_button.setBounds(193, 460, 89, 23);
            contentPane.add(back_button);
            
          
                   
            String query = "SELECT * FROM driver";
                        
            
         
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
            	
            	String[] columns= {"Name","Age","Gender","Car Company","Car Model","Availability","Location"};
            	for (int i = 0; i < columns.length; i++) {
            		table.getColumnModel().getColumn(i).setHeaderValue(columns[i]);
				}
           
            	 
            	 while(rs.next()) { 
            		 
                	 String name = rs.getString("name"); 
                	 String age= rs.getString("age");
                	 String gender= rs.getString("gender"); 
                	 String car_comp = rs.getString("car_company"); 
                	 String car_model= rs.getString("car_model"); 
                	 String avail= rs.getString("availability"); 
                	 String location = rs.getString("location"); 
                	 
                	//save these values in array format
                	 String [] data = {name,age,gender,car_comp,car_model,avail,location};
                	 tblData.addRow(data);
                	 
                	 }
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
}
	public static void main(String[] args) {
		new ShowDrivers();
	} 
}

