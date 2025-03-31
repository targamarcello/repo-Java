package Negozio.Prodotti;
/**
 * @author Marcello Targa
 * @version 1.0
 * @since 31/032025
 */
public class Manuale extends Libro {
    private String argomento;

    /**
     *
     * @param nome
     * @param descrizione
     * @param autore
     * @param ISBN
     * @param prezzo
     * @param quantita
     * @param argomento
     */
    public Manuale(String nome, String descrizione, String autore, String ISBN, double prezzo, int quantita, String argomento) {
        super(nome, descrizione, autore, ISBN, prezzo, quantita);
        this.argomento = argomento;
    }

    public String getArgomento() {
        return argomento;
    }

    /**
     *
     * @return Stringa di visualizzazione
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" - Argomento: %s", argomento);
    }

}
