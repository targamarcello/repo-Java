package Negozio.Prodotti;

public class Manuale extends Libro {
    private String argomento;

    public Manuale(String nome, String descrizione, String autore, String ISBN, double prezzo, int quantita, String argomento) {
        super(nome, descrizione, autore, ISBN, prezzo, quantita);
        this.argomento = argomento;
    }

    public String getArgomento() {
        return argomento;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" - Argomento: %s", argomento);
    }

}
