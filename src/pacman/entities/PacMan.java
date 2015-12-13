package pacman.entities;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import pacman.frames.MainPanel;

public class PacMan {
	private MainPanel main;
	private int posX=100, posY=100;
	private Dimension hitbox = new Dimension(20,20);
	public Rectangle pacHitbox = new Rectangle(posX,posY,20,20);
	private ArrayList<Image> sprites = new ArrayList<Image>();
	private int speed=4;
	public int state=0;
	private int direction=KeyEvent.VK_RIGHT;
	
	public PacMan(MainPanel main){
		this.main = main;
		try {
			sprites.add(ImageIO.read(new File("sp1.png")));
			sprites.add(ImageIO.read(new File("sp2.png")));
			sprites.add(ImageIO.read(new File("sp3.png")));
			sprites.add(ImageIO.read(new File("sp4.png")));
			sprites.add(ImageIO.read(new File("sp5.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init(){
		posX = 100;
		posY = 100;
		speed = 4;
		state=0;
		direction = KeyEvent.VK_RIGHT;
	}
	
	public void move(){
		switch(direction){
		case KeyEvent.VK_LEFT:
			posX-=1+speed;
			if(state==0){state=2;}else{state=0;}
			break;
		case KeyEvent.VK_RIGHT:
			posX+=1+speed;
			if(state==0){state=1;}else{state=0;}
			break;
		case KeyEvent.VK_UP:
			posY-=1+speed;
			if(state==0){state=3;}else{state=0;}
			break;
		case KeyEvent.VK_DOWN:
			posY+=1+speed;
			if(state==0){state=4;}else{state=0;}
			break;
		}
		pacHitbox.x=posX;
		pacHitbox.y=posY;
	}
	
	public void drawPacMan(Graphics2D g2d){
		g2d.drawImage(sprites.get(state), posX, posY, main);
	}
	
	public void setPosX(int posX){
		this.posX=posX;
	}
	
	public int getPosX(){
		return this.posX;
	}
	
	public void setPosY(int posY){
		this.posY=posY;
	}
	
	public int getPosY(){
		return this.posY;
	}
	public Dimension getHitbox() {
		return hitbox;
	}

	public void setHitbox(Dimension hitbox) {
		this.hitbox = hitbox;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
