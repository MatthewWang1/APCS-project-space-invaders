package spaceInvaders;

import java.util.ArrayList;


/**
 * Manages, detects, and executes all the collisions between the lasers and
 * aliens and player.
 * 
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public class CollisionsManager
{
    private Ship ship;

    private LaserCoordinator lc;

    private AlienCoordinator ac;

    private ExplosionCoordinator ec;


    /**
     * constructor, sets all the game objects that can collide
     * 
     * @param s
     *            ship
     * @param l
     *            laser coordinator
     * @param a
     *            alien coordinator
     */
    public CollisionsManager( Ship s, LaserCoordinator l, AlienCoordinator a )
    {
        ship = s;
        lc = l;
        ac = a;
    }


    /**
     * checks collisions between the aliens and the player's lasers
     * 
     * @return how many aliens where hit, usually 0 or 1, but just in case 2 hit
     *         in the same frame
     */
    public int alienToLaser()
    {
        int hits = 0;

        ArrayList<Alien> aliens = ac.getAliens();
        ArrayList<Laser> lasers = lc.getPlayerLasers();
        ArrayList<Laser> removingL = new ArrayList<Laser>();
        ArrayList<Alien> removingA = new ArrayList<Alien>();

        for ( Alien a : aliens )
        {
            for ( Laser l : lasers )
            {
                if ( dist( a.getX() + a.getR() / 2,
                    l.getX() + l.getR() / 2,
                    a.getY() + a.getR() / 2,
                    l.getY() + l.getR() / 2 ) < a.getR() / 2 + l.getR() / 2 )
                {
                    removingA.add( a );
                    removingL.add( l );
                    hits++;
                }
            }

            for ( Laser l : removingL )
            {
                lasers.remove( l );
            }
            removingL = new ArrayList<Laser>();

        }

        for ( Alien a : removingA )
        {
            aliens.remove( a );

            ec.addBoom( new Explosion( a.getX() - 10, a.getY() + 10 ) );

        }

        return hits;
    }


    /**
     * checks if the ship has been hit with an alien laser
     * 
     * @return true if it has been hit, false otherwise
     */
    public boolean shipToLaser()
    {

        ArrayList<Laser> lasers = lc.getAlienLasers();
        Laser laser = null;
        boolean hit = false;
        for ( Laser l : lasers )
        {
            if ( dist( ship.getX() + ship.getR() / 2,
                l.getX() + l.getR() / 2,
                ship.getY() + ship.getR() / 2,
                l.getY() + l.getR() / 2 ) < ship.getR() / 2 + l.getR() / 2 )
            {
                laser = l;
                hit = true;
                break;
            }
        }

        lasers.remove( laser );
        return hit;
    }


    /**
     * checks if the ship has collided with an alien
     * 
     * @return true if it has collided with an alien, false otherwise
     */
    public boolean shipToAlien()
    {
        ArrayList<Alien> aliens = ac.getAliens();
        boolean hit = false;
        Alien alien = null;
        for ( Alien a : aliens )
        {
            if ( dist( ship.getX() + ship.getR() / 2,
                a.getX() + a.getR() / 2,
                ship.getY() + ship.getR() / 2,
                a.getY() + a.getR() / 2 ) < ship.getR() / 2 + a.getR() / 2 )
            {
                alien = a;
                hit = true;
                break;
            }
        }

        if ( alien != null )
        {
            ec.addBoom(
                new Explosion( alien.getX() - 10, alien.getY() + 10 ) );
        }

        aliens.remove( alien );
        return hit;

    }


    /**
     * checks if a player laser and an alien laser have hit each other and
     * removes them accordingly
     * 
     */
    public void laserToLaser()
    {
        ArrayList<Laser> aLasers = lc.getAlienLasers();
        ArrayList<Laser> pLasers = lc.getPlayerLasers();
        ArrayList<Laser> removingAL = new ArrayList<Laser>();
        ArrayList<Laser> removingPL = new ArrayList<Laser>();

        for ( Laser a : aLasers )
        {
            for ( Laser p : pLasers )
            {
                if ( dist( a.getX() + a.getR() / 2,
                    p.getX() + p.getR() / 2,
                    a.getY() + a.getR() / 2,
                    p.getY() + p.getR() / 2 ) < a.getR() / 2 + p.getR() / 2 )
                {
                    removingAL.add( a );
                    removingPL.add( p );
                }
            }

            for ( Laser p : removingPL )
            {
                pLasers.remove( p );
            }
            removingPL = new ArrayList<Laser>();

        }

        for ( Laser a : removingAL )
        {
            aLasers.remove( a );
        }

    }


    /**
     * sets the explosion coordinator in order to make explosions when
     * collisions occur
     * 
     * @param eco
     *            explosion coordinator to be used
     */
    public void setEC( ExplosionCoordinator eco )
    {
        this.ec = eco;
    }


    /**
     * helper method to find the distance between 2 sprites and check if their
     * radiuses intersect
     * 
     * @param x1
     *            x of sprite 1
     * @param x2
     *            x of sprite 2
     * @param y1
     *            y of sprite 1
     * @param y2
     *            y of sprite 2
     * @return the distance between the two positions
     */
    public int dist( int x1, int x2, int y1, int y2 )
    {
        return (int)( Math.sqrt(
            ( ( x2 - x1 ) * ( x2 - x1 ) ) + ( ( y2 - y1 ) * ( y2 - y1 ) ) ) );
    }

}
