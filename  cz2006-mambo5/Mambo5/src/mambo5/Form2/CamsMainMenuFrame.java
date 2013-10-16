package mambo5.Form2;

import java.awt.EventQueue;

public class CamsMainMenuFrame extends CamsInterface {


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CamsMainMenuFrame frame = new CamsMainMenuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CamsMainMenuFrame() {
		init();
		addContent(new CamsMainMenuForm());
	}
}
