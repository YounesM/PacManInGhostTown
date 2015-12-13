package pacman.runnable;

import pacman.entities.Ghost;
import pacman.entities.PacMan;
import pacman.frames.MainPanel;
import pacman.frames.ScorePanel;

public class Game implements Runnable{
	private MainPanel main;
	private PacMan pacman;
	private ScorePanel score;
	private boolean spawn = false;
	
	public Game(MainPanel main ,ScorePanel score, PacMan pacman){
		this.pacman=pacman;
		this.main=main;
		this.score=score;
	}
	public void run() {
		main.setGameOver(false);
		main.repaint();
		ScorePanel.score=0;
		score.repaint();
		while(pacman.getPosX() > 0 && pacman.getPosY() > 0 
				&& pacman.getPosX() < main.getWidth()-pacman.getHitbox().getWidth()
				&& pacman.getPosY() < main.getHeight()-pacman.getHitbox().getHeight()
				&& !main.getGameOver()){
			pacman.move();
			main.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(checkCollisionPel())
			{
				main.getPellet().init();
				ScorePanel.score++;
				score.repaint();				
			}
			if(ScorePanel.score%5==0 /*&& ScorePanel.score!=0*/ && !spawn){
				new Thread(new Ghost(main)).start();
				spawn=true;
			}
			if(ScorePanel.score%5!=0){
				spawn=false;
			}
		}
		main.setGameOver(true);
		main.resetGhosts();
		main.repaint();
	}
	
	public boolean checkCollisionPel(){
		if(pacman.pacHitbox.intersects(main.getPellet().pelHitbox)){
			return true;
		}
		return false;
	}
}
