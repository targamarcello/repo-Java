package Negozio;

import Eccezioni.EccezioneProdotto;
import Eccezioni.EccezioneProdottoNonTrovato;
import Negozio.Prodotti.Prodotto;
import Negozio.Prodotti.ProdottoElettronico;

import java.util.ArrayList;

/**
 * @author Marcello Targa
 * @version 1.0
 * @since 31/032025
 */
public class GestioneNegozio {
    private int numeroProdotti;
    private int maxProdotti;
    private ArrayList<Prodotto> inventario = new ArrayList<>();

    public GestioneNegozio(int max) {
        this.maxProdotti = max;
    }

    /**
     *
     * @return Copia di un ArrayList di tipo Prodotto
     */
    public ArrayList<Prodotto> getInventario() {
        return new ArrayList<Prodotto>(inventario);
    }

    /**
     * Metodo per aggiungere un oggetto di tipo Prodotto
     * @param prod
     * @throws Exception solleva eccezione personalizzata
     */
    public void addProdotto(Prodotto prod)throws Exception {
        if (prod != null && !inventario.contains(prod)) {
            inventario.add(prod);
            numeroProdotti++;
        } else {
            throw new EccezioneProdotto("Prodotto già presente...");
        }
    }

    /**
     *
     * @param prod
     * @throws Exception solleva eccezione personalizzata
     */
    public void removeProdotto(ProdottoElettronico prod) throws Exception {
        if (prod != null && inventario.contains(prod)) {
            inventario.remove(prod);
            numeroProdotti--;
        } else {
            throw new EccezioneProdottoNonTrovato("Prodotto con codice " + prod.getCodice() + " non trovato...");
        }
    }

    /**
     *
     * @return ritorna false se non è verificata la condizione
     * @throws Exception solleva eccezione personalizzata
     */
    public boolean checkSpace() throws Exception {
        if (numeroProdotti == maxProdotti) {
            throw new Exception("Inventario pieno...");
        }else{
            return false;
        }
    }
}
