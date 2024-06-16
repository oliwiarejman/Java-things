
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Walec walec = new Walec();
            System.out.println("Program służy do wykonywaniu operacji na walcu:");
            wyswietlMenu();

            char option;
            do {
                System.out.print("Wybierz opcje: ");
                option = scanner.next().charAt(0);

                switch (option) {
                    case 'a' -> {
                        wyswietlanieWartosci(walec);
                    }
                    case 'b' -> {
                        ustawWartosci(scanner, walec);
                    }
                    case 'c' -> {
                        wyswietlaniePol(walec);
                    }
                    case 'd' -> {
                        wyswietlanieObjetosci(walec);
                    }
                    case 'e' ->
                        System.out.println("Koniec programu.");
                    default ->
                        System.out.println("Niepoprawna opcja");
                }
            } while (option != 'e');
        }
    }

    private static void wyswietlMenu() {
        System.out.println("a. Wyświetlenie wartości zmiennych instancji obiektu klasy Walec");
        System.out.println("b. Ustawienie wartości zmiennych instancji klasy Walec");
        System.out.println("c. Wyliczenie i wyświetlenie pól powierzchni Walca");
        System.out.println("d. Wyliczenie i wyświetlenie objętości Walca");
        System.out.println("e. Wyjście z programu");
    }

    private static void wyswietlanieWartosci(Walec walec) {
        System.out.println("Wartości zmiennych wynoszą: ");
        System.out.println("Wysokość: " + walec.pobierzWysokosc() + ", Promień: " + walec.pobierzPromien());
    }

    private static void ustawWartosci(Scanner scanner, Walec walec) {
        System.out.println("Podaj promień: ");
        double promien = scanner.nextDouble();
        System.out.println("Podaj wysokość: ");
        double wysokosc = scanner.nextDouble();
        walec.ustawPromien(promien);
        walec.ustawWysokosc(wysokosc);
    }

    private static void wyswietlaniePol(Walec walec) {
        System.out.println("Obliczanie wartości pól powierzchni.");
        System.out.println("Pole podstawy: " + walec.obliczPolePowierzchniPodstawy());
        System.out.println("Pole boczne: " + walec.obliczPolePowierzchniBocznej());
        System.out.println("Pole całkowite: " + walec.obliczPolePowierzchniCalkowitej());
    }

    private static void wyswietlanieObjetosci(Walec walec) {
        System.out.println("Obliczanie objętości.");
        System.out.println("Objętość: " + walec.obliczObjetosc());
    }
}
