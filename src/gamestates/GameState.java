package gamestates;

public enum GameState {
    MENU,
    PLAYING,
    OPTIONS,
    QUIT,
    GAMEOVER,
    PAUSE,
    WIN,
    LOSE,
    CREDITS,
    HELP,
    SHOP,
    CUTSCENE,
    INVENTORY,
    DIALOGUE,
    SETTINGS,
    TUTORIAL,
    LEVELUP,
    SKILLTREE, state;
    public static GameState currentState = MENU;
    public static GameState previousState = MENU;
}
