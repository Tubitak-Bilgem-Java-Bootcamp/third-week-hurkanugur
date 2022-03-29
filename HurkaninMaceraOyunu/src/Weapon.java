public class Weapon {
	
	private int price;
    private int id;
    
    private int damage;
    private String name;
    


    public Weapon(String name, int id, int damage, int price) 
    {
    	
        this.name = name;
        this.damage = damage;
        
        this.price = price;
        this.id = id;
        
    }

    public static Weapon[] weapons()
    {
        Weapon[] myWeaponList = new Weapon[3];
        
        myWeaponList[0] = new Weapon("Gun",1,2,15);
        
        myWeaponList[1] = new Weapon("Sword",2,3,35);
        
        myWeaponList[2] = new Weapon("Rifle",3,7,45);
        
        return myWeaponList;
    }
    

    public static Weapon getWeaponObjByID(int findByWeaponID)
    {
        for(Weapon myWeapons : Weapon.weapons())
        {
            if(myWeapons.getId() == findByWeaponID)
            {
                return myWeapons;
            }
        }
        return null;
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
    

    public void setDamage(int newDamageValue) 
    {
        this.damage = newDamageValue;
    }
    

    public int getPrice() 
    {
        return price;
    }
    

    public void setPrice(int newPrice) 
    {
        this.price = newPrice;
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
