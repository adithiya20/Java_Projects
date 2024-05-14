import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

import org.jaudiotagger.audio.*;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Song {
	
	private String song_name, song_artist,song_length, filePath;
	
	
	public Song(File file) {
		//this.filePath = filePath;
		try {
			AudioFile audioFile = AudioFileIO.read(file);
			AudioHeader audioHeader = audioFile.getAudioHeader();
			Tag tag = audioFile.getTag();
			if(tag!=null) {
				song_name = tag.getFirst(FieldKey.TITLE);
				song_artist = tag.getFirst(FieldKey.ARTIST);
			}
			else {
				song_name = "N/A";
				song_artist = "N/A";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

	public String getSongName() {
		return song_name;
	}
	
	public String getSongArtist() {
		return song_artist;
	}



	public String getSong_length() {
		return song_length;
	}

	public String getFilePath() {
		return filePath;
	}

	
	
	
}

