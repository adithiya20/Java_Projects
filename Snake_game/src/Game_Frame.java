import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Game_Frame extends JFrame {
	public Game_Frame() {
		 this.add(new GamePanel());
		 this.setTitle("Snake");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 this.pack();
		 this.setVisible(true);
		 this.setLocation(null);

		 ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
		 Image image = icon.getImage();
		 if (image != null) {
		     this.setIconImage(image);
		 } else {
		     System.out.println("Image not loaded!");
		 }
		}





}
