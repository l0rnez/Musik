import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import playlist.Playlist;
import song.Song;

public class Musikverwaltung {

	public static void main(String[] args) {
		Playlist playlist = new Playlist("Rap");
		Song song1 = new Song("Hallo", "Ckarsten", "Metal");
		Song song2 = new Song("Haus", "Hans", "Hip-Hop");
		Song song3 = new Song("Morgen", "Ckarsten", "Minimal german dark Techno");
		Song song4 = new Song("Zeitzbib", "Peter", "progressiv underground psy House");
		Song song5 = new Song("ABBA", "Peter", "progressiv underground psy House");
		Song song6 = new Song("Asoz", "Peter", "progressiv underground psy House");
		playlist.addSong(song1, song2, song3, song4,song5,song6);
//		System.out.println(playlist.toString());

		
		System.out.println("Suche: ");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String s = scanner.next();
			ArrayList<Song> list = playlist.searchSong(s);
			StringBuilder sb = new StringBuilder("\n");
			for(int i = 0; i<list.size(); i++) {
				sb.append(list.get(i).getInterpreter() + " - " + list.get(i).getTitle() + "\n");
				
				//sollte man �ndern, ist aber lustig
				playlist.playSound();
			}
			//System.out.println(sb);
		}
	}
}
