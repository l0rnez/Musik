package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class AddMusic extends JFrame implements ActionListener{

	private JLabel label1, label2, label3;
	private JTextField field1, field2, field3;
	private JButton button1;
	
	public AddMusic() {
	setLayout(new FlowLayout());
	setVisible(false);
	setSize(600, 200);
	setTitle("Musicplayer");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.getContentPane().setBackground(Color.getHSBColor((float) 0.55, (float) 0.7, (float) 0.8));
	
	
	label1 = new JLabel("Titel:");
	label2 = new JLabel("Interpret:");
	label3 = new JLabel("Genre:");
	
	field1 = new JTextField("                        ");  //noch ändern, Felder so größer machen
	field2 = new JTextField("                        ");
	field3 = new JTextField("                        ");
	
	button1 = new JButton("Add");
	
	add(label1);
	add(field1);
	add(label2);
	add(field2);
	add(label3);
	add(field3);
	add(button1);
	
	
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
