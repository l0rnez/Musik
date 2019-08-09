package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import Main.Musikverwaltung;
import data.data;
import song.Song;
import playlist.Playlist;
import gui.AddMusic;

public class MainFrame extends JFrame implements ActionListener{
	private JButton bAktualisieren, bAddMusic,play,pause,stop;
	private JLabel label1;
	private JFrame jframe1;
	private JTable tabelle, tabelleinterpreten, tabellegenre, tabellesuchergebnisse;
	private JPanel panelmenu, panelliste;
	private JMenu songs, genre, interpreter, playlists;
	private JMenuBar menubar;
	private JTextField searchbar;
	private JScrollPane scroll, scrollinterpreten, scrollgenre, scrollsuche;
	private JProgressBar fortschritt;
	int songl�nge=15;//Beispiel eig. �ber song.getl�nge
	Timer t1 = new Timer();
	Timer t2 = new Timer();
	boolean zpause=false;
	boolean t1runs=false,t2runs=false;//Zwischenpause
	
	
	
	ArrayList<Song> alleshier = new ArrayList<Song>();
	String[] [] daten = null;
	Playlist keck = new Playlist("gay nay nay");
	
	
	//Funktionen im GUI
	public String[] [] druckenTabelle(ArrayList<Song> neu) {
		alleshier = neu;
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
		return daten;
	}
	
	
	
	AddMusic frame2 = new AddMusic();  //könnte man eventuell anders lösen
	
	//alles Musik stücke
	data alles = new data("Alles");
	

	
	
	//Probleme:
	//	X	1. Warum zum fick ist das Fenster leer, wenn man es Ã¶ffnet, aber fÃ¼llt sich, wenn man es grÃ¶ÃŸer macht?
	
	//	X	2. Warum muss Actionlistener (ganz unten) geaddet werden, damit der sich nicht beschwert
	
	//	O	3. bei dem "Add"-Fenster muss man immer Enter drücken, um Titel und ähnliches zu bestätigen
			//Lösung: Focus listener, der reagiert wenn man von dem Feld weggeht
	
	//	X	4. Tabelle lässt sich durch "Aktualisieren" nicht refreshen, obwohl daten, aus "data" in MainFrame ankomme
	//		Tabelle kriegt die Daten nicht
	//		Daten werden aber in "daten" übernommen
	
	//	X	5. Tabellen Listener macht alles 2 Mal, wird problematisch beim Sound abspielen
	
	
	
	
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
	alleshier = alles.getContent();
	daten = druckenTabelle(alleshier);
	
	
	
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
/*	String suche;
	String [] suchetitel = {"Suchergebnisse"};
	String[] [] sucheergebnisse = new String[alleshier.size()] [1];
	ArrayList<Song> gesuchteTitel = new ArrayList<Song>();
	ArrayList<String> gesuchteInterpreten = new ArrayList<String>();
	ArrayList<String> gesuchteGenre = new ArrayList<String>();
	
	
	
	
	for(int i = 0; i < alleshier.size(); i++) {
		sucheergebnisse [i] [0] = gesuchteTitel.get(i).getTitle();
	}
*/

	

		
		
		
		
		
		
		
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
		
			bAktualisieren = new JButton("Aktualisieren");
			bAktualisieren.setFont(f1);
		
			//Searchbar
			searchbar = new JTextField("Was möchten sie suchen?");
			//mouselistener damit bei klick der Text "was mchten sie..." verschwindet
			
			
			
			
			
		//Songtabellen
		tabelle = new JTable(daten, titlesTable);
		tabelleinterpreten = new JTable(datainterpreten, interpretentitel);
		tabellegenre = new JTable(datagenre, genratitel);
		//tabellesuchergebnisse = new JTable(sucheergebnisse,suchetitel);
		
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
		menubar.add(bAktualisieren);
		
		
		panelmenu.add(bAddMusic);
		panelmenu.add(menubar);
		panelmenu.add(searchbar);
		panelmenu.add(bAktualisieren);
		
	
//Start Leon
		JPanel Player = new JPanel();
		Player.setBounds(10, 450, 760, 80);
		Player.setLayout(new FlowLayout());
		Player.setBackground(Color.white);
		
		fortschritt = new JProgressBar(0,songl�nge);	//playleiste
		fortschritt.setValue(0);
		fortschritt.setStringPainted(true);
		fortschritt.setPreferredSize(new Dimension(480,50));
		fortschritt.setSize(getPreferredSize());
		
		play = new JButton();
		play.setOpaque(false);
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.setIcon(new ImageIcon("play.png"));
		play.addActionListener(new ActionListener() 
		{
			
				public void actionPerformed(ActionEvent ae)
				{
					t1 = new Timer();
					if(!zpause && t1runs==false)
					{
							if(fortschritt.getValue()<=songl�nge)
							{
								t1.scheduleAtFixedRate(new TimerTask() 
								{
	
									@Override
									public void run() 
									{
										t1runs=true;
										fortschritt.setValue(fortschritt.getValue()+1);
										if(fortschritt.getValue() == songl�nge)
										{
											fortschritt.setValue(0);
											t1.cancel();
											t1runs=false;
										}
									}
									
								}, fortschritt.getValue(), 1000);
							}
			
					}
					
						if(zpause && t2runs==false)
						{
							t2 = new Timer();
							if(fortschritt.getValue()<=songl�nge)
							{
								
								t2.scheduleAtFixedRate(new TimerTask() 
								{
	
									@Override
									public void run() 
									{
										t2runs=true;
										fortschritt.setValue(fortschritt.getValue()+1);
										if(fortschritt.getValue() == songl�nge)
										{
											fortschritt.setValue(0);
											t2.cancel();
											t2runs=false;
										}
									}
									
								}, fortschritt.getValue(), 1000);
							
						
							}
						}
				}
		});
		
		pause = new JButton();
		pause.setOpaque(false);
		pause.setContentAreaFilled(false);
		pause.setBorderPainted(false);
		pause.setIcon(new ImageIcon("pause.png"));
		pause.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent ae)
					{
						zpause=true;
						t1.cancel();
						t2.cancel();
						t1runs=false;
						t2runs=false;
					}
				});
		
		stop = new JButton();
		stop.setOpaque(false);
		stop.setContentAreaFilled(false);
		stop.setBorderPainted(false);
		stop.setIcon(new ImageIcon("stop.png"));
		stop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae)
			{
				fortschritt.setValue(0);
				t1.cancel();
				t2.cancel();
				t1runs=false;
				t2runs=false;
			}
		});
		
	
		
		Player.add(play);
		Player.add(pause);
		Player.add(fortschritt);
		Player.add(stop);
		
		
		
		//panelliste.add(tabelle);
		add(scrollsuche);
		add(scroll);
		add(scrollinterpreten);
		add(scrollgenre);
		add(panelmenu);
		add(Player);
		
		
		
		//Button Actions
		bAddMusic.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(true);
				alles.testDruck();
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
				scrollinterpreten.setVisible(true);;
				
			}
		});
		
		
		
		//Searchbar Action
		searchbar.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				/*char a = e.getKeyChar();
				suche = Character.toString(a);
				gesuchteTitel = alles.searchSong(suche);*/
				
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
		
		bAktualisieren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				alles.testDruck();
				daten = druckenTabelle(data.getContent());
				//tabelle.revalidate();
				//scroll.revalidate();
				
				//tabelle.repaint();
				//scroll.repaint();
				
				//scroll.setBounds(10, 50, 800, 500);
				
				//tabelle.tableChanged(TableModelEvent);
				
				tabelle.invalidate();
				scroll.repaint();
				
				System.out.println(tabelle.getColumnCount()); //Tabelle kreigt die Daten net
				System.out.println(daten[2][1]);
				System.out.println(daten[0][0]);
				try {
					System.out.println(daten[3][0]);
				}
				finally{
					System.out.println("net da");
				}
			}
		});
		
		
		//Tabelle Listener für Zeilen
		tabelle.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(tabelle.getSelectedRow() > -1) {
					System.out.println(tabelle.getValueAt(tabelle.getSelectedRow(), 0).toString());
				}
				
			}
		});
		
		
	}
	
	
	


	//Warum muss das geaddet werden, damit der sich nicht beschwert
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
