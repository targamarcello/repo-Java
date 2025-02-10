
package Veicoli;

public class Moto extends Veicolo{
    private int cilindrata;

    public Moto(String marca, String modello, int prezzo, int cilindrata) {
        super(marca, modello, prezzo);
        this.cilindrata = cilindrata;
    }
    public int getCilindrata(){
        return cilindrata;
    }
    @Override
    public String toString(){
        return String.format(super.toString()+ "- Cilindrata: %d\n",cilindrata);
    }
}
