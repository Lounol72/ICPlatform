package game;

public class GameClass {
    private GamePanel gamePanel;
    private GameWindow gameWindow;

    public GameClass() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        
        
    }
}