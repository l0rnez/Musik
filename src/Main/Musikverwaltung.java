package Main;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;

import gui.AddMusic;
import gui.MainFrame;
import playlist.Playlist;
import song.Song;

public class Musikverwaltung{

	public static void main(String[] args) {
		
		
		MainFrame frame = new MainFrame();
		/*
		System.out.println("Suche: ");
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String s = scanner.next();
			ArrayList<Song> list = playlist.searchSong(s);
			StringBuilder sb = new StringBuilder("\n");
			for(int i = 0; i<list.size(); i++) {
				sb.append(list.get(i).getInterpreter() + " - " + list.get(i).getTitle() + "\n");
				
				//sollte man ändern, ist aber lustig
				playlist.playSound();
			}
			System.out.println(sb);
			
		}*/
	}
}
