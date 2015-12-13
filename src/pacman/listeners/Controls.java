package pacman.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pacman.entities.PacMan;
import pacman.frames.MainPanel;
import pacman.frames.ScorePanel;
import pacman.runnable.Game;

public class Controls implements KeyListener{
	PacMan pacman;
	MainPanel main;
	ScorePanel score;
	
	public Controls(MainPanel main, ScorePanel score, PacMan pacman){
		this.pacman=pacman;
		this.main=main;
		this.score=score;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()=='r' || e.getKeyCode()==KeyEvent.VK_ENTER){
			pacman.init();
			main.getPellet().init();
			Thread th = new Thread(new Game(main,score,pacman));
			th.start();
			main.setStart(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_LEFT 
				|| e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN ){
			pacman.setDirection(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
