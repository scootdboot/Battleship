import java.util.ArrayList;
import java.util.List;

public abstract class Ship
{
    // don't listen to intellij! it's lying to you! it started without a final and it will end without a final
    private int length;
    private List<Location> locations;
    private List<Location> hitsTaken;

    public Ship(int length)
    {
        this.length = length;
    }

    public void addLocation(Location... loc)
    {
        for (Location location : loc)
        {
            locations.add(location);
        }
    }

    public List<Location> getLocations()
    {
        return locations;
    }

    /**
     * Add Location loc to hitsTaken.
     *
     * @param loc
     */
    public void takeHit(Location loc)
    {
        hitsTaken.add(loc);
    }

    /**
     * Returns true if the number of hits taken is
     *   equal to the length of this ship.
     *
     * @return
     */
    public boolean isSunk()
    {
        return hitsTaken.size() == length;
    }
}
