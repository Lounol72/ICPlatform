package ui;

import utilz.Constants;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.UI.UrmButtons.URM_SIZE_DEFAULT;

public class UrmButtons extends PauseButton{
    private BufferedImage[] imgs;
    private int rowIndex;
    private int index = 0;
    private boolean isMouseOver, isMousePressed;

    public UrmButtons( int x, int y, int width, int height, int rowIndex ) {
        super(x, y, width, height);
        this.rowIndex = rowIndex;
        loadImgs();
    }

    private void loadImgs() {
        BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.URM_BUTTONS);
        imgs = new BufferedImage[3];
        for (int i = 0; i < imgs.length; i++)
            imgs[i] = temp.getSubimage(i * URM_SIZE_DEFAULT, rowIndex * URM_SIZE_DEFAULT, URM_SIZE_DEFAULT, URM_SIZE_DEFAULT);
    }

    public void update() {
        // Update logic for the buttons
        index = 0;
        if (isMouseOver)
            index = 1;
        if (isMousePressed)
            index = 2;
    }

    public void draw( Graphics g ) {
        // Draw the buttons
        g.drawImage(imgs[index], x, y,width,height, null);
    }
    public void resetBools() {
        isMouseOver = false;
        isMousePressed = false;
    }

    public boolean isMouseOver() {return isMouseOver;}
    public void setMouseOver( boolean mouseOver ) {isMouseOver = mouseOver;}
    public boolean isMousePressed() {return isMousePressed;}
    public void setMousePressed( boolean mousePressed ) {isMousePressed = mousePressed;}
}
