package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class PluginFrame extends JFrame{
	protected JMenu menu;
	protected JPanel mainPanel;
	
	public PluginFrame(String titre){
		super(titre);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(800,600)); 
		JPanel a = new MainPanel(this);
        setContentPane(a);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	
	public static void main(String args []){
			PluginFrame f = new PluginFrame("Teeeeeeeeest");
	}
}
