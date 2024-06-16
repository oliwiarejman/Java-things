
import java.time.LocalDate;

public final class Mieszkanie extends Oferta {

    private final int numerMieszkania;
    private final int numerPietra;

    public Mieszkanie(String ulica, int numerDomu, int numerMieszkania, String miejscowosc, String kodPocztowy, double powierzchnia, int numerPietra, double cena, LocalDate dataObowiazywaniaOferty) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }

    public int getNumerPietra() {
        return numerPietra;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numer mieszkania: " + numerMieszkania + ", Numer piętra: " + numerPietra;
    }
}
