package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	private JButton bLinks, bRechts, bMitte;
	private JLabel label1;
	private JFrame jframe1;
	private JList liste;
	private JPanel panelmenu;
	private JMenu songs, genre, interpreter, playlists;
	private JMenuBar menubar;
	private JTextField searchbar;

	
	
	//Probleme:
	//1. Warum zum fick ist das Fenster leer, wenn man es öffnet, aber füllt sich, wenn man es größer macht?
	
	
	
	public MainFrame(){
		setLayout(null);
		setVisible(true);
		setSize(800, 600);
		setTitle("Musicplayer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.getHSBColor((float) 0.55, (float) 0.7, (float) 0.8));
		//setResizable(false);    //an sich gut, aber geht nicht, wenn die Komponenten nicht auftauchen
		
		//Fonts
		Font f1 = new Font(Font.SERIF, Font.PLAIN, 15);
		
		//Erstellen der Komponenten
		panelmenu = new JPanel();
		panelmenu.setLayout(new FlowLayout());
		panelmenu.setBounds(10, 10, 765, 37);
		
		menubar = new JMenuBar();
		//menubar.setBounds(10, 10, 770, 50);
		
		//Menüpunkte
		songs = new JMenu("Songs");
		songs.setFont(f1);
		
		genre= new JMenu("Genre");
		genre.setFont(f1);
		
		interpreter = new JMenu("Interpreten");
		interpreter.setFont(f1);
		
		playlists = new JMenu("Playlists");
		playlists.setFont(f1);
		
		
		
		//Searchbar
		searchbar = new JTextField("Was möchten sie suchen?");
		//mouselistener damit bei klick der Text "was mchten sie..." verschwindet
		
		
		
		//Einfügen ins Fenster
		menubar.add(songs);   //schauen ob das alle in eine Zeile geht
		menubar.add(playlists);
		menubar.add(genre);
		menubar.add(interpreter);
		
		panelmenu.add(menubar);
		panelmenu.add(searchbar);
		
		
		add(panelmenu);
		
		
	}
}
