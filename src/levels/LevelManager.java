package levels;

import game.Game;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static game.Game.*;
import static utilz.LoadSave.*;

public class LevelManager {

    private Game game;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelManager(Game game) {
        this.game = game;
        importOutsideSprites();
        levelOne = new Level(LoadSave.GetLevelData());
    }

    public void importOutsideSprites() {
        levelSprite = new BufferedImage[48];
        BufferedImage img = GetSpriteAtlas(LEVEL_ATLAS);
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<12; j++) {
                int index = i*12+ j;
                levelSprite[index] = img.getSubimage(j*32, i*32, 32, 32);
            }
        }
    }

    public void draw(Graphics g) {
        for (int j = 0; j < TILES_IN_HEIGHT; j++)
            for (int i = 0; i < TILES_IN_WIDTH; i++) {
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], i * TILES_SIZE, j * TILES_SIZE, TILES_SIZE, TILES_SIZE, null);
            }
    }

    public void update() {
        // Update level logic here
    }

    public Level getCurrentLevel() {
        return levelOne;
    }
}
