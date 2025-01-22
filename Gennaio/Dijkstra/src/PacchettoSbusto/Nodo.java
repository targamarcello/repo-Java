package PacchettoSbusto;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    public  String _hostname;
    public boolean _stato;
    public int _indice;
    public String _classe;
    public List<Nodo> _collegamenti;

    public Nodo(String hostname, int indice, String classe){
        _hostname = hostname;
        _stato = false;
        _indice = indice;
        _classe = classe;
        _collegamenti = new ArrayList<>();
    }
    public void aggiungiCollegamento(Nodo nodone){
        if(!_collegamenti.contains(nodone)){
            _collegamenti.add(nodone);
        }
    }
    @Override
    public String toString(){
        return String.format("Nodo {hostname = %s, indice = %d, classe = %s}\n",_hostname,_indice,_classe);
    }
}
