import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Reception extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Reception() {

        setBounds(530, 200, 850, 570);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250,30,500,470);
        getContentPane().add(l1);

		JButton btnNewCustomerForm = new JButton("New Customer Form");
		btnNewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				AddCustomer custom = new AddCustomer();
				custom.setVisible(true);
		                        setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		
		btnNewCustomerForm.setBounds(10, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        contentPane.add(btnNewCustomerForm);

        
        JButton btnNewButton = new JButton("All Rooms Info");
        btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
		try{
			ShowRooms room = new ShowRooms();
			room.setVisible(true);
			setVisible(false);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
});
        
        btnNewButton.setBounds(10, 70, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);

        contentPane.add(btnNewButton);


        JButton btnNewButton_2 = new JButton("All Employee Info");
        btnNewButton_2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
		try{
		
			ShowEmployees em = new ShowEmployees();
			em.setVisible(true);
			setVisible(false);
			
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
	
	}
});

        btnNewButton_2.setBounds(10, 111, 200, 30);                
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("All Customer Info");
		btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			try{
			ShowCustomers customer = new ShowCustomers();
			customer.setVisible(true);				
			setVisible(false);
		}
		catch (Exception e1){
			e1.printStackTrace();
		}
	}
});
		
		btnNewButton_3.setBounds(10, 151, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Check Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check = new CheckOut();
				//check.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton_4.setBounds(10, 192, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_4);

		JButton btnUpdateCustomer = new JButton("Update Customer Info");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				//UpdateCheck update = new UpdateCheck();
				//update.setVisible(true);
		                        setVisible(false);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
		btnUpdateCustomer.setBounds(10, 232, 200, 30);
        btnUpdateCustomer.setBackground(Color.BLACK);
        btnUpdateCustomer.setForeground(Color.WHITE);

        contentPane.add(btnUpdateCustomer);

		JButton bntUpdateRoom = new JButton("Update Room Status");
		bntUpdateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//UpdateRoom room = new UpdateRoom();
					//room.setVisible(true);
		             setVisible(false);
				}catch(Exception s)
				{
					s.printStackTrace();
				}
			}
		});
		
				JButton btnUpdateEmployees = new JButton("Update Employee Info");
				btnUpdateEmployees.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ShowRooms search = new ShowRooms();
							search.setVisible(true);
					        setVisible(false);
						}
						catch (Exception ss){
							ss.printStackTrace();
						}
					}
				});
				btnUpdateEmployees.setBounds(10, 313, 200, 30);
				btnUpdateEmployees.setBackground(Color.BLACK);
				btnUpdateEmployees.setForeground(Color.WHITE);
				
				        contentPane.add(btnUpdateEmployees);
		bntUpdateRoom.setBounds(10, 272, 200, 30);
        bntUpdateRoom.setBackground(Color.BLACK);
        bntUpdateRoom.setForeground(Color.WHITE);

        contentPane.add(bntUpdateRoom);
		
		JButton btnNewButton_7 = new JButton("Log Out");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
                    new Login().setVisible(true);
                    setVisible(false);
		                            
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.setBounds(10, 393, 200, 30);
        btnNewButton_7.setBackground(Color.BLACK);
        btnNewButton_7.setForeground(Color.WHITE);

        contentPane.add(btnNewButton_7);
        getContentPane().setBackground(Color.WHITE);
        
        JButton btnUpdateDriver = new JButton("Update Driver Info");
        btnUpdateDriver.setForeground(Color.WHITE);
        btnUpdateDriver.setBackground(Color.BLACK);
        btnUpdateDriver.setBounds(10, 354, 200, 30);
        contentPane.add(btnUpdateDriver);
        
        setVisible(true);
}

}
