/**
 * GamePanel est un JPanel personnalisé qui sert de panneau principal pour
 * le rendu du jeu. Il gère les animations, les entrées utilisateur et
 * l'affichage des états du joueur.
 *
 * Fonctionnalités :
 * - Charge et gère les animations pour différents états du joueur.
 * - Gère les entrées utilisateur via des écouteurs de souris et de clavier.
 * - Met à jour et rend dynamiquement les animations en fonction de l'état actuel.
 *
 * Méthodes principales :
 * - paintComponent(Graphics g) : Rendu des animations du joueur.
 * - setDirection(int playerDir) : Définit la direction du joueur.
 * - setplayerAction(int animation) : Change l'état d'animation du joueur.
 * - updateAnimationTick() : Met à jour l'index de l'animation.
 *
 * Utilisation :
 * - Instancier GamePanel et l'ajouter à un JFrame.
 *
 * Auteur : Lounol72
 * Date : 16/04/2025
 */
package game;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel{
    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private BufferedImage image;
    private BufferedImage[][] animations;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private int indexImage = 0;
    private boolean isMoving = false;

    private final int frameWidth = 64, frameHeight = 40;

    private int xDelta = 100, yDelta = 100;
    private int animationTick = 0, animationIndex = 0, animationSpeed = 20;
    private final int playerSpeed = 1;

    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);

        
        image =  importImage();
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
    
    private BufferedImage importImage() {
        String imagePath = "/Captain Clown Nose/player_sprites.png";
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

    public void setDirection(int playerDir) {
        this.playerDir = playerDir;
        isMoving = true;
    }

    public void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            indexImage++;
            if (indexImage >= GetSpriteAmount(playerAction)) {
                indexImage = 0;
            }
        }
    }

    public void setplayerAction(int animation) {
        this.playerAction = animation;
        indexImage = 0;
    }
    public int getplayerAction() {return this.playerAction;}
    public int getPlayerSpeed() {return playerSpeed;}
    public int getIndexImage() {return indexImage;}

    public void setIsMoving(boolean b) { this.isMoving = b;}

    private void setAnimation() {
        if (isMoving) {
            switch (playerDir) {
                case UP:
                    yDelta -= playerSpeed;
                    break;
                case DOWN:
                    yDelta += playerSpeed;
                    break;
                case LEFT:
                    xDelta -= playerSpeed;
                    break;
                case RIGHT:
                    xDelta += playerSpeed;
                    break;
            }
            playerAction = RUN;
        } else {
            playerAction = IDLE;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();
        setAnimation();

        g.drawImage(animations[playerAction][indexImage], xDelta, yDelta, 128, 80, null);
    }




}