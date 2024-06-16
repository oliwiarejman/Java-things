
import java.time.LocalTime;

public class Spotkanie {

    private final String opis;
    private final LocalTime czasPoczatkowy;
    private final LocalTime czasZakonczenia;
    private final String priorytet;

    public static final LocalTime NAJWCZESNIEJ = LocalTime.of(8, 0);

    public Spotkanie(String opis, LocalTime czasPoczatkowy, LocalTime czasZakonczenia, String priorytet) {
        this.opis = opis;
        this.czasPoczatkowy = czasPoczatkowy;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = priorytet;

    }

    public String getOpis() {
        return opis;
    }

    public LocalTime getCzasPoczatkowy() {
        return czasPoczatkowy;
    }

    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public String getPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie{"
                + "opis='" + opis + '\''
                + ", czasPoczatkowy=" + czasPoczatkowy
                + ", czasZakonczenia=" + czasZakonczenia
                + ", priorytet='" + priorytet + '\''
                + '}';
    }
}
