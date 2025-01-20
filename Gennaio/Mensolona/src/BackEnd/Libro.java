package BackEnd;

import java.util.Objects;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;

    private final double costoPagine = 0.05;

    Genere tipo;


    public Libro(String autore, String titolo, int nPagine, Genere tipo) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
        this.tipo = tipo;
    }

    public Libro(Libro l) {
        this.autore = l.autore;
        this.titolo = l.titolo;
        this.nPagine = l.nPagine;
        this.tipo = l.tipo;
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
    public int hashCode() {
        return Objects.hash(autore, titolo);
    }

    @Override
    public String toString() {
        return String.format("Autore: %s Titolo: %s Numero Pagine: %d Costo: %f", autore, titolo, nPagine, costoPagine * nPagine);
    }
    public String csv(){
        return String.format("%s; %s; %d; %s",autore,titolo,nPagine,tipo);
    }
}