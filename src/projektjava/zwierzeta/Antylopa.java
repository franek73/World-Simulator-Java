package projektjava.zwierzeta;

import java.lang.*;
import projektjava.*;

public class Antylopa extends Zwierze  {
    public Antylopa() {
        super();
    }

    public Antylopa(int x, int y, Swiat swiat) {
        super(4, 4, x, y, 0, swiat, 'A', "Antylopa");
    }

    public Antylopa(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 4, x, y, wiek, swiat, 'A', "Antylopa");
    }

    @Override
    public void Akcja() {
        super.Akcja();
    }

    @Override
    public void Kolizja(Organizm atakowany) {
        super.Kolizja(atakowany);
    }

    @Override
    public void Rysowanie() {
        System.out.print("\033[38;5;166m" + this.znak + "\033[0m");
    }

}
