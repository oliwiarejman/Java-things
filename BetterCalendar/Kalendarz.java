
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private final ArrayList<ArrayList<Wydarzenie>> kalendarz;

    public Kalendarz() {
        kalendarz = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            kalendarz.add(new ArrayList<>());
        }
    }

    public void dodajWydarzenie(int dzien, Wydarzenie wydarzenie) {
        while (kalendarz.size() <= dzien) {
            kalendarz.add(new ArrayList<>());
        }
        kalendarz.get(dzien).add(wydarzenie);
    }

    public void usunSpotkanie(int dzien, int indeks) {
        if (dzien >= 1 && dzien <= 7 && dzien < kalendarz.size()) {
            ArrayList<Wydarzenie> wydarzeniaWDniu = kalendarz.get(dzien);
            if (indeks >= 0 && indeks < wydarzeniaWDniu.size()) {
                wydarzeniaWDniu.remove(indeks);
                System.out.println("Usunięto spotkanie.");
            } else {
                System.out.println("Niepoprawny indeks spotkania.");
            }
        } else {
            System.out.println("Niepoprawny dzień.");
        }
    }

    public void usunZadanie(int dzien, int indeks) {
        if (dzien >= 1 && dzien <= 7 && dzien < kalendarz.size()) {
            ArrayList<Wydarzenie> wydarzeniaWDniu = kalendarz.get(dzien);
            if (indeks >= 0 && indeks < wydarzeniaWDniu.size()) {
                wydarzeniaWDniu.remove(indeks);
                System.out.println("Usunięto zadanie.");
            } else {
                System.out.println("Niepoprawny indeks zadania.");
            }
        } else {
            System.out.println("Niepoprawny dzień.");
        }
    }

    public ArrayList<Wydarzenie> filtrujWydarzenia(int dzien, Predicate<Wydarzenie> warunek) {
        ArrayList<Wydarzenie> spelniajaceWarunek = new ArrayList<>();
        for (Wydarzenie wydarzenie : kalendarz.get(dzien)) {
            if (warunek.test(wydarzenie)) {
                spelniajaceWarunek.add(wydarzenie);
            }
        }
        return spelniajaceWarunek;
    }
}
