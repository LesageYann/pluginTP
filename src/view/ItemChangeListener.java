package view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import model.plugin.PluginModel;

public class ItemChangeListener implements ItemListener {
	private PluginModel model;
	private PluginFrame frame;

	public ItemChangeListener(PluginFrame frame,PluginModel model) {
		this.model = model;
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		if (event.getStateChange() == ItemEvent.SELECTED) {
			String item = (String) event.getItem();
			try {
				this.model.setCurrentPlugin(item);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Error while selecting Plugin", "FATAL ERROR", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}