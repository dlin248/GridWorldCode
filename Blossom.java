/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 */

///Line to run it is  javac -cp "../gridworld.jar" *.java
///					  java -cp ".;../gridworld.jar" JumperRunner

import info.gridworld.actor.Actor;
//import info.gridworld.actor;
import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 * Blossom has a certain lifespan and will get darker until their life is up
 * where they die a miserable life
 */

public class Blossom extends Flower
{
    private static final Color DEFAULT_COLOR = Color.GREEN;
    private static final double DARKENING_FACTOR = 0.05;
    private int life;

    // lose 5% of color value in each step

    /**
     * Constructs a pink flower.
     */
    public Blossom()
    {
        life = 10;
    }

    /**
     * Constructs a flower of a given color.
     * @param initialColor the initial color of this flower
     */
    public Blossom(int lifeIn)
    {
        life = lifeIn;
    }

    /**
     * Causes the color of this flower to darken.
     */
    public void act()
    {
        Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
        life--;
        if(life == 0)
			removeSelfFromGrid();
    }
}

