package projektjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwiatHex extends Swiat{
    public SwiatHex() {
        super();
    }
    public SwiatHex(int N, int M) {
        super(N, M);
    }

    @Override
    public void Stworz_Plansze() {
        panel = new JPanel() {
            @Override
            public void paint(Graphics grafika) {
                int przesuniecie=0;
                for (int j = 0; j < wysokosc; j++) {
                    for (int i = 0; i < szerokosc; i++) {
                        int x, y;
                        int r = 16;

                        if (j==0 || j%2==0) {
                            x = i * 64;
                            y = j * 64-przesuniecie*r;
                        }
                        else {
                            x = i * 64+2*r;
                            y = j * 64-r-przesuniecie*r;
                        }

                            int[] punkty_x = {x, x + 2*r, x + 4 * r, x + 4 * r, x + 2 * r, x};
                            int[] punkty_y = {y + r, y, y+r, y + 3 * r, y + 4 * r, y + 3 * r};

                            grafika.setColor(Color.white);
                            grafika.fillPolygon(punkty_x, punkty_y, 6);
                            grafika.setColor(Color.black);
                            grafika.drawPolygon(punkty_x, punkty_y, 6);

                        if (plansza[j][i] != null) {

                            char s = plansza[j][i].Get_Znak();
                            grafika.setColor(Color.green);
                            grafika.drawString(Character.toString(s), x + 32, y+ 32);
                        }
                    }
                    if (j%2==1) {
                        przesuniecie+=2;
                    }
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x_0 = e.getX()/64;
                int y_0 = e.getY();

                int przesuniecie=0;
                int x=0, y=0;
                for (int j = 0; j < wysokosc; j++) {
                    for (int i = 0; i < szerokosc; i++) {
                        int r = 16;

                        if (j == 0 || j % 2 == 0) {
                            x = i * 64;
                            y = j * 64 - przesuniecie * r;
                        } else {
                            x = i * 64 + 2 * r;
                            y = j * 64 - r - przesuniecie * r;
                        }

                        if (y_0<(y+64) && y_0>y)
                        {
                           y_0=j;
                           break;
                        }

                    }

                    if (j%2==1) {
                        przesuniecie+=2;
                    }
                }

                if (Sprawdz_Czy_Pole_Puste(y_0,x_0))
                {
                    Object[] opcje = { "O", "W", "Z", "A", "L", "B","G","M","T" };
                    int wybor = JOptionPane.showOptionDialog(null, "Wybierz znak:", "Wybór znaku", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcje, opcje[0]);

                    if (wybor == -1) {
                        return;
                    }

                    char znak = opcje[wybor].toString().charAt(0);
                    Dodaj_Nowy_Organizm(znak, y_0, x_0);
                    panel.repaint();
                }
            }
        });

        this.liczba_kierunkow=6;
    }
}
