
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    private static Kalendarz kalendarz = new Kalendarz();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        przykladoweSpotkania();
        System.out.println("Program Kalendarz");
        wyswietlMenu();

        obslugaMenu();
        scanner.close();
    }

    private static void obslugaMenu() {
        char option;
        do {
            System.out.print("Wybierz opcje: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case '1' ->
                    dodajSpotkanie();
                case '2' ->
                    usunSpotkanie();
                case '3' ->
                    wyswietlSpotkaniaWDniu();
                case '4' ->
                    wyswietlSpotkaniaWDniuOPriorytecie();
                case '5' ->
                    wyswietlSpotkaniaPoCzasieWDniu();
                case '6' ->
                    wyswietlSpotkaniaWMarginesieCzasowymWDniu();
                case '7' ->
                    wyswietlSpotkaniaPriorytetICzasWDniu();
                case '0' ->
                    System.out.println("Koniec programu.");
                default ->
                    System.out.println("Niepoprawna opcja");
            }
        } while (option != '0');
    }

    private static void wyswietlMenu() {
        System.out.println("1. Dodaj spotkanie na wybrany dzień.");
        System.out.println("2. Usuń wybrane spotkanie z dnia.");
        System.out.println("3. Wyświetl wszystkie spotkania z wybranego dnia.");
        System.out.println("4. Wyświetl wszystkie spotkania z wybranego dnia o wybranym priorytecie.");
        System.out.println("5. Wyświetl spotkania z danego dnia zaczynające się nie wcześniej niż podana godzina.");
        System.out.println("6. Wyświetl spotkania z danego dnia odbywające się pomiędzy podanymi czasami włącznie.");
        System.out.println("7. Wyświetl spotkania z danego dnia o danym priorytecie i zaczynające się nie wcześniej niż od podanego czasu.");
        System.out.println("0. Wyjście z programu.");
    }

    private static void dodajSpotkanie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia (HH:mm): ");
        LocalTime czasPoczatkowy = LocalTime.parse(scanner.nextLine());

        if (czasPoczatkowy.isBefore(Spotkanie.NAJWCZESNIEJ)) {
            System.out.println("Spotkanie nie może być wcześniej niż " + Spotkanie.NAJWCZESNIEJ);
            return;
        }

        System.out.println("Podaj godzinę zakończenia (HH:mm): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());

        System.out.println("Podaj priorytet (normalny, wysoki, najwyższy): ");
        String priorytet = scanner.nextLine();

        kalendarz.dodajSpotkanie(dzien, new Spotkanie(opis, czasPoczatkowy, czasZakonczenia, priorytet));
        System.out.println("Dodano spotkanie.");
    }

    private static void usunSpotkanie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj indeks spotkania do usunięcia: ");
        int indeks = scanner.nextInt();
        scanner.nextLine();
        kalendarz.usunSpotkanie(dzien, indeks);
        System.out.println("Usunięto spotkanie.");
    }

    private static void wyswietlSpotkaniaWDniu() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Spotkania w dniu " + dzien + ":");
        Predicate<Spotkanie> warunek = spotkanie -> true;
        wyswietlSpotkaniaWDniu(kalendarz.filtrujSpotkania(dzien, warunek));
    }

    private static void wyswietlSpotkaniaWDniuOPriorytecie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet (normalny, wysoki, najwyższy): ");
        String priorytet = scanner.nextLine();
        System.out.println("Spotkania o priorytecie " + priorytet + " w dniu " + dzien + ":");
        Predicate<Spotkanie> warunek = spotkanie -> spotkanie.getPriorytet().equals(priorytet);
        wyswietlSpotkaniaWDniu(kalendarz.filtrujSpotkania(dzien, warunek));
    }

    private static void wyswietlSpotkaniaPoCzasieWDniu() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzinę (HH:mm): ");
        LocalTime czas = LocalTime.parse(scanner.nextLine());
        System.out.println("Spotkania po godzinie " + czas + " w dniu " + dzien + ":");
        Predicate<Spotkanie> warunek = spotkanie -> !spotkanie.getCzasPoczatkowy().isBefore(czas);
        wyswietlSpotkaniaWDniu(kalendarz.filtrujSpotkania(dzien, warunek));
    }

    private static void wyswietlSpotkaniaWMarginesieCzasowymWDniu() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj godzinę początkową (HH:mm): ");
        LocalTime czasPoczatkowy = LocalTime.parse(scanner.nextLine());
        System.out.println("Podaj godzinę końcową (HH:mm): ");
        LocalTime czasKoncowy = LocalTime.parse(scanner.nextLine());
        System.out.println("Spotkania od godziny " + czasPoczatkowy + " do godziny " + czasKoncowy + " w dniu " + dzien + ":");
        Predicate<Spotkanie> warunek = spotkanie
                -> !spotkanie.getCzasPoczatkowy().isBefore(czasPoczatkowy) && !spotkanie.getCzasZakonczenia().isAfter(czasKoncowy);
        wyswietlSpotkaniaWDniu(kalendarz.filtrujSpotkania(dzien, warunek));
    }

    private static void wyswietlSpotkaniaPriorytetICzasWDniu() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet (normalny, wysoki, najwyższy): ");
        String priorytet = scanner.nextLine();
        System.out.println("Podaj godzinę (HH:mm): ");
        LocalTime czas = LocalTime.parse(scanner.nextLine());
        System.out.println("Spotkania o priorytecie " + priorytet + " od godziny " + czas + " w dniu " + dzien + ":");
        Predicate<Spotkanie> warunek = spotkanie
                -> spotkanie.getPriorytet().equals(priorytet) && !spotkanie.getCzasPoczatkowy().isBefore(czas);
        wyswietlSpotkaniaWDniu(kalendarz.filtrujSpotkania(dzien, warunek));
    }

    private static void wyswietlSpotkaniaWDniu(ArrayList<Spotkanie> spotkania) {
        if (spotkania.isEmpty()) {
            System.out.println("Brak spotkań.");
        } else {
            spotkania.forEach(System.out::println);
        }
    }

    private static void przykladoweSpotkania() {
        kalendarz.dodajSpotkanie(DayOfWeek.MONDAY.getValue(), new Spotkanie("Spotkanie 1", LocalTime.of(9, 0), LocalTime.of(10, 0), "normalny"));
        kalendarz.dodajSpotkanie(DayOfWeek.MONDAY.getValue(), new Spotkanie("Spotkanie 2", LocalTime.of(12, 0), LocalTime.of(14, 0), "wysoki"));
        kalendarz.dodajSpotkanie(DayOfWeek.MONDAY.getValue(), new Spotkanie("Spotkanie 3", LocalTime.of(15, 0), LocalTime.of(16, 0), "normalny"));
        kalendarz.dodajSpotkanie(DayOfWeek.TUESDAY.getValue(), new Spotkanie("Spotkanie 4", LocalTime.of(9, 0), LocalTime.of(10, 0), "najwyższy"));
        kalendarz.dodajSpotkanie(DayOfWeek.TUESDAY.getValue(), new Spotkanie("Spotkanie 5", LocalTime.of(11, 0), LocalTime.of(12, 0), "najwyższy"));
        kalendarz.dodajSpotkanie(DayOfWeek.WEDNESDAY.getValue(), new Spotkanie("Spotkanie 6", LocalTime.of(15, 0), LocalTime.of(16, 0), "normalny"));
        kalendarz.dodajSpotkanie(DayOfWeek.WEDNESDAY.getValue(), new Spotkanie("Spotkanie 7", LocalTime.of(18, 0), LocalTime.of(19, 0), "normalny"));
    }

    public static Kalendarz getKalendarz() {
        return kalendarz;
    }

    public static void setKalendarz(Kalendarz kalendarz) {
        Main.kalendarz = kalendarz;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Main.scanner = scanner;
    }
}
