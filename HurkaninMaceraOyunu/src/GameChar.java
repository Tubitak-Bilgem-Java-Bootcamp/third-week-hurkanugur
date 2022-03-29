public abstract class GameChar 
{
	
    private int id;
    private int damage;
    private int health;
    
    private String name;
    
    private int money;

    public GameChar(int playerId, String playerName, int playerDamage, int playerHealth, int playerMoney) 
    {
        this.id = playerId;
        this.name = playerName;
        this.damage = playerDamage;
        this.health = playerHealth;
        this.money = playerMoney;
    }

    
    public int getId() 
    {
        return id;
    }

    
    public void setId(int id) 
    {
        this.id = id;
    }

    
    public int getDamage() 
    {
        return damage;
    }
    

    public void setDamage(int newDamage) 
    {
        this.damage = newDamage;
    }

    
    public int getHealth() 
    {
        return health;
    }

    
    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }
    

    public int getMoney() 
    {
        return money;
    }

    
    public void setMoney(int newMoney) 
    {
        this.money = newMoney;
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
