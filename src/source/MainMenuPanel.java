package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	JLabel title, upTitle, upUpTitle;
	JLabel play, exit, howToPlay;
	BufferedImage cube;
	BufferedImage img;
	Clip clip;
	private String highscore = "0";
	private int currHighscore = 0;
	private int newHighscore = 0;

	private float h = (float) 0.53358333;
	private float s = (float) 0.5697;
	private float b = (float) 0.9569;

	@Override
	public void paint(Graphics g) {
		setBackground(Color.getHSBColor(h, s, b));
		super.paint(g);
		g.drawImage(img, 40, 320, null);
		g.drawImage(cube, 250, 30, 130, 130, null);
	}

	public JLabel initLabel(JLabel MyLabel)
	{
		MyLabel.setBounds(60, 213, 500, 50);
		MyLabel.setFont(new Font("Orange Kid", Font.BOLD, 36));
		MyLabel.setForeground(Color.BLACK);

		return MyLabel;
	}

	public MainMenuPanel() {
		setLayout(null);

		try {
			img = ImageIO.read(Board.class.getResource("/totoro.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			cube = ImageIO.read(Board.class.getResource("/cube.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// title = new JLabel("TETRIS 2019", JLabel.CENTER);
		// title.setBounds(50, 0, 500, 50);
		// title.setFont(new Font("Helvetica", Font.BOLD, 36));
		// title.setForeground(Color.BLUE);
		// add(title);

		play = new JLabel("Play", JLabel.CENTER);
		play = initLabel(play);

		play.addMouseListener(new MouseClickLabel(play));
		add(play);

		howToPlay = new JLabel("How To Play", JLabel.CENTER);
		howToPlay = initLabel(howToPlay);

		howToPlay.addMouseListener(new MouseClickLabel(howToPlay));
		add(howToPlay);

		exit = new JLabel("Exit", JLabel.CENTER);
		exit = initLabel(exit);

		exit.addMouseListener(new MouseClickLabel(exit));
		add(exit);

		// masukkin sound
		try {
			clip = AudioSystem.getClip();
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File("Sprites/TonariNoTotoro.wav"));
			clip.open(stream);
			clip.start();
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
	}

	public void setHighscore(int score) {
		newHighscore = score;
		if (newHighscore > currHighscore) {
			currHighscore = newHighscore;
			highscore = "" + currHighscore;
		}
	}

	class MouseClickLabel implements MouseListener{
		
		JLabel tempLabel;
		
		public MouseClickLabel(JLabel label){
			this.tempLabel = label;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			if (tempLabel == play || tempLabel == howToPlay || tempLabel == exit)
			{
				tempLabel.setForeground(Color.BLACK);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

			if (tempLabel == play || tempLabel == howToPlay || tempLabel == exit)
			{
				tempLabel.setForeground(Color.YELLOW);
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			if (tempLabel == play)
			{
				MainMenuFrame.window.remove(MainMenuPanel.this);
				new WindowFrame();
			}
			else if (tempLabel == howToPlay)
			{
				MainMenuFrame.window.remove(MainMenuPanel.this);
				new HowToPlayFrame();
			}
			else if (tempLabel == exit)
			{
				System.exit(0);
			}
			
		}


	}

}
