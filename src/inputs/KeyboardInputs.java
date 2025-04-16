/**
 * La classe KeyboardInputs gère les événements du clavier pour contrôler
 * les actions et les déplacements du joueur.
 *
 * Fonctionnalités :
 * - Détecte les touches pressées pour changer la direction du joueur.
 * - Réinitialise les actions lorsque les touches sont relâchées.
 * - Intègre les actions du clavier avec GamePanel.
 *
 * Méthodes principales :
 * - keyPressed(KeyEvent e) : Définit la direction du joueur.
 * - keyReleased(KeyEvent e) : Arrête le mouvement du joueur.
 *
 * Utilisation :
 * - Ajouter KeyboardInputs comme écouteur à un composant graphique.
 *
 * Auteur : Lounol72
 * Date : 16/04/2025
 */
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import static utilz.Constants.Directions.*;
import game.GamePanel;

public class KeyboardInputs implements KeyListener{
    private final GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        // TO-DO auto-generated method stub
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key pressed: " + e.getKeyChar() + " (" + e.getKeyCode() + ")");

        switch(e.getKeyCode()){
            case KeyEvent.VK_Z:
                gamePanel.setDirection(UP);
                break;
            case KeyEvent.VK_S:
                gamePanel.setDirection(DOWN);
                break;
            case KeyEvent.VK_Q:
                gamePanel.setDirection(LEFT);
                break;
            case KeyEvent.VK_D:
                gamePanel.setDirection(RIGHT);
                break;
            case KeyEvent.VK_SPACE:
            default:
                break;
        }

    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TO-DO auto-generated method stub

        switch(e.getKeyCode()){
            case KeyEvent.VK_Z:

            case KeyEvent.VK_S:

            case KeyEvent.VK_Q:

            case KeyEvent.VK_D:

            case KeyEvent.VK_SPACE:
                gamePanel.setIsMoving(false);
                break;
        }
    }
}