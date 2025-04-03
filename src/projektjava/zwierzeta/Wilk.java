package projektjava.zwierzeta;

import java.lang.*;
import projektjava.*;

public class Wilk extends Zwierze {

    public Wilk() {
        super();
    }

    public Wilk(int x, int y, Swiat swiat) {
        super(9, 5, x, y, 0, swiat, 'W', "Wilk");
    }

    public Wilk(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 5, x, y, wiek, swiat, 'W', "Wilk");
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
        System.out.print("\033[38;5;240m" + znak + "\033[0m");
    }
}

