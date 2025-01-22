package PacchettoSbusto;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
    protected List<Nodo> _nodi;
    protected List<Arco> _archi;
    public Grafo(){
        _nodi = new ArrayList<>();
        _archi = new ArrayList<>();
    }
    public Nodo aggiungiNodo(String hostname, int indice, String classe){
        for(Nodo nodo: _nodi){
            if(nodo._hostname.equals(hostname)){
                return nodo;
            }
        }
        Nodo nuovoModo = new Nodo(hostname,indice,classe);
        _nodi.add(nuovoModo);
        return nuovoModo;
    }
    public void aggiungiArco(String da, String a, int costo) throws Exception {
        Nodo nodoDa = trovaNodo(da);
        Nodo nodoA = trovaNodo(a);
        _archi.add(new Arco(nodoDa,nodoA,costo));
    }
    public Nodo trovaNodo(String hostname) throws Exception {
        for(Nodo nodo: _nodi){
            if(nodo._hostname.equals(hostname)){
                return nodo;
            }
        }
        throw new Exception("Nodo non trovato, crudo"+hostname);
    }

    public List<Nodo> get_nodi() {
        return _nodi;
    }

    public List<Arco> get_archi() {
        return _archi;
    }
}
