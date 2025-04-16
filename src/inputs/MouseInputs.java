/**
 * La classe MouseInputs gère les événements de la souris, tels que les clics,
 * les mouvements et les actions de glisser-déposer.
 *
 * Fonctionnalités :
 * - Détecte les clics de souris pour déclencher des actions spécifiques.
 * - Gère les mouvements de la souris pour des interactions dynamiques.
 * - Intègre les actions de la souris avec GamePanel.
 *
 * Méthodes principales :
 * - mousePressed(MouseEvent e) : Déclenche une action d'attaque.
 * - mouseReleased(MouseEvent e) : Réinitialise l'action d'attaque.
 *
 * Utilisation :
 * - Ajouter MouseInputs comme écouteur à un composant graphique.
 *
 * Auteur : Lounol72
 * Date : 16/04/2025
 */
package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import game.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener{
    private final GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Mouse moved ");
        //gamePanel.setRectPos(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        if (gamePanel.getplayerAction() == 0)gamePanel.setplayerAction(8);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        if (gamePanel.getplayerAction() == 8 && gamePanel.getIndexImage() != 3) { gamePanel.setplayerAction(0);}
    }
    
}