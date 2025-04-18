package gamestates;

public enum GameState {
    MENU,
    PLAYING,
    OPTIONS,
    QUIT,
    GAMEOVER,
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
    SKILLTREE ;
    public static GameState state = MENU;
    public static GameState previousState = MENU;
}
