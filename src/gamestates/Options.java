package gamestates;

import game.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Options extends State implements StateMethods {

    private static BufferedImage background ;


    /**
     * Constructor for the Options state.
     *
     * @param game The game instance.
     */
    public Options( Game game ) {
        super(game);
        loadBackground();
    }

    private static void loadBackground() {
        background = LoadSave.GetSpriteAtlas(LoadSave.OPTIONS_BACKGROUND);
    }

    /**
     *
     */
    @Override
    public void update() {

    }

    /**
     * @param g
     */
    @Override
    public void draw( Graphics g ) {
        g.drawImage( background, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null );
    }

    /**
     * @param e
     */
    @Override
    public void keyPressed( KeyEvent e ) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
            GameState.state = GameState.MENU;
    }

    /**
     * @param e
     */
    @Override
    public void keyReleased( KeyEvent e ) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseClicked( MouseEvent e ) {

    }

    /**
     * @param e
     */
    @Override
    public void mousePressed( MouseEvent e ) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseReleased( MouseEvent e ) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseDragged( MouseEvent e ) {

    }

    /**
     * @param e
     */
    @Override
    public void mouseMoved( MouseEvent e ) {

    }
}
