
import java.util.ArrayList;
import java.util.function.Predicate;

public class ListaOfert {

    private final ArrayList<Oferta> oferty = new ArrayList<>();

    public void dodajOferte(Oferta oferta) {
        oferty.add(oferta);
    }

    public ArrayList<Oferta> filtrujOferty(Predicate<Oferta> warunek) {
        ArrayList<Oferta> spelniajaceWarunek = new ArrayList<>();
        for (Oferta oferta : oferty) {
            if (warunek.test(oferta)) {
                spelniajaceWarunek.add(oferta);
            }
        }
        return spelniajaceWarunek;
    }

    public void wyswietlOferty(ArrayList<Oferta> oferty) {
        if (oferty.isEmpty()) {
            System.out.println("Brak ofert spełniających kryteria.");
        } else {
            for (Oferta oferta : oferty) {
                System.out.println(oferta + "\n");
            }
        }
    }
}
