
package Veicoli;

public class Veicolo {
    private final String marca;
    private String modello;
    private int prezzo;

    public Veicolo(String marca, String modello, int prezzo) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo){
        this.prezzo = prezzo;
    }
    @Override
    public boolean equals(Object obj){
        return this.marca.equals(marca) && this.modello.equals(modello);
    }
    @Override
    public String toString(){
        return String.format("Marca: %s - Modello: %s - Prezzo: %d ",marca,modello,prezzo);
    }
}
