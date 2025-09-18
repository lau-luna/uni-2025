import java.awt.Color;
import java.util.Random;

import java.awt.*;
import java.awt.geom.*;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Draws a green triangle on the screen.
     */
    public void drawTriangle(){
        Pen pen = new Pen(100, 150, myCanvas);
        pen.setColor(java.awt.Color.GREEN);
        for (int i = 0; i < 3; i++){
            pen.move(100);
            pen.turn(360/3);
        }
    }
    
    /**
     * Draws a pentagon on the screen.
     */
    public void drawPentagon(){
        Pen pen = new Pen(100, 150, myCanvas);
        for (int i = 0; i < 5; i++){
            pen.move(100);
            pen.turn(360/5);
        }
    }
    
    /**
     * Draws a polygon on the screen.
     * @param n is the number of sides of the polygon to be drawn.
     */
    
    public void drawPolygon(int n){
        Pen pen = new Pen(100, 150, myCanvas);
        for (int i = 0; i < n; i++){
            pen.move(100);
            pen.turn(360/n);
        }
    }
    
    /**
     * Draws a spiral of 90 degrees angles.
     */
    public void drawSpiral(int n){
        Pen pen = new Pen(200, 200, myCanvas);
        int size = 5;
        pen.turnTo(90);
        for (int i = 0; i < n; i++){
            pen.move(size);
            pen.turn(90);
            size += 5;
        }
    }
    
    public void drawCheckerboard(){
        
        Rectangle rectanguloCentro = new Rectangle(100, 100, 240, 240);
        myCanvas.draw(rectanguloCentro);
        
        int x = 100;
        int y = 100;
        
        for (int i = 1; i <= 8; i++){
            for (int j = 1; j<= 8; j++){
                Rectangle rectangulo = new Rectangle(x, y, 30, 30);
                myCanvas.draw(rectangulo);
                if ((i % 2 != 0 && j % 2 != 0) || (i % 2 == 0 && j % 2 == 0)){
                    myCanvas.setForegroundColor(Color.WHITE);
                    myCanvas.fill(rectangulo); 
                } else {
                    myCanvas.setForegroundColor(Color.BLACK);
                    myCanvas.fill(rectangulo); 
                }
                x += 30;
            }
            x = 100;
            y += 30;
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}