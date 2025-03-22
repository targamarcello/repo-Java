package Negozio;

abstract public class ProdottoElettronico {
    protected String codice;
    protected String marca;
    protected double prezzo;

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

    @Override
    public String toString(){
        return String.format("Codice prodotto: %s - Marca: %s - Prezzo: %d",codice,marca,prezzo);
    }
    @Override
    public boolean equals(Object o){
        ProdottoElettronico p;
        if(!(o instanceof ProdottoElettronico prod)) return false;
        p = (ProdottoElettronico)o;
        return p.codice.equals(codice);
    }

}
