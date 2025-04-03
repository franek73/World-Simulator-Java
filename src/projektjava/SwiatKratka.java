package projektjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwiatKratka extends Swiat{
    public SwiatKratka() {
        super();
    }
    public SwiatKratka(int N, int M) {
        super(N, M);
    }

    @Override
    public void Stworz_Plansze() {
        panel=new JPanel(){
            @Override
            public void paint(Graphics grafika)
            {
                for (int i=0; i<wysokosc; i++)
                {
                    for (int j=0; j<szerokosc; j++) {
                        grafika.setColor(Color.white);
                        grafika.fillRect(i * 64, j * 64, 64, 64);
                        grafika.setColor(Color.black);
                        grafika.drawRect(i * 64, j * 64, 64, 64);
                        if (plansza[j][i] != null) {
                            char s=plansza[j][i].Get_Znak();
                            grafika.setColor(Color.green);
                            grafika.drawString(Character.toString(s), i * 64 + 32, j * 64 + 32);

                        }
                    }
                }
            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent akcja) {
                int x = akcja.getX() / 64;
                int y = akcja.getY() / 64;

                if (Sprawdz_Czy_Pole_Puste(y,x))
                {
                    Object[] opcje = { "O", "W", "Z", "A", "L", "B","G","M","T" };

                    int wybor = JOptionPane.showOptionDialog(null, "Wybierz znak:", "Wybór znaku", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcje, opcje[0]);

                    if (wybor == -1) {
                        return;
                    }

                    char znak = opcje[wybor].toString().charAt(0);
                    Dodaj_Nowy_Organizm(znak, y, x);
                    panel.repaint();
                }
            }
        });

        this.liczba_kierunkow=4;
    }
}
