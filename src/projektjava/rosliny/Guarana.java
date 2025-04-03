package projektjava.rosliny;

import projektjava.*;

public class Guarana extends Roslina {
    public Guarana() {
        super();
    }

    public Guarana(int x, int y, Swiat swiat) {
        super(0, 0, x, y, 0, swiat, 'G', "Guarana");
    }

    public Guarana(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 0, x, y, wiek, swiat, 'G', "Guarana");
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
        System.out.print("\033[31m" + znak + "\033[0m");
    }
}
