package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * explosion sprite. Used when an alien dies, or a laser hits the player, or a
 * player hits an alien.
 * 
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Explosion implements Sprite
{
    private int x;

    private int y;

    private int lifespan = 50;

    private boolean remove = false;


    /**
     * constructor, initializes fields
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     */
    public Explosion( int x, int y )
    {
        this.x = x + 5;
        this.y = y - 20;
    }


    /**
     * updates itself and checks if it is time to be removed.
     */
    public void update()
    {
        lifespan--;
        if ( lifespan == 0 )
        {
            remove = true;
        }
    }


    /**
     * returns whether or not it should be removed
     * 
     * @return true if it should be removed, false otherwise
     */
    public boolean shouldRemove()
    {
        return remove;
    }


    /**
     * draws itself
     * 
     * @param g
     *            graphics used to draw
     */
    public void draw( Graphics g )
    {
        g.setColor( new Color( 255, 0, 0, lifespan * 5 ) );
        g.fillOval( x, y, 50, 50 );

        g.setColor( new Color( 255, 153, 0, lifespan * 5 ) );
        g.fillOval( x + 5, y + 5, 40, 40 );

        g.setColor( new Color( 255, 255, 0, lifespan * 5 ) );
        g.fillOval( x + 10, y + 10, 30, 30 );

        g.setColor( new Color( 255, 255, 255, lifespan * 5 ) );
        g.fillOval( x + 15, y + 15, 20, 20 );
    }


    /**
     * gets the x value (unused)
     * 
     * @return x value
     */
    public int getX()
    {
        return (int)x;
    }


    /**
     * gets the y value (unused)
     * 
     * @return y value
     */
    public int getY()
    {
        return (int)y;
    }


    /**
     * gets the radius (unused)
     * 
     * @return r value
     */

    public int getR()
    {
        return 0;
    }


    /**
     * unused method
     */
    public void reset()
    {
    }

}