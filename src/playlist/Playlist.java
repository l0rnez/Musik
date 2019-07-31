package playlist;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import song.Song;

public class Playlist {

	String name;
	String genre;
	ArrayList<Song> content = new ArrayList<>();

	public Playlist(String name) {
		this.name = name;
	}

	public void addSong(Song... s) {
		for(int i = 0; i<s.length; i++) {
			content.add(s[i]);
		}
	}

	public ArrayList<Song> searchSong(String s) {
		ArrayList<Song> searchResults = new ArrayList<>();
		for(int i = 0; i<content.size(); i++) {
			Song song = content.get(i);
			int l = 0;
			if(s.length() > song.getTitle().length()) {
				l = song.getTitle().length();
			}
			else {
				l = s.length(); 
			}
			for(int j = 0; j<l; j++) {
				char c = song.getTitle().charAt(j);
				char b = song.getInterpreter().charAt(j);
				char d = s.charAt(j);
				if(c == d && !searchResults.contains(song)) {
					searchResults.add(song);
				}
				if(b == d && !searchResults.contains(song)) {
					searchResults.add(song);
				}
				if(b != d && c != d) {
					searchResults.remove(song);
					break;
				}
			}
		}
		return searchResults;
	}
	
	public void sort(String s) {
		if(s == "a") {
//			Collections.sort(content);
		}
	}

	public void playSound() {
		try {
		      File file = new File("./sound.wav");
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name + "\n");
		for(int i = 0; i<content.size(); i++) {
			sb.append(content.get(i).getInterpreter() + " - " + content.get(i).getTitle() + "\n");
		}
		return "Playlist: " + sb;
	}
}
