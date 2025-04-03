package projektjava.rosliny;

import projektjava.*;
public class Trawa extends Roslina {
    public Trawa() {
        super();
    }
    public Trawa(int x, int y, Swiat swiat) {
        super(0, 0, x, y, 0, swiat, 'T', "Trawa");
    }

    public Trawa(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 0, x, y, wiek, swiat, 'T', "Trawa");
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
        System.out.print("\033[32m" + znak + "\033[0m");
    }

}
