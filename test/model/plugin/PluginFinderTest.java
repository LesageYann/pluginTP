package model.plugin;

import static org.junit.Assert.*;

import java.io.*; 

import model.event.PluginListenerTest;

import org.junit.Test;

public class PluginFinderTest {


	@Test
	public void testActionPerformed() {
		PluginFinder finder = new PluginFinder(new File("plugins"));
		PluginListenerTest finderTest= new PluginListenerTest();
		finder.addListener(finderTest);
		//on teste si les fichier sont ajouter
		File source = new File("pluginsTest/Pluginmove.class");
		File destination = new File("plugins/Pluginmove.class");
		source.renameTo(destination);
		// on attend 1 sec pour être sûr que le fichier est ajouter
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail();
		}
		assertTrue(finderTest.haveAdded());
		assertFalse(finderTest.haveRemove());
		destination.renameTo(source);
		// on attend 1 sec pour être sûr que le fichier est ajouter
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			fail();
		}
		assertTrue(finderTest.haveRemove());
		
	}

}
