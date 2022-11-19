import java.util.ArrayList;
import java.util.List;

public class KonyvesPolc {

    private String nev;
    private int teherbiras;
    private String megjegyzes;


    public KonyvesPolc(String nev, int teherbiras, String megjegyzes) {
        this.nev = nev;
        this.teherbiras = teherbiras;
        this.megjegyzes = megjegyzes;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getTeherbiras() {
        return teherbiras;
    }

    public void setTeherbiras(int teherbiras) {
        this.teherbiras = teherbiras;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }


}
