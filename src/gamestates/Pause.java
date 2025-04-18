package gamestates;

import entities.Player;
import game.Game;
import levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Pause extends State implements StateMethods{
    private Playing play;

    public Pause(Game game) {
        super(game);
        this.play = game.getPlaying();
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        play.draw(g);
        g.setColor( new Color( 0, 0, 0, 150 ));
        g.fillRect( 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT );
        g.setColor(Color.WHITE);
        g.drawString("Press Escape to continue", Game.GAME_WIDTH / 2 - 100, Game.GAME_HEIGHT / 2 - 50);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            // Resume the game or switch to the playing state
            GameState.state = GameState.PLAYING;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
}
