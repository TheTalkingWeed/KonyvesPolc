import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fomenu {

    
    
    private Map<KonyvesPolc,List<Konyv>> polcok;
    private KonyvesPolc kivalsztott;


    public Fomenu() {
        this.polcok = new HashMap<>();

    }

    public void polcHozzaadas(KonyvesPolc konyvesPolc){
        polcok.put(konyvesPolc,new ArrayList<>());
        System.out.println("Polc hozzáadva");
    }

    public void polcKivalasztas(String name){
        List<String> polcNevek = new ArrayList<>();
        for (KonyvesPolc k : polcok.keySet()) polcNevek.add(k.getNev());
        if (polcok.size() == 0){
            System.out.println("Nics polc amik közül választani lehet,kérem hozzon létre egyet");
        }else if (!polcNevek.contains(name)){
            System.out.println("Nincs ilyen nevű polc");

        }else {
            for (KonyvesPolc i : polcok.keySet()) {
                if (i.getNev().equals(name)) {
                    kivalsztott = i;
                    System.out.println("Polc kivalasztva");
                    break;
                }
            }
        }
    }

    public void konyvHozzaadasaPolchoz(Konyv konyv){

        if (kivalsztott.getTeherbiras() < getKonyvekSulya(kivalsztott) + konyv.getSuly()) {
            System.out.println("Nem bírja el a polc kérem válasszon egy másik aktív polcot!");
        }else{

            if (getKonyvIdk(polcok).contains(konyv.getId())){
                System.out.println("Ilyen idvel rendelkező könyv már létezik");
            }else {
                polcok.get(kivalsztott).add(konyv);
                System.out.println("Könyv hozzáadva a polchoz");
            }
        }
    }


    public void polcTorles(String name){
        for (KonyvesPolc i : polcok.keySet()) {
            System.out.println(i.getNev());
        }


        KonyvesPolc torlendoPolc =  polcok.keySet().stream().filter(x -> x.getNev().equals(name)).findFirst().orElse(null);

        polcok.remove(torlendoPolc);

        System.out.println(name + " törölve");

        for (KonyvesPolc i : polcok.keySet()) {
            System.out.println(i.getNev());
        }

    }

    public void konyvtorles(int id){
        if (getKonyvIdk(polcok).contains(id)){
            for (KonyvesPolc i : polcok.keySet()) {
                Konyv torlendoKonyv = polcok.get(i).stream().filter(x-> x.getId() == id).findFirst().orElse(null);
                polcok.get(i).remove(torlendoKonyv);
            }
            System.out.println("Konyv torolve");
        }else {
            System.out.println("Ilyen ID-ju konyv nem található");
        }

    }


    public void vissza(){
        this.kivalsztott = null;
        System.out.println("Vissza");
    }

    public int getKonyvekSulya(KonyvesPolc polc){
        int res = 0;

        List<Konyv> tempListKonyvek = polcok.get(polc);

        for (Konyv k:tempListKonyvek) {
            res += k.getSuly();
        }
        return res;
    }

    private List<Integer> getKonyvIdk(Map<KonyvesPolc,List<Konyv>> polcok2){
        List<Integer> konyvIdk = new ArrayList<>();
        for (KonyvesPolc i : polcok2.keySet()) {
            for (Konyv k: polcok2.get(i)) {
                konyvIdk.add(k.getId());
            }
        }

        return konyvIdk;
    }






}
