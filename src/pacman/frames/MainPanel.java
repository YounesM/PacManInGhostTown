package pacman.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import pacman.entities.Ghost;
import pacman.entities.PacMan;
import pacman.entities.Pellet;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = -941667287831269755L;
	private PacMan pacman;
	private Pellet pel = new Pellet(this);
	private boolean gameover = false;
	private boolean starts = false;
	private ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
	
	public MainPanel(PacMan pacman){
		this.setPreferredSize(new Dimension(400,300));
		this.pacman=pacman;
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		pacman.drawPacMan(g2d);
		pel.drawPellet(g2d);
		if(!starts){
			try {
				g.drawImage(ImageIO.read(new File("start.png")), 0, 0, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(Ghost ghost : ghosts){
			ghost.draw(g2d);
		}
		if(gameover){
			try {
				g.drawImage(ImageIO.read(new File("gameover.png")), 0, 0, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.setColor(Color.RED);
			g.drawString("SCORE FINAL : "+ScorePanel.score,150,200);
		}
	}
	
	public void addGhost(Ghost g){
		ghosts.add(g);
	}
	
	public void resetGhosts(){
		ghosts=new ArrayList<Ghost>();
	}

	public void setStart(boolean t){
		starts=t;
	}
	
	public void setGameOver(boolean t){
		gameover=t;
	}
	
	public boolean getGameOver(){
		return gameover;
	}

	public PacMan getPacman() {
		return pacman;
	}
	
	public Pellet getPellet() {
		return pel;
	}
	
}
