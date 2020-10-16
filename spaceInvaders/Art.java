package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import javax.swing.*;


/**
 * Draws all the sprites and updates them. Has the main game loops that also
 * checks for game events such as starting or restarting the game.
 *
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Art extends JPanel implements ActionListener, MouseListener
{

    // Game state 0 = start 1 = playing 2 = death

    private int gameState;

    private int lives;

    private int score = 0;

    private int width;

    private int height;

    private final int LIVES = 3;

    private int numStars;

    private Ship ship;

    private int highScore = 0;

    private ArrayList<Sprite> sprites;

    private Timer timer = new Timer( 10, this );

    private CollisionsManager cm;

    private ExplosionCoordinator ec;


    /**
     * constructor, initializes fields
     * 
     * @param w
     *            width of screen
     * @param h
     *            height of screen
     * @param ac
     *            alien coordinator
     * @param lc
     *            laser coordinator
     * @param s
     *            ship
     * @param numStars
     *            number of stars to make
     */
    public Art(
        int w,
        int h,
        AlienCoordinator ac,
        LaserCoordinator lc,
        Ship s,
        int numStars )
    {
        width = w;
        height = h;
        this.numStars = numStars;

        sprites = new ArrayList<Sprite>();

        for ( int i = 0; i < numStars; i++ )
        {
            sprites.add( new Star( w, h ) );
        }

        cm = new CollisionsManager( s, lc, ac );
        gameState = 0;
        lives = LIVES;
        ship = s;
    }


    /**
     * adds a sprite to a list to be drawn and updated
     * 
     * @param s
     *            sprite to be added
     */
    public void addSprite( Sprite s )
    {
        sprites.add( s );
    }


    /**
     * draws all the sprites
     * 
     * @param g
     *            graphics used to draw
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        g.setColor( Color.black );
        g.fillRect( 0, 0, width, height );

        for ( Sprite i : sprites )
        {
            i.draw( g );
        }

        switch ( gameState )
        {
            case 0:
                g.setColor( Color.DARK_GRAY );
                g.fillRect( 340, 395, 120, 40 );
                g.setColor( Color.white );
                g.drawString( "CLICK TO START", 350, 420 );
                break;
            case 1:
                if ( lives == 0 )
                {
                    gameState = 2;
                    if ( score > highScore )
                    {
                        highScore = score;
                    }
                }
                break;
            case 2:
                g.setColor( Color.DARK_GRAY );
                g.fillRect( 340, 325, 120, 40 );
                g.setColor( Color.WHITE );
                g.drawString( "GAME OVER", width / 2 - 35, height / 2 );

                g.setColor( Color.DARK_GRAY );
                g.fillRect( 340, 395, 120, 40 );
                g.setColor( Color.WHITE );
                g.drawString( "CLICK TO RETRY", 350, 420 );
                break;
        }

        g.setColor( Color.green );
        g.drawString( "Lives: " + lives, 10, 20 );
        g.drawString( "Score: " + score, 10, 40 );
        g.drawString( "High Score: " + highScore, 10, 60 );

        timer.start();

    }


    /**
     * gets called when an action happens. Essentially it is the update loop
     * that updates all the sprites.
     * 
     * @param arg0
     *            event that triggered the method
     */
    public void actionPerformed( ActionEvent arg0 )
    {

        switch ( gameState )
        {
            case 0:
                break;
            case 1:

                for ( Sprite i : sprites )
                {
                    i.update();
                }
                score += cm.alienToLaser();
                cm.laserToLaser();
                if ( cm.shipToLaser() )
                {
                    ec.addBoom( new Explosion( ship.getX(), ship.getY() ) );
                    lives--;
                }
                if ( cm.shipToAlien() )
                {
                    lives--;
                }
                break;
            case 2:
                break;
        }
        repaint();
    }


    /**
     * checks where the mouse is clicked in order to respond accordingly
     * (start/restart game)
     * 
     * @param e
     *            mouse event that triggered method
     */
    public void mouseClicked( MouseEvent e )
    {
        int x = (int)e.getLocationOnScreen().getX();
        int y = (int)e.getLocationOnScreen().getY();

        switch ( gameState )
        {
            case 0:
                if ( x >= 640 && x <= 760 && y >= 420 && y <= 460 )
                {
                    gameState = 1;
                }
                break;
            case 1:
                break;
            case 2:
                if ( x >= 640 && x <= 760 && y >= 420 && y <= 460 )
                {
                    gameState = 1;
                    reset();
                }
        }

    }


    /**
     * resets the game after the reset button is pressed
     */
    private void reset()
    {
        score = 0;
        lives = LIVES;
        for ( Sprite i : sprites )
        {
            i.reset();
        }

    }


    /**
     * gets the explosion coordinator to make explosions
     * 
     * @param ec
     *            explosion coordinator
     */
    public void setEC( ExplosionCoordinator ec )
    {
        this.ec = ec;
        sprites.add( ec );
        cm.setEC( ec );
    }


    /**
     * unused method
     * 
     * @param arg0
     */
    public void mouseEntered( MouseEvent arg0 )
    {
    }


    /**
     * unused method
     * 
     * @param arg0
     */
    public void mouseExited( MouseEvent arg0 )
    {
    }


    /**
     * unused method
     * 
     * @param arg0
     */
    public void mousePressed( MouseEvent arg0 )
    {
    }


    /**
     * unused method
     * 
     * @param arg0
     */
    public void mouseReleased( MouseEvent arg0 )
    {
    }

}
