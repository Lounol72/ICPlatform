package game;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private BufferedImage image;
    private BufferedImage[] idleAni;
    private BufferedImage[] runAni;
    private int indexImage = 0;
    private int state = 0; // 0 = idle, 1 = run
    int frameWidth = 64, frameHeight = 40;

    private int xDelta = 100, yDelta = 100;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);

        idleAni = loadAnimations("/Captain Clown Nose/Sprites/Captain Clown Nose/Captain Clown Nose with Sword/09-Idle Sword/", 5, "Idle Sword 01.png");
        runAni = loadAnimations("/Captain Clown Nose/Sprites/Captain Clown Nose/Captain Clown Nose with Sword/10-Run Sword/", 6, "Run Sword 01.png");
        image = idleAni[indexImage];
        
        setPanelSize(1280, 800);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private BufferedImage[] loadAnimations(String path, int numberOfFrames, String firstImage) {
        BufferedImage[] animation = new BufferedImage[numberOfFrames];
        for ( int i = 0; i < numberOfFrames; i++){
            String imagePath = path + firstImage.replace("01", String.format("%02d", i + 1));
            animation[i] = importImage(imagePath);
        }
        return animation;
    }
    
    private BufferedImage importImage(String path) {
        String imagePath = "../../assets" + path;
        InputStream is =  getClass().getResourceAsStream(imagePath);
        if (is == null) {
            System.out.println("Image not found");
            return null;
        }
        BufferedImage img = null;
        try{
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

    private void setPanelSize(int i, int j) {
        Dimension size = new Dimension(i, j);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, xDelta, yDelta, 128, 80, null);
        } else {
            System.err.println("Image is null, cannot draw.");
        }
        updateAnimation();
    }

    // Methods

    public void changeXDelta(int value) {
        this.xDelta += value;
    }
    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void updateAnimation() {
        indexImage++;
        switch (state) {
            case 0:
                if (indexImage == idleAni.length - 1) {
                    indexImage = 0;
                }
                image = idleAni[indexImage];
                
                break;
            case 1:
                if (indexImage == runAni.length - 1) {
                    indexImage = 0;
                }
                image = runAni[indexImage];
            default:
                break;
        }
    }

    public void setState(int state) {
        this.state = state;
        indexImage = 0;
    }

}