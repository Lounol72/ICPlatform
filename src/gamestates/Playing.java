package gamestates;

import entities.Player;
import game.Game;
import levels.LevelManager;
import static game.Game.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playing implements StateMethods{
    private Player player;
    private LevelManager levelManager;
    private Game game;

    public Playing(Game game) {
        this.game = game;
        initClasses();

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private void initClasses() {
        levelManager = new LevelManager(game);
        player = new Player(100, 200, PLAYER_WIDTH , PLAYER_HEIGHT );
        player.loadLvlData(levelManager.getCurrentLevel().getLevelData());

    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
    public Player getPlayer() {return this.player;}

}
