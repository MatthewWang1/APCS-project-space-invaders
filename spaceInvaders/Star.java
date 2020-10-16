package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;


/**
 * Star for the background. Can flash and scrolls downward.
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Star implements Sprite
{

    private int x;

    private int y;

    private int size;

    private boolean increasing;

    private int time = (int)( Math.random() * 400 );

    private Color c;

    private int height;


    /**
     * constructor, initializes position and color
     * 
     * @param w
     *            width of screen
     * @param h
     *            height of screen
     */
    public Star( int w, int h )
    {
        height = h;
        x = (int)( Math.random() * w );
        y = (int)( Math.random() * h );
        size = (int)( Math.random() * 4 );
        increasing = size < 2;
        int r = (int)( Math.random() * 155 ) + 100;
        int g = (int)( Math.random() * 155 ) + 100;
        int b = (int)( Math.random() * 155 ) + 100;
        c = new Color( r, g, b );
    }


    /**
     * updates the star by moving it down and or changing its size
     *
     */
    public void update()
    {
        if ( time % 4 == 0 )
        {
            y += 1;
        }
        if ( y > height )
        {
            y = 0;
        }
        time++;
        if ( time % 400 == 0 )
        {
            int chance = (int)( Math.random() * 100 );

            if ( chance < 20 )
            {
                size = 4;
            }

            else if ( chance < 40 )
            {
                size = 3;
            }
            else if ( chance < 70 )
            {
                size = 2;
            }
            else
            {
                size = 1;
            }
        }
    }


    /**
     * draws the star on the screen
     * 
     * @param g
     *            graphics to be used to draw
     */
    public void draw( Graphics g )
    {
        g.setColor( c );
        g.fillRect( x, y, size, size );
    }


    /**
     * gets the x value (unused)
     * 
     * @return x value
     */
    public int getX()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * gets the x value (unused)
     * 
     * @return x value
     */
    public int getY()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * gets the radius (unused)
     * 
     * @return radius value
     */
    public int getR()
    {
        return -1;
    }


    /**
     * unused method
     */
    public void reset()
    {
        // TODO Auto-generated method stub

    }

}
