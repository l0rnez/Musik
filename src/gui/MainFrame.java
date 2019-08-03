package gui;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MainFrame extends javax.swing.JFrame {

	public MainFrame() {
	}

	public void initComponents() {
        JButton jButton1 = new javax.swing.JButton();
        JLabel jLabel1 = new javax.swing.JLabel();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());
 
        jButton1.setText("jButton1");
        getContentPane().add(jButton1);

        //adjust size of frame
        pack();
    }
}
