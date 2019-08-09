package song;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Song {

	String title;
	String interpreter;
	String genre;

	public Song(String title, String interpreter, String genre) {
		this.title = title;
		this.interpreter = interpreter;
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
	
	public void playSound() {
		try {
		      File file = new File("./soundsource/" + title + "-" + interpreter + "-" + genre + ".wav");
//		      File file = new File("./123.wav");
//		      File file = new File("./soundsource/123.wav");
		      AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		      Clip clip = AudioSystem.getClip();
		      clip.open(stream);
		      clip.start();
		      Thread.sleep(500);
		      stream.close();
		 
		    } catch (Exception ex) {
		      System.out.println(ex.getMessage());
		    }
	}
}
