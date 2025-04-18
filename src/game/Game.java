/**
 * La classe Game représente le cœur du jeu, gérant la boucle principale et
 * initialisant les composants essentiels comme GamePanel et GameWindow.
 * Fonctionnalités :
 * - Initialise les composants graphiques du jeu.
 * - Gère la boucle principale pour le rendu et la logique du jeu.
 * - Affiche les FPS dans la console pour le suivi des performances.
 * Méthodes principales :
 * - startGameLoop() : Démarre la boucle principale dans un thread séparé.
 * - run() : Implémente la logique de la boucle principale, calculant les FPS
 *   et rafraîchissant l'affichage.
 * Utilisation :
 * - Instancier Game pour démarrer le jeu.
 * Auteur : Lounol72
 * Date : 16/04/2025
 */
package game;
import gamestates.*;
import gamestates.Menu;
import java.awt.*;

public class Game implements Runnable{
    private final GamePanel gamePanel;
    private final GameWindow gameWindow;
    private Thread gameLoopThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private Playing playing;
    private Menu menu;
    private Pause pause;
    private Options options;

    public final static float SCALE = 2.0f;

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public final static int PLAYER_DEFAULT_WIDTH = 64;
    public final static int PLAYER_DEFAULT_HEIGHT = 40;
    public final static int PLAYER_WIDTH = (int) (PLAYER_DEFAULT_WIDTH * SCALE);
    public final static int PLAYER_HEIGHT = (int) (PLAYER_DEFAULT_HEIGHT * SCALE);

    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        startGameLoop();
    }

    private void initClasses() {
        this.menu = new Menu(this);
        this.playing = new Playing(this);
        this.pause = new Pause(this);
        this.options = new Options(this);
    }

    private void startGameLoop() {
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    private void update() {
        switch (GameState.state){
            case MENU :
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case OPTIONS:
                options.update();
                break;
            case QUIT:
            case GAMEOVER:
            case PAUSE:
                pause.update();
            case WIN:
            case LOSE:
            case CREDITS:
            case HELP:
            case SHOP:
            case CUTSCENE:
            case INVENTORY:
            case DIALOGUE:
            case SETTINGS:
            case TUTORIAL:
            case LEVELUP:
            case SKILLTREE:
                break;
            default : throw new IllegalStateException("Unexpected value: " + GameState.state);
        }
    }

    public void render(Graphics g) {


        switch (GameState.state){
            case MENU :
                menu.draw(g);
                break;
            case PLAYING:
                playing.draw(g);
                break;
            case OPTIONS:
                options.draw(g);
                break;
            case QUIT:
            case GAMEOVER:
            case PAUSE:
                pause.draw(g);
                break;
            case WIN:
            case LOSE:
            case CREDITS:
            case HELP:
            case SHOP:
            case CUTSCENE:
            case INVENTORY:
            case DIALOGUE:
            case SETTINGS:
            case TUTORIAL:
            case LEVELUP:
            case SKILLTREE:
                break;
            default : throw new IllegalStateException("Unexpected value: " + GameState.state);
        }
    }

    @Override
    public void run() {


        double timePerFrame = 1000000000.0 / FPS_SET; // 1 second / FPS_SET
        double timePerUpdate = 1000000000.0 / UPS_SET; // 1 second / UPS_SET

        long previousTime = System.nanoTime();
        int frames = 0;
        int updates = 0;

        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;

            previousTime = currentTime;
            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }
            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            // FPS and UPS check
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }


    public void windowFocusLost() {
        if (GameState.state == GameState.PLAYING) {
            // Pause the game or perform any other action
            playing.windowFocusLost();
        }

    }

    public Menu getMenu() {return menu;}
    public Playing getPlaying() {return playing;}

    public Pause getPause() {return pause;}
    public Options getOptions() {return this.options;}
}