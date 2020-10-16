package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Ship class. This is the player and is controlled by the arrow keys. Can shoot
 * with the space bar. Starts the game with 3 lives and loses one if it hits
 * anything.
 *
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Ship implements Sprite, KeyListener
{
    private double x;

    private double y;

    private double vx;

    private double vy;

    private int w;

    private int h;

    private int radius;

    private int[] screen;

    private LaserCoordinator lc;

    private final double initX;

    private final double initY;


    /**
     * constructor
     * 
     * @param x
     *            initial x
     * @param y
     *            initial y
     * @param vx
     *            initial velocity x
     * @param vy
     *            initial velocity y
     * @param w
     *            width
     * @param h
     *            height
     * @param r
     *            radius
     * @param s
     *            size of the screen (to keep in bounds)
     */
    public Ship( int x, int y, int vx, int vy, int w, int h, int r, int[] s )
    {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.w = w;
        this.h = h;
        this.radius = r;
        screen = s;
        initX = x;
        initY = y;
    }


    /**
     * Draws the ship
     * 
     * @param g
     *            graphics that will be used to draw it
     * 
     */
    public void draw( Graphics g )
    {
        g.setColor( Color.GREEN );
        g.fillRect( (int)x - w / 2, (int)y - h / 2, w, 3 * h );

        g.fillRect( (int)x - w / 2 + 7, (int)y - h / 2 - h / 4, w / 4, h / 4 );
        g.fillRect( (int)x - w / 2 + 7,
            (int)y - h / 2 + ( 3 * h ),
            w / 4,
            h / 4 );
        g.fillRect( (int)x - ( w * 3 ) / 2, (int)y - h + ( h * 5 ) / 2, w, h );
        g.fillRect( (int)x + w / 2, (int)y - h + ( h * 5 ) / 2, w, h );
        g.fillRect( (int)x - w / 2 - w + 7,
            (int)y - h / 2 + h + 15,
            w / 4,
            h / 4 );
        g.fillRect( (int)x - w / 2 + w + 7,
            (int)y - h / 2 + h + 15,
            w / 4,
            h / 4 );

        g.setColor( Color.BLACK );
        g.fillRect( (int)x - w / 2 + 7, (int)y - h / 2 + 7, w / 4 + 1, h );
        g.fillRect( (int)x - w / 2 - w / 4,
            (int)y - h / 2 + ( 2 * h ) + 15,
            w / 4,
            h / 4 );
        g.fillRect( (int)x - w / 2 + w,
            (int)y - h / 2 + ( 2 * h ) + 15,
            w / 4,
            h / 4 );

    }


    /**
     * updates the ship for the next frame
     * 
     */
    public void update()
    {
        x += vx;
        y += vy;

        // vx *= 0.99;
        // vy *= 0.99;

        if ( x > screen[0] )
        {
            x = screen[0] - w;
            vx = 0;
        }
        else if ( x < 20 )
        {
            x = 20;
            vx = 0;
        }

        else if ( y > screen[1] )
        {
            y = screen[1] - h;
            vy = 0;
        }

        else if ( y < 40 )
        {
            y = 42;
            vy = 0;
        }

    }


    /**
     * detects which key is pressed and what actions to take
     * 
     * @param e
     *            event to be processed
     * 
     */
    public void keyPressed( KeyEvent e )
    {
        // key codes: Left arrow is 37, up 38, right 39, down 40

        double speed = 3;

        if ( e.getKeyCode() == 37 )
        {
            vx = -speed;
        }
        else if ( e.getKeyCode() == 38 )
        {
            vy = -speed;
        }
        else if ( e.getKeyCode() == 39 )
        {
            vx = speed;
        }
        else if ( e.getKeyCode() == 40 )
        {
            vy = speed;
        }

    }


    /**
     * detects which key is pressed and what actions to take
     * 
     * @param e
     *            event to be processed
     * 
     */
    public void keyReleased( KeyEvent e )
    {
        int speed = 0;
        if ( e.getKeyCode() == 37 )
        {
            vx = -speed;
        }
        else if ( e.getKeyCode() == 38 )
        {
            vy = -speed;
        }
        else if ( e.getKeyCode() == 39 )
        {
            vx = speed;
        }
        else if ( e.getKeyCode() == 40 )
        {
            vy = speed;
        }
        if ( e.getKeyCode() == 32 )
        {
            lc.addPlayerLaser(
                new Laser( (int)x - 3, (int)y - 30, -4, Color.CYAN ) );
        }
    }


    /**
     * gets a reference to the LaserCoordinator so it can shoot
     * 
     * @param temp
     *            laser coordinator to be used
     */
    public void setLaserCoordinator( LaserCoordinator temp )
    {
        lc = temp;
    }


    /**
     * unused method
     * 
     * @param e
     * 
     */
    public void keyTyped( KeyEvent e )
    {

    }


    /**
     * gets the x value
     * 
     * @return x value
     */
    public int getX()
    {
        return (int)x - 30;
    }


    /**
     * gets the y value
     * 
     * @return y value
     */
    public int getY()
    {
        return (int)y - 10;
    }


    /**
     * gets the radius
     * 
     * @return radius value
     */
    public int getR()
    {
        return radius * 3;
    }


    /**
     * resets the ship when the game is reset
     */
    public void reset()
    {
        x = initX;
        y = initY;
    }

}
