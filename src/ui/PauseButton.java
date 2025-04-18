package ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PauseButton {
    // Placeholder for PauseButton class
    // This class can be implemented to handle pause button functionality
    // such as drawing the button, handling mouse events, etc.

    protected int x, y, width, height;
    protected Rectangle bounds;

    public PauseButton(int x, int y, int width, int height) {
        // Constructor implementation
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        createBounds();

    }

    private void createBounds() {
        bounds = new Rectangle(x, y, width, height);
    }

    public void draw() {
        // Draw the pause button
    }

    public void handleMouseClick( MouseEvent e) {
        // Handle mouse click event on the pause button
    }

    // Getters and Setters
    public int getX() {return x;}
    public void setX( int x ) {this.x = x;}
    public int getY() {return y;}
    public void setY( int y ) {this.y = y;}
    public int getWidth() {return width;}
    public void setWidth( int width ) {this.width = width;}
    public int getHeight() {return height;}
    public void setHeight( int height ) {this.height = height;}
    public Rectangle getBounds() {return bounds;}
    public void setBounds( Rectangle bounds ) {this.bounds = bounds;}
}
