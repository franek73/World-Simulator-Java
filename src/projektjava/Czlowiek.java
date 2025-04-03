package projektjava;
import java.util.Random;

import projektjava.zwierzeta.Zwierze;

public class Czlowiek extends Zwierze {
    public static final int GORA = 0;
    public static final int DOL = 1;
    public static final int PRAWO = 2;
    public static final int LEWO = 3;
    public static final int GORA_0 = 4;
    public static final int DOL_0 = 5;
    private int licznik_umiejetnosci;
    private int ruch;
    public Czlowiek() {
        super();
        licznik_umiejetnosci = -5;
        ruch = -1;
    }

    public Czlowiek(int x, int y, Swiat swiat) {
        super(5, 4, x, y, 0, swiat, 'X', "Czlowiek");
        this.licznik_umiejetnosci = -5;
        this.ruch = -1;
    }

    public Czlowiek(int x, int y, Swiat swiat, int sila, int wiek, int licznik_umiejetnosci) {
        super(sila, 4, x, y, wiek, swiat, 'X', "Czlowiek");
        this.licznik_umiejetnosci = licznik_umiejetnosci;
        this.ruch = -1;
    }

    @Override
    public void Akcja() {
        boolean czy_byl_ruch = false;
        int przesuniecie = 1;

        if (licznik_umiejetnosci < 3 && licznik_umiejetnosci > 0) {
            Random rand = new Random();
            int szansa = rand.nextInt(2);
            if (szansa == 1) {
                przesuniecie = 2;
            }
        }

        if (licznik_umiejetnosci > 2) {
            przesuniecie = 2;
        }

        if (ruch == GORA && y >= przesuniecie) {
            if (swiat.Get_Liczba_Kierunkow()==4) {
                ostatni_x = this.x;
                ostatni_y = this.y;
                this.y = y - przesuniecie;
            }
            else {
                if ((y==0 || (y%2)==0) && x >0) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y - przesuniecie;
                    this.x = x - przesuniecie;

                } else if ((y%2)==1) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y - przesuniecie;
                }
            }
            czy_byl_ruch = true;
        }
        else if (ruch == DOL && y < swiat.Get_Wysokosc() - przesuniecie) {
            if (swiat.Get_Liczba_Kierunkow()==4)
            {
            ostatni_x = this.x;
            ostatni_y = this.y;
            this.y = y + przesuniecie;
           }
            else {

                    if ((y==0 || (y%2)==0) && x>0) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y + przesuniecie;
                        this.x = x - przesuniecie;
                    } else if ((y%2)==1) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y + przesuniecie;
                    }

            }
            czy_byl_ruch = true;
        }
        else if (ruch == PRAWO && x < swiat.Get_Szerokosc() - przesuniecie) {
            ostatni_x = this.x;
            ostatni_y = this.y;
            this.x = x + przesuniecie;
            czy_byl_ruch = true;
        }
        else if (ruch == LEWO && x >= przesuniecie) {
            ostatni_x = this.x;
            ostatni_y = this.y;
            this.x = x - przesuniecie;
            czy_byl_ruch = true;
        }
        else if (ruch == GORA_0 && y >= przesuniecie) {
            if ((y==0 || (y%2)==0)) {
                ostatni_x = this.x;
                ostatni_y = this.y;
                this.y = y - przesuniecie;
                czy_byl_ruch = true;
            } else if ((y%2)==1 && x<swiat.Get_Szerokosc()- przesuniecie) {
                ostatni_x = this.x;
                ostatni_y = this.y;
                this.y = y - przesuniecie;
                this.x = x + przesuniecie;
                czy_byl_ruch = true;
            }
        }
        else if (ruch == DOL_0 && y < swiat.Get_Wysokosc() - przesuniecie) {
                if ((y==0 || (y%2)==0)) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y + przesuniecie;

                } else if ((y%2)==1 && x<swiat.Get_Szerokosc()- przesuniecie) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y + przesuniecie;
                    this.x = x + przesuniecie;

                }
            czy_byl_ruch = true;
        }

        if (licznik_umiejetnosci > -5) {
            licznik_umiejetnosci--;
        }

        if (czy_byl_ruch) {
            String komunikat = nazwa + " przechodzi z " + Integer.toString(x) + ',' + Integer.toString(y) + " do " + Integer.toString(ostatni_x) + ',' + Integer.toString(ostatni_y);
            swiat.Dodaj_Komunikat(komunikat);
        }
    }

    @Override
    public void Kolizja(Organizm atakowany) {
        super.Kolizja(atakowany);
    }

    @Override
    public void Rysowanie() {
        System.out.print("\033[0;34m" + znak + "\033[0m");
    }
    public void Set_Umiejetnosc_Specjalna() {
        if (this.licznik_umiejetnosci == -5) {
            this.licznik_umiejetnosci = 5;
        }
    }

    public int Get_Licznik_Umiejetnosci() {
        return this.licznik_umiejetnosci;
    }

    public void Set_Ruch(int ruch) {
        this.ruch = ruch;
    }

}