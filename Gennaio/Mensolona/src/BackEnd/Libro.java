package BackEnd;

import java.util.Objects;

public class Libro {
    private String _autore;
    private String _titolo;
    private int _nPagine;
    private final double costoPagina = 0.5;
    public Libro(String autore, String titolo, int nPagine){
        _autore = autore;
        _titolo = titolo;
        _nPagine = nPagine;
    }
    public Libro(Libro l){
        _autore = l.getAutore();
        _titolo = l.getTitolo();
        _nPagine = l.getnPagine();
    }

    public String getAutore() {
        return _autore;
    }

    public String getTitolo() {
        return _titolo;
    }

    public int getnPagine() {
        return _nPagine;
    }
    @Override
    public String toString(){
        return String.format("Autore: %s - Titolo: %s - Numero Pagine: %d - Costo: %d\n",_autore,_titolo,_nPagine,costoPagina);
    }

    @Override
    public boolean equals(Object o) {
        Libro book;
        if(!(o instanceof Libro lib)) return false;
        book=(Libro) o;
        return book._autore.equals(_autore) && book._titolo.equals(_titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_autore, _titolo, _nPagine, costoPagina);
    }
}
