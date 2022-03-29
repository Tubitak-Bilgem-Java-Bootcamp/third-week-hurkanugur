import java.util.Scanner;

public abstract class Location 
{
	private String name;
    private Player player;
    
    public static Scanner input = new Scanner(System.in);

    public Location(Player player, String name) 
    {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();

    public Player getPlayer() 
    {
        return player;
    }

    public void setPlayer(Player newPlayer)
    {
        this.player = newPlayer;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String newName) 
    {
        this.name = newName;
    }


}
