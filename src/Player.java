import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Player
{
    private String name;
    private List<Ship> ships;
    private int[][] guessBoard;

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    /**
     * Returns how many ships are currently in this
     *   Player's ships List.
     *
     * @return
     */
    public int getNumberOfShips()
    {
        return ships.size();
    }

    /**
     * Returns the ship that occupies the specified
     *   Location loc.  Returns null if this Player
     *   does not control a ship at Location loc.
     *
     * @param loc
     * @return
     */
    public Ship getShip(Location loc)
    {
        for (Ship ship : ships)
        {
            for (Location location : ship.getLocations())
            {
                if (location == loc)
                    return ship; // @TODO this line here COULD BE PROBLEMATIC
            }
        }
        return null;
    }

    public void addShip(Ship ship)
    {
        ships.add(ship);
    }

    public void removeShip(Ship ship)
    {
        ships.remove(ship); // if mr hubbard did something stupid with this this way of doing it might cause a problem
    }

    /**
     * Returns true if this Player controls a ship
     *   at the specified Location loc; false
     *   otherwise.
     *
     * @param loc
     * @return
     */
    public boolean hasShipAtLocation(Location loc)
    {
        for (Ship ship : ships)
        {
            for (Location location : ship.getLocations())
            {
                if (location.equals(loc))
                    return true;
            }
        }

        return false;
    }

    public int[][] getGuessBoard()
    {
        return guessBoard;
    }

    /**
     * Returns true if obj is an instanceof Player and
     *   instance variables are equivalent.
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj)
    {
        boolean rtn = true;
        if (!(obj instanceof Player))
            return false;
        // i hate this. this is horrific.
        if (!guessBoard.equals(((Player) obj).guessBoard))
            rtn = false;
        if (!name.equals(((Player) obj).name))
            rtn = false;
        if (!ships.equals(((Player) obj).ships))
            rtn = false;

        return rtn; // god help me if this bugs out
    }

    /**
     * Attack the specified Player at the specified Location.
     *
     * Return true if the attack resulted in a ship sinking;
     *   false otherwise.
     *
     * @param enemy
     * @param loc
     * @return
     */
    public abstract boolean attack(Player enemy, Location loc);

    /**
     * Construct an instance of
     *
     *   AircraftCarrier,
     *   Destroyer,
     *   Submarine,
     *   Cruiser, and
     *   PatrolBoat
     *
     * and add them to this Player's list of ships.
     */
    public abstract void populateShips();
}
