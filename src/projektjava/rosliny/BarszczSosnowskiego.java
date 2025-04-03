package projektjava.rosliny;

import projektjava.*;
public class BarszczSosnowskiego extends Roslina{
    public BarszczSosnowskiego() {
        super();
    }

    public BarszczSosnowskiego(int x, int y, Swiat swiat) {
        super(99, 0, x, y, 0, swiat, 'B', "BarszczSosnowskiego");
    }

    public BarszczSosnowskiego(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 0, x, y, wiek, swiat, 'B', "BarszczSosnowskiego");
    }

    @Override
    public void Akcja() {
        Organizm zwierze = swiat.Zwroc_Pole(Get_Y() - 1, Get_X());
        if (zwierze != null) {
            if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                swiat.Dodaj_Komunikat(komunikat);
                swiat.Usun_Organizm(zwierze);
            }
        }
        zwierze = swiat.Zwroc_Pole(Get_Y() + 1, Get_X());
        if (zwierze != null) {
            if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                swiat.Dodaj_Komunikat(komunikat);
                swiat.Usun_Organizm(zwierze);
            }
        }
        zwierze = swiat.Zwroc_Pole(Get_Y(), Get_X() - 1);
        if (zwierze != null) {
            if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                swiat.Dodaj_Komunikat(komunikat);
                swiat.Usun_Organizm(zwierze);
            }
        }
        zwierze = swiat.Zwroc_Pole(Get_Y(), Get_X() + 1);
        if (zwierze != null) {
            if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                swiat.Dodaj_Komunikat(komunikat);
                swiat.Usun_Organizm(zwierze);
            }
        }
        if (swiat.Get_Liczba_Kierunkow()==6)
        {
            if ((y==0 || (y%2)==0) && x>0) {
                zwierze = swiat.Zwroc_Pole(Get_Y()+1, Get_X() - 1);
                if (zwierze != null) {
                    if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                        swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                        String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                        swiat.Dodaj_Komunikat(komunikat);
                        swiat.Usun_Organizm(zwierze);
                    }
                }
                zwierze = swiat.Zwroc_Pole(Get_Y()-1, Get_X() - 1);
                if (zwierze != null) {
                    if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                        swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                        String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                        swiat.Dodaj_Komunikat(komunikat);
                        swiat.Usun_Organizm(zwierze);
                    }
                }
            }
            else{
                zwierze = swiat.Zwroc_Pole(Get_Y()+1, Get_X() + 1);
                if (zwierze != null) {
                    if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                        swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                        String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                        swiat.Dodaj_Komunikat(komunikat);
                        swiat.Usun_Organizm(zwierze);
                    }
                }
                zwierze = swiat.Zwroc_Pole(Get_Y()-1, Get_X() + 1);
                if (zwierze != null) {
                    if (zwierze.Get_Znak() != 'B' && zwierze.Get_Znak() != 'J' && zwierze.Get_Sila() > 0) {
                        swiat.Ustaw_Puste_Pole(zwierze.Get_Y(), zwierze.Get_X());
                        String komunikat = "Barszcz sosnowskiego zabija " + zwierze.Get_Nazwa();
                        swiat.Dodaj_Komunikat(komunikat);
                        swiat.Usun_Organizm(zwierze);
                    }
                }
            }

        }
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
