package ui;

import game.Game;
import gamestates.GameState;
import gamestates.Playing;
import utilz.LoadSave;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static game.Game.*;
import static utilz.Constants.UI.PauseButtons.SOUND_SIZE;
import static utilz.Constants.UI.UrmButtons.URM_SIZE;

public class PauseOverlay {

    private final Playing playing;

    private static final int MENU_X = 313;
    private static final int REPLAY_X = 387;
    private static final int RESUME_X = 462;
    private static final int B_Y = 325;

    //Background image variables
    private BufferedImage backgroundImg;
    private final int DEFAULT_BG_Y = 25;
    private int bgX, bgY, bgW, bgH;

    //Sound image variables
    private SoundButton musicButton, sfxButton;

    // URM buttons
    private UrmButtons menuB, replayB, resumeB;


    public PauseOverlay(Playing playing) {
        this.playing = playing;
        loadBackground();
        createSoundButtons();
        createURMButtons();
    }

    private void createURMButtons() {
        int menuX = (int) (MENU_X * SCALE);
        int replayX = (int) (REPLAY_X * SCALE);
        int resumeX = (int) (RESUME_X * SCALE);
        int bY = (int) (B_Y * SCALE);

        menuB = new UrmButtons(menuX, bY, URM_SIZE, URM_SIZE, 2);
        replayB = new UrmButtons(replayX, bY, URM_SIZE, URM_SIZE, 1);
        resumeB = new UrmButtons(resumeX, bY, URM_SIZE, URM_SIZE, 0);
    }

    public void update() {
        // Update logic for the pause overlay
        musicButton.update();
        sfxButton.update();

        menuB.update();
        replayB.update();
        resumeB.update();
    }

    public void draw( Graphics g ) {
        // Background
        g.setColor(new Color (0, 0, 0, 128));
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);

        // Sound buttons
        musicButton.draw(g);
        sfxButton.draw(g);

        // URM buttons

        menuB.draw(g);
        replayB.draw(g);
        resumeB.draw(g);
    }

    private void loadBackground() {
        backgroundImg = LoadSave.GetSpriteAtlas(LoadSave.PAUSE_BACKGROUND);
        bgW = (int) (backgroundImg.getWidth() * SCALE);
        bgH = (int) (backgroundImg.getHeight() * SCALE);
        bgX = GAME_WIDTH / 2 - bgW / 2;
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
        else if (isIn(e, sfxButton))
            sfxButton.setMousePressed(true);
        else if (isIn(e, menuB))
            menuB.setMousePressed(true);
        else if (isIn(e, replayB))
            replayB.setMousePressed(true);
        else if (isIn(e, resumeB))
            resumeB.setMousePressed(true);
    }


    public void mouseReleased(MouseEvent e) {
        if (isIn(e, musicButton)) {
            if (musicButton.isMousePressed())
                musicButton.setMuted(!(musicButton.isMuted()));
        } else if (isIn(e, sfxButton)) {
            if (sfxButton.isMousePressed())
                sfxButton.setMuted(!(sfxButton.isMuted()));
        } else if (isIn(e, replayB)) {
            if (replayB.isMousePressed()) {
                System.out.println("Replay level!");
                //Game.resetGame();
            }
        } else if (isIn(e, menuB)) {
            if (menuB.isMousePressed()) {
                GameState.state = GameState.MENU;
                playing.setPaused(false);
            }
        } else if (isIn(e, resumeB)) {
            if (resumeB.isMousePressed())
                playing.setPaused(false);
        }
        // Réinitialiser l'état mousePressed pour tous les boutons
        musicButton.resetBools();
        sfxButton.resetBools();
        menuB.resetBools();
        replayB.resetBools();
        resumeB.resetBools();
    }


    public void mouseMoved(MouseEvent e) {
        // Réinitialiser l'état mousePressed
        musicButton.resetBools();
        sfxButton.resetBools();
        menuB.resetBools();
        replayB.resetBools();
        resumeB.resetBools();

        // Ensuite définir à true uniquement pour le bouton sous la souris
        if (isIn(e, musicButton))
            musicButton.setMouseOver(true);
        if (isIn(e, sfxButton))
            sfxButton.setMouseOver(true);
        if (isIn(e, menuB))
            menuB.setMouseOver(true);
        if (isIn(e, replayB))
            replayB.setMouseOver(true);
        if (isIn(e, resumeB))
            resumeB.setMouseOver(true);
    }

    private boolean isIn(MouseEvent e, PauseButton b){
        return b.getBounds().contains(e.getX(), e.getY());
    }

}
