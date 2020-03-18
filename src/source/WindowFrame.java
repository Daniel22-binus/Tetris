package source;

import javax.swing.JFrame;

public class WindowFrame extends MyFrame {

	public WindowFrame() {

		Board board = new Board();
		this.add(board);

		this.setGlassPane(new GlassPane());
		this.getGlassPane().setVisible(true);
		this.addKeyListener(board);

		this.setVisible(true);
	}

}
