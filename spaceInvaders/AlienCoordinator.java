package spaceInvaders;

import java.awt.Graphics;
import java.util.ArrayList;


/**
 * 
 * Coordinator for the aliens. It has a list for all the aliens and draws and
 * updates them.
 *
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class AlienCoordinator implements Sprite
{

    private ArrayList<Alien> aliens = new ArrayList<Alien>();

    private int time = 0;

    private LaserCoordinator lc;

    private ExplosionCoordinator ec;


    /**
     * constructor, initializes fields
     * 
     * @param coord
     *            laser coordinator to be used to shoot lasers
     */
    public AlienCoordinator( LaserCoordinator coord )
    {
        lc = coord;
    }


    /**
     * updates all the aliens
     */
    public void update()
    {
        time++;
        if ( time % 300 == 0 )
        {
            aliens.add(
                new Alien( (int)( Math.random() * ( Main.WIDTH - 60 ) + 20 ),
                    0,
                    0,
                    1,
                    40,
                    40,
                    40,
                    300,
                    lc ) );
        }
        if ( time % 800 == 0 )
        {
            aliens.add( new StrongAlien(
                (int)( Math.random() * ( Main.WIDTH - 60 ) + 20 ),
                0,
                (int)( Math.random() * 5 - 2 ),
                1,
                40,
                40,
                40,
                300,
                lc ) );
        }
        ArrayList<Alien> removing = new ArrayList<Alien>();
        for ( Alien a : aliens )
        {
            a.update();
            if ( !a.isIn() )
            {
                removing.add( a );
            }
        }

        for ( Alien a : removing )
        {
            aliens.remove( a );
        }
    }


    /**
     * draws all the aliens
     * 
     * @param g
     *            graphics to be used to draw
     */
    public void draw( Graphics g )
    {
        for ( Alien a : aliens )
        {
            a.draw( g );
        }

    }


    /**
     * gets the list of aliens
     * 
     * @return alien list
     */
    public ArrayList<Alien> getAliens()
    {
        return aliens;
    }


    /**
     * unused method
     * 
     * @return
     */
    public int getX()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * unused method
     * 
     * @return
     */
    public int getY()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * unused method
     * 
     * @return
     */
    public int getR()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * resets the aliens by removing them all from the list
     */
    public void reset()
    {
        aliens = new ArrayList<Alien>();
    }
}
