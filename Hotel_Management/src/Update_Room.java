import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class Update_Room extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField roomnumber_textbox;
	private JTextField cleaning_status_textbox;
	private JTextField price_textbox;
	private JTextField bed_type_textbox;


	public Update_Room() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		roomnumber_textbox = new JTextField();
		roomnumber_textbox.setBounds(174, 33, 86, 20);
		contentPane.add(roomnumber_textbox);
		roomnumber_textbox.setColumns(10);
		
		JLabel roomnumber_text = new JLabel("Room Number:");
		roomnumber_text.setBounds(55, 36, 91, 14);
		contentPane.add(roomnumber_text);
		
		JLabel availability_text = new JLabel("Availability:");
		availability_text.setBounds(55, 85, 91, 14);
		contentPane.add(availability_text);
		
		cleaning_status_textbox = new JTextField();
		cleaning_status_textbox.setColumns(10);
		cleaning_status_textbox.setBounds(174, 136, 86, 20);
		contentPane.add(cleaning_status_textbox);
		
		JLabel cleaning_status_text = new JLabel("Cleaning Status:");
		cleaning_status_text.setBounds(55, 139, 91, 14);
		contentPane.add(cleaning_status_text);
		
		price_textbox = new JTextField();
		price_textbox.setColumns(10);
		price_textbox.setBounds(174, 198, 86, 20);
		contentPane.add(price_textbox);
		
		JLabel price_text = new JLabel("Price:");
		price_text.setBounds(55, 201, 91, 14);
		contentPane.add(price_text);
		
		bed_type_textbox = new JTextField();
		bed_type_textbox.setColumns(10);
		bed_type_textbox.setBounds(174, 260, 86, 20);
		contentPane.add(bed_type_textbox);
		
		JLabel Bedtype_text = new JLabel("Bed Type:");
		Bedtype_text.setBounds(55, 263, 91, 14);
		contentPane.add(Bedtype_text);
		
		JComboBox availability_textbox = new JComboBox();
		availability_textbox.setBounds(174, 81, 86, 22);
		contentPane.add(availability_textbox);
	}
}
