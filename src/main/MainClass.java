package main;

import player.PlayerClass;
import game.Game;

public class MainClass {
    public static void main(String[] args) {
        if (args[1].length() != 1 || (args[1].charAt(0) != 'C' && args[1].charAt(0) != 'F') || args.length != 2) {
            System.out.println("usage : java Main <temperature> <C/F>");
            System.exit(1);
        }
        System.out.println(args[1].charAt(0) == 'C' ? "Celsius to Fahrenheit" : "Fahrenheit to Celsius");
        double temp = Double.parseDouble(args[0]);
        if (args[1].charAt(0) == 'C') {
            System.out.println("Temperature in Fahrenheit: " + ((temp * 9 / 5) + 32));
        } else {
            System.out.println("Temperature in Celsius: " + ((temp - 32) * 5 / 9));
        }

        PlayerClass player = new PlayerClass(1, "John Doe", 100, 1);
        player.displayPlayerInfo();
        player.updatePlayerScore(150);
        player.updatePlayerLevel(2);
        System.out.println("--------------------------------------------------");
        System.out.println("Updated Player Info:");
        player.displayPlayerInfo();
        player.resetPlayer();
        System.out.println("--------------------------------------------------");
        System.out.println("Player Info after reset:");
        player.displayPlayerInfo();

        Game game = new Game();
        
        
    }
}