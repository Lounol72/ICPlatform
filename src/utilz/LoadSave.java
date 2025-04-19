package utilz;

import game.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static game.Game.TILES_IN_HEIGHT;
import static game.Game.TILES_IN_WIDTH;

public class LoadSave {
    public static final String PLAYER_ATLAS = "/Captain Clown Nose/player_sprites.png";
    public static final String LEVEL_ATLAS = "/Palm Tree Island/Sprites/Terrain/Terrain (32x32).png";

    public static final String MENU_BUTTONS = "/Wood and Paper UI/Menu/button_atlas.png";
    public static final String MENU_BACKGROUND = "/Wood and Paper UI/Menu/menu_background.png";

    public static final String VOLUME_BUTTONS = "/Wood and Paper UI/Pause/volume_buttons.png";
    public static final String SOUND_BUTTONS = "/Wood and Paper UI/Pause/sound_button.png";
    public static final String URM_BUTTONS = "/Wood and Paper UI/Pause/urm_buttons.png";
    public static final String PAUSE_BACKGROUND = "/Wood and Paper UI/Pause/pause_background.png";

    public static final String OPTIONS_BACKGROUND = "/Palm Tree Island/Sprites/Background/BG Image.png";

    public static final String LEVEL_ONE_DATA = "/Levels/level_one_data.png";


    public static BufferedImage GetSpriteAtlas(String path) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream(path);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    public static int[][] GetLevelData(){
        int [][] levelData = new int[TILES_IN_HEIGHT][TILES_IN_WIDTH];
        BufferedImage img = GetSpriteAtlas(LEVEL_ONE_DATA);

        for(int j = 0; j<img.getHeight(); j++)
            for(int i = 0; i<img.getWidth(); i++){
                Color tileColor = new Color(img.getRGB(i,j));
                int value = tileColor.getRed();
                if (value >= 48)
                    value = 0;
                levelData[j][i] = value;
            }


        return levelData;
    }
}
