package ui;

import game.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static game.Game.*;
import static utilz.Constants.UI.PauseButtons.SOUND_SIZE;

public class PauseOverlay {

    //Background image variables
    private BufferedImage backgroundImg;
    private final int DEFAULT_BG_Y = 25;
    private int bgX, bgY, bgW, bgH;

    //Sound image variables
    private SoundButton musicButton, sfxButton;


    public PauseOverlay() {
        loadBackground();
        createSoundButtons();
    }

    public void update() {
        // Update logic for the pause overlay
        musicButton.update();
        sfxButton.update();
    }

    public void draw( Graphics g ) {
        // Background
        g.setColor(new Color (0, 0, 0, 128));
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);

        // Sound buttons
        musicButton.draw(g);
        sfxButton.draw(g);
    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
        bgW = (int) (backgroundImg.getWidth() * SCALE);
        bgH = (int) (backgroundImg.getHeight() * SCALE);
        bgX = (int) (GAME_WIDTH / 2 - bgW / 2);
        bgY = (int) (DEFAULT_BG_Y * SCALE);
    }

    private void createSoundButtons() {
        int soundX = (int) (450 * SCALE);
        int musicY = (int) (140 * SCALE);
        int sfxY = (int) (186 * SCALE);
        musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
        sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (isIn(e, musicButton))
            musicButton.setMousePressed(true);
        if (isIn(e, sfxButton))
            sfxButton.setMousePressed(true);

    }


    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!(musicButton.isMuted()));
        } else if (isIn(e, sfxButton)) {
            if (sfxButton.isMousePressed())
                sfxButton.setMuted(!(sfxButton.isMuted()));
        }
        musicButton.resetBools();
        sfxButton.resetBools();
    }


    public void mouseMoved(MouseEvent e) {
        // Réinitialiser l'état mousePressed
        musicButton.resetBools();
        sfxButton.resetBools();

        // Ensuite définir à true uniquement pour le bouton sous la souris
        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        if (isIn(e, sfxButton))
            sfxButton.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b){
        return b.getBounds().contains(e.getX(), e.getY());
    }

}
