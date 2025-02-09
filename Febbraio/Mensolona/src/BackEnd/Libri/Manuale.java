package BackEnd.Libri;

import java.util.ListResourceBundle;

public class Manuale extends Libro {
    private String argomento;
    private Livello livello;

    public Manuale(String autore, String titolo, int nPagine, String argomento, Livello livello) {
        super(autore, titolo, nPagine);
        this.argomento = argomento;
        this.livello = livello;
    }
    @Override
    public String toString() {
        return super.toString() + "\nArgomento: " + argomento + "\nLivello: " + livello;
    }
}
