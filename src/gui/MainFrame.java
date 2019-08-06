package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

import Main.Musikverwaltung;
import song.Song;
import playlist.Playlist;
import gui.AddMusic;

public class MainFrame extends JFrame implements ActionListener{
	private JButton bLinks, bRechts, bMitte, bAddMusic;
	private JLabel label1;
	private JFrame jframe1;
	private JTable tabelle;
	private JPanel panelmenu, panelliste;
	private JMenu songs, genre, interpreter, playlists;
	private JMenuBar menubar;
	private JTextField searchbar;
	private JScrollPane scroll;
	private	JMenuItem genrepop;
	

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
		
		
		
		
	//Tabelle test
	String[] titles = {"Titel","Interpreten","Genre"};
	
	Object[] [] data = {{"Peters Kackhaus", "Peter der Kacker", "Deathmetal"}, {"All the leaves are white", "White Powerranger", "Melodic Hardcore Punk"}};
	//Zahlen automatisch erzeugen	
		
	
	//Menulisten
		//Liste der Interpreten
		ArrayList<String> interpreten = new ArrayList<String>();
		Playlist interpretendata = new Playlist("Daten Interpreten");
		interpreten = interpretendata.getAllInterpreter();
		
		
		
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
		
				//Pop-Up menu
				genrepop = new JMenuItem("Reggea");
		
		
			//Searchbar
			searchbar = new JTextField("Was möchten sie suchen?");
			//mouselistener damit bei klick der Text "was mchten sie..." verschwindet
			
		//Songtabelle
		tabelle = new JTable(data, titles);
		//tabelle.setBounds(10, 50, 500, 500);
		
		scroll = new JScrollPane(tabelle);
		scroll.setBounds(10, 50, 760, 400);
		
		//EinfÃ¼gen ins Fenster
		menubar.add(songs);   //schauen ob das alle in eine Zeile geht
		menubar.add(playlists);
		menubar.add(genre);
		menubar.add(interpreter);
		menubar.add(bAddMusic);
		
		genre.add(genrepop);
		
		
		panelmenu.add(bAddMusic);
		panelmenu.add(menubar);
		panelmenu.add(searchbar);
		
		
		
		
		//panelliste.add(tabelle);
		
		add(scroll);
		add(panelmenu);
		
		
		
		//Actionlistener
		bAddMusic.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(true);
			}
			
		});
		
		addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                System.out.println("Closed");
	                e.getWindow().dispose();
	               }
	     	});
	}


	//Warum muss das geaddet werden, damit der sich nicht beschwert
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
