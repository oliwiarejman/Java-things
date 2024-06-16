
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    private static Kalendarz kalendarz = new Kalendarz();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Program - Kalendarz tygodniowy zadań i spotkań");
        przykladoweWydarzenia();
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
                    dodajZadanie();
                case '3' ->
                    usunSpotkanie();
                case '4' ->
                    usunZadanie();
                case '5' ->
                    wyswietlSpotkaniaWDniu();
                case '6' ->
                    wyswietlZadaniaWDniu();
                case '7' ->
                    wyswietlSpotkaniaWDniuOPriorytecie();
                case '8' ->
                    wyswietlZadaniaWDniuOStatusie();
                case '9' ->
                    wyswietlSpotkaniaWDniuOPriorytecieICzasie();
                case '0' ->
                    wyswietlZadaniaWDniuOStatusieICzasie();
                case 'x' ->
                    System.out.println("Koniec programu.");
                default ->
                    System.out.println("Niepoprawna opcja");
            }
        } while (option != 'x');
    }

    private static void wyswietlMenu() {
        System.out.println("1. Dodaj spotkanie na wybrany dzień.");
        System.out.println("2. Dodaj zadanie na wybrany dzień.");
        System.out.println("3. Usuń wybrane spotkanie z dnia.");
        System.out.println("4. Usuń wybrane zadanie z dnia.");
        System.out.println("5. Wyświetl wszystkie spotkania z wybranego dnia.");
        System.out.println("6. Wyświetl wszystkie zadania z wybranego dnia.");
        System.out.println("7. Wyświetl spotkania z danego dnia o wybranym priorytecie.");
        System.out.println("8. Wyświetl zadania z danego dnia o wybranym statusie.");
        System.out.println("9. Wyświetl spotkania z danego dnia o wybranym priorytecie i zaczynające się nie wcześniej niż od podanego czasu.");
        System.out.println("0. Wyświetl zadania z danego dnia o wybranym statusie i kończące się nie później niż do podanego czasu.");
        System.out.println("x. Wyjście z programu.");
    }

    private static void dodajSpotkanie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis spotkania: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia (HH:mm): ");
        LocalTime czasPoczatkowy = LocalTime.parse(scanner.nextLine());
        System.out.println("Podaj godzinę zakończenia (HH:mm): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());
        System.out.println("Podaj priorytet (normalny, wysoki, najwyższy): ");
        String priorytet = scanner.nextLine();
        kalendarz.dodajWydarzenie(dzien, new Spotkanie(czasPoczatkowy, czasZakonczenia, opis, priorytet));
        System.out.println("Dodano spotkanie.");
    }

    private static void dodajZadanie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj opis zadania: ");
        String opis = scanner.nextLine();
        System.out.println("Podaj godzinę rozpoczęcia (HH:mm): ");
        LocalTime czasPoczatkowy = LocalTime.parse(scanner.nextLine());
        System.out.println("Podaj godzinę zakończenia (HH:mm): ");
        LocalTime czasZakonczenia = LocalTime.parse(scanner.nextLine());
        System.out.println("Podaj status (planowane, potwierdzone, realizowane, wykonane): ");
        String status = scanner.nextLine();
        kalendarz.dodajWydarzenie(dzien, new Zadanie(czasPoczatkowy, czasZakonczenia, opis, status));
        System.out.println("Dodano zadanie.");
    }

    private static void usunSpotkanie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj indeks spotkania do usunięcia: ");
        int indeks = scanner.nextInt();
        scanner.nextLine();
        kalendarz.usunSpotkanie(dzien, indeks);
    }

    private static void usunZadanie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj indeks zadania do usunięcia: ");
        int indeks = scanner.nextInt();
        scanner.nextLine();
        kalendarz.usunZadanie(dzien, indeks);
    }

    private static void wyswietlSpotkaniaWDniu() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Spotkania w dniu " + dzien + ":");
        Predicate<Wydarzenie> warunek = wydarzenie -> wydarzenie instanceof Spotkanie;
        wyswietlWydarzeniaWDniu(kalendarz.filtrujWydarzenia(dzien, warunek));
    }

    private static void wyswietlZadaniaWDniu() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Zadania w dniu " + dzien + ":");
        Predicate<Wydarzenie> warunek = wydarzenie -> wydarzenie instanceof Zadanie;
        wyswietlWydarzeniaWDniu(kalendarz.filtrujWydarzenia(dzien, warunek));
    }

    private static void wyswietlSpotkaniaWDniuOPriorytecie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet (normalny, wysoki, najwyższy): ");
        String priorytet = scanner.nextLine();
        System.out.println("Spotkania o priorytecie " + priorytet + " w dniu " + dzien + ":");
        Predicate<Wydarzenie> warunek = event -> event instanceof Spotkanie && ((Spotkanie) event).getPriorytet().equalsIgnoreCase(priorytet);
        wyswietlWydarzeniaWDniu(kalendarz.filtrujWydarzenia(dzien, warunek));
    }

    private static void wyswietlZadaniaWDniuOStatusie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj status (planowane, potwierdzone, realizowane, wykonane): ");
        String status = scanner.nextLine();
        System.out.println("Zadania o statusie " + status + " w dniu " + dzien + ":");
        Predicate<Wydarzenie> warunek = event -> event instanceof Zadanie && ((Zadanie) event).getStatus().equalsIgnoreCase(status);
        wyswietlWydarzeniaWDniu(kalendarz.filtrujWydarzenia(dzien, warunek));
    }

    private static void wyswietlSpotkaniaWDniuOPriorytecieICzasie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj priorytet (normalny, wysoki, najwyższy): ");
        String priorytet = scanner.nextLine();
        System.out.println("Podaj godzinę (HH:mm): ");
        LocalTime czas = LocalTime.parse(scanner.nextLine());
        System.out.println("Spotkania o priorytecie " + priorytet + " w dniu " + dzien + " zaczynające się po godzinie " + czas + ":");
        Predicate<Wydarzenie> warunek = event -> event instanceof Spotkanie && ((Spotkanie) event).getPriorytet().equalsIgnoreCase(priorytet) && ((Spotkanie) event).getCzasPoczatkowy().compareTo(czas) >= 0;
        wyswietlWydarzeniaWDniu(kalendarz.filtrujWydarzenia(dzien, warunek));
    }

    private static void wyswietlZadaniaWDniuOStatusieICzasie() {
        System.out.println("Podaj dzień (1-7): ");
        int dzien = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj status (planowane, potwierdzone, realizowane, wykonane): ");
        String status = scanner.nextLine();
        System.out.println("Podaj godzinę (HH:mm): ");
        LocalTime czas = LocalTime.parse(scanner.nextLine());
        System.out.println("Zadania o statusie " + status + " w dniu " + dzien + " zakończone przed godziną " + czas + ":");
        Predicate<Wydarzenie> warunek = event -> event instanceof Zadanie && ((Zadanie) event).getStatus().equalsIgnoreCase(status) && ((Zadanie) event).getCzasZakonczenia().compareTo(czas) <= 0;
        wyswietlWydarzeniaWDniu(kalendarz.filtrujWydarzenia(dzien, warunek));
    }

    private static void wyswietlWydarzeniaWDniu(ArrayList<Wydarzenie> wydarzenia) {
        if (wydarzenia.isEmpty()) {
            System.out.println("Brak wydarzeń w danym dniu.");
        } else {
            for (Wydarzenie wydarzenie : wydarzenia) {
                System.out.println(wydarzenie);
            }
        }
    }

    private static void przykladoweWydarzenia() {
        kalendarz.dodajWydarzenie(1, new Spotkanie(LocalTime.of(9, 0), LocalTime.of(10, 30), "Spotkanie z klientem A", "normalny"));
        kalendarz.dodajWydarzenie(2, new Zadanie(LocalTime.of(11, 0), LocalTime.of(12, 30), "Przygotowanie raportu", "planowane"));
        kalendarz.dodajWydarzenie(3, new Spotkanie(LocalTime.of(13, 0), LocalTime.of(14, 30), "Spotkanie z klientem B", "normalny"));
        kalendarz.dodajWydarzenie(3, new Zadanie(LocalTime.of(15, 0), LocalTime.of(16, 30), "Testowanie nowej funkcji", "potwierdzone"));
        kalendarz.dodajWydarzenie(4, new Spotkanie(LocalTime.of(10, 0), LocalTime.of(11, 30), "Spotkanie z klientem C", "najwyższy"));
        kalendarz.dodajWydarzenie(4, new Zadanie(LocalTime.of(12, 0), LocalTime.of(13, 30), "Przygotowanie prezentacji", "wykonane"));
        kalendarz.dodajWydarzenie(5, new Spotkanie(LocalTime.of(14, 0), LocalTime.of(15, 30), "Spotkanie z działem IT", "wysoki"));
        kalendarz.dodajWydarzenie(5, new Zadanie(LocalTime.of(16, 0), LocalTime.of(17, 30), "Analiza danych", "planowane"));
        kalendarz.dodajWydarzenie(6, new Spotkanie(LocalTime.of(9, 0), LocalTime.of(10, 30), "Spotkanie z HR", "normalny"));
        kalendarz.dodajWydarzenie(6, new Zadanie(LocalTime.of(11, 0), LocalTime.of(12, 30), "Przygotowanie harmonogramu", "planowane"));
        kalendarz.dodajWydarzenie(7, new Spotkanie(LocalTime.of(13, 0), LocalTime.of(14, 30), "Spotkanie z zespołem projektowym", "wysoki"));
        kalendarz.dodajWydarzenie(7, new Zadanie(LocalTime.of(15, 0), LocalTime.of(16, 30), "Opracowanie dokumentacji", "planowane"));
        kalendarz.dodajWydarzenie(1, new Spotkanie(LocalTime.of(10, 0), LocalTime.of(11, 30), "Rozmowa kwalifikacyjna", "wysoki"));
        kalendarz.dodajWydarzenie(2, new Zadanie(LocalTime.of(12, 0), LocalTime.of(13, 30), "Testowanie aplikacji", "realizowane"));
        kalendarz.dodajWydarzenie(3, new Spotkanie(LocalTime.of(14, 0), LocalTime.of(15, 30), "Konferencja online", "najwyższy"));
        kalendarz.dodajWydarzenie(4, new Zadanie(LocalTime.of(16, 0), LocalTime.of(17, 30), "Rozwiązanie błędów", "wykonane"));
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
