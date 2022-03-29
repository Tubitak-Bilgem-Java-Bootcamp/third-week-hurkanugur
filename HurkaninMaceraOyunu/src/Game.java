import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hos geldin! ");
        System.out.print("Lutfen adinizi giriniz: ");

        String playerName = input.next();
        Player player = new Player(playerName);
        System.out.println("Hos geldin " + player.getName());
        System.out.println("Benim adim Hurkan Ugur, memnun oldum :D");
        System.out.println("Burada yasanan her sey gercek, dikkatli ol!!!");
        System.out.println("Lutfen bir karakter seciniz: ");
        player.selectChar();

        Location location = null;
        
        while(true)
        {
        	
            player.printInfo();
            

            System.out.println("\n#################### Mekanlar ####################\n");
            
            System.out.println("0 - Oyundan Cik");
            System.out.println("1 - Guvenli Ev => Burasý senin icin guvenli bir bolge, dusman yok!");
            System.out.println("2 - Dukkan => Buradan silah veya zirh alabilirsin!");
            System.out.println("3 - Magara => Odul : <Yiyecek>, ama dikkatli ol, burada zombiler var!");
            System.out.println("4 - Orman => Odul : <Odun>, ama dikkatli ol, burada vampirler var!");
            System.out.println("5 - Nehir => Odul : <Water>, ama dikkatli ol, burada ayilar var!");
            System.out.println("6 - Maden => Odul : <Silah,Kalkan>, ama dikkatli ol, burada yilanlar var!");
            
            System.out.println("##################################################");
            System.out.print("Lutfen bir mekana gitmek icin bir sayi giriniz: ");
            
            int selectLoc = input.nextInt();
            
            switch (selectLoc)
            {
                case 0:
                    location = null;
                    break;
                    
                case 1:
                    location = new SafeHouse(player);
                    break;
                    
                case 2:
                    location = new ToolStore(player);
                    break;
                    
                case 3:
                    location = new Cave(player);
                    break;
                    
                case 4:
                    location = new Forest(player);
                    break;
                    
                case 5:
                    location = new River(player);
                    break;
                    
                case 6:
                    location = new Mine(player);
                    break;
                    
                default:
                    System.out.println("Lutfen gecerli bir sayi giriniz: ");
            }

            if(location == null){
                System.out.println("Ne kadar cabuk pes ettin :((");
                break;
            }
            if(!location.onLocation()){
                System.out.println("<<<<<<<<< OYUN BITTI >>>>>>>>>");
                break;
            }
        }
    }
}
