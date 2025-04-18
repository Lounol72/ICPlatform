/**
 * La classe Game représente le cœur du jeu, gérant la boucle principale et
 * l'ensemble des composants du jeu.
 *
 * <p><b>Fonctionnalités principales :</b></p>
 * <ul>
 *   <li>Initialisation des composants graphiques et des états du jeu</li>
 *   <li>Gestion de la boucle principale avec synchronisation FPS/UPS</li>
 *   <li>Coordination des différents états du jeu (menu, jeu, options)</li>
 *   <li>Gestion de l'échelle et des dimensions du jeu</li>
 * </ul>
 *
 * <p><b>Constantes importantes :</b></p>
 * <ul>
 *   <li>SCALE : Facteur d'échelle appliqué aux éléments graphiques</li>
 *   <li>TILES_SIZE : Taille des tuiles du jeu après mise à l'échelle</li>
 *   <li>GAME_WIDTH/HEIGHT : Dimensions de la fenêtre de jeu</li>
 *   <li>PLAYER_WIDTH/HEIGHT : Dimensions du joueur après mise à l'échelle</li>
 * </ul>
 *
 * <p><b>Utilisation :</b> Instancier un objet Game pour démarrer le jeu.</p>
 *
 * @author Lounol72
 * @version 1.0
 * @since 16/04/2025
 */
package game;
import gamestates.*;
import gamestates.Menu;
import java.awt.*;

public class Game implements Runnable{
    // Composants principaux du jeu
    private final GamePanel gamePanel;      // Panneau où le jeu est rendu
    private final GameWindow gameWindow;    // Fenêtre qui contient le panneau
    private Thread gameLoopThread;          // Thread dédié à la boucle de jeu

    // Paramètres de performance
    private final int FPS_SET = 120;        // Images par seconde cible
    private final int UPS_SET = 200;        // Mises à jour par seconde cible

    // États du jeu
    private Playing playing;                // État de jeu actif
    private Menu menu;                      // État du menu
    private Options options;                // État des options

    // Constantes de mise à l'échelle et dimensions
    public final static float SCALE = 1.0f;                              // Facteur d'échelle global

    // Constantes liées aux tuiles
    public final static int TILES_DEFAULT_SIZE = 32;                     // Taille de base d'une tuile
    public final static int TILES_IN_WIDTH = 26;                         // Nombre de tuiles en largeur
    public final static int TILES_IN_HEIGHT = 14;                        // Nombre de tuiles en hauteur
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);  // Taille d'une tuile après mise à l'échelle
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;    // Largeur totale du jeu
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;  // Hauteur totale du jeu

    // Constantes liées au joueur
    public final static int PLAYER_DEFAULT_WIDTH = 64;                   // Largeur de base du joueur
    public final static int PLAYER_DEFAULT_HEIGHT = 40;                  // Hauteur de base du joueur
    public final static int PLAYER_WIDTH = (int) (PLAYER_DEFAULT_WIDTH * SCALE);    // Largeur du joueur après mise à l'échelle
    public final static int PLAYER_HEIGHT = (int) (PLAYER_DEFAULT_HEIGHT * SCALE);  // Hauteur du joueur après mise à l'échelle

    /**
     * Constructeur qui initialise et démarre le jeu.
     * Crée les composants nécessaires et lance la boucle de jeu.
     */
    public Game() {
        initClasses();
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        startGameLoop();
    }

    /**
     * Initialise les différents états du jeu.
     */
    private void initClasses() {
        this.menu = new Menu(this);
        this.playing = new Playing(this);
        this.options = new Options(this);
    }

    /**
     * Démarre la boucle de jeu dans un thread séparé.
     */
    private void startGameLoop() {
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    /**
     * Met à jour l'état du jeu en fonction du GameState actuel.
     * Délègue la mise à jour à l'état approprié.
     */
    private void update() {
        switch (GameState.state){
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case OPTIONS:
                options.update();
                break;
            case QUIT:
                System.exit(0);
                // Autres états à implémenter
            case GAMEOVER:
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
            default:
                throw new IllegalStateException("Unexpected value: " + GameState.state);
        }
    }

    /**
     * Dessine l'état actuel du jeu selon le GameState.
     * Délègue le rendu à l'état approprié.
     *
     * @param g Contexte graphique utilisé pour le dessin
     */
    public void render(Graphics g) {
        switch (GameState.state){
            case MENU:
                menu.draw(g);
                break;
            case PLAYING:
                playing.draw(g);
                break;
            case OPTIONS:
                options.draw(g);
                break;
            // Autres états à implémenter
            case QUIT:
            case GAMEOVER:
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
            default:
                throw new IllegalStateException("Unexpected value: " + GameState.state);
        }
    }

    /**
     * Implémente la boucle principale du jeu avec synchronisation FPS/UPS.
     * Utilise un temps delta pour maintenir une cadence régulière.
     * Affiche les FPS et UPS dans la console pour le suivi des performances.
     */
    @Override
    public void run() {
        // Calcul du temps entre chaque frame et update
        double timePerFrame = 1000000000.0 / FPS_SET;  // Nanoseconds par frame
        double timePerUpdate = 1000000000.0 / UPS_SET; // Nanoseconds par update

        long previousTime = System.nanoTime();
        int frames = 0;      // Compteur de frames rendues
        int updates = 0;     // Compteur de mises à jour effectuées
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;   // Accumulation du temps pour les updates
        double deltaF = 0;   // Accumulation du temps pour les frames

        // Boucle infinie du jeu
        while (true) {
            long currentTime = System.nanoTime();

            // Calcul des deltas
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            // Mise à jour de la logique si nécessaire
            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            // Rendu à l'écran si nécessaire
            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            // Affichage des FPS et UPS chaque seconde
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    /**
     * Gère la perte de focus de la fenêtre.
     * Met le jeu en pause si l'état actuel est PLAYING.
     */
    public void windowFocusLost() {
        if (GameState.state == GameState.PLAYING) {
            playing.windowFocusLost();
        }
    }

    // Getters pour accéder aux états du jeu
    public Menu getMenu() {return menu;}
    public Playing getPlaying() {return playing;}
    public Options getOptions() {return this.options;}
}