import java.awt.Color;
import java.util.*;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
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
     * Simulate two bouncing balls
     */
    public void bounce(int nDeBolas)
    {    
        ArrayList<BouncingBall> bolas = new ArrayList<>();
        Random nAleatorio = new Random();
        int posY = 0;
        int posX = 0;
        int diametro = 0;
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        for (int count = 0; count < nDeBolas; count++){
            int r = nAleatorio.nextInt(256);
            int g = nAleatorio.nextInt(256);
            int b = nAleatorio.nextInt(256);
            posY = nAleatorio.nextInt(100);
            posX = nAleatorio.nextInt(100);
            diametro = nAleatorio.nextInt(50);
            BouncingBall ball = new BouncingBall(posY, posX, diametro, new Color(r,g,b), ground, myCanvas);
            ball.draw();
            bolas.add(ball);
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            // stop once ball has travelled a certain distance on x axis
            if(bolas.get(0).getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}

