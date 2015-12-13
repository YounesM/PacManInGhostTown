package pacman.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pacman.frames.MainPanel;

public class Pellet {
	private MainPanel main;
	private int posX=(int) (Math.random() * (350 - 50)) + 50;
	private int posY=(int) (Math.random() * (250 - 50)) + 50;
	private Image sprite;
	private Dimension hitbox = new Dimension(10,10);
	public Rectangle pelHitbox;
	
	public Pellet(MainPanel main){
		this.main=main;
		init();
		try {
			sprite = ImageIO.read(new File("pel.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init(){
		posX=(int) (Math.random() * (350 - 50)) + 50;
		posY=(int) (Math.random() * (250 - 50)) + 50;
		pelHitbox = new Rectangle(posX,posY,10,10);
	}
	
	public void drawPellet(Graphics2D g2d){
		g2d.drawImage(sprite, posX, posY, main);
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Dimension getHitbox() {
		return hitbox;
	}
	public void setHitbox(Dimension hitbox) {
		this.hitbox = hitbox;
	}

}
