package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GamePanel;
import gamestates.GameState;

import static utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (GameState.state) {
			case MENU:
				gamePanel.getGame().getMenu().keyReleased(e);
				break;
			case PLAYING:
				gamePanel.getGame().getPlaying().keyReleased(e);
				break;
			case OPTIONS:
				gamePanel.getGame().getOptions().keyReleased(e);
				break;
			case QUIT:
				break;
			case GAMEOVER:
				break;
			case WIN:
				break;
			case LOSE:
				break;
			case CREDITS:
				break;
			case HELP:
				break;
			case SHOP:
				break;
			case CUTSCENE:
				break;
			case INVENTORY:
				break;
			case DIALOGUE:
				break;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (GameState.state) {
			case MENU:
				gamePanel.getGame().getMenu().keyPressed(e);
				break;
			case PLAYING:
				gamePanel.getGame().getPlaying().keyPressed(e);
				break;
			case OPTIONS:
				gamePanel.getGame().getOptions().keyPressed(e);
				break;
			case QUIT:
				break;
			case GAMEOVER:
				break;
			case WIN:
				break;
			case LOSE:
				break;
			case CREDITS:
				break;
			case HELP:
				break;
			case SHOP:
				break;
			case CUTSCENE:
				break;
			case INVENTORY:
				break;
			case DIALOGUE:
				break;
		}
	}
}
