package projektjava;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Main {

    public static void main(String[] args) {

        int N, M;
        String wymiary = JOptionPane.showInputDialog(null, "Wpisz wymiary: ");
        String[] x_y = wymiary.split(" ");
        N = Integer.parseInt(x_y[0]);
        M = Integer.parseInt(x_y[1]);
        Object[] opcje = { "Kratka", "Hex" };
        int wybor = JOptionPane.showOptionDialog(null, "Wybierz rodzaj planszy:",
                "Wybór rodzaju planszy", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcje, opcje[0]);
        char rodzaj_planszy = opcje[wybor].toString().charAt(0);

        Swiat nowy_swiat=new SwiatKratka();

        if (rodzaj_planszy=='K') {
            nowy_swiat = new SwiatKratka(N, M);
        }
        if (rodzaj_planszy=='H') {
            nowy_swiat = new SwiatHex(N, M);
        }

        JFrame frame=new JFrame();
        frame.setTitle("Symulator zycia");
        frame.setBounds(N, M, N*100, M*100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (rodzaj_planszy=='K') {
            Przyciski_Do_Kratki(frame, N, M, nowy_swiat);
        }
        if (rodzaj_planszy=='H') {
            Przyciski_Do_Hexa(frame, N, M, nowy_swiat);
        }

        frame.setVisible(true);
        nowy_swiat.Rysuj_Swiat();

    }

    public static void Przyciski_Do_Kratki(JFrame frame, int N, int M, Swiat nowy_swiat)
    {
        JTextArea panel_komunikatow = new JTextArea(5, 20);

        JButton zapisz_button = new JButton("Zapisz grę");
        JButton wczytaj_button = new JButton("Wczytaj grę");
        JButton gora_button = new JButton("Góra");
        JButton dol_button = new JButton("Dół");
        JButton prawo_button = new JButton("Prawo");
        JButton lewo_button = new JButton("Lewo");
        JButton specjalna_umiejetnosc_button = new JButton("Specjalna umiejętność");

        zapisz_button.setBounds(N*80-100, 170, 200, 30);
        wczytaj_button.setBounds(N*80-100, 210, 200, 30);
        gora_button.setBounds(N*80-100, 10, 200, 30);
        dol_button.setBounds(N*80-100, 50, 200, 30);
        prawo_button.setBounds(N*80-100, 90, 200, 30);
        lewo_button.setBounds(N*80-100, 130, 200, 30);
        specjalna_umiejetnosc_button.setBounds(N*80-100, 250, 200, 30);

        zapisz_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Zapisz_Do_Pliku();
                System.out.println("Zapisano gre");
            }
        });

        wczytaj_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wczytaj_Z_Pliku();
                System.out.println("Wczytano gre");
            }
        });

        gora_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(0);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w gore");
            }
        });

        dol_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(1);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w dol");
            }
        });

        prawo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(2);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w prawo");
            }
        });

        lewo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(3);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w lewo");
            }
        });

        specjalna_umiejetnosc_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykorzystaj_Umiejetnosc();
                System.out.println("Uzyto umiejetnosci specjalnej");
            }
        });

        frame.add(zapisz_button);
        frame.add(wczytaj_button);
        frame.add(gora_button);
        frame.add(dol_button);
        frame.add(prawo_button);
        frame.add(lewo_button);
        frame.add(specjalna_umiejetnosc_button);

        nowy_swiat.Dodaj_Plansze(frame);

        panel_komunikatow.append("Gra rozpoczeta" + "\n");

        panel_komunikatow.setEditable(false);
        frame.getContentPane().add(panel_komunikatow, BorderLayout.PAGE_END);
    }

    public static void Przyciski_Do_Hexa(JFrame frame, int N, int M, Swiat nowy_swiat)
    {
        JTextArea panel_komunikatow = new JTextArea(5, 20);

        JButton zapisz_button = new JButton("Zapisz grę");
        JButton wczytaj_button = new JButton("Wczytaj grę");
        JButton gora_lewo_button = new JButton("Góra Lewo");
        JButton gora_prawo_button = new JButton("Góra Prawo");
        JButton dol_lewo_button = new JButton("Dół Lewo");
        JButton dol_prawo_button = new JButton("Dół Prawo");
        JButton prawo_button = new JButton("Prawo");
        JButton lewo_button = new JButton("Lewo");
        JButton specjalna_umiejetnosc_button = new JButton("Specjalna umiejętność");


        gora_lewo_button.setBounds(N*80-100, 10, 200, 30);
        gora_prawo_button.setBounds(N*80-100, 50, 200, 30);
        dol_lewo_button.setBounds(N*80-100, 90, 200, 30);
        dol_prawo_button.setBounds(N*80-100, 130, 200, 30);
        prawo_button.setBounds(N*80-100, 170, 200, 30);
        lewo_button.setBounds(N*80-100, 210, 200, 30);
        specjalna_umiejetnosc_button.setBounds(N*80-100, 250, 200, 30);
        zapisz_button.setBounds(N*80-100, 290, 200, 30);
        wczytaj_button.setBounds(N*80-100, 340, 200, 30);

        zapisz_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Zapisz_Do_Pliku();
                System.out.println("Zapisano gre");
            }
        });

        wczytaj_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wczytaj_Z_Pliku();
                System.out.println("Wczytano gre");
            }
        });

        gora_lewo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(0);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w gore");
            }
        });

        gora_prawo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(4);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w gore");
            }
        });

        dol_lewo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(1);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w dol");
            }
        });

        dol_prawo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(5);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w dol");
            }
        });

        prawo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(2);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w prawo");
            }
        });

        lewo_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykonaj_Ture(3);
                nowy_swiat.Wyswietl_Komunikaty(panel_komunikatow);
                nowy_swiat.Rysuj_Swiat();
                System.out.println("Ruch w lewo");
            }
        });

        specjalna_umiejetnosc_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nowy_swiat.Wykorzystaj_Umiejetnosc();
                System.out.println("Uzyto umiejetnosci specjalnej");
            }
        });

        frame.add(zapisz_button);
        frame.add(wczytaj_button);
        frame.add(gora_lewo_button);
        frame.add(gora_prawo_button);
        frame.add(dol_lewo_button);
        frame.add(dol_prawo_button);
        frame.add(prawo_button);
        frame.add(lewo_button);
        frame.add(specjalna_umiejetnosc_button);

        nowy_swiat.Dodaj_Plansze(frame);

        panel_komunikatow.append("Gra rozpoczeta" + "\n");

        panel_komunikatow.setEditable(false);
        frame.getContentPane().add(panel_komunikatow, BorderLayout.PAGE_END);

    }

}