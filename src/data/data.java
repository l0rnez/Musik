package data;

import java.util.ArrayList;

import playlist.Playlist;
import song.Song;

public class data {
	
	public ArrayList<Song> content = new ArrayList<Song>();
	public String name;
	
	public data(String name) {
		this.name = name;
	}
	
	public void contentAdd(String title, String interpreter, String genre) {
		content.add(new Song(title,interpreter,genre));
	}
	

	
	
	
	
	public ArrayList<Song> getContent() {
		return content;
	}

	//packt alle Interpreten in eine Liste
	public ArrayList<String> getAllInterpreter() {
			
		ArrayList<String> liste = new ArrayList<String>();
			
		for(int i = 0; i< content.size(); i++) {
			liste.add(i, content.get(i).getInterpreter());
		}
		return liste;
	}
	
	//packt alle Genre in eine Liste
	public ArrayList<String> getAllGenre() {
		
		ArrayList<String> liste = new ArrayList<String>();
			
		for(int i = 0; i< content.size(); i++) {
			liste.add(i, content.get(i).getGenre());
		}
		return liste;
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
}
