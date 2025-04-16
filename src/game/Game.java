/**
 * La classe Game représente le cœur du jeu, gérant la boucle principale et
 * initialisant les composants essentiels comme GamePanel et GameWindow.
 *
 * Fonctionnalités :
 * - Initialise les composants graphiques du jeu.
 * - Gère la boucle principale pour le rendu et la logique du jeu.
 * - Affiche les FPS dans la console pour le suivi des performances.
 *
 * Méthodes principales :
 * - startGameLoop() : Démarre la boucle principale dans un thread séparé.
 * - run() : Implémente la logique de la boucle principale, calculant les FPS
 *   et rafraîchissant l'affichage.
 *
 * Utilisation :
 * - Instancier Game pour démarrer le jeu.
 *
 * Auteur : Lounol72
 * Date : 16/04/2025
 */
package game;

public class Game implements Runnable{
    private final GamePanel gamePanel;
    private final GameWindow gameWindow;
    private final Thread gameLoopThread;
    private final int FPS_SET = 120;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }

    @Override
    public void run() {
        
        double timePerFrame = 1000000000.0 / FPS_SET; // 1 second / FPS_SET
        long lastFrame = System.nanoTime();
        long now =  System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        
        while (true){

            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                gamePanel.repaint();
                lastFrame  = now;
                frames++;
            }
            
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

}