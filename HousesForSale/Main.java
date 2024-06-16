
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    private static final ListaOfert listaOfert = new ListaOfert();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Program - Zarządzanie ofertami nieruchomości");
        przykladoweOferty();
        wyswietlMenu();
        obslugaMenu();
        scanner.close();
    }

    private static void obslugaMenu() {
        char option;
        do {
            System.out.print("Wybierz opcję: ");
            option = scanner.next().charAt(0);
            scanner.nextLine();

            switch (option) {
                case '1' ->
                    dodajOferteDomu();
                case '2' ->
                    dodajOferteMieszkania();
                case '3' ->
                    wyswietlAktualneOfertyDomow();
                case '4' ->
                    wyswietlAktualneOfertyMieszkan();
                case '5' ->
                    wyswietlOfertyDomowWMiejscowosci();
                case '6' ->
                    wyswietlOfertyMieszkanWMiejscowosci();
                case 'x' ->
                    System.out.println("Koniec programu.");
                default ->
                    System.out.println("Niepoprawna opcja");
            }
        } while (option != 'x');
    }

    private static void wyswietlMenu() {
        System.out.println("1. Dodaj ofertę domu.");
        System.out.println("2. Dodaj ofertę mieszkania.");
        System.out.println("3. Wyświetl aktualne oferty domów.");
        System.out.println("4. Wyświetl aktualne oferty mieszkań.");
        System.out.println("5. Wyświetl oferty domów w miejscowości.");
        System.out.println("6. Wyświetl oferty mieszkań w miejscowości.");
        System.out.println("x. Wyjście z programu.");
    }

    private static void dodajOferteDomu() {
        System.out.println("Podaj ulicę: ");
        String ulica = scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int numerDomu = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.nextLine();
        System.out.println("Podaj powierzchnię: ");
        double powierzchnia = scanner.nextDouble();
        System.out.println("Podaj cenę: ");
        double cena = scanner.nextDouble();
        System.out.println("Podaj powierzchnię działki: ");
        double powierzchniaDzialki = scanner.nextDouble();
        System.out.println("Podaj datę obowiązywania oferty (YYYY-MM-DD): ");
        LocalDate dataObowiazywaniaOferty = LocalDate.parse(scanner.next());

        listaOfert.dodajOferte(new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty, powierzchniaDzialki));
        System.out.println("Oferta dodana.");
    }

    private static void dodajOferteMieszkania() {
        System.out.println("Podaj ulicę: ");
        String ulica = scanner.nextLine();
        System.out.println("Podaj numer domu: ");
        int numerDomu = scanner.nextInt();
        System.out.println("Podaj numer mieszkania: ");
        int numerMieszkania = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();
        System.out.println("Podaj kod pocztowy: ");
        String kodPocztowy = scanner.nextLine();
        System.out.println("Podaj powierzchnię: ");
        double powierzchnia = scanner.nextDouble();
        System.out.println("Podaj numer piętra: ");
        int numerPietra = scanner.nextInt();
        System.out.println("Podaj cenę: ");
        double cena = scanner.nextDouble();
        System.out.println("Podaj datę obowiązywania oferty (YYYY-MM-DD): ");
        LocalDate dataObowiazywaniaOferty = LocalDate.parse(scanner.next());

        listaOfert.dodajOferte(new Mieszkanie(ulica, numerDomu, numerMieszkania, miejscowosc, kodPocztowy, powierzchnia, numerPietra, cena, dataObowiazywaniaOferty));
        System.out.println("Oferta dodana.");
    }

    private static void wyswietlAktualneOfertyDomow() {
        Predicate<Oferta> warunek = oferta -> oferta instanceof Dom && oferta.isOfertaAktualna();
        ArrayList<Oferta> oferty = listaOfert.filtrujOferty(warunek);
        listaOfert.wyswietlOferty(oferty);
    }

    private static void wyswietlAktualneOfertyMieszkan() {
        Predicate<Oferta> warunek = oferta -> oferta instanceof Mieszkanie && oferta.isOfertaAktualna();
        ArrayList<Oferta> oferty = listaOfert.filtrujOferty(warunek);
        listaOfert.wyswietlOferty(oferty);
    }

    private static void wyswietlOfertyDomowWMiejscowosci() {
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();
        System.out.println("Podaj minimalną powierzchnię: ");
        double minimalnaPowierzchnia = scanner.nextDouble();
        scanner.nextLine();

        Predicate<Oferta> warunek = oferta -> oferta instanceof Dom && oferta.isOfertaAktualna() && oferta.miejscowosc.equals(miejscowosc) && oferta.powierzchnia >= minimalnaPowierzchnia;
        ArrayList<Oferta> oferty = listaOfert.filtrujOferty(warunek);
        listaOfert.wyswietlOferty(oferty);
    }

    private static void wyswietlOfertyMieszkanWMiejscowosci() {
        System.out.println("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();
        System.out.println("Podaj maksymalną cenę: ");
        double maksymalnaCena = scanner.nextDouble();
        System.out.println("Podaj minimalne piętro: ");
        int minimalnePietro = scanner.nextInt();
        scanner.nextLine();

        Predicate<Oferta> warunek = oferta -> oferta instanceof Mieszkanie && oferta.isOfertaAktualna() && oferta.miejscowosc.equals(miejscowosc) && oferta.cena <= maksymalnaCena && ((Mieszkanie) oferta).getNumerPietra() >= minimalnePietro;
        ArrayList<Oferta> oferty = listaOfert.filtrujOferty(warunek);
        listaOfert.wyswietlOferty(oferty);
    }

    private static void przykladoweOferty() {
        listaOfert.dodajOferte(new Dom("Krótka", 5, "Warszawa", "00-001", 120, 650000, LocalDate.now().plusDays(10), 300));
        listaOfert.dodajOferte(new Mieszkanie("Długa", 10, 15, "Warszawa", "00-002", 70, 3, 350000, LocalDate.now().plusDays(5)));
        listaOfert.dodajOferte(new Dom("Prosta", 7, "Kraków", "30-001", 200, 850000, LocalDate.now().plusDays(15), 400));
        listaOfert.dodajOferte(new Mieszkanie("Łamana", 20, 8, "Kraków", "30-002", 60, 2, 300000, LocalDate.now().plusDays(20)));
        listaOfert.dodajOferte(new Dom("Kolorowa", 10, "Rumia", "84-230", 250, 1000000, LocalDate.now().plusDays(10), 400));
        listaOfert.dodajOferte(new Mieszkanie("Biała", 35, 12, "Warszawa", "00-004", 95, 9, 400000, LocalDate.now().plusDays(5)));
        listaOfert.dodajOferte(new Dom("Czarna", 2, "Gdańsk", "34-987", 180, 500000, LocalDate.now().plusDays(15), 250));
        listaOfert.dodajOferte(new Mieszkanie("Niebieska", 24, 88, "Gdynia", "83-200", 75, 7, 280000, LocalDate.now().plusDays(10)));
        listaOfert.dodajOferte(new Dom("Żółta", 22, "Kraków", "30-001", 150, 800000, LocalDate.now().plusDays(10), 200));
        listaOfert.dodajOferte(new Mieszkanie("Niebieska", 24, 68, "Gdynia", "83-200", 75, 1, 250000, LocalDate.now().plusDays(10)));
        listaOfert.dodajOferte(new Mieszkanie("Zielona", 9, 20, "Gdynia", "83-200", 65, 5, 150000, LocalDate.now().plusDays(10)));
        listaOfert.dodajOferte(new Mieszkanie("Warszawska", 15, 5, "Warszawa", "00-002", 40, 3, 300000, LocalDate.now().plusDays(10)));
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Main.scanner = scanner;
    }
}
