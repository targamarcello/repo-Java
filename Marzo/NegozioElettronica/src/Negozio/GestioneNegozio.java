package Negozio;

import Eccezioni.EccezioneProdotto;
import Eccezioni.EccezioneProdottoNonTrovato;

import java.util.ArrayList;

public class GestioneNegozio {
    private int numeroProdotti;
    private int maxProdotti;
    private ArrayList<ProdottoElettronico> inventario = new ArrayList<>();

    public GestioneNegozio(int max){
        this.maxProdotti = max;
    }
    public ArrayList<ProdottoElettronico> getInventario(){
        return inventario;
    }
    public void addProdotto(ProdottoElettronico prod){
        if(prod != null && !inventario.contains(prod)){
            inventario.add(prod);
            numeroProdotti++;
        }else{
            throw new EccezioneProdotto("Prodotto con codice "+prod.getCodice() + " già presente...");
        }
    }

    public void modificaPrezzo(String codice, double prez) throws Exception {
        for(ProdottoElettronico p : inventario){
            if(p.getCodice().equals(codice)){
                p.setPrezzo(prez);
                return;
            }
        }
        throw new EccezioneProdottoNonTrovato("Prodotto con codice "+codice + " non trovato...");
    }

    public void removeProdotto(ProdottoElettronico prod){
        if(prod != null && inventario.contains(prod)){
            inventario.remove(prod);
            numeroProdotti--;
        }else{
            throw new EccezioneProdottoNonTrovato("Prodotto con codice "+prod.getCodice() + " non trovato...");
        }
    }
    public ProdottoElettronico cercaProdotto(String codice){
        for(ProdottoElettronico p : inventario){
            if(p.getCodice().equals(codice)){
                return p;
            }
        }
        throw new EccezioneProdottoNonTrovato("Prodotto con codice "+codice + " non trovato...");
    }
    public boolean checkSpace()throws Exception{
        boolean pieno = true;
        if(numeroProdotti == maxProdotti){
            throw new Exception("Inventario pieno...");
        }else{
            return false;
        }
    }
}
