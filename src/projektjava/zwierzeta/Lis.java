package projektjava.zwierzeta;

import java.lang.*;
import projektjava.*;
import java.util.Random;

public class Lis extends Zwierze {
    public static final int GORA = 0;
    public static final int DOL = 1;
    public static final int PRAWO = 2;
    public static final int LEWO = 3;
    public Lis() {
        super();
    }

    public Lis(int x, int y, Swiat swiat) {
        super(3, 7, x, y, 0, swiat, 'L', "Lis");
    }

    public Lis(int x, int y, Swiat swiat, int sila, int wiek) {
        super(sila, 7, x, y, wiek, swiat, 'L', "Lis");
    }

    @Override
    public void Akcja() {
        Random rand = new Random();
        boolean czy_znaleziono = false;
        boolean czy_byla_gora = false;
        boolean czy_byl_dol = false;
        boolean czy_bylo_lewo = false;
        boolean czy_bylo_prawo = false;
        boolean czy_byla_gora_0 = false;
        boolean czy_byl_dol_0 = false;

        while (!czy_znaleziono) {
            int ruch = rand.nextInt(swiat.Get_Liczba_Kierunkow());
            if (ruch == GORA && y >= 1) {
                if (swiat.Zwroc_Pole(y - 1, x) == null) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y - 1;
                    czy_znaleziono = true;
                }
                else if (swiat.Zwroc_Pole(y - 1, x).Get_Sila() < this.sila) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y - 1;
                    czy_znaleziono = true;
                }
                czy_byla_gora = true;
            }
            if (ruch == DOL && y < swiat.Get_Wysokosc() - 1) {
                if (swiat.Zwroc_Pole(y + 1, x) == null) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y + 1;
                    czy_znaleziono = true;
                }
                else if (swiat.Zwroc_Pole(y + 1, x).Get_Sila() < this.sila) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.y = y + 1;
                    czy_znaleziono = true;
                }
                czy_byl_dol = true;
            }
            if (ruch == PRAWO && x < swiat.Get_Szerokosc() - 1) {
                if (swiat.Zwroc_Pole(y, x + 1) == null) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.x = x + 1;
                    czy_znaleziono = true;
                }
                else if (swiat.Zwroc_Pole(y, x + 1).Get_Sila() < this.sila) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.x = x + 1;
                    czy_znaleziono = true;
                }
                czy_bylo_prawo = true;
            }
            if (ruch == LEWO && x >= 1) {
                if (swiat.Zwroc_Pole(y, x - 1) == null) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.x = x - 1;
                    czy_znaleziono = true;
                }
                else if (swiat.Zwroc_Pole(y, x - 1).Get_Sila() < this.sila) {
                    ostatni_x = this.x;
                    ostatni_y = this.y;
                    this.x = x - 1;
                    czy_znaleziono = true;
                }
                czy_bylo_lewo = true;
            }
            else if (ruch == GORA_0 && y >= 1 ) {

                    if ((y==0 || (y%2)==0) && x>0) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y - 1;
                        this.x = x - 1;
                        czy_byla_gora_0 = true;
                    } else if ((y%2)==1 && x<swiat.Get_Szerokosc()- 1) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y - 1;
                        this.x = x + 1;
                        czy_byla_gora_0 = true;
                    }

            }
            else if (ruch == DOL_0 && y < swiat.Get_Wysokosc() - 1) {
                    if ((y==0 || (y%2)==0) && x>0) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y + 1;
                        this.x = x - 1;
                        czy_byl_dol_0 = true;
                    } else if ((y%2)==1 && x<swiat.Get_Szerokosc()- 1) {
                        ostatni_x = this.x;
                        ostatni_y = this.y;
                        this.y = y + 1;
                        this.x = x + 1;
                        czy_byl_dol_0 = true;
                    }

            }
            if (czy_byla_gora && czy_byl_dol && czy_bylo_prawo && czy_bylo_lewo && czy_byla_gora_0 && czy_byl_dol_0) {
                break;
            }
        }

        // String komunikat = nazwa + " przechodzi z " + Integer.toString(x) + ',' + Integer.toString(y) + " do " + Integer.toString(ostatni_x) + ',' + Integer.toString(ostatni_y);
        // swiat.Dodaj_Komunikat(komunikat);
    }

    @Override
    public void Kolizja(Organizm atakowany) {
        super.Kolizja(atakowany);
    }

    @Override
    public void Rysowanie() {
        System.out.print("\033[38;2;205;92;92m" + znak + "\033[0m");
    }
}
