import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate n bouncing balls
     */
    public void bounce(int n)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // Setting random RGB collors for the balls
        Random random = new Random();

        // create and show the balls
        ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>();
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(225);
            int g = random.nextInt(225);
            int b = random.nextInt(225);

            Color randomColor = new Color(r, g, b);
            int randomDiameter = random.nextInt(10, 100);
            int ballXPosition = random.nextInt(50, 500);
            
            // int randomDiameter = i % 2 != 0 ? 20 : 40;

            BouncingBall ball = new BouncingBall(ballXPosition, 50, randomDiameter, randomColor, ground, myCanvas);
            ball.draw();
            balls.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(30);           // small delay
            for (BouncingBall ball : balls) { 
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(balls.get(0).getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    
    public void boxBounce(int n){
        Box box = new Box(n);
    }
}
