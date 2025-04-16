/**
 * GamePanel is a custom JPanel that serves as the main game rendering panel.
 * It handles the loading and rendering of animations, as well as user input
 * through mouse and keyboard listeners. The panel supports different states
 * (e.g., IDLE, RUN) and updates the displayed animation accordingly.
 * 
 * Features:
 * - Loads and manages animations for different states (idle, run).
 * - Handles user input through mouse and keyboard listeners.
 * - Dynamically updates and renders animations based on the current state.
 * - Provides methods to adjust the position of the rendered image.
 * 
 * Dependencies:
 * - javax.imageio.ImageIO for loading images.
 * - javax.swing.JPanel for the game panel.
 * - java.awt.Graphics for rendering.
 * - java.awt.image.BufferedImage for image handling.
 * - Custom input classes: MouseInputs and KeyboardInputs.
 * 
 * Usage:
 * - Instantiate GamePanel and add it to a JFrame.
 * - Use setState(State state) to change the animation state.
 * - Use changeXDelta(int value) and changeYDelta(int value) to move the image.
 * 
 * Note:
 * - Ensure the assets folder is correctly structured and accessible.
 * - The image paths must be relative to the assets folder.
 * - The panel size is fixed to 1280x800 pixels.
 * 
 * Author: Lounol72
 * Date: 16/04/2025
 */
package game;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.*;
import state.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private BufferedImage image;
    private BufferedImage[][] animations;
    private int currentAnimation = 0;
    private int indexImage = 0;

    private final int frameWidth = 64, frameHeight = 40;

    private int xDelta = 100, yDelta = 100;
    private int animationTick = 0, animationIndex = 0, animationSpeed = 20;
    private final int playerSpeed = 4;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);

        
        image =  importImage("/Captain Clown Nose/player_sprites.png");
        loadAnimations();

        setPanelSize(1280, 800);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int i = 0; i < animations.length; i++) {
            for (int j = 0; j < animations[i].length; j++) {
                animations[i][j] = this.image.getSubimage(j * frameWidth, i * frameHeight, frameWidth, frameHeight);
            }
        }
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
        g.drawImage(animations[currentAnimation][indexImage], xDelta, yDelta, 128, 80, null);
        
        updateAnimationTick();
    }

    // Methods

    public void changeXDelta(int value) {
        this.xDelta += value;
    }
    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            indexImage++;
        }
        if (indexImage >= animations[currentAnimation].length) {
            indexImage = 0;
        }
    }

    public void setCurrentAnimation(int animation) {
        this.currentAnimation = animation;
        indexImage = 0;
    }
    public int getCurrentAnimation() {
        return this.currentAnimation;
    }
    public int getPlayerSpeed() {
        return playerSpeed;
    }

}