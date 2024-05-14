import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_textbox;

	public Login_Screen() {
		setTitle("Music Player LogOn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 631);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_textbox = new JTextField();
		name_textbox.setBounds(133, 252, 137, 21);
		contentPane.add(name_textbox);
		name_textbox.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter a name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(142, 209, 137, 33);
		contentPane.add(lblNewLabel);
		
		JButton submit = new JButton("LET'S JAM OUT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = name_textbox.getText();
				System.out.println("WELCOME "+name.toUpperCase());
				MusicPlayerGUI player = null;
				try {
					player = new MusicPlayerGUI();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				player.setVisible(true);
			}
		});
		submit.setBounds(133, 283, 137, 21);
		contentPane.add(submit);
	}
}
