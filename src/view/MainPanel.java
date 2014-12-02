package view;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JComponent center, menu ;
	protected JFrame frame;
	
	public MainPanel(JFrame f){
		this.frame=f;
		this.setLayout(new BorderLayout());
		this.menu = new MenuPanel(this);
        add(this.menu, BorderLayout.NORTH);
        
        this.center =new CenterPanel(this,"test");
        add(center, BorderLayout.CENTER);
	}
	
	public JComponent getCentre(){
		return this.center;
	}
	public JComponent getMenu(){
		return this.menu;
	}
	public JFrame getFrame(){
		return this.frame;
	}
}
