package game;

public class GameClass {
    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private static boolean gameRunning = false;
    public GameClass() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
                
    }
    
}