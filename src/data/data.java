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
	
	Playlist rap = new Playlist("Rap");
	
	Playlist playlist = new Playlist("Rap");
	Song song1 = new Song("Hallo", "Ckarsten", "Metal");
	Song song2 = new Song("Haus", "Hans", "Hip-Hop");
	Song song3 = new Song("Morgen", "Ckarsten", "Minimal german dark Techno");
	Song song4 = new Song("Gut", "Peter", "progressiv underground psy House");

	
	
	
	

	//packt alle Interpreten in eine Liste
	public ArrayList<String> getAllInterpreter() {
			
		ArrayList<String> liste = new ArrayList<String>();
			
		for(int i = 0; i< content.size(); i++) {
			liste.add(i, content.get(i).getInterpreter());
		}
		return liste;
	}
}
