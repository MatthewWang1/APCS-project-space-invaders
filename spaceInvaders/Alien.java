package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * Basic alien class. Only moves downward and shoots a laser every time
 * interval.
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class Alien implements Sprite
{
    private int vy;

    private int vx;

    private int x;

    private int y;

    private int w;

    private int h;

    private int radius;

    private int cooldown;

    private int counter = 0;

    private LaserCoordinator lc;

    private BufferedImage image = null;


    /**
     * empty constructor
     */
    public Alien()
    {

    }


    /**
     * constructor, initializes fields
     * 
     * @param x
     *            x position
     * @param y
     *            y position
     * @param vx
     *            x velocity
     * @param vy
     *            y velocity
     * @param w
     *            width
     * @param h
     *            height
     * @param r
     *            radius
     * @param cd
     *            cool down on the shooting
     * @param lc
     *            laser coordinator to add lasers to
     */
    public Alien(
        int x,
        int y,
        int vx,
        int vy,
        int w,
        int h,
        int r,
        int cd,
        LaserCoordinator lc )
    {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.w = w;
        this.h = h;
        this.radius = r;
        cooldown = cd;
        this.lc = lc;
        lc.addAlienLaser( new Laser( x + radius / 2, y, 2, Color.ORANGE ) );
        try
        {
            image = ImageIO.read( new File( "Alien.JPG" ) );
        }
        catch ( IOException e )
        {
        }
    }


    /**
     * updates the alien by moving it and or shooting
     */
    public void update()
    {
        counter++;

        if ( x + vx < 0 || x + vx > Main.WIDTH )
        {
            vx = -vx;
        }
        x += vx;
        y += vy;

        if ( counter % cooldown == 0 )
        {
            lc.addAlienLaser(
                new Laser( x + radius / 2, y, 2, Color.ORANGE ) );
        }

    }


    /**
     * draws the alien
     * 
     * @param g
     *            graphics used to draw
     */
    public void draw( Graphics g )
    {
        g.drawImage( image, x, y, radius, radius - 10, Color.RED, null );
    }


    /**
     * check if it is in the screen
     * 
     * @return true if it is in, false otherwise
     */
    public boolean isIn()
    {
        return !( x < 0 || x > Main.WIDTH || y < 0 || y > Main.HEIGHT );

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
     * unsused method
     */
    public void reset()
    {
        // TODO Auto-generated method stub

    }

}
