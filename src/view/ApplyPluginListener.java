package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyPluginListener implements ActionListener {
	
	private PluginFrame frame;

	public ApplyPluginListener(PluginFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.frame.applyCurrentPlugin();
	}

}
