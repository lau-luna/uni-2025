import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * Class BoxBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2016.02.29
 */

public class Box
{
    private Rectangle2D.Double rectangle;
    private int width;
    private int height;
    private int nBalls;
    private int xPosition;
    private int yPosition;
    private ArrayList<BoxBall> balls;
    private Canvas canvas;

    /**
     * Constructor for objects of class BoxBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public Box(int nBalls)
    {
        width = 400;
        height = 400;
        xPosition = (1080/2) - (width/2);
        yPosition = (720/2) - (height/2);
        canvas = new Canvas("Ball Demo", 1080, 720);
        draw();
        
        balls = new ArrayList<>(); 
        for (int i = 0; i < nBalls; i++) {
            BoxBall ball = new BoxBall((yPosition+height)-1, yPosition+2, xPosition+2, (xPosition+width)-2, canvas);
            balls.add(ball);
        }
        boxBounce();
    }

    /**
     * Draws the rectangle its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(new Color(0, 0, 0));
        canvas.fillRectangle(xPosition, yPosition, width, height);
        
        canvas.setForegroundColor(new Color(240, 240, 240));
        canvas.fillRectangle(xPosition +2, yPosition+2, width-4, height-4);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseRectangle(xPosition, yPosition, width, height);
    }    

   

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    private void boxBounce(){
        /*
        boolean finished =  false;
        int timer = 0;
        while (!finished) {
            canvas.wait(30);          // small delay
            for (BoxBall ball : balls) { 
                ball.move();
                timer += 30;
                // stop once ball has travelled a certain distance on x axis
                if(timer <= 1000) {
                    finished = true;
                }
            }

            */
        for (int i = 0; i < 150; i++) {
            canvas.wait(28);          // small delay
            canvas.erase();
            draw();
            for (BoxBall ball : this.balls) { 
                ball.move();
            }
        }
    }
 
}
