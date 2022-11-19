import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fomenu fomenu = new Fomenu();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String menuSzoveg = """
                Kérem Válasszon az alábbiak közül:
                1. Polc hozzáadása
                2. Polc törlése
                3. Polc kiválasztása
                4. Vissza
                5. Könyv hozzáadása
                6. Könyv törlése
                q  kilépés""";


        System.out.println(menuSzoveg);
        String valasztottOpcio ;
        Boolean vanValasztottpolc = false;
        while (true){


            System.out.println("Válasszon menü pontot");
            valasztottOpcio = sc.nextLine();


                switch (valasztottOpcio) {
                    case "1" -> {
                        System.out.println("Polc hozzáadása:");

                        System.out.println("Kérem adja meg a polc nevét:");
                        String nev = new Scanner(System.in).nextLine();
                        System.out.println("Kérem adja meg a polc teherbirasát:");
                        int teherbiras = new Scanner(System.in).nextInt();
                        System.out.println("Kérem adjon meg egy megjegyzést a polcról:");
                        String megjegyzes = new Scanner(System.in).nextLine();
                        fomenu.polcHozzaadas(new KonyvesPolc(nev, teherbiras, megjegyzes));

                    }
                    case "2" -> {
                        System.out.println("Polc törlése");
                        System.out.println("Kérem adja meg a törölendő polc nevét:");
                        String nev = sc.nextLine();
                        fomenu.polcTorles(nev);
                    }
                    case "3" -> {
                        System.out.println("Polc kiválasztása:");
                        System.out.println("Kérem adja meg a polc nevét amit kiszeretne választani:");
                        String nev = sc.nextLine();
                        fomenu.polcKivalasztas(nev);
                        vanValasztottpolc = true;
                    }
                    case "4" -> {
                        fomenu.vissza();
                        vanValasztottpolc = false;
                        System.out.println("Visszalépve.");
                    }
                    case "5" -> {
                        if (!vanValasztottpolc){
                            System.out.println("Nincs aktív polc kérem válasszon ki egy aktív polcot!");

                        }else {
                            System.out.println("Könyv hozzáadása");
                            System.out.println("Kérem adja meg a könyv idjét:");
                            int id = sc.nextInt();
                            System.out.println("Kérem adja meg a könyv címét:");
                            String cim = new Scanner(System.in).nextLine();
                            System.out.println("Kérem adja meg a könyv szerzőjét:");
                            String szerzo = new Scanner(System.in).nextLine();
                            System.out.println("Kérem adja meg a könyv súlyát:");
                            int suly = sc.nextInt();

                            fomenu.konyvHozzaadasaPolchoz(new Konyv(id, szerzo, cim, suly));
                        }


                    }
                    case "6" -> {
                        System.out.println("Könyv törlése");
                        System.out.println("Kérem adja meg a törlendő könyv ID-jét");
                        int id = sc.nextInt();
                        fomenu.konyvtorles(id);
                    }
                    case "q" -> System.exit(1);
                }
        }


    }
}