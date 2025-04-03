package projektjava;

import java.awt.*;
import java.util.Random;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import projektjava.zwierzeta.*;
import projektjava.rosliny.*;

import javax.swing.*;

public abstract class Swiat {
    public Organizm[][] plansza;
    protected Organizm[] organizmy;
    protected Czlowiek czlowiek;
    protected String[] komunikaty;
    protected int liczba_komunikatow;
    protected int szerokosc;
    protected int wysokosc;
    protected int liczba_organizmow;
    protected int liczba_kierunkow;
    protected JPanel panel;

    public Swiat() {}

    public Swiat(int szerokosc, int wysokosc) {
        Random rand = new Random();

        this.komunikaty = new String[0];
        this.liczba_komunikatow = 0;

        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;

        this.plansza = new Organizm[wysokosc][szerokosc];
        this.organizmy = new Organizm[szerokosc * wysokosc];

        for (int i = 0; i < wysokosc; i++) {
            for (int y = 0; y < szerokosc; y++) {
                plansza[i][y] = null;
            }
        }

        this.liczba_organizmow = szerokosc * wysokosc / 4;

        int x = rand.nextInt(szerokosc);
        int y = rand.nextInt(wysokosc);
        Czlowiek czlek = new Czlowiek(x, y, this);
        this.czlowiek = czlek;
        organizmy[0] = czlek;
        plansza[y][x] = czlek;

        int i = 1;
        while (i < liczba_organizmow) {
            boolean czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm owca = new Owca(x, y, this);
                    organizmy[i] = owca;
                    plansza[y][x] = owca;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }

            czy_znaleziono_miejsce = false;

            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm wilk = new Wilk(x, y, this);
                    organizmy[i] = wilk;
                    plansza[y][x] = wilk;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }

            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm lis = new Lis(x, y, this);
                    organizmy[i] = lis;
                    plansza[y][x] = lis;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }

            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm zolw = new Zolw(x, y, this);
                    organizmy[i] = zolw;
                    plansza[y][x] = zolw;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }
            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm antylopa = new Antylopa(x, y, this);
                    organizmy[i] = antylopa;
                    plansza[y][x] = antylopa;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }
            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm trawa = new Trawa(x, y, this);
                    organizmy[i] = trawa;
                    plansza[y][x] = trawa;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }
            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm mlecz = new Mlecz(x, y, this);
                    organizmy[i] = mlecz;
                    plansza[y][x] = mlecz;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }
            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm guarana = new Guarana(x, y, this);
                    organizmy[i] = guarana;
                    plansza[y][x] = guarana;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }
            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm wilczejagody = new WilczeJagody(x, y, this);
                    organizmy[i] = wilczejagody;
                    plansza[y][x] = wilczejagody;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }
            czy_znaleziono_miejsce = false;
            while (!czy_znaleziono_miejsce) {
                x = rand.nextInt(szerokosc);
                y = rand.nextInt(wysokosc);
                if (plansza[y][x] == null) {
                    Organizm barszczsosnowskiego = new BarszczSosnowskiego(x, y, this);
                    organizmy[i] = barszczsosnowskiego;
                    plansza[y][x] = barszczsosnowskiego;
                    czy_znaleziono_miejsce = true;
                    i++;
                }
            }


        }
        this.liczba_organizmow = i;

        this.liczba_komunikatow=0;

        Stworz_Plansze();

    }

    public abstract void Stworz_Plansze();

    public void Dodaj_Plansze(JFrame frame) {
        frame.add(panel);
    }

    public void Wyswietl_Komunikaty(JTextArea panel_komunikatow) {
        panel_komunikatow.setText("");
        for (int i=0; i<komunikaty.length; i++) {
            panel_komunikatow.append(komunikaty[i] + "\n");
        }
    }

    public void Wykonaj_Ture(int ruch) {
        for (int i = 0; i < liczba_organizmow; i++) {
            Organizm org = organizmy[i];
            org.Zwieksz_Wiek();
        }

        Sortuj_Organizmy();
        czlowiek.Set_Ruch(ruch);

        for (int i = 0; i < liczba_organizmow; i++) {
            Organizm org = organizmy[i];

            if (org != null) {
                int old_x = org.Get_X();
                int old_y = org.Get_Y();

                if (org.Get_Wiek() > 0) {
                    org.Akcja();

                    if (old_x != org.Get_X() || old_y != org.Get_Y()) {

                        if (plansza[org.Get_Y()][org.Get_X()] != null) {
                            org.Kolizja(plansza[org.Get_Y()][org.Get_X()]);
                        }
                        else {
                            plansza[org.Get_Y()][org.Get_X()] = org;
                            plansza[old_y][old_x] = null;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < liczba_organizmow; i++) {
            if (organizmy[i] == null) {

                for (int j = i; j < liczba_organizmow - 1; j++) {
                    organizmy[j] = organizmy[j + 1];
                }
                liczba_organizmow--;
                i--;

            }
        }
    }

    public void Rysuj_Swiat() {

        for (int i = 0; i < wysokosc; i++) {
            for (int y = 0; y < szerokosc; y++) {
                Organizm org = plansza[i][y];
                if (org == null) {
                    System.out.print(".");
                } else {
                    org.Rysowanie();
                }
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < liczba_komunikatow; i++) {
            System.out.println(komunikaty[i]);
        }

        panel.repaint();

        this.liczba_komunikatow = 0;
        this.komunikaty = new String[0];

        System.out.println();

        Sprawdz_Status_Umiejetnosci();
        System.out.println("Zapis gry - s, Wczytanie gry - w");
        System.out.println("Poruszanie sie - strzalki, Umiejetnosc specjalna - x");

    }

    public void Dodaj_Organizm(Organizm org_1, Organizm org_2) {
        boolean czy_znaleziono_miejsce = false;
        int x = 0, y = 0;

        if (Sprawdz_Czy_Pole_Puste(org_1.Get_Y() - 1, org_1.Get_X())) {
            czy_znaleziono_miejsce = true;
            x = org_1.Get_X();
            y = org_1.Get_Y() - 1;
        } else if (Sprawdz_Czy_Pole_Puste(org_1.Get_Y() + 1, org_1.Get_X())) {
            czy_znaleziono_miejsce = true;
            x = org_1.Get_X();
            y = org_1.Get_Y() + 1;
        } else if (Sprawdz_Czy_Pole_Puste(org_1.Get_Y(), org_1.Get_X() - 1)) {
            czy_znaleziono_miejsce = true;
            x = org_1.Get_X() - 1;
            y = org_1.Get_Y();
        } else if (Sprawdz_Czy_Pole_Puste(org_1.Get_Y(), org_1.Get_X() + 1)) {
            czy_znaleziono_miejsce = true;
            x = org_1.Get_X() + 1;
            y = org_1.Get_Y();
        } else if (Sprawdz_Czy_Pole_Puste(org_2.Get_Y() - 1, org_2.Get_X())) {
            czy_znaleziono_miejsce = true;
            x = org_2.Get_X();
            y = org_2.Get_Y() - 1;
        } else if (Sprawdz_Czy_Pole_Puste(org_2.Get_Y() + 1, org_2.Get_X())) {
            czy_znaleziono_miejsce = true;
            x = org_2.Get_X();
            y = org_2.Get_Y() + 1;
        } else if (Sprawdz_Czy_Pole_Puste(org_2.Get_Y(), org_2.Get_X() - 1)) {
            czy_znaleziono_miejsce = true;
            x = org_2.Get_X() - 1;
            y = org_2.Get_Y();
        } else if (Sprawdz_Czy_Pole_Puste(org_2.Get_Y(), org_2.Get_X() + 1)) {
            czy_znaleziono_miejsce = true;
            x = org_2.Get_X() + 1;
            y = org_2.Get_Y();
        }

        boolean czy_zwierze = true;
        if (czy_znaleziono_miejsce) {
            Organizm nowy_organizm = null;
            if (org_1.Get_Znak() == 'O') {
                nowy_organizm = new Owca(x, y, this);
            }
            if (org_1.Get_Znak() == 'W') {
                nowy_organizm = new Wilk(x, y, this);
            }
            if (org_1.Get_Znak() == 'L') {
                nowy_organizm = new Lis(x, y, this);
            }
            if (org_1.Get_Znak() == 'Z') {
                nowy_organizm = new Zolw(x, y, this);
            }
            if (org_1.Get_Znak() == 'A') {
                nowy_organizm = new Antylopa(x, y, this);
            }
            if (org_1.Get_Znak() == 'T') {
                nowy_organizm = new Trawa(x, y, this);
                czy_zwierze=false;
            }
            if (org_1.Get_Znak() == 'M') {
                nowy_organizm = new Mlecz(x, y, this);
                czy_zwierze=false;
            }
            if (org_1.Get_Znak() == 'G') {
                nowy_organizm = new Guarana(x, y, this);
                czy_zwierze=false;
            }
            if (org_1.Get_Znak() == 'J') {
                nowy_organizm = new WilczeJagody(x, y, this);
                czy_zwierze=false;
            }
            if (org_1.Get_Znak() == 'B') {
                nowy_organizm = new BarszczSosnowskiego(x, y, this);
                czy_zwierze=false;
            }
            if (liczba_organizmow<(wysokosc*szerokosc)) {
                organizmy[liczba_organizmow] = nowy_organizm;
                plansza[y][x] = nowy_organizm;
                if (czy_zwierze) {
                    String komunikat = "Dwa organizmy gatunku: " + org_1.Get_Nazwa() + " rozmnazaja sie";
                    Dodaj_Komunikat(komunikat);
                } else {
                    String komunikat = org_1.Get_Nazwa() + " rozsiewa sie";
                    Dodaj_Komunikat(komunikat);
                }

                liczba_organizmow++;
            }

        }
    }

    public void Dodaj_Nowy_Organizm(char znak, int y, int x){
        Organizm nowy_organizm = null;
        if (znak == 'O') {
            nowy_organizm = new Owca(x, y, this);
        }
        if (znak == 'W') {
            nowy_organizm = new Wilk(x, y, this);
        }
        if (znak == 'L') {
            nowy_organizm = new Lis(x, y, this);
        }
        if (znak == 'Z') {
            nowy_organizm = new Zolw(x, y, this);
        }
        if (znak == 'A') {
            nowy_organizm = new Antylopa(x, y, this);
        }
        if (znak == 'T') {
            nowy_organizm = new Trawa(x, y, this);
        }
        if (znak == 'M') {
            nowy_organizm = new Mlecz(x, y, this);
        }
        if (znak == 'G') {
            nowy_organizm = new Guarana(x, y, this);
        }
        if (znak == 'J') {
            nowy_organizm = new WilczeJagody(x, y, this);
        }
        if (znak == 'B') {
            nowy_organizm = new BarszczSosnowskiego(x, y, this);
        }
        if (liczba_organizmow<(wysokosc*szerokosc)) {
            organizmy[liczba_organizmow] = nowy_organizm;
            plansza[y][x] = nowy_organizm;
            liczba_organizmow++;
        }
    }
    public void Usun_Organizm(Organizm org) {
        for (int i = 0; i < liczba_organizmow; i++) {
            if (organizmy[i] == org) {
                organizmy[i] = null;
            }
        }
        org = null;
    }

    public int Get_Szerokosc() {
        return this.szerokosc;
    }

    public int Get_Wysokosc() {
        return this.wysokosc;
    }

    public int Get_Liczba_Kierunkow() {
        return this.liczba_kierunkow;
    }

    public boolean Sprawdz_Czy_Pole_Puste(int y, int x) {
        if (x >= 0 && x < szerokosc && y>=0 && y < wysokosc) {
            if (plansza[y][x] == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void Ustaw_Na_Planszy(Organizm org) {
        plansza[org.Get_Y()][org.Get_X()] = org;
    }

    public void Ustaw_Puste_Pole(int y, int x) {
        plansza[y][x] = null;
    }

    public Organizm Zwroc_Pole(int y, int x) {
        if (x > 0 && x < szerokosc && y>0 && y < wysokosc) {
            return plansza[y][x];
        }
            return null;
    }

    public void Sprawdz_Status_Umiejetnosci() {
        int status = czlowiek.Get_Licznik_Umiejetnosci();

        if (status == -5) {
            System.out.println("Jesli chcesz uzyc umiejetnosc specjalna wcisnij x");
        }
        else if (status > 0) {
            System.out.println("Umiejetnosc specjalna w uzyciu");
        }
        else if (status <= 0 && status > -5) {
            System.out.println("Nie mozna w tym momencie uzyc umiejetnosci specjalnej");
        }
    }

    public void Wykorzystaj_Umiejetnosc() {
        czlowiek.Set_Umiejetnosc_Specjalna();
    }

    public void Sortuj_Organizmy() {
        for (int i = 0; i < liczba_organizmow; i++) {
            for (int j = 0; j < liczba_organizmow - i - 1; j++) {
                if (organizmy[j].Get_Inicjatywa() < organizmy[j + 1].Get_Inicjatywa() || (organizmy[j].Get_Inicjatywa() == organizmy[j + 1].Get_Inicjatywa() && organizmy[j].Get_Wiek() < organizmy[j + 1].Get_Wiek())) {
                    Organizm temp = organizmy[j];
                    organizmy[j] = organizmy[j + 1];
                    organizmy[j + 1] = temp;
                }
            }
        }
    }

    public void Zapisz_Do_Pliku() {
        try {
            FileWriter plik = new FileWriter("zapis.txt");

            plik.write(szerokosc + "\n");
            plik.write(wysokosc + "\n");
            plik.write(liczba_organizmow + "\n");

            for (int i = 0; i < liczba_organizmow; i++) {
                Organizm org = organizmy[i];
                if (org.Get_Znak() == 'X') {
                    plik.write(org.Get_Znak() + " " + org.Get_X() + " " + org.Get_Y() + " " + org.Get_Sila() + " " + org.Get_Wiek() + " " + org.Get_Nazwa() + " " + czlowiek.Get_Licznik_Umiejetnosci() + "\n");
                } else {
                    plik.write(org.Get_Znak() + " " + org.Get_X() + " " + org.Get_Y() + " " + org.Get_Sila() + " " + org.Get_Wiek() + " " + org.Get_Nazwa() + "\n");
                }
            }

            plik.close();
        } catch (IOException error) {
            System.out.println("Nie udalo sie zapisac");
        }
    }

    public void Wczytaj_Z_Pliku() {
        try {
            FileReader fileReader = new FileReader("zapis.txt");
            Scanner scanner = new Scanner(fileReader);

            szerokosc = scanner.nextInt();
            wysokosc = scanner.nextInt();
            liczba_organizmow = scanner.nextInt();

            plansza = new Organizm[wysokosc][szerokosc];
            organizmy = new Organizm[szerokosc * wysokosc];

            for (int i = 0; i < wysokosc; i++) {
                plansza[i] = new Organizm[szerokosc];
                for (int y = 0; y < szerokosc; y++) {
                    plansza[i][y] = null;
                }
            }

            for (int i = 0; i < liczba_organizmow; i++) {
                char znak;
                int licznik_umiejetnosci;
                int x, y, sila, wiek;
                String nazwa;
                znak = scanner.next().charAt(0);
                x = scanner.nextInt();
                y = scanner.nextInt();
                sila = scanner.nextInt();
                wiek = scanner.nextInt();
                nazwa = scanner.next();
                if (znak == 'X') {
                    licznik_umiejetnosci = scanner.nextInt();
                    Czlowiek czlek = new Czlowiek(x, y, this, sila, wiek, licznik_umiejetnosci);
                    czlowiek = czlek;
                    organizmy[i] = czlek;
                    plansza[y][x] = czlek;
                } else {
                    Organizm nowy_organizm = new Owca();
                    if (znak == 'O') {
                        nowy_organizm = new Owca(x, y, this);
                    }
                    else if (znak == 'W') {
                        nowy_organizm = new Wilk(x, y, this);
                    }
                    else if (znak == 'L') {
                        nowy_organizm = new Lis(x, y, this);
                    }
                    else if (znak == 'Z') {
                        nowy_organizm = new Zolw(x, y, this);
                    }
                    else if (znak == 'A') {
                        nowy_organizm = new Antylopa(x, y, this);
                    }
                    else if (znak == 'T') {
                        nowy_organizm = new Trawa(x, y, this);
                    }
                    else if (znak == 'M') {
                        nowy_organizm = new Mlecz(x, y, this);
                    }
                    else if (znak== 'G') {
                        nowy_organizm = new Guarana(x, y, this);
                    }
                    else if (znak == 'J') {
                        nowy_organizm = new WilczeJagody(x, y, this);
                    }
                    else if (znak == 'B') {
                        nowy_organizm = new BarszczSosnowskiego(x, y, this);
                    }
                    organizmy[i] = nowy_organizm;
                    plansza[y][x] = nowy_organizm;
                }
            }

            fileReader.close();
        } catch (IOException error) {
            System.out.println("Nie udalo sie wczytac");
        }

        panel.repaint();
    }

    public void Dodaj_Komunikat(String nowy_komunikat) {
        String[] nowa_tablica = new String[liczba_komunikatow + 1];
        for (int i = 0; i < liczba_komunikatow; i++) {
            nowa_tablica[i] = komunikaty[i];
        }
        nowa_tablica[liczba_komunikatow] = nowy_komunikat;
        liczba_komunikatow++;
        komunikaty = nowa_tablica;
    }

}
