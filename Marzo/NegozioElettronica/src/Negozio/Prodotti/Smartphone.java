package Negozio.Prodotti;

import java.util.concurrent.ExecutionException;

/**
 * @author Marcello Targa
 * @version 1.0
 * @since 31/032025
 */
public class Smartphone extends ProdottoElettronico {
    private String modello;
    private int memoria;

    /**
     *
     * @param prezzo
     * @param marca
     * @param codice
     * @param modello
     * @param memoria
     * @throws Exception IllegalArgumentException
     */
    public Smartphone(double prezzo, String marca, String codice, String modello, int memoria) throws Exception {
        super(prezzo, marca, codice);
        this.modello = modello;
        if(memoria <=0){
            throw new IllegalArgumentException("Le memoria deve essere positiva...");
        }
        this.memoria = memoria;
    }

    public String getModello() {
        return modello;
    }

    public int getMemoria() {
        return memoria;
    }

    /**
     *
     * @return Stringa di visualizzazione
     */
    @Override
    public String toString(){
        return super.toString() + String.format(" - Modello: %s - Memoria: %d",modello,memoria);
    }

}
