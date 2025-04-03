package projektjava.zwierzeta;

import java.lang.*;
import projektjava.*;
import java.util.Random;

public class Zolw extends Zwierze {
    public Zolw() {
        super();
    }

    public Zolw(int x, int y, Swiat swiat) {
        super(2, 1, x, y, 0, swiat, 'Z', "Zolw");
    }

    public Zolw(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 1, x, y, wiek, swiat, 'Z', "Zolw");
    }

    @Override
    public void Akcja() {
        Random rand = new Random();
        int czy_ruch = rand.nextInt(4);
        if (czy_ruch == 0) {
            super.Akcja();
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
