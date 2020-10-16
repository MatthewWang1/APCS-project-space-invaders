package spaceInvaders;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.timer.Timer;
import javax.swing.JFrame;


/**
 * Main class that starts the game. Initializes everything and starts running
 * the Art class. Sets up all classes and passes necessary objects.
 *
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Main
{

    public final static int WIDTH = 800;

    public final static int HEIGHT = 700;

    private static boolean playing = true;

    private static JFrame f;


    /**
     * Main method that starts the game. sets everything up and starts the art
     * class
     * 
     * @param args
     *            thing that starts it
     */
    public static void main( String[] args )
    {
        // setting up JFrame and Art
        f = new JFrame( "Space Invaders" );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( WIDTH, HEIGHT );
        f.setBounds( 300, 0, WIDTH, HEIGHT );
        f.setResizable( false );
        f.setVisible( true );
        int[] screen = new int[] { WIDTH, HEIGHT };

        // Creating game objects
        Ship ship = new Ship( WIDTH
            / 2, HEIGHT - 100, 0, 0, 20, 20, 20, screen );
        LaserCoordinator lc = new LaserCoordinator();
        ship.setLaserCoordinator( lc );

        AlienCoordinator ac = new AlienCoordinator( lc );
        ExplosionCoordinator ec = new ExplosionCoordinator();

        Art art = new Art( WIDTH, HEIGHT, ac, lc, ship, 400 );

        f.add( art );

        // Adding game objects to Art and JFrame
        art.addSprite( ship );
        art.addSprite( lc );
        art.addSprite( ac );
        art.setEC( ec );

        f.addKeyListener( ship );
        f.addMouseListener( art );

        art.paintComponent( f.getGraphics() );

    }

}
