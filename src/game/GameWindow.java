package game;

import javax.swing.JFrame;


public class GameWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private boolean  isGameRunning;

    public GameWindow( GamePanel gamePanel) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Game Window");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        frame.add(gamePanel);
        frame.setVisible(true);
    }


    public void endGame() {
        System.out.println("Game ended.");
        frame.setVisible(false);
        frame.dispose();
        isGameRunning = false;
        
    }
    public boolean isGameRunning() {
        return isGameRunning;
    }
}