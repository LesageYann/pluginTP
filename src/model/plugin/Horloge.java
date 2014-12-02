package model.plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Horloge {

	public void heure(){
		
	}
	
	
	
	public static void main(String[] args) {
		ActionListener taskPerformer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(java.util.Calendar.getInstance().getTime());

				System.out.println("test1");
				
			}
		  };
		Timer time = new Timer(1000, taskPerformer);
		time.start();
		while (true){

			System.out.println("test2");
			time.restart();
		}

	}

}
