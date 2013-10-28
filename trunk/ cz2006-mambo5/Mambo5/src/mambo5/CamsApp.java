package mambo5;

import javax.swing.SwingUtilities;

import mambo5.Controller.LoginController;
import mambo5.Entity.Menu;
import mambo5.Entity.Stall;
import mambo5.Form.CamsMainFrame;

public class CamsApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CamsMainFrame();
			}
		});
	}
}
