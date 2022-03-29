public class ToolStore extends NormalLocation
{
    public ToolStore(Player player) {
        super(player, "Store");
    }

    @Override
    public boolean onLocation()
    {
        System.out.println("Dukkana hos geldiniz ! ");
        
        boolean showMenu = true;
        
        while (showMenu)
        {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armor");
            System.out.println("3 - Exit");
            System.out.print("Your choice : ");
            
            int selectCase = Location.input.nextInt();
            
            while(selectCase < 1 || selectCase > 3)
            {
                System.out.println(" Gecersiz deger, lutfen tekrar giriniz: ");
                
                selectCase = input.nextInt();
            }
            switch (selectCase)
            {
            
                case 1 :
                    printWeapon();
                    buyWeapon();
                    break;
                    
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                    
                case 3:
                    System.out.println("Kendine iyi bak, gorusuruz! ");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon()
    {
        System.out.println("----- Weapons -----");
        
        for(Weapon w : Weapon.weapons())
        {
        	
            System.out.println(w.getId() + " - " + w.getName() + " <Price : " + w.getPrice() + " , Damage : " + w.getDamage()  + " >");
        }
        
        System.out.println("0 - Exit");
    }

    public void buyWeapon()
    {
        System.out.print("Lutfen bir silah seciniz: ");
        
        int selectWeaponID = input.nextInt();

        while((selectWeaponID < 0) || (selectWeaponID > Weapon.weapons().length))
        {
            System.out.print("Lutfen gecerli bir silah tuslayiniz: ");
            
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0)
        {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            
            if(selectedWeapon!= null)
            {
            	
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney())
                {
                    System.out.println("Yeterli paran yok, fakir!!!!");
                }
                
                else
                {
                    System.out.println("Bu silahi satin aldiniz: " + selectedWeapon.getName());
                    
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    
                    System.out.println("Kalan para: " + this.getPlayer().getMoney());
                    System.out.println("Onceki silah: " + this.getPlayer().getInventory().getWeapon().getName());
                    
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silah: " + this.getPlayer().getInventory().getWeapon().getName());
                }
                
            }
        }
    }

    public void printArmor()
    {
        System.out.println("----- Zirhlar -----");
        
        for(Armor a : Armor.armors())
        {
            System.out.println(a.getId() + " - " + a.getName() + "<Fiyat: " + a.getPrice() + " , Hasar Emilimi: " + a.getBlock()  + " >");
        }
        
        System.out.println("0 => Cikis");
    }

    private void buyArmor() 
    {
    	
        System.out.print("Lutfen bir zirh seciniz: ");
        
        
        int selectArmorID = input.nextInt();

        
        while(selectArmorID < 0 || selectArmorID > Armor.armors().length)
        {
            System.out.print("Lutfen gecerli bir zirh numarasi seciniz: ");
            selectArmorID = input.nextInt();
        }

        

        if(selectArmorID != 0)
        {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            
            
            if(selectedArmor!= null)
            {
                if(selectedArmor.getPrice() > this.getPlayer().getMoney())
                {
                    System.out.println("Yeterli paran yok, fakir!!!!!");
                }
                
                else
                {
                    System.out.println("Bu silahi satin aldiniz: " + selectedArmor.getName());
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    
                    this.getPlayer().setMoney(balance);
                    
                    System.out.println("Kalan para: " + this.getPlayer().getMoney());
                    System.out.println("Onceki zirh: " + this.getPlayer().getInventory().getWeapon().getName());
                    
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    
                    System.out.println("Yeni zirh: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }
}
