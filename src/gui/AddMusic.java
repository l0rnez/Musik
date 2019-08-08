package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import data.data;
import song.Song;

public class AddMusic extends JFrame implements ActionListener{

	private JLabel label1, label2, label3;
	private JTextField field1, field2, field3;
	private JButton button1;
	private String title, interpreter, genre;
	
	public AddMusic() {
	setLayout(new FlowLayout());
	setVisible(false);
	setSize(600, 100);
	setTitle("Musicplayer");
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	this.getContentPane().setBackground(Color.getHSBColor((float) 0.55, (float) 0.7, (float) 0.8));
	
	data alles = new data("Alles");
	Dimension groeﬂe = new Dimension(100, 20);
	
	
	label1 = new JLabel("Titel:");
	label2 = new JLabel("Interpret:");
	label3 = new JLabel("Genre:");
	
	field1 = new JTextField();  //noch ‰ndern, Felder so grˆﬂer machen
	field1.setPreferredSize(groeﬂe);	//warum funzt das nicht(geht nur wenn man kein Layout benutzt)
	field2 = new JTextField();
	field2.setPreferredSize(groeﬂe);
	field3 = new JTextField();
	field3.setPreferredSize(groeﬂe);
	
	button1 = new JButton("Add");
	
	add(label1);
	add(field1);
	add(label2);
	add(field2);
	add(label3);
	add(field3);
	add(button1);
	
	//hollt sich den Titel, den Interpreten und das Genre aus den jeweiligen Text Feldern
	field1.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			title = field1.getText();
			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
		
			
		}
	});

	
	field2.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			interpreter = field2.getText();
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	field3.addFocusListener(new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) {
			genre = field3.getText();
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	button1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			data.content.add(new Song(title, interpreter, genre));
			alles.testDruck();
		}
	});
	
	
	
	
	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void visible(int a) {
		if( a == 1) {
			setVisible(true);
		}
		else {
			setVisible(false);
			}
		}
}
