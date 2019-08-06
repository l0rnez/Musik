package Main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		
		File f = new File("./memory.txt");
		if(f.exists() && !f.isDirectory()) {
			BufferedReader br = new BufferedReader(new FileReader("memory.txt"));
			try {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();
			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    String everything = sb.toString();
			    System.out.println(everything);
			} finally {
			    br.close();
			}
		}
		else {
			f.getParentFile().mkdirs(); 
			f.createNewFile();
		}
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
