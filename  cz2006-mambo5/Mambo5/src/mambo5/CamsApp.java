package mambo5;

import javax.swing.SwingUtilities;

import mambo5.Entity.Menu;
import mambo5.Entity.Stall;
import mambo5.Form2.CamsMainFrame;

public class CamsApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				init();
			}
		});
	}

	public static void init() {
		//Model
		Stall stall = new Stall();
		Menu menu = new Menu();
		//View
		CamsMainFrame CamsFrame = new CamsMainFrame();
		//Controller
		//StallController stallController = new StallController();
		//MenuController menuController = new MenuController();
		
		//CamsFrame.setLoginListener(stallController);
		
	}

}
