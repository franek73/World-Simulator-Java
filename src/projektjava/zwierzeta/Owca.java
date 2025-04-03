package projektjava.zwierzeta;

import java.lang.*;
import projektjava.*;

public class Owca extends Zwierze {

    public Owca() {
        super();
    }

    public Owca(int x, int y, Swiat swiat) {
        super(4, 4, x, y, 0, swiat, 'O', "Owca");
    }

    public Owca(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 4, x, y, wiek, swiat, 'O', "Owca");
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
        System.out.print("\033[38;5;15m" + znak + "\033[0m");
    }
}
