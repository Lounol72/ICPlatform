package game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
public class GamePanel extends JPanel{

    public GamePanel(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(100, 100, 200, 50);
    }
}