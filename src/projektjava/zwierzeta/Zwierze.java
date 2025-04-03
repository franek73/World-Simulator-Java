package projektjava.zwierzeta;

import projektjava.*;
import java.util.Random;

public abstract class Zwierze extends Organizm {
    public static final int GORA = 0;
    public static final int DOL = 1;
    public static final int PRAWO = 2;
    public static final int LEWO = 3;
    public static final int GORA_0 = 4;
    public static final int DOL_0 = 5;
    protected int ostatni_x;
    protected int ostatni_y;

    public Zwierze() {
        super();
        this.ostatni_x = x;
        this.ostatni_y = y;
    }

    public Zwierze(int sila, int inicjatywa, int x, int y, int wiek, Swiat swiat, char znak, String nazwa) {
        super(sila, inicjatywa, x, y, wiek, swiat, znak, nazwa);
        this.ostatni_x = x;
        this.ostatni_y = y;
    }

    @Override
    public void Akcja() {
        Random rand = new Random();
        boolean czy_byl_ruch = false;
        int przemieszczenie = 1;

        if (znak == 'A') {
            przemieszczenie = 2;
        }

        while (!czy_byl_ruch) {
            int ruch = rand.nextInt(swiat.Get_Liczba_Kierunkow());
            if (ruch == GORA) {
                if (y >= przemieszczenie) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y - przemieszczenie;
                    czy_byl_ruch = true;
                }
            } else if (ruch == DOL) {
                if (y < swiat.Get_Wysokosc() - przemieszczenie) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y + przemieszczenie;
                    czy_byl_ruch = true;
                }
            }
            else if (ruch == PRAWO) {
                if (x < swiat.Get_Szerokosc() - przemieszczenie) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.x = x + przemieszczenie;
                    czy_byl_ruch = true;
                }
            }
            else if (ruch == LEWO) {
                if (x >= przemieszczenie) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.x = x - przemieszczenie;
                    czy_byl_ruch = true;
                }
            }
            else if (ruch == GORA_0) {
                if (y >= przemieszczenie) {
                    if ((y==0 || (y%2)==0) && x>0) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y - przemieszczenie;
                        this.x = x - przemieszczenie;
                        czy_byl_ruch = true;
                    } else if ((y%2)==1 && x<swiat.Get_Szerokosc()- przemieszczenie) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y - przemieszczenie;
                        this.x = x + przemieszczenie;
                        czy_byl_ruch = true;
                    }
                }
            }
            else if (ruch == DOL_0) {
                if (y < swiat.Get_Wysokosc() - przemieszczenie) {
                    if ((y==0 || (y%2)==0) && x>0) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y + przemieszczenie;
                        this.x = x - przemieszczenie;
                        czy_byl_ruch = true;
                    } else if ((y%2)==1 && x<swiat.Get_Szerokosc()- przemieszczenie) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y + przemieszczenie;
                        this.x = x + przemieszczenie;
                        czy_byl_ruch = true;
                    }
                }
            }
        }
        //String komunikat = nazwa + " przechodzi z " + Integer.toString(x) + ',' + Integer.toString(y) + " do " + Integer.toString(ostatni_x) + ',' + Integer.toString(ostatni_y);
        //swiat.Dodaj_Komunikat(komunikat);
    }

    @Override
    public void Kolizja(Organizm drugi_organizm) {
        if (znak == drugi_organizm.Get_Znak()) {
            if (Get_Wiek() > 0 && drugi_organizm.Get_Wiek() > 0) {
                swiat.Dodaj_Organizm(this, drugi_organizm);
                this.Wroc_Do_Ostatniej_Pozycji();
            }
            else {
                this.Wroc_Do_Ostatniej_Pozycji();
            }
        }
        else if (znak != drugi_organizm.Get_Znak()) {
            if (Czy_Trujace(drugi_organizm)) {
            }
            else if (Czy_Odparl_Atak(drugi_organizm)) {
            }
            else if (Czy_Uciekl(drugi_organizm)) {
            }
            else if (sila > drugi_organizm.Get_Sila() || sila == drugi_organizm.Get_Sila()) {
                Zwieksz_Sile(drugi_organizm);
                String komunikat = Get_Nazwa() + " zjada " + drugi_organizm.Get_Nazwa();
                swiat.Dodaj_Komunikat(komunikat);
                swiat.Usun_Organizm(drugi_organizm);
                swiat.Ustaw_Puste_Pole(Get_Ostatni_Y(), Get_Ostatni_X());
                swiat.Ustaw_Na_Planszy(this);
            }
            else if (sila < drugi_organizm.Get_Sila()) {
                String komunikat = drugi_organizm.Get_Nazwa() + " zjada " + Get_Nazwa();
                swiat.Dodaj_Komunikat(komunikat);
                swiat.Ustaw_Puste_Pole(Get_Ostatni_Y(), Get_Ostatni_X());
                swiat.Usun_Organizm(this);
            }
        }
    }

    @Override
    public abstract void Rysowanie();

    public int Get_Ostatni_X() {
        return this.ostatni_x;
    }

    public int Get_Ostatni_Y() {
        return this.ostatni_y;
    }

    public void Wroc_Do_Ostatniej_Pozycji() {
      // String komunikat = Get_Nazwa() + " wraca z " + to_string(x) + "," + to_string(y) + " do " + to_string(ostatni_x) + "," + to_string(ostatni_y);
      // swiat->Dodaj_Komunikat(komunikat);
        this.x = this.ostatni_x;
        this.y = this.ostatni_y;
    }
    public boolean Czy_Odparl_Atak(Organizm drugi_organizm) {
        if (drugi_organizm.Get_Znak() == 'Z' && sila < 5) {
            String komunikat = "Zolw odparl atak";
            swiat.Dodaj_Komunikat(komunikat);
            this.Wroc_Do_Ostatniej_Pozycji();
            return true;
        }
            return false;
    }

    public boolean Czy_Uciekl(Organizm drugi_organizm) {
        Random rand = new Random();
        int czy_ucieknie = rand.nextInt(2);
        boolean czy_uciekla = false;

        if (drugi_organizm.Get_Znak() == 'A' && czy_ucieknie == 1) {
            if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y(), drugi_organizm.Get_X() - 1)) {
                drugi_organizm.Set_X(drugi_organizm.Get_X() - 1);
                czy_uciekla = true;
            }
            else if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y(), drugi_organizm.Get_X() + 1)) {
                drugi_organizm.Set_X(drugi_organizm.Get_X() + 1);
                czy_uciekla = true;
            }
            else if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y() - 1, drugi_organizm.Get_X())) {
                drugi_organizm.Set_Y(drugi_organizm.Get_Y() - 1);
                czy_uciekla = true;
            }
            else if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y() + 1, drugi_organizm.Get_X())) {
                drugi_organizm.Set_Y(drugi_organizm.Get_Y() + 1);
                czy_uciekla = true;
            }

            else if (swiat.Get_Liczba_Kierunkow()==6)
            {
                if ((y==0 || (y%2)==0) && x>0) {
                    if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y() + 1, drugi_organizm.Get_X() - 1)) {
                        drugi_organizm.Set_Y(drugi_organizm.Get_Y() + 1);
                        drugi_organizm.Set_X(drugi_organizm.Get_Y() - 1);
                        czy_uciekla = true;
                    }
                    else if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y() - 1, drugi_organizm.Get_X() - 1)) {
                        drugi_organizm.Set_Y(drugi_organizm.Get_Y() - 1);
                        drugi_organizm.Set_X(drugi_organizm.Get_Y() - 1);
                        czy_uciekla = true;
                    }
                }
                else{
                    if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y() + 1, drugi_organizm.Get_X() + 1)) {
                        drugi_organizm.Set_Y(drugi_organizm.Get_Y() + 1);
                        drugi_organizm.Set_X(drugi_organizm.Get_Y() + 1);
                        czy_uciekla = true;
                    }
                    else if (swiat.Sprawdz_Czy_Pole_Puste(drugi_organizm.Get_Y() - 1, drugi_organizm.Get_X() + 1)) {
                        drugi_organizm.Set_Y(drugi_organizm.Get_Y() - 1);
                        drugi_organizm.Set_X(drugi_organizm.Get_Y() + 1);
                        czy_uciekla = true;
                    }
                }

            }

        }

        if (czy_uciekla) {
            swiat.Ustaw_Na_Planszy(drugi_organizm);
            String komunikat = "Antylopa uciekla";
            swiat.Dodaj_Komunikat(komunikat);
            swiat.Ustaw_Puste_Pole(Get_Ostatni_Y(), Get_Ostatni_X());
            swiat.Ustaw_Na_Planszy(this);
            return true;
        }
        else {
            return false;
        }
    }

    public void Zwieksz_Sile(Organizm drugi_organizm) {
        if (drugi_organizm.Get_Znak() == 'G') {
            this.sila += 3;
            String komunikat = Get_Nazwa() + " zwieksza sile o 3";
            swiat.Dodaj_Komunikat(komunikat);
        }
    }

    public boolean Czy_Trujace(Organizm drugi_organizm) {
        if (drugi_organizm.Get_Znak() == 'J' || drugi_organizm.Get_Znak() == 'B') {
            String komunikat = drugi_organizm.Get_Nazwa() + " zabija " + Get_Nazwa();
            swiat.Dodaj_Komunikat(komunikat);
            swiat.Ustaw_Puste_Pole(Get_Ostatni_Y(), Get_Ostatni_X());
            swiat.Ustaw_Puste_Pole(Get_Y(), Get_X());
            swiat.Usun_Organizm(drugi_organizm);
            swiat.Usun_Organizm(this);
            return true;
        }
        return false;
    }
}
