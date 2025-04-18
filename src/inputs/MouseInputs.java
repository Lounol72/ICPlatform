package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.GamePanel;
import gamestates.GameState;

public class MouseInputs implements MouseListener, MouseMotionListener {

	private GamePanel gamePanel;

	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (GameState.state == GameState.OPTIONS)
			gamePanel.getGame().getOptions().mouseDragged(e);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (GameState.state) {
			case MENU:
				gamePanel.getGame().getMenu().mouseMoved(e);
				break;
			case PLAYING:
				gamePanel.getGame().getPlaying().mouseMoved(e);
				break;
			case OPTIONS:
				gamePanel.getGame().getOptions().mouseMoved(e);
				break;
			case QUIT:
				break;
			case GAMEOVER:
				break;
			case PAUSE:
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
			case SETTINGS:
				break;
			case TUTORIAL:
				break;
			case LEVELUP:
				break;
			case SKILLTREE:
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + GameState.state);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (GameState.state) {
			case MENU:
				gamePanel.getGame().getMenu().mouseClicked(e);
				break;
			case PLAYING:
				gamePanel.getGame().getPlaying().mouseClicked(e);
				break;
			case OPTIONS:
				gamePanel.getGame().getOptions().mouseClicked(e);
				break;
			case QUIT:
				break;
			case GAMEOVER:
				break;
			case PAUSE:
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
			case SETTINGS:
				break;
			case TUTORIAL:
				break;
			case LEVELUP:
				break;
			case SKILLTREE:
				break;
			default:
				break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (GameState.state) {
			case MENU:
				gamePanel.getGame().getMenu().mousePressed(e);
				break;
			case PLAYING:
				gamePanel.getGame().getPlaying().mousePressed(e);
				break;
			case OPTIONS:
				gamePanel.getGame().getOptions().mousePressed(e);
				break;
			case QUIT:
				break;
			case GAMEOVER:
				break;
			case PAUSE:
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
			case SETTINGS:
				break;
			case TUTORIAL:
				break;
			case LEVELUP:
				break;
			case SKILLTREE:
				break;
			default : throw new IllegalStateException("Unexpected value: " + GameState.state);
        }

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (GameState.state) {
			case MENU:
				gamePanel.getGame().getMenu().mouseReleased(e);
				break;
			case PLAYING:
				gamePanel.getGame().getPlaying().mouseReleased(e);
				break;
			case OPTIONS:
				gamePanel.getGame().getOptions().mouseReleased(e);
				break;
			case QUIT:
				break;
			case GAMEOVER:
				break;
			case PAUSE:
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
			case SETTINGS:
				break;
			case TUTORIAL:
				break;
			case LEVELUP:
				break;
			case SKILLTREE:
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + GameState.state);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
