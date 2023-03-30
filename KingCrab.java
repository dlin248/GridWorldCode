import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
	public KingCrab()
	{
		setColor(Color.RED);
	}
	/**
	 * Will force everyone to move like a landlord
	 * @param actor		The arraylist of actors to mess with
	 */
	 public void processActors(ArrayList<Actor> actors)
	 {
		 for(Actor actor: actors)
		 {
			 if(actor instanceof Rock)
				actor.removeSelfFromGrid();
	
}
