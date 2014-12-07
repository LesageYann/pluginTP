package view;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected CenterPanel center;
	protected MenuPanel menu ;
	protected PluginFrame frame;
	
	public MainPanel(PluginFrame f){
		this.frame=f;
		this.setLayout(new BorderLayout());
		this.menu = new MenuPanel(this);
        add(this.menu, BorderLayout.NORTH);
        
        this.center =new CenterPanel(this.frame,"test");
        add(center, BorderLayout.CENTER);
	}
	
	public JComponent getCentre(){
		return this.center;
	}
	public JComponent getMenu(){
		return this.menu;
	}
	public PluginFrame getFrame(){
		return this.frame;
	}
	
	public String getText(){
		return this.center.getText();
	}
	
	public void setText(String s){
		this.center.setText(s);
	}
	
	@Override
	public void update(Graphics arg0) {
		this.center.update(arg0);
		super.update(arg0);
	}
}
