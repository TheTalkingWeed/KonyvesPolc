public class Konyv {

        private int id;
        private String cim;
        private String szerzo;
        private int suly;


    public Konyv(int id, String cim, String szerzo, int suly) {

        this.id = id;
        this.cim = cim;
        this.szerzo = szerzo;
        this.suly = suly;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public int getSuly() {
        return suly;
    }

    public void setSuly(int suly) {
        this.suly = suly;
    }
}
