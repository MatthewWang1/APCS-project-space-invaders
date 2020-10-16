package spaceInvaders;

import java.awt.Graphics;
import java.util.ArrayList;


/**
 * Coordinator class for all the lasers. Has a list for player and alien lasers
 * and updates them all and draws them all.
 * 
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class LaserCoordinator implements Sprite
{

    private ArrayList<Laser> player;

    private ArrayList<Laser> aliens;


    /**
     * constructor, initializes laser lists
     */
    public LaserCoordinator()
    {
        player = new ArrayList<Laser>();
        aliens = new ArrayList<Laser>();

    }


    /**
     * adds a player laser
     * 
     * @param l
     *            laser to be added
     */
    public void addPlayerLaser( Laser l )
    {
        player.add( l );
    }


    /**
     * adds a alien laser
     * 
     * @param l
     *            laser to be added
     */
    public void addAlienLaser( Laser l )
    {
        aliens.add( l );
    }


    /**
     * updates all the lasers
     */
    public void update()
    {
        ArrayList<Laser> removing = new ArrayList<Laser>();

        for ( Laser l : player )
        {
            l.update();
            if ( !l.isIn() )
            {
                removing.add( l );
            }
        }

        for ( Laser l : removing )
        {
            player.remove( l );
        }

        removing = new ArrayList<Laser>();

        for ( Laser l : aliens )
        {
            l.update();
            if ( !l.isIn() )
            {
                removing.add( l );
            }
        }

        for ( Laser l : removing )
        {
            aliens.remove( l );
        }

    }


    /**
     * draws all the lasers
     * 
     * @param g
     *            graphics used to draw
     */
    public void draw( Graphics g )
    {
        for ( Laser l : player )
        {
            l.draw( g );
        }
        for ( Laser l : aliens )
        {
            l.draw( g );
        }

    }


    /**
     * getter method for the player lasers
     * 
     * @return player laser list
     */
    public ArrayList<Laser> getPlayerLasers()
    {
        return player;
    }


    /**
     * getter method for the alien lasers
     * 
     * @return alien laser list
     */
    public ArrayList<Laser> getAlienLasers()
    {
        return aliens;
    }


    /**
     * gets the x value
     * 
     * @return x value
     */
    public int getX()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * gets the y value
     * 
     * @return y value
     */
    public int getY()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * gets the radius
     * 
     * @return radius value
     */
    public int getR()
    {
        // TODO Auto-generated method stub
        return 0;
    }


    /**
     * resets the lasers by deleting them all
     */
    public void reset()
    {
        player = new ArrayList<Laser>();
        aliens = new ArrayList<Laser>();
    }
}
