
import java.time.LocalDate;

public final class Dom extends Oferta {

    private final double powierzchniaDzialki;

    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena, LocalDate dataObowiazywaniaOferty, double powierzchniaDzialki) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }

    @Override
    public String toString() {
        return super.toString() + ", Powierzchnia działki: " + powierzchniaDzialki;
    }
}
