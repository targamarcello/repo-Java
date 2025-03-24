package Negozio.Prodotti;

public abstract class Libro implements Prodotto{
    private String nome;
    private String descrizione;
    private String autore;
    private final String ISBN;
    private double prezzo;
    private int quantita;


    public Libro(String nome, String descrizione, String autore, String ISBN, double prezzo, int quantita) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.autore = autore;
        this.ISBN = ISBN;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object o){
        Libro l;
        if(!(o instanceof Libro lib)) return false;
        l = (Libro) o;
        return l.ISBN.equals(ISBN);
    }

    @Override
    public String toString(){
        return String.format("Titolo libro: %s - Descrizione: %s - Autore: %s - Codice ISBN: %s - Prezzo: %.2f - Quantità: %d",nome,descrizione,autore,ISBN, prezzo, quantita);
    }

}
