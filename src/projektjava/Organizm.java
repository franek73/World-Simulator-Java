package projektjava;

public class Organizm {
    protected int sila;
    protected int inicjatywa;
    protected int x;
    protected int y;
    protected int wiek;
    protected char znak;
    protected String nazwa;
    protected Swiat swiat;

    public Organizm() {
        this.sila = 0;
        this.inicjatywa = 0;
        this.x = 0;
        this.y = 0;
        this.wiek = 0;
        this.swiat = null;
        this.znak = ' ';
        this.nazwa = " ";
    }

    public Organizm(int sila, int inicjatywa, int x, int y, int wiek, Swiat swiat, char znak, String nazwa) {
        this.sila = sila;
        this.inicjatywa = inicjatywa;
        this.x = x;
        this.y = y;
        this.wiek = wiek;
        this.swiat = swiat;
        this.znak = znak;
        this.nazwa = nazwa;
    }

    public void Akcja() {}

    public void Kolizja(Organizm organizm) {}

    public void Rysowanie() {}

    public char Get_Znak() {
        return this.znak;
    }

    public int Get_X() {
        return this.x;
    }

    public int Get_Y() {
        return this.y;
    }

    public void Zwieksz_Wiek() {
        this.wiek++;
    }

    public int Get_Sila() {
        return this.sila;
    }

    public String Get_Nazwa() {
        return this.nazwa;
    }

    public int Get_Wiek() {
        return this.wiek;
    }

    public int Get_Inicjatywa() {
        return this.inicjatywa;
    }

    public void Set_X(int x) {}

    public void Set_Y(int y) {}
}