public class Obstacle 
{
    
    private int id;
    private int damage;
    private int health;
    
    private int award;
    private int originalHealth;
    
    private String name;

    public Obstacle(String name, int id, int damage, int health, int award) 
    {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.originalHealth = health;
        this.award = award;
    }

    
    public int getId() 
    {
        return id;
    }

    
    public void setId(int newID) 
    {
        this.id = newID;
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
        if(health < 0)
        {
            health = 0;
        }
        
        this.health = newHealth;
    }

    
    public String getName() 
    {
        return name;
    }

    
    public int getAward() 
    {
        return award;
    }

    
    public void setAward(int newAward) 
    {
        this.award = newAward;
    }
    

    public void setName(String newName) 
    {
        this.name = newName;
    }
    

    public int getOriginalHealth() 
    {
        return originalHealth;
    }

    
    public void setOriginalHealth(int newOriginalHealth) 
    {
        this.originalHealth = newOriginalHealth;
    }
    
}
