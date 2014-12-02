package model.plugin;

import java.awt.event.ActionEvent;
import java.io.File;

import model.event.PluginListenerTest;

import org.junit.Test;

public class PluginFinderTest {


	@Test
	public void testActionPerformed() {
		PluginFinder finder = new PluginFinder(new File("plugins"));
		PluginListenerTest finderTest= new PluginListenerTest();
		finder.addListener(finderTest);
		ActionEvent event= new ActionEvent(source, id, command);
		finder.actionPerformed(event);
	}

}
