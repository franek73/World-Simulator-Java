package projektjava.rosliny;

import projektjava.*;

import java.util.Random;

public class Mlecz extends Roslina {
    public Mlecz() {
        super();
    }
    public Mlecz(int x, int y, Swiat swiat) {
        super(0, 0, x, y, 0, swiat, 'M', "Mlecz");
    }

    public Mlecz(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 0, x, y, wiek, swiat, 'M', "Mlecz");
    }

    @Override
    public void Akcja() {
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int czy_zasieje = rand.nextInt(4);
            if (czy_zasieje == 0) {
                swiat.Dodaj_Organizm(this, this);
                break;
            }
        }
    }

    @Override
    public void Kolizja(Organizm atakowany) {
        super.Kolizja(atakowany);
    }

    @Override
    public void Rysowanie() {
        System.out.print("\033[33m" + znak + "\033[0m");
    }

}
