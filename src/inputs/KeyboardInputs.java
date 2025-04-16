package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GamePanel;

public class KeyboardInputs implements KeyListener{
    private GamePanel gamePanel;

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
                gamePanel.changeYDelta(-5);
                break;
            case KeyEvent.VK_Q:
                gamePanel.changeXDelta(-5);
                
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(5);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(5);
                break;
            case 127:
                System.out.println("SUPPR key pressed");
                break;
            default:
                
        }
        gamePanel.setState(1);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TO-DO auto-generated method stub

        gamePanel.setState(0);
    }
    
}