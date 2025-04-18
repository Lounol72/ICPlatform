package ui;

import utilz.LoadSave;


import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.PauseButtons.SOUND_SIZE_DEFAULT;

public class SoundButton extends PauseButton {

    private BufferedImage[][] soundImgs;
    private boolean isMouseOver, isMousePressed;
    private boolean isMuted;
    private int rowIndex, colIndex;

    public SoundButton( int x, int y, int width, int height ) {
        super(x, y, width, height);
        loadSoundImages();
    }

    private void loadSoundImages() {
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.SOUND_BUTTONS);
        soundImgs = new BufferedImage[2][3];
        for (int j = 0; j < soundImgs.length; j++)
            for (int i = 0; i < soundImgs[j].length; i++)
                soundImgs[j][i] = temp.getSubimage(i * SOUND_SIZE_DEFAULT, j * SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT, SOUND_SIZE_DEFAULT);
    }
    public void resetBools() {
        isMouseOver = false;
        isMousePressed = false;
    }

    public void update() {
        rowIndex = isMuted ? 1 : 0;
        colIndex = 0;
        if (isMouseOver)
            colIndex = 1;
        if (isMousePressed)
            colIndex = 2;
    }
    public void draw( Graphics g ) {
        g.drawImage(soundImgs[rowIndex][colIndex], x, y, width, height, null);
    }

    // Getters and Setters
    public boolean isMouseOver() {return isMouseOver;}
    public void setMouseOver( boolean mouseOver ) {isMouseOver = mouseOver;}
    public boolean isMousePressed() {return isMousePressed;}
    public void setMousePressed( boolean mousePressed ) {isMousePressed = mousePressed;}
    public boolean isMuted() {return isMuted;}
    public void setMuted( boolean muted ) {isMuted = muted;}
}
