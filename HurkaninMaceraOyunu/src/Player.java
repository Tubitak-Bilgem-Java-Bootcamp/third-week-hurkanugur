import java.util.Scanner;

public class Player 
{
    private boolean completedCave;
    private boolean completedForest;
    private boolean completedRiver;
    private boolean completedMine;
    
    private String name;
    private String charName;
    
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;
    
    private int damage;
    private int health;
    private int originalHealth;
    private int money;

    public Player(String name) 
    {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar()
    {
        GameChar[] characterList =  {new Samurai(), new Archer(), new Knight() };
        
        
        System.out.println("###################################################################");
        
        System.out.println("########################### KARAKTERLER ###########################");
        
        
        for (GameChar searchChar : characterList)
        {
            System.out.println("ID : " + searchChar.getId() + "\t Karakter: " + searchChar.getName() + "\t Hasar: " + searchChar.getDamage() + "\t Can: " + searchChar.getHealth() + "\t Para: " + searchChar.getMoney());
        }
        
        
        System.out.println("###################################################################");
        
        System.out.print("Karakter secmek icin lutfen ID giriniz: ");
        
        int selectChar = input.nextInt();
        
        switch (selectChar)
        {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
                break;
        }
        
        System.out.println("Karakter: " + this.getCharName() + "\t Hasar: " + this.getDamage() + "\t Can: " + this.getHealth() + "\t Para: " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar)
    {
        this.setDamage(gameChar.getDamage());
        
        this.setHealth(gameChar.getHealth());
        
        this.setOriginalHealth(gameChar.getHealth());
        
        this.setMoney(gameChar.getMoney());
        
        this.setCharName(gameChar.getName());
    }

    public void printInfo()
    {
        System.out.println(" Silahiniz: " + this.getInventory().getWeapon().getName() + "\n Zirhiniz: " + this.getInventory().getArmor().getName() + "\n Hasar Emilimi: " + this.getInventory().getArmor().getBlock() + "\n Hasariniz: " + this.getTotalDamage() + "\n Caniniz: " + this.getHealth() + "\n Paraniz: " + this.getMoney());
    }

    public int getTotalDamage()
    {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() 
    {
        return damage;
    }

    public void setDamage(int damage) 
    {
        this.damage = damage;
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

    public String getCharName() 
    {
        return charName;
    }

    public void setCharName(String newName)
    {
        this.charName = newName;
    }

    public Inventory getInventory() 
    {
        return inventory;
    }

    public void setInventory(Inventory newInventory) 
    {
        this.inventory = newInventory;
    }

    public int getOriginalHealth() 
    {
        return originalHealth;
    }

    public void setOriginalHealth(int newOriginalHealth)
    {
        this.originalHealth = newOriginalHealth;
    }

    public Weapon getWeapon()
    {
        return this.getInventory().getWeapon();
    }

    public boolean isCompletedCave() 
    {
        return completedCave;
    }

    public void setCompletedCave(boolean completedCave) 
    {
        this.completedCave = completedCave;
    }

    public boolean isCompletedForest()
    {
        return completedForest;
    }

    public void setCompletedForest(boolean completedForest) 
    {
        this.completedForest = completedForest;
    }

    public boolean isCompletedRiver() 
    {
        return completedRiver;
    }

    public void setCompletedRiver(boolean completedRiver) 
    {
        this.completedRiver = completedRiver;
    }

    public boolean isCompletedMine() 
    {
        return completedMine;
    }

    public void setCompletedMine(boolean completedMine) 
    {
        this.completedMine = completedMine;
    }
}
