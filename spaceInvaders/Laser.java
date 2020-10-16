package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;


/**
 * Laser class. Can be either a player laser or alien laser.
 *
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Laser implements Sprite
{

    private int vy;

    private int x;

    private int y;

    private int w = 6;

    private int h = 10;

    private Color color;

    private int radius = 8;


    /**
     * constructor, initializes fields
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param vy
     *            y velocity
     * @param c
     *            color
     */
    public Laser( int x, int y, int vy, Color c )
    {
        this.x = x;
        this.y = y;
        this.vy = vy;
        color = c;
    }


    /**
     * updates the laser by changing its y position
     */
    public void update()
    {
        y += vy;

    }


    /**
     * returns whether it is in the screen or not
     * 
     * @return true if it is in, false otherwise
     */
    public boolean isIn()
    {
        return !( x < 0 || x > Main.WIDTH || y < 0 || y > Main.HEIGHT );

    }


    /**
     * draws the laser
     * 
     * @param g
     *            graphics used to draw
     */
    public void draw( Graphics g )
    {
        g.setColor( color );
        g.fillRect( x, y, w, h );

    }


    /**
     * gets the x value
     * 
     * @return x value
     */
    public int getX()
    {
        return (int)x;
    }


    /**
     * gets the y value
     * 
     * @return y value
     */
    public int getY()
    {
        return (int)y;
    }


    /**
     * gets the radius
     * 
     * @return radius value
     */
    public int getR()
    {
        return radius;
    }


    /**
     * unused method
     */
    public void reset()
    {
        // TODO Auto-generated method stub

    }

}
