package pacman.frames;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import pacman.entities.PacMan;
import pacman.listeners.Controls;

public class PacManFrame extends JFrame {
	private static final long serialVersionUID = -9065092610632251398L;
	private MainPanel mainP;
	private PacMan pacman = new PacMan(mainP);
	private ScorePanel scoreP = new ScorePanel();
	
	public PacManFrame(){
		this.setTitle("PacMan in Ghost Town");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setVisible(true);
		
		mainP = new MainPanel(pacman);
		this.getContentPane().add(mainP, BorderLayout.CENTER);
		this.getContentPane().add(scoreP, BorderLayout.SOUTH);
		this.addKeyListener(new Controls(mainP,scoreP,pacman));
		
		this.pack();
	}
}
