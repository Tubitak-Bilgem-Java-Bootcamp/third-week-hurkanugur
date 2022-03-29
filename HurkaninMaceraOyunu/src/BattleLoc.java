import java.util.Random;

public abstract class BattleLoc extends Location
{
	private String award;
    private int maxObstacle;
    private Obstacle obstacle;
    

    public BattleLoc(Player player, String name,Obstacle obstacle,String award, int maxObstacle) 
    {
    	
        super(player, name);
        
        this.award = award;
        this.maxObstacle = maxObstacle;
        this.obstacle = obstacle;
        
    }

    @Override
    public boolean onLocation() 
    {
        if(isCompleted(this.getName()))
        {
            System.out.println("Tum dusmanlari yok ettin, " + this.getName());
            
            return true;
        }
        
        if(this.getName().equals("Mine"))
        {
        	
            Random r = new Random();
            
            int damage = r.nextInt(4) + 3;
            
            this.getObstacle().setDamage(damage);
            
        }
        
        int obsNumber = this.randomObstacleNumber();
        
        System.out.println("Su an buradasin: " + this.getName());
        
        System.out.println("Burada dikkatli ol! " + obsNumber + " " + this.getObstacle().getName() + " yasiyor burada!");
        
        System.out.println("<F>ight or <R>un" );
        
        String selectCase = input.next().toUpperCase();
        
        if(selectCase.equals("F") && combat(obsNumber))
        {
            System.out.println(this.getName() + " bolgesindeki tum dusmanlari yok ettin!");
            return true;
        }
        
        if(this.getPlayer().getHealth() <= 0)
        {
            System.out.println("Hayatini kaybettin, Allah rahmet eylesin Lol...");
            return false;
        }
        
        return true;
    }

    public boolean combat(int obsNumber)
    {
        Random r = new Random();
        int start = r.nextInt(2) ;
        for(int i = 1; i <= obsNumber; ++i)
        {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            
            playerStats();
            
            obstacleStats(i);
            
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0)
            {
                System.out.println("<H>it or <R>un");
                
                String selectCombat = input.next().toUpperCase();
                
                if(selectCombat.equals("H"))
                {
                	
                    if(start == 1)
                    {
                        System.out.println("Once sen vuruyorsun");
                        playerHitFirst();
                    }
                    else
                    {
                        System.out.println("Once engel vurur");
                        obstacleHitFirst();
                    }
                }
                else
                {
                    return false;
                }
            }

            if((this.getObstacle().getHealth()) < (this.getPlayer().getHealth()))
            {
                System.out.println("Tum dusmanlarini yok ettin!!!");
                if(this.getName().equals("Mine"))
                {
                    int prize = r.nextInt(100) + 1;
                    
                    if( prize <= 15)
                    {
                        int randomGun = r.nextInt(100) + 1;
                        
                        if(randomGun <= 20)
                        {
                            Weapon selectedWeapon = Weapon.getWeaponObjByID(3);
                            
                            this.getPlayer().getInventory().setWeapon(selectedWeapon);
                            
                        }
                        
                        else if( randomGun <= 50)
                        {
                            Weapon selectedWeapon = Weapon.getWeaponObjByID(2);
                            
                            this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        }
                        
                        else
                        {
                            Weapon selectedWeapon = Weapon.getWeaponObjByID(1);
                            
                            this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        }
                    }
                    else if(prize <= 30)
                    {
                        int randomArmor = r.nextInt(100) + 1;
                        
                        if(randomArmor <= 20)
                        {
                            Armor selectedArmor = Armor.getArmorObjByID(3);
                            
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                        }
                        else if(randomArmor <= 50)
                        {
                            Armor selectedArmor = Armor.getArmorObjByID(2);
                            
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                        }
                        else
                        {
                            Armor selectedArmor = Armor.getArmorObjByID(1);
                            
                            this.getPlayer().getInventory().setArmor(selectedArmor);
                        }
                    }
                    else if(prize <= 55)
                    {
                        int randomMoney = r.nextInt(100) + 1;
                        
                        if(randomMoney <= 20)
                        {
                            System.out.println( "10 TL para kazandin!");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 10 );
                            System.out.println("Anlik para: " + this.getPlayer().getMoney());
                        }
                        else if(randomMoney <= 50)
                        {
                            System.out.println( "5 TL para kazandin!");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 5 );
                            System.out.println("Anlik para: " + this.getPlayer().getMoney());
                        }
                        else
                        {
                            System.out.println( "1 TL para kazandin! ");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + 1 );
                            System.out.println("Anlik para: " + this.getPlayer().getMoney());
                        }
                    }
                    else
                    {
                        System.out.println("Hicbir sey kazanamadin!");
                    }
                }
                else
                {
                    System.out.println(this.getObstacle().getAward() + " TL para kazandin! ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward() );
                    System.out.println("Anlik para: " + this.getPlayer().getMoney());
                }

            }
            else
            {
                return false;
            }
        }
        assignComplete(super.getName());
        return true;
    }

    private void obstacleHitFirst() 
    {
        System.out.println("Engel sana vurur");
        
        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
        
        if(obstacleDamage < 0 ) obstacleDamage = 0;
        
        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
        
        afterHit();
        
        if(this.getPlayer().getHealth() > 0)
        {
            System.out.println("Sen vurursun");
            
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
            
            afterHit();
        }
    }

    private void playerHitFirst() 
    {
    	
        System.out.println("Sen vurursun!!");
        
        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        
        afterHit();
        
        if(this.getObstacle().getHealth() > 0 )
        {
            System.out.println();
            
            System.out.println("Engel sana vuruyor!!!!!");
            
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
            
            System.out.println(obstacleDamage);
            
            if(obstacleDamage < 0 ) obstacleDamage = 0;
            
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
            
            afterHit();
        }
    }

    private boolean isCompleted(String locationName) 
    {
        System.out.println("Girilen isim : " + locationName);
        switch (locationName){
            case "Cave":
                return this.getPlayer().isCompletedCave();
            case "Forest":
                return this.getPlayer().isCompletedForest();
            case "River":
                return this.getPlayer().isCompletedRiver();
            case "Mine":
                return this.getPlayer().isCompletedMine();
        }
        return false;
    }

    private void assignComplete(String locationName) 
    {
        switch (locationName)
        {
            case "Cave":
                this.getPlayer().setCompletedCave(true);
                this.getPlayer().getInventory().setFood(true);
                break;
                
            case "Forest":
                this.getPlayer().setCompletedForest(true);
                this.getPlayer().getInventory().setFirewood(true);
                break;
                
            case "River":
                this.getPlayer().setCompletedRiver(true);
                this.getPlayer().getInventory().setWater(true);
                break;
                
            case "Mine":
                this.getPlayer().setCompletedMine(true);
                break;
        }

    }

    public void afterHit()
    {
        System.out.println("Caniniz: " + this.getPlayer().getHealth());
        
        System.out.println(this.getObstacle().getName() + "'s health : " + this.obstacle.getHealth());
        
        System.out.println();
    }

    private void playerStats() {
        System.out.println("########################################");
        System.out.println("Oyuncu statlari");
        
        System.out.println("Can: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Kalkan: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar engelleme: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
        System.out.println();

    }

    public void obstacleStats(int i){
        System.out.println("########################################");
        
        System.out.println(i + "." + this.getObstacle().getName() + " Stats");
        System.out.println("Can: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Odul: " + this.getObstacle().getAward());
        System.out.println();
    }

    
    public int randomObstacleNumber()
    {
        Random hukoRandom = new Random();
        
        return hukoRandom.nextInt(this.getMaxObstacle()) + 1 ;
    }

    
    public Obstacle getObstacle() 
    {
        return obstacle;
    }
    

    public void setObstacle(Obstacle newObstacle) 
    {
        this.obstacle = newObstacle;
    }

    
    public String getAward() 
    {
        return award;
    }

    public void setAward(String newAward) {
        this.award = newAward;
    }

    
    public int getMaxObstacle() 
    {
        return maxObstacle;
    }
    

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
