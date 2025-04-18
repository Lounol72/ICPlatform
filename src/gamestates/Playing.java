package gamestates;

import entities.Player;
import game.Game;
import levels.LevelManager;
import ui.PauseOverlay;

import static game.Game.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing extends State implements StateMethods {
    private Player player;
    private LevelManager levelManager;
    private PauseOverlay pauseOverlay;
    public boolean paused = false;

    public Playing(Game game) {
        super(game);
        initClasses();
    }

    @Override
    public void update() {
        if (!paused) {
            levelManager.update();
            player.update();
        } else
            pauseOverlay.update();
    }

    @Override
    public void draw(Graphics g) {
        levelManager.draw(g);
        player.render(g);
        if (paused)
            pauseOverlay.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q:
                this.player.setLeft(true);
                break;
            case KeyEvent.VK_D:
                this.player.setRight(true);
                break;
            case KeyEvent.VK_SPACE:
                this.player.setJump(true);
                break;
            case KeyEvent.VK_ENTER:
                GameState.state = GameState.MENU;
                player.resetDirBooleans();
                break;
            case KeyEvent.VK_ESCAPE:
                paused = !paused;
                player.resetDirBooleans();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q:
                this.player.setLeft(false);
                break;
            case KeyEvent.VK_D:
                this.player.setRight(false);
                break;
            case KeyEvent.VK_SPACE:
                this.player.setJump(false);
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            this.player.setAttacking(true);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (paused)
            pauseOverlay.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (paused)
            pauseOverlay.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (paused)
            pauseOverlay.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (paused)
            pauseOverlay.mouseMoved(e);
    }

    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(100, 200, PLAYER_WIDTH , PLAYER_HEIGHT );
        player.loadLvlData(levelManager.getCurrentLevel().getLevelData());
        pauseOverlay = new PauseOverlay();

    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
