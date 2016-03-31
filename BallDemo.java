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
        int index = 0;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (BouncingBall ball : bolas){                
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                if(ball.getXPosition() >= 550) {
                    finished = true;
                }
                index++;
            }
        }
    }

    /**
     * Simulate two bouncing balls
     */
    public void boxBounce(int nDeBolas)
    {    
        ArrayList<BoxBall> bolas = new ArrayList<>();
        Random nAleatorio = new Random();
        int posY = 0;
        int posX = 0;
        int diametro = 0;
        int ground = 400;   // position of the ground line
        int sky = 60;
        int izq = 50;
        int der = 550;
        boolean posicionCorrecta = false;
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(izq , ground, der, ground);
        myCanvas.drawLine(izq , sky, der, sky);
        myCanvas.drawLine(izq , ground, izq, sky);
        myCanvas.drawLine(der, ground, der, sky);
        // create and show the balls
        for (int count = 0; count < nDeBolas; count++){
            int r = nAleatorio.nextInt(256);
            int g = nAleatorio.nextInt(256);
            int b = nAleatorio.nextInt(256);
            while(!posicionCorrecta) {
                posicionCorrecta = true;
                posY = nAleatorio.nextInt(200);
                posX = nAleatorio.nextInt(200);
                if (posY <= sky || posY >= ground){
                    posicionCorrecta = false;
                }
                else if (posX <= izq || posX >= der){
                    posicionCorrecta = false;
                }
            }
            diametro = nAleatorio.nextInt(50);
            BoxBall ball = new BoxBall(posY, posX, diametro, new Color(r,g,b), ground, izq, sky, der, myCanvas);
            ball.draw();
            bolas.add(ball);
        }
        // make them bounce
        boolean finished =  false;
        int index = 0;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for (BoxBall ball : bolas){                
                ball.move();
                // stop once ball has travelled a certain distance on x axis
                index++;
            }
        }
    }

}