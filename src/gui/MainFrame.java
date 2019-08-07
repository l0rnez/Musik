package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	private JButton bLinks, bRechts, bMitte,play,stop,pause;
	private JLabel label1;
	private JFrame jframe1,PlayerFrame;
	private JTable tabelle;
	private JPanel panelmenu, panelliste;
	private JMenu songs, genre, interpreter, playlists;
	private JMenuBar menubar;
	private JTextField searchbar;
	private JScrollPane scroll;
	private JProgressBar fortschritt;
	int songlänge=15;//Beispiel eig. über song.getlänge
	Timer t = new Timer();
	Timer t2 = new Timer();
	boolean zpause=false;//Zwischenpause
	
	//Probleme:
	//1. Warum zum fick ist das Fenster leer, wenn man es Ã¶ffnet, aber fÃ¼llt sich, wenn man es grÃ¶ÃŸer macht?
	
	
	public MainFrame()
	{
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
		
		
		
			//Searchbar
			searchbar = new JTextField("Was möchten sie suchen?");
			//mouselistener damit bei klick der Text "was mchten sie..." verschwindet
			
		//Songtabelle
		tabelle = new JTable(data, titles);
		tabelle.setBounds(10, 50, 500, 500);
		
		scroll = new JScrollPane(tabelle);
		scroll.setBounds(10, 50, 760, 400);
		
		
		//Player
		JPanel Player = new JPanel();
		Player.setBounds(10, 450, 760, 80);
		Player.setLayout(new FlowLayout());
		Player.setBackground(Color.white);
		
		fortschritt = new JProgressBar(0,songlänge);	//playleiste
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
					t = new Timer();
					if(!zpause)
					{
							if(fortschritt.getValue()<=songlänge)
							{
								t.scheduleAtFixedRate(new TimerTask() 
								{
	
									@Override
									public void run() 
									{
										fortschritt.setValue(fortschritt.getValue()+1);
										System.out.println(fortschritt.getValue());
										if(fortschritt.getValue() == songlänge)
										{
											fortschritt.setValue(0);
											t.cancel();
										}
									}
									
								}, fortschritt.getValue(), 1000);
							}
			
					}
					
						if(zpause)
						{
							t2 = new Timer();
							if(fortschritt.getValue()<=songlänge)
							{
								
								t2.scheduleAtFixedRate(new TimerTask() 
								{
	
									@Override
									public void run() 
									{
										fortschritt.setValue(fortschritt.getValue()+1);
										System.out.println(fortschritt.getValue());
										
										if(fortschritt.getValue() == songlänge)
										{
											fortschritt.setValue(0);
											t2.cancel();
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
						t.cancel();
						t2.cancel();
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
				t.cancel();
				t2.cancel();
			}
		});
		
	
		
		Player.add(play);
		Player.add(pause);
		Player.add(fortschritt);
		Player.add(stop);
		//Player.add(shuffle,BorderLayout.WEST );
		
		
		
		
		//EinfÃ¼gen ins Fenster
		menubar.add(songs);   //schauen ob das alle in eine Zeile geht
		menubar.add(playlists);
		menubar.add(genre);
		menubar.add(interpreter);
		
		panelmenu.add(menubar);
		panelmenu.add(searchbar);
		
		
		
		//panelliste.add(tabelle);
		
		add(scroll);
		add(panelmenu);
		add(Player);
		
	}
}
