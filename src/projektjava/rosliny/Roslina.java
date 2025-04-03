package projektjava.rosliny;

import projektjava.*;

public abstract class Roslina extends Organizm {
    public Roslina() {
        super();
    }

    public Roslina(int sila, int inicjatywa, int x, int y, int wiek, Swiat swiat, char znak, String nazwa) {
        super(sila, inicjatywa, x, y, wiek, swiat, znak, nazwa);
    }

    @Override
    public void Akcja() {
        int czy_zasieje = (int)(Math.random() * swiat.Get_Liczba_Kierunkow());
        if (czy_zasieje == 0) {
            swiat.Dodaj_Organizm(this, this);
        }
    }

    @Override
    public void Kolizja(Organizm atakowany) {

    }

    @Override
    public abstract void Rysowanie();

    @Override
    public void Set_X(int x) {
        this.x = x;
    }

    @Override
    public void Set_Y(int y) {
        this.y = y;
    }

}