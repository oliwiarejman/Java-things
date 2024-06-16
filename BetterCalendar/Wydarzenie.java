
import java.time.LocalTime;

public abstract class Wydarzenie {

    private final LocalTime czasPoczatkowy;
    private final LocalTime czasZakonczenia;
    private final String opis;

    public Wydarzenie(LocalTime czasPoczatkowy, LocalTime czasZakonczenia, String opis) {
        this.czasPoczatkowy = czasPoczatkowy;
        this.czasZakonczenia = czasZakonczenia;
        this.opis = opis;
    }

    public LocalTime getCzasPoczatkowy() {
        return czasPoczatkowy;
    }

    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public String toString() {
        return "Wydarzenie{"
                + "czasPoczatkowy=" + czasPoczatkowy
                + ", czasZakonczenia=" + czasZakonczenia
                + ", opis='" + opis + '\''
                + '}';
    }
}
