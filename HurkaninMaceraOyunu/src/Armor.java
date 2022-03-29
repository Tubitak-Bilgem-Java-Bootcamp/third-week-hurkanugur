public class Armor
{
    
    private int id;
    private int block;
    private int price;
    private String name;

    
    public Armor(String name, int id, int block, int price) 
    {
        this.name = name;
        this.id = id;
        this.block = block;
        this.price = price;
    }

    
    public static Armor[] armors()
    {
        Armor[] armorList = new Armor[3];

        armorList[0] = new Armor("Light", 1, 1 ,15);
        armorList[1] = new Armor("Medium", 2, 3, 25);
        armorList[2] = new Armor("Heavy", 3, 5, 40);

        return armorList;
    }
    

    public static Armor getArmorObjByID(int armorID)
    {
        for(Armor a : Armor.armors())
        {
            if(a.getId() == armorID)
            {
                return a;
            }
        }
        return null;
    }
    

    public String getName()
    {
        return name;
    }
    

    public void setName(String newName)
    {
        this.name = newName;
    }

    
    public int getId() 
    {
        return id;
    }

    
    public void setId(int newId) 
    {
        this.id = newId;
    }

    
    public int getBlock() 
    {
        return block;
    }

    
    public void setBlock(int newBlock)
    {
        this.block = newBlock;
    }

    
    public int getPrice() 
    {
        return price;
    }
    

    public void setPrice(int newPrice) 
    {
        this.price = newPrice;
    }
}
