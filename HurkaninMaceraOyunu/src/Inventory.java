public class Inventory 
{
    private boolean water;
    private boolean firewood;
    private boolean food;
    
    private Weapon weapon;
    private Armor armor;

    public Inventory()
    {
        this.weapon = new Weapon("Punch", -1, 0, 0);
        this.armor = new Armor("Unarmored", -1, 0, 0);
        this.water = false;
        this.firewood = false;
        this.food = false;
    }

    public Weapon getWeapon() 
    {
        return weapon;
    }

    public void setWeapon(Weapon newWeapon) 
    {
        this.weapon = newWeapon;
    }

    public Armor getArmor() 
    {
        return armor;
    }

    public void setArmor(Armor newArmor) 
    {
        this.armor = newArmor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean newWater) {
        this.water = newWater;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean newFirewood) {
        this.firewood = newFirewood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean newFood) {
        this.food = newFood;
    }

}
