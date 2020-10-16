package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 * Strong version of the basic alien. It moves faster, shoots faster and can
 * move from side to side.
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class StrongAlien extends Alien implements Sprite
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
     * constructor
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
     *            cool down on shooting
     * @param lc
     *            laser coordinator for shooting
     */
    public StrongAlien(
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
            image = ImageIO.read( new File( "StrongAlien.JPG" ) );
        }
        catch ( IOException e )
        {
        }
    }


    /**
     * updates itself by moving and or shooting
     */
    public void update()
    {
        counter += 2;

        if ( x + vx < 0 || x + vx > Main.WIDTH )
        {
            vx = -vx;
        }
        x += vx;
        if ( x - radius < 0 || x + radius > 800 )
        {
            vx = -vx;
        }
        y += vy;

        if ( counter % cooldown == 0 )
        {
            lc.addAlienLaser( new Laser( x + radius / 2, y, 3, Color.PINK ) );
        }

    }


    /**
     * draws itself
     * 
     * @param g
     *            graphics used to draw
     */
    public void draw( Graphics g )
    {
        g.drawImage( image, x, y, radius, radius - 10, Color.RED, null );
    }


    /**
     * returns whether or not it is in the screen
     * 
     * @return true if it is in the screen, false otherwise
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
     * get the radius
     * 
     * @return radius value
     */
    public int getR()
    {
        return radius;
    }

}
