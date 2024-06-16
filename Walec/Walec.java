
public class Walec {

    private double promienPodstawy;
    private double wysokosc;

    public Walec(double promienPodstawy, double wysokosc) {
        this.promienPodstawy = promienPodstawy;
        this.wysokosc = wysokosc;
    }

    public Walec() {

    }

    public void ustawPromien(double promienPodstawy) {
        this.promienPodstawy = promienPodstawy;
    }

    public void ustawWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double pobierzPromien() {
        return promienPodstawy;
    }

    public double pobierzWysokosc() {
        return wysokosc;
    }

    public double obliczPolePowierzchniPodstawy() {
        return Math.PI * Math.pow(promienPodstawy, 2);
    }

    public double obliczPolePowierzchniBocznej() {
        return 2 * Math.PI * promienPodstawy * wysokosc;
    }

    public double obliczPolePowierzchniCalkowitej() {
        return 2 * obliczPolePowierzchniPodstawy() + obliczPolePowierzchniBocznej();
    }

    public double obliczObjetosc() {
        return obliczPolePowierzchniPodstawy() * wysokosc;
    }
}
