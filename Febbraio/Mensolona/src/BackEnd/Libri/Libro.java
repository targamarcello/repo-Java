
package BackEnd.Libri;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;

    private final double costoPagine = 0.05;


    public Libro(String autore, String titolo, int nPagine) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
    }

    public Libro(Libro l) {
        this.autore = l.autore;
        this.titolo = l.titolo;
        this.nPagine = l.nPagine;
    }


    public String getAutore() {
        return autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getnPagine() {
        return nPagine;
    }

    public double getCostoPagine() {
        return costoPagine;
    }

    @Override
    public boolean equals(Object o) {
        Libro book;
        if (!(o instanceof Libro libro)) return false;
        book = (Libro) o;
        return book.autore.equals(autore) && book.titolo.equals(titolo);
    }

    @Override
    public String toString() {
        return String.format("Autore: %s Titolo: %s Numero Pagine: %d Costo: %f", autore, titolo, nPagine, costoPagine * nPagine);
    }
    public String csv(){
        return String.format("%s; %s; %d; %s",autore,titolo,nPagine);
    }
}