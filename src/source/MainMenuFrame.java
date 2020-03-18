package source;

import javax.swing.JFrame;

public class MainMenuFrame extends MyFrame{

	public MainMenuFrame() {

		this.add(new MainMenuPanel());
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new MainMenuFrame();
	}

}
