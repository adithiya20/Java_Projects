import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.sound.sampled.*;

public class SongOpener {
	 // to store current position 
    Long currentFrame; 
    Clip clip; 
      
    // current status of clip 
    String status; 
      
    AudioInputStream audioInputStream; 
    String filePath; 
    
	
	public SongOpener(File file) {
		//this.filePath = filePath;
		
		try {
			audioInputStream =  AudioSystem.getAudioInputStream(file.getAbsoluteFile());
			  // create clip reference 
	        clip = AudioSystem.getClip(); 
	        // open audioInputStream to the clip 
	        clip.open(audioInputStream); 
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          
          
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
				
	}
	
	// Method to play the audio 
    public void play()  
    { 
        //start the clip 
        clip.start(); 
    } 
      
    // Method to pause the audio 
    public void pause()  
    { 
        this.currentFrame =  this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 
      
    // Method to resume the audio 
    public void resumeAudio() throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    } 
      
    // Method to restart the audio 
    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
      
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, IOException, LineUnavailableException  
    { 
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    } 
	
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
	
    
    public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException  
    { 
        switch (c)  
        { 
            case 1: 
                pause(); 
                break; 
            case 2: 
                resumeAudio(); 
                break; 
            case 3: 
                restart(); 
                break; 
            case 4: 
                stop(); 
                break; 
            /*case 5: 
                System.out.println("Enter time (" + 0 +  
                ", " + clip.getMicrosecondLength() + ")"); 
                Scanner sc = new Scanner(System.in); 
                long c1 = sc.nextLong(); 
                jump(c1); 
                break; */
      
        } 
	
    }
}
