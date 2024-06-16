
import java.time.LocalTime;

public class Spotkanie extends Wydarzenie {

    private final String priorytet;

    public Spotkanie(LocalTime czasPoczatkowy, LocalTime czasZakonczenia, String opis, String priorytet) {
        super(czasPoczatkowy, czasZakonczenia, opis);
        this.priorytet = priorytet;
    }

    public String getPriorytet() {
        return priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie{"
                + "opis='" + getOpis() + '\''
                + ", czasPoczatkowy=" + getCzasPoczatkowy()
                + ", czasZakonczenia=" + getCzasZakonczenia()
                + ", priorytet='" + priorytet + '\''
                + '}';
    }
}
