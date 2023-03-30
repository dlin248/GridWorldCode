
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;

public class BlusterCritter extends Critter
{
	private int courage;
	public BlusterCritter(int c)
	{
		courage = c;
	}
	/**
	 * This method overrides the method getActors in Critter. Will look
	 * for neighbors that are 2 spaces away from the BlusterCritter
	 * @return The ArrayList with all of the actors;
	 */
	public ArrayList<Actor> getActors()
	{
		ArrayList<Actor> actors = new ArrayList<Actor>();
		Grid<Actor> grid = getGrid();
		Location currentLocation = getLocation();
		for(int i = -2; i <=2; i++)
		{
			for(int j = -2; j <=2; j++)
			{
				Location valid = new Location(currentLocation.getRow() + i, currentLocation.getCol() + j);
				if(grid.isValid(valid))
				{
					Actor actor = grid.get(valid);
					if(actor != null && actor != this)
						actors.add(actor);
				}
			}
		}
		return actors;
	}
	/**
	 * This method will remove all neighbors that are rocks
	 * @param The arraylist of actors that you want to process
	 */
    public void processActors(ArrayList<Actor> actors)
    {
        Color c = getColor();
        double DARKENING_FACTOR = 0.05;
        int red, blue, green;
        red = blue = green = 0;
        if(actors.size() < courage)
        {
			red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
		}
		else
		{
			red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
			green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
			blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
		}
		if(red > 255)
			red = 255;
		if(blue > 255)
			blue = 255;
		if(green > 255)
			green = 255;
		setColor(new Color(red,green,blue));
    }
	
	
	
}
