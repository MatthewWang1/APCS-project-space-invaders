package spaceInvaders;

import java.awt.Graphics;


/**
 * Interface. Anything that is drawn or updated on the screen is a sprite.
 *
 * @author Matthew Wang and Christopher Kim
 * @version May 25, 2020
 * @author Period: 1
 * @author Assignment: APCS_Final_Project
 *
 * @author Sources: TODO
 */
public interface Sprite
{

    /**
     * updates itself
     */
    public void update();


    /**
     * draws itself
     * 
     * @param g
     *            graphics used to draw
     */
    public void draw( Graphics g );


    /**
     * gets the x value
     * 
     * @return x value
     */
    public int getX();


    /**
     * gets the y value
     * 
     * @return y value
     */
    public int getY();


    /**
     * gets the radius
     * 
     * @return radius value
     */
    public int getR();


    /**
     * resets itself when the game resets
     */
    public void reset();
}
