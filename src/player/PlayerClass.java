package player;

public class PlayerClass{

    // Atributes
    private int playerID;
    private String playerName;
    private int playerScore;
    private int playerLevel;

    // Constructor
    public PlayerClass(int id, String name, int score, int level) {
        playerID = id;
        playerName = name;
        playerScore = score;
        playerLevel = level;
    }
    // Methods
    public void displayPlayerInfo() {
        System.out.println("ID: " + playerID);
        System.out.println("Name: " + playerName);
        System.out.println("Score: " + playerScore);
        System.out.println("Level: " + playerLevel);
    }

    public void updatePlayerScore(int newScore) {
        playerScore = newScore;
    }
    public void updatePlayerLevel(int newLevel) {
        playerLevel = newLevel;
    }

    // Getters
    public int getPlayerID() {
        return playerID;
    }
    public String getPlayerName() {
        return playerName;
    }
    public int getPlayerScore() {
        return playerScore;
    }
    public int getPlayerLevel() {
        return playerLevel;
    }

    // Setters
    public void setPlayerID(int id) {
        playerID = id;
    }
    public void setPlayerName(String name) {
        playerName = name;
    }
    public void setPlayerScore(int score) {
        playerScore = score;
    }

    public void setPlayerLevel(int level) {
        playerLevel = level;
    }
    // Reset method
    public void resetPlayer() {
        playerID = 0;
        playerName = "";
        playerScore = 0;
        playerLevel = 0;
    }
}