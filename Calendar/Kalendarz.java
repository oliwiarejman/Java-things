
import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {

    private final ArrayList<ArrayList<Spotkanie>> kalendarz;

    public Kalendarz() {
        kalendarz = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            kalendarz.add(new ArrayList<>());
        }
    }

    public void dodajSpotkanie(int dzien, Spotkanie spotkanie) {
        while (kalendarz.size() <= dzien) {
            kalendarz.add(new ArrayList<>());
        }
        kalendarz.get(dzien).add(spotkanie);
    }

    public void usunSpotkanie(int dzien, int index) {
        kalendarz.get(dzien).remove(index);
    }

    public ArrayList<Spotkanie> filtrujSpotkania(int dzien, Predicate<Spotkanie> warunek) {
        ArrayList<Spotkanie> spelniajaceWarunek = new ArrayList<>();
        for (Spotkanie spotkanie : kalendarz.get(dzien)) {
            if (warunek.test(spotkanie)) {
                spelniajaceWarunek.add(spotkanie);
            }
        }
        return spelniajaceWarunek;
    }
}
