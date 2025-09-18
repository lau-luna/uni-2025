import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

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

public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition; // ball x position
    private int yPosition; // ball y positon
    private final int groundPosition;// y position of box ground
    private final int ceilingPosition; // y position of box ceiling
    private final int leftSidePosition; // x position of left box side
    private final int rightSidePosition; // x position of right box side
    private Canvas canvas;
    private int ySpeed ; // vertical speed
    private int xSpeed ; // horizontal speed
    private Random random;

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
    public BoxBall(int groundPos, int ceilingPosition, int leftSidePosition, int rightSidePosition, Canvas drawingCanvas)
    {
        diameter = 40;
        
        // Posicion aleatoria dentro del box
        random = new Random();
        xPosition = random.nextInt(leftSidePosition, rightSidePosition-diameter);
        yPosition = random.nextInt(ceilingPosition, groundPos-diameter);
        
        // Color aleatorio
        int r = random.nextInt(230);
        int g = random.nextInt(230);
        int b = random.nextInt(230);
        color = new Color(r, g, b);
        
        groundPosition = groundPos;
        this.ceilingPosition = ceilingPosition;
        this.leftSidePosition = leftSidePosition;
        this.rightSidePosition = rightSidePosition;
        canvas = drawingCanvas;
        
        // Velocidad aleatoria
        xSpeed = random.nextInt(-15, 15);
        ySpeed = random.nextInt(-15, 15);
        
        draw();
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.setBackgroundColor(new Color(240, 240, 240));
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;

        // check if it has hit the ground
        if (yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            ySpeed = -ySpeed; 
        }
        
        // check if it has hit the ceiling
        if (yPosition <= ceilingPosition && ySpeed < 0) {
            ySpeed = -ySpeed; 
        }
        
        // check if it has hit the ground
        if (xPosition <= leftSidePosition && xSpeed < 0) {
            xSpeed = -xSpeed; 
        }
        
        // check if it has hit the ceiling
        if (xPosition >= (rightSidePosition - diameter) && xSpeed > 0) {
            xSpeed = -xSpeed; 
        }

        // draw again at new position
        draw();
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
    
    /**
     * return ball's diameter
     */
    public int getDiameter(){
        return this.diameter;
    }
}
