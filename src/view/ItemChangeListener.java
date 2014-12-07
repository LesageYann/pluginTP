package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.JOptionPane;

public class ItemChangeListener implements ItemListener {
	private PluginFrame frame;

	public ItemChangeListener(PluginFrame f) {
		this.frame = f;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			File item = (File) event.getItem();
			try {
				this.frame.setCurrentPlugin(item);
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				JOptionPane.showMessageDialog(frame, "Error while selecting Plugin", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}