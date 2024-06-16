import java.time.LocalDate;

public abstract class Oferta {
    protected String ulica;
    protected int numerDomu;
    protected String miejscowosc;
    protected String kodPocztowy;
    protected double powierzchnia;
    protected double cena;
    protected LocalDate dataObowiazywaniaOferty;

    public Oferta(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia, double cena, LocalDate dataObowiazywaniaOferty) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywaniaOferty = dataObowiazywaniaOferty;
    }

    public boolean isOfertaAktualna() {
        return LocalDate.now().isBefore(dataObowiazywaniaOferty) || LocalDate.now().isEqual(dataObowiazywaniaOferty);
    }

    @Override
    public String toString() {
        return String.format("Adres: %s %d, %s, %s\nPowierzchnia: %.2f m2\nCena: %.2f PLN\nOferta ważna do: %s", ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
    }
}
