package Negozio.Prodotti;
/**
 * @author Marcello Targa
 * @version 1.0
 * @since 31/032025
 */
abstract public class ProdottoElettronico implements Prodotto{
    protected String codice;
    protected String marca;
    protected double prezzo;

    /**
     * Classe astratta per definire un oggetto prodotto elettronico e gestirlo
     * @param prezzo
     * @param marca
     * @param codice
     */
    public ProdottoElettronico(double prezzo, String marca, String codice) {
        this.prezzo = prezzo;
        this.marca = marca;
        this.codice = codice;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCodice() {
        return codice;
    }

    public void setPrezzo(double prezzo) throws Exception {
        if(prezzo<=0){
            throw new Exception("Il prezzo deve essere positivo....");
        }
        this.prezzo = prezzo;
    }

    /**
     *
     * @return Stringa di visualizzazione
     */
    @Override
    public String toString(){
        return String.format("Codice prodotto: %s - Marca: %s - Prezzo: %d",codice,marca,prezzo);
    }

    /**
     *
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        ProdottoElettronico p;
        if(!(o instanceof ProdottoElettronico prod)) return false;
        p = (ProdottoElettronico)o;
        return p.codice.equals(codice);
    }

}
