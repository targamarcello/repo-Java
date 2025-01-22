package PacchettoSbusto;

public class Arco {
   public Nodo _origine;
   public Nodo _dest;
   public int _costo;
    public Arco(Nodo origine, Nodo dest, int costo){
        _origine = origine;
        _dest = dest;
        _costo = costo;
        origine.aggiungiCollegamento(dest);
    }
}
