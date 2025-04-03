package projektjava.rosliny;

import projektjava.*;
public class WilczeJagody extends Roslina {
    public WilczeJagody() {
        super();
    }
    public WilczeJagody(int x, int y, Swiat swiat) {
        super(99, 0, x, y, 0, swiat, 'J', "WilczeJagody");
    }

    public WilczeJagody(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 0, x, y, wiek, swiat, 'J', "WilczeJagody");
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
        System.out.print("\033[38;5;118m" + znak + "\033[0m");
    }

}
