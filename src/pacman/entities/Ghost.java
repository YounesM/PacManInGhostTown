package pacman.entities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pacman.frames.MainPanel;



public class Ghost implements Runnable {
	private int posX=0,posY=0,dx=1,dy=1;
	private Image sprite;
	private Rectangle ghostHitbox = new Rectangle(posX+5,posY+3,10,20);
	private MainPanel panel;
	
	public Ghost(MainPanel panel){
		this.panel = panel;
		try {
			this.sprite = ImageIO.read(new File("blook.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void move(Rectangle2D zone){
//		if(posX < panel.getPacman().getPosX()){
//			posX++;
//		}
//		else if (posY < panel.getPacman().getPosY()){
//			posY++;
//		}
//		
//		else if (posY > panel.getPacman().getPosY()){
//			posY--;
//		}
//		else if (posX > panel.getPacman().getPosX()){
//			posX--;
//		}
		posX+=dx;
        posY+=dy;
        if (posX < zone.getMinX()) { posX = (int) zone.getMinX();  dx = -dx; }
        if (posX+15 >= zone.getMaxX()) { posX = (int) zone.getMaxX() - 15;  dx = -dx; }
        if (posY < zone.getMinY()) { posY = (int) zone.getMinY();  dy = -dy; }
        if (posY+15 >= zone.getMaxY()) { posY = (int) zone.getMaxY() - 15;  dy = -dy; }
        ghostHitbox.x=posX;
        ghostHitbox.y=posY;
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawImage(sprite, posX, posY, panel);
	}

	@Override
	public void run() {
		Ghost ghost = new Ghost(panel);
		panel.addGhost(ghost);
		panel.repaint();
		while(!panel.getGameOver()){
			ghost.move(panel.getBounds());
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(ghost.checkCollisionPac()){
				panel.setGameOver(true);
			}
		}
	}
	
	public boolean checkCollisionPac(){
		if(ghostHitbox.intersects(panel.getPacman().pacHitbox)){
			return true;
		}
		return false;
	}


}
