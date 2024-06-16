
import java.time.LocalTime;

public class Zadanie extends Wydarzenie {

    private final String status;

    public Zadanie(LocalTime czasPoczatkowy, LocalTime czasZakonczenia, String opis, String status) {
        super(czasPoczatkowy, czasZakonczenia, opis);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Zadanie{"
                + "opis='" + getOpis() + '\''
                + ", czasPoczatkowy=" + getCzasPoczatkowy()
                + ", czasZakonczenia=" + getCzasZakonczenia()
                + ", status='" + status + '\''
                + '}';
    }
}
