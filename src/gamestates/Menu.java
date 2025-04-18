package gamestates;

import game.Game;
import ui.MenuButton;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static game.Game.*;

public class Menu extends State implements StateMethods {

    private MenuButton[] buttons = new MenuButton[3];
    private BufferedImage backgroundMenu;
    private BufferedImage background;

    private int menuX, menuY, menuWidth, menuHeight;

    public Menu(Game game) {
        super(game);
        loadButtons();
        loadBackground();
    }

    private void loadBackground() {
        backgroundMenu = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND);

        menuWidth = (int) (backgroundMenu.getWidth() * SCALE);
        menuHeight = (int) (backgroundMenu.getHeight() * SCALE);
        menuX = (int) ((float) GAME_WIDTH / 2 - backgroundMenu.getWidth() * SCALE / 2);
        menuY = (int) (45 * SCALE);


    }

    public void update() {
        // Update menu components here
        for (MenuButton mb : buttons)
            mb.update();
    }

    public void draw(Graphics g) {
        // Draw menu components here
        g.drawImage(backgroundMenu, menuX, menuY, menuWidth, menuHeight, null);
        for (MenuButton mb : buttons)
            mb.draw(g);

    }

    private void loadButtons() {
        buttons[0] = new MenuButton(GAME_WIDTH / 2, (int)(150 * SCALE), 0, GameState.PLAYING);
        buttons[1] = new MenuButton(GAME_WIDTH / 2, (int)(220 * SCALE), 1, GameState.OPTIONS);
        buttons[2] = new MenuButton(GAME_WIDTH / 2, (int)(290 * SCALE), 2, GameState.QUIT);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Start the game or switch to the playing state
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
        for (MenuButton mb : buttons) {
            if (isIn(e, mb)){
                mb.setMousePressed(true);
                break;
            }
        }
    }

    @Override
    public void mouseReleased( MouseEvent e ) {
        for ( MenuButton mb : buttons ) {
            if ( isIn(e, mb) ) {
                if ( mb.isMousePressed() ) {
                    mb.applyGamestate();
                }
                break;
            }
        }
        resetButtons();
    }

    private void resetButtons() {
        for (MenuButton mb : buttons) mb.resetBools();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for ( MenuButton mb : buttons )
            mb.setMouseOver(false);
        for ( MenuButton mb : buttons )
            if ( isIn(e, mb) ) {
                mb.setMouseOver(true);
                break;
            }
    }
}
