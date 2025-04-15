package keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {
        // TO-DO auto-generated method stub
    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar() + " (" + e.getKeyCode() + ")");

        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                System.out.println("W key pressed");
                break;
            case KeyEvent.VK_A:
                System.out.println("A key pressed");
                break;
            case KeyEvent.VK_S:
                System.out.println("S key pressed");
                break;
            case KeyEvent.VK_D:
                System.out.println("D key pressed");
                break;
            case 127:
                System.out.println("SUPPR key pressed");
                break;
            default:
                System.out.println("Other key pressed");
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TO-DO auto-generated method stub
    }
    
}