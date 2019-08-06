package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import Main.Musikverwaltung;
import data.data;
import song.Song;
import playlist.Playlist;
import gui.AddMusic;

public class MainFrame extends JFrame implements ActionListener{
	private JButton bLinks, bRechts, bMitte, bAddMusic;
	private JLabel label1;
	private JFrame jframe1;
	private JTable tabelle, tabelleinterpreten, tabellegenre, tabellesuchergebnisse;
	private JPanel panelmenu, panelliste;
	private JMenu songs, genre, interpreter, playlists;
	private JMenuBar menubar;
	private JTextField searchbar;
	private JScrollPane scroll, scrollinterpreten, scrollgenre, scrollsuche;
	

	//Funktionen im GUI
	/*public void popupInterpreter(ArrayList<String> interpreter) {
		StringBuilder name = new StringBuilder("interpret");
		
		for(int i = 0; i < interpreter.size(); i++) {
			String interpreterhier = interpreter.get(i);
			String keck = name.append(i).toString();
			JMenuItem keck = new JMenuItem(interpreterhier);
		}
	}*/
	
	
	
	
	
	AddMusic frame2 = new AddMusic();  //könnte man eventuell anders lösen
	
	//alles Musik stücke
	data alles = new data("Alles");
	

	
	
	//Probleme:
	//1. Warum zum fick ist das Fenster leer, wenn man es Ã¶ffnet, aber fÃ¼llt sich, wenn man es grÃ¶ÃŸer macht?
	//2. Warum muss Actionlistener (ganz unten) geaddet werden, damit der sich nicht beschwert
	
	public MainFrame(){
		setLayout(null);
		setVisible(true);
		setSize(800, 600);
		setTitle("Musicplayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.getHSBColor((float) 0.55, (float) 0.7, (float) 0.8));
		//setResizable(false);    //an sich gut, aber geht nicht, wenn die Komponenten nicht auftauchen
		
		
	//Testtitel
	alles.contentAdd("Keck", "Kecker", "Keckno");
	alles.contentAdd("Klang", "White House Mouse", "Melodic Hardcore Punk");
	alles.contentAdd("Suppenparty", "Rentner-Rocker", "Schlager");
		
		
		
		
	//Tabelle Alles
	String[] titlesTable = {"Titel","Interpreten","Genre"};
	
	
	ArrayList<Song> alleshier = new ArrayList<Song>();
	alleshier = alles.getContent();
	ArrayList<String> titles = new ArrayList<String>();
	ArrayList<String> genra = new ArrayList<String>();
	ArrayList<String> interpreters = new ArrayList<String>();
	
	String[] [] daten = new String [alleshier.size()] [3];
	
	for(int i = 0; i < alleshier.size(); i++) {
		titles.add(alleshier.get(i).getTitle());
		genra.add(alleshier.get(i).getGenre());
		interpreters.add(alleshier.get(i).getInterpreter());
	}
	
	for(int i = 0; i < titles.size(); i++) {
		daten[i] [0] = titles.get(i);
		daten[i] [1] = interpreters.get(i);
		daten[i] [2] = genra.get(i);
	}
	
	
	
	//Tabelle Interpreten
	String[] interpretentitel = {"Interpreten"};
	String[] [] datainterpreten = new String[alleshier.size()] [1];
	
	for(int i = 0; i < alleshier.size(); i++) {
		datainterpreten[i] [0] = alleshier.get(i).getInterpreter();
	}

	//Tabelle Genre
	String[] genratitel = {"Genre"};
	String[] [] datagenre = new String[alleshier.size()] [1];
	
	for(int i = 0; i < alleshier.size(); i++) {
		datagenre[i] [0] = alleshier.get(i).getGenre();
	}
		
	
	//Tabelle suchen
	String suche;
	String [] suchetitel = {"Suchergebnisse"};
	String[] [] sucheergebnisse = new String[alleshier.size()] [1];
	ArrayList<Song> gesuchteTitel = new ArrayList<Song>();
	ArrayList<String> gesuchteInterpreten = new ArrayList<String>();
	ArrayList<String> gesuchteGenre = new ArrayList<String>();
	
	
	
	
	for(int i = 0; i < alleshier.size(); i++) {
		sucheergebnisse [i] [0] = gesuchteTitel.get(i).getTitle();
	}


	

		
		
		
		
		
		
		
		//Fonts
		Font f1 = new Font(Font.SERIF, Font.PLAIN, 15);
		
		//Erstellen der Komponenten
		panelmenu = new JPanel();
		panelmenu.setLayout(new FlowLayout());
		panelmenu.setBounds(10, 10, 760, 37);
		
		panelliste = new JPanel();
		panelliste.setBounds(10, 50, 500, 500);
		
		menubar = new JMenuBar();
		//menubar.setBounds(10, 10, 770, 50);
		
			//MenÃ¼punkte
			songs = new JMenu("Songs");
			songs.setFont(f1);
			
			genre= new JMenu("Genre");
			genre.setFont(f1);
			
			interpreter = new JMenu("Interpreten");
			interpreter.setFont(f1);
			
			playlists = new JMenu("Playlists");
			playlists.setFont(f1);
			
			bAddMusic = new JButton("Add");
			bAddMusic.setFont(f1);
			bAddMusic.setAlignmentX(Component.LEFT_ALIGNMENT); //macht nichts, Knopf soll nach ganz links
		
		
		
			//Searchbar
			searchbar = new JTextField("Was möchten sie suchen?");
			//mouselistener damit bei klick der Text "was mchten sie..." verschwindet
			
			
			
			
			
		//Songtabellen
		tabelle = new JTable(daten, titlesTable);
		tabelleinterpreten = new JTable(datainterpreten, interpretentitel);
		tabellegenre = new JTable(datagenre, genratitel);
		tabellesuchergebnisse = new JTable(sucheergebnisse,suchetitel);
		
		scroll = new JScrollPane(tabelle);
		scroll.setBounds(10, 50, 760, 400);
		scroll.setVisible(true);
		
		scrollinterpreten = new JScrollPane(tabelleinterpreten);
		scrollinterpreten.setBounds(10, 50, 760, 400);
		scrollinterpreten.setVisible(false);
		
		scrollgenre = new JScrollPane(tabellegenre);
		scrollgenre.setBounds(10, 50, 760, 400);
		scrollgenre.setVisible(false);
		
		scrollsuche = new JScrollPane(tabellesuchergebnisse);
		scrollsuche.setBounds(10, 50, 760, 400);
		scrollsuche.setVisible(false);
		
		
		
		
		
		//EinfÃ¼gen ins Fenster
		menubar.add(songs);   //schauen ob das alle in eine Zeile geht
		menubar.add(playlists);
		menubar.add(genre);
		menubar.add(interpreter);
		menubar.add(bAddMusic);
		
		
		panelmenu.add(bAddMusic);
		panelmenu.add(menubar);
		panelmenu.add(searchbar);
		
		
		
		
		//panelliste.add(tabelle);
		add(scrollsuche);
		add(scroll);
		add(scrollinterpreten);
		add(scrollgenre);
		add(panelmenu);
		
		
		
		//Button Actions
		bAddMusic.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(true);
			}
			
		});
		
		
		//Menu Actions
		genre.addMenuListener(new MenuListener() {
			
			public void menuCanceled(MenuEvent arg0) {
				
			}

			
			public void menuDeselected(MenuEvent arg0) {
				scroll.setVisible(true);
				scrollgenre.setVisible(false);
				
			}

			
			public void menuSelected(MenuEvent arg0) {
				scroll.setVisible(false);
				scrollgenre.setVisible(true);
				
			}	
		});
		
		
		interpreter.addMenuListener(new MenuListener() {

			public void menuCanceled(MenuEvent e) {
					
			}
			

			@Override
			public void menuDeselected(MenuEvent e) {
				scroll.setVisible(true);
				scrollinterpreten.setVisible(false);
				
			}
			
			@Override
			public void menuSelected(MenuEvent e) {
				scroll.setVisible(false);
				scrollinterpreten.setVisible(true);
				
			}
		});
		
		
		
		//Searchbar Action
		searchbar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				suche = Character.toString(a);
				gesuchteTitel = alles.searchSong(suche);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	


	//Warum muss das geaddet werden, damit der sich nicht beschwert
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
