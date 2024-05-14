import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.stage.Stage; 

public class MusicPlayer{
	
	private File directory;

	private File[] files;
	private ArrayList<File> songs;
	private int songNumber;

	private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};

	//private Timer timer;

	//private TimerTask task;


	  
	
	public File[] get_song_filepath(){
		JFileChooser j = new JFileChooser(new File("C:\\Users\\adith\\eclipse-workspace\\MP3_player\\src\\images"));
		j.setMultiSelectionEnabled(true);
		// Open the save dialog

		// Show the dialog; wait until dialog is closed
		j.showOpenDialog(null);

		// Retrieve the selected files.
		File[] files_paths = j.getSelectedFiles();
		return (files_paths);
		
	}	
	
	public void playSong(File file)  {
	
	}

	public void stopSong() {
		
	}
	
	public void resetSong() {
		
	}

	public static void main(String[] args){
		 String path = "/MP3_player/src/Songs/Wind Riders - Asher Fulero.mp3";  
         
		 String musicFile = "StayTheNight.mp3";     // For example

		 Media sound = new Media(getClass().getResource("/player/football.flv").toExternalForm()));
		 MediaPlayer mediaPlayer = new MediaPlayer(sound);
		 mediaPlayer.play();
		
		
	}


	
}
