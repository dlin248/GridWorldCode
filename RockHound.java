
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import info.gridworld.actor.Rock;

public class RockHound extends Critter
{
	/**
	 * This method will remove all neighbors that are rocks
	 * @param The arraylist of actors that you want to process
	 */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if ((a instanceof Rock))
                a.removeSelfFromGrid();
        }
    }
	
	
	
}
