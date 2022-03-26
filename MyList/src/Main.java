public class Main {
    public static void main(String[] args) {
        MyList<Integer> hurkanList = new MyList<>();
        
        //BURASI TEST 1 ICIN:
        System.out.println("Dizinin Kapasitesi : " + hurkanList.getCapacity());
        System.out.println("Dizideki Eleman Say�s� : " + hurkanList.size());
        hurkanList.add(10);
        hurkanList.add(20);
        hurkanList.add(30);
        hurkanList.add(40);
        System.out.println("Dizinin Kapasitesi : " + hurkanList.getCapacity());
        System.out.println("Dizideki Eleman Say�s� : " + hurkanList.size());
        hurkanList.add(50);
        hurkanList.add(60);
        hurkanList.add(70);
        hurkanList.add(80);
        hurkanList.add(90);
        hurkanList.add(100);
        hurkanList.add(110);
        System.out.println("Dizinin Kapasitesi : " + hurkanList.getCapacity());
        System.out.println("Dizideki Eleman Say�s� : " + hurkanList.size());
        System.out.println("...........................................");
        //BURASI TEST 2 ICIN:
        hurkanList.clear();
        hurkanList.add(10);
        hurkanList.add(20);
        hurkanList.add(30);
        System.out.println("2. indisteki de�er : " + hurkanList.get(2));
        hurkanList.remove(2);
        hurkanList.add(40);
        hurkanList.set(0, 100);
        System.out.println("2. indisteki de�er : " + hurkanList.get(2));
        System.out.println(hurkanList.toString());
        System.out.println("...........................................");
        //BURASI TEST 3 ICIN:
        hurkanList.clear();
        System.out.println("hurkanList Durumu : " + (hurkanList.isEmpty() ? "Bo�" : "Dolu"));
        hurkanList.add(10);
        hurkanList.add(20);
        hurkanList.add(30); 
        hurkanList.add(40);
        hurkanList.add(20);
        hurkanList.add(50);
        hurkanList.add(60);
        hurkanList.add(70);
        System.out.println("hurkanList Durumu : " + (hurkanList.isEmpty() ? "Bo�" : "Dolu"));
        System.out.println("Indeks : " + hurkanList.indexOf(20)); // Buldu�u ilk indeksi verir
        System.out.println("Indeks :" + hurkanList.indexOf(100)); // Bulamazsa -1 d�nd�r�r
        System.out.println("Indeks : " + hurkanList.lastIndexOf(20)); // Buldu�u son indeksi verir
        Object[] dizi = hurkanList.toArray(); // hurkanListeyi Object[] dizisi olarak geri verir.
        System.out.println("Object dizisinin ilk eleman� :" + dizi[0]);
        MyList<Integer> althurkanListm = hurkanList.subList(0, 3); // hurkanList veri t�r�nde alt bir hurkanList olu�turdu
        System.out.println(althurkanListm.toString());
        System.out.println("hurkanListemde 20 de�eri : " + hurkanList.contains(20)); // De�erim hurkanListedeki olup olmad���n� sorgulad�
        System.out.println("hurkanListemde 120 de�eri : " + hurkanList.contains(120));
        System.out.println("...........................................");
        hurkanList.clear(); // hurkanListeyi tamamen bo�alt�r ve varsay�lan boyutuna �evirir
        System.out.println(hurkanList.toString());
    }
}