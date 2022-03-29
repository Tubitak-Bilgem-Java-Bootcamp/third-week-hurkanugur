public class SafeHouse extends NormalLocation
{
    public SafeHouse(Player player) 
    {
        super(player, "Guvenli Ev");
    }

    @Override
    public boolean onLocation()
    {
        System.out.println(" Su an Guvenli Evdesiniz ! ");
        System.out.println(" Can�n�z yenileniyor ! ");
        System.out.println();
        
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        
        if(this.getPlayer().isCompletedForest() && this.getPlayer().isCompletedCave() && this.getPlayer().isCompletedRiver() && this.getPlayer().isCompletedMine())
        {
            System.out.println(" T�m d��manlar� yok ettiniz, Tebrikler!!!!! ");
            return false;
        }
        
        return true;
    }
}
