package spaceInvaders;

import java.awt.Graphics;
import java.util.ArrayList;


/**
 * Coordinator for all the explosions. Draws, updates, and removes them when
 * necessary.
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class ExplosionCoordinator implements Sprite
{

    private ArrayList<Explosion> booms;


    /**
     * constructor, initializes list of explosions
     */
    public ExplosionCoordinator()
    {
        booms = new ArrayList<Explosion>();
    }


    /**
     * adds an explosion to the list
     * 
     * @param e
     *            explosion to be added
     */
    public void addBoom( Explosion e )
    {
        booms.add( e );
    }


    /**
     * updates all the explosions
     */
    public void update()
    {
        ArrayList<Explosion> removing = new ArrayList<Explosion>();
        for ( Explosion e : booms )
        {
            e.update();
            if ( e.shouldRemove() )
            {
                removing.add( e );
            }
        }

        for ( Explosion e : removing )
        {
            booms.remove( e );
        }
    }


    /**
     * draws all the explosions
     * 
     * @param g
     *            graphics used to draw
     */

    public void draw( Graphics g )
    {
        for ( Explosion e : booms )
        {
            e.draw( g );
        }

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
     * resets the explosions by removing them from the list
     */
    public void reset()
    {
        booms = new ArrayList<Explosion>();
    }
}
