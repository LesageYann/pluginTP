package model.plugin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import model.event.PluginListenerTest;

import org.junit.Test;

public class PluginFinderTest {

	@Test
	public void testActionPerformed() {
		File source = new File("bin/plugins/Pluginmove.class");
		File destination = new File("bin/Pluginmove.class");
		PluginFinder finder = new PluginFinder(new File("bin/plugins"));
		PluginListenerTest finderTest = new PluginListenerTest();
		finder.addListener(finderTest);
		finder.start();
		// on teste si les fichier sont ajouter
		// wait to add plugin
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(finderTest.haveAdded());
		assertFalse(finderTest.haveRemove());
		source.renameTo(destination);
		// wait to remove plugin
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		source = new File("bin/Pluginmove.class");
		destination = new File("bin/plugins/Pluginmove.class");
		source.renameTo(destination);
		assertTrue(finderTest.haveRemove());
	}
	

}
