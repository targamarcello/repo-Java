package BackEnd.Libri;

public class Thriller extends Libro{
    public boolean serieTV;

    public Thriller(String autore, String titolo, int nPagine, boolean serieTV) {
        super(autore, titolo, nPagine);
        this.serieTV = serieTV;
    }
    @Override
    public String toString() {
        return super.toString() + "\nDerivato da una serie TV: " + serieTV;
    }
}
