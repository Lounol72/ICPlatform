package game;

import javax.swing.JFrame;


public class GameWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    

    public GameWindow( GamePanel gamePanel) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Game Window");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(gamePanel);
        frame.setVisible(false);
    }
    public void startGame() {
        frame.setVisible(true);
        
    }

    public void endGame() {
        frame.setVisible(false);
        frame.dispose();
        
    }
}