package Negozio;

import Eccezioni.EccezioneProdotto;
import Eccezioni.EccezioneProdottoNonTrovato;
import Negozio.Prodotti.Prodotto;
import Negozio.Prodotti.ProdottoElettronico;

import java.util.ArrayList;

public class GestioneNegozio {
    private int numeroProdotti;
    private int maxProdotti;
    private ArrayList<Prodotto> inventario = new ArrayList<>();

    public GestioneNegozio(int max) {
        this.maxProdotti = max;
    }

    public ArrayList<Prodotto> getInventario() {
        return inventario;
    }

    public void addProdotto(Prodotto prod) {
        if (prod != null && !inventario.contains(prod)) {
            inventario.add(prod);
            numeroProdotti++;
        } else {
            throw new EccezioneProdotto("Prodotto già presente...");
        }
    }

    public void removeProdotto(ProdottoElettronico prod) {
        if (prod != null && inventario.contains(prod)) {
            inventario.remove(prod);
            numeroProdotti--;
        } else {
            throw new EccezioneProdottoNonTrovato("Prodotto con codice " + prod.getCodice() + " non trovato...");
        }
    }

    public boolean checkSpace() throws Exception {
        boolean pieno = true;
        if (numeroProdotti == maxProdotti) {
            throw new Exception("Inventario pieno...");
        } else {
            return false;
        }
    }
}
