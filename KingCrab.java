import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
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
			 else
				 if(!moveIt(actor))
					 actor.removeSelfFromGrid();
		 }
	 }
	/**
	 * Method that will test if two locations are far enough so the big krab
	 * stays passive and does not cause another earthquake
	 * @param loc1	the first location
	 * @param loc2	The second location
	 * @return true	It is far enough
	 * @return false It is not far enough
	 */
	 public boolean farEnough(Location loc1, Location loc2)
	 {
		 int x1 = loc1.getRow();
		 int y1 = loc1.getCol();
		 int x2 = loc2.getRow();
		 int y2 = loc2.getCol();
		 //int diff = Math.abs(y1-y2) + Math.abs(x1-x2); 
		 //doesn't take into account diagonal case need something else
		 double diff = Math.sqrt((x1-x2)^2 + (y1-y2)^2) + 0.5;
		 if(diff > 1)
			return true;
		 return false;

	 }
	 /**
	  * Will move an actor more than one box away from the king crab
	  * @param actor the actor that it will move
	  * @return true the actor made the move
	  * @return false the actor failed to make the move
	  */
	 public boolean moveIt(Actor actor)
	 {
		 ArrayList<Location>locations = getGrid().getEmptyAdjacentLocations(actor.getLocation());
		 for(Location loc : locations)
		 {
			 if(farEnough(loc,getLocation()))
			 {
				 actor.moveTo(loc);
				 return true;
			 }
		 }
		 return false;
	 }

}
