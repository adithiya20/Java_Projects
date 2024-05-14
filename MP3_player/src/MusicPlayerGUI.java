import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MusicPlayerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu songMenu, playlistMenu;
	JMenuItem loadSong, createPlaylist, loadPlaylist;
	boolean play_status;
	SongOpener current_song;
	File[] song_filepaths;

	public MusicPlayerGUI() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				
			
		setResizable(false);
		setTitle("Adi's Music Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 618);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		songMenu = new JMenu("SONG");
		menuBar.add(songMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("LOAD SONG");
		songMenu.add(mntmNewMenuItem);
		
		playlistMenu = new JMenu("PLAYLIST");
		menuBar.add(playlistMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("LOAD PLAYLIST");
		playlistMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("CREATE PLAYLIST");
		playlistMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel album_cover = new JLabel("");
		album_cover.setIcon(new ImageIcon(MusicPlayerGUI.class.getResource("/images/record.png")));
		album_cover.setBounds(118, 10, 225, 235);
		contentPane.add(album_cover);
		
		JLabel song_name = new JLabel("Song Name");
		song_name.setForeground(new Color(255, 255, 255));
		song_name.setFont(new Font("Tahoma", Font.PLAIN, 20));
		song_name.setBounds(180, 255, 272, 35);
		contentPane.add(song_name);
		
		JLabel artist_name = new JLabel("Artist Name");
		artist_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		artist_name.setForeground(new Color(255, 255, 255));
		artist_name.setBounds(201, 300, 91, 21);
		contentPane.add(artist_name);
		
		JSlider slider = new JSlider();
		slider.setBounds(118, 384, 252, 75);
		contentPane.add(slider);
		
		JButton pause_play = new JButton("");
		pause_play.setIcon(new ImageIcon(MusicPlayerGUI.class.getResource("/images/pause.png")));
		pause_play.setBounds(195, 499, 72, 21);
		contentPane.add(pause_play);
		
		JButton rewind = new JButton("");
		rewind.setIcon(new ImageIcon(MusicPlayerGUI.class.getResource("/images/previous.png")));
		rewind.setBounds(55, 499, 85, 21);
		contentPane.add(rewind);
		
		JButton forward = new JButton("");
		forward.setIcon(new ImageIcon(MusicPlayerGUI.class.getResource("/images/next.png")));
		forward.setBounds(322, 499, 85, 21);
		contentPane.add(forward);
		
		JButton Reset_button = new JButton("Reset");
		Reset_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Reset_button.setBounds(188, 531, 89, 23);
		contentPane.add(Reset_button);
	}
}
