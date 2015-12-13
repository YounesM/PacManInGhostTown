package pacman.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	private static final long serialVersionUID = 8190539512196927870L;
	public static int score=0;
	
	public ScorePanel(){
		this.setPreferredSize(new Dimension(400,50));
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Font f = new Font("Calibri",Font.BOLD,20);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("Score = "+score, 10, 30);
	}
	
	public void update(){
		repaint();
	}
}
