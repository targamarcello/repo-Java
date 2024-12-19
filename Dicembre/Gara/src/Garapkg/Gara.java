package Garapkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gara {
    private String _nome;
    private String _nazione;
    private ArrayList<Scuderia> _griglia;
    private Cronometro _cronom;
    private String _vincitore;
    private int _nScuderie;

    public Gara(String nome, String nazione){
        _nome = nome;
        _nazione = nazione;
        _griglia = new ArrayList<>();
    }

    public String getNome(){return _nome;}
    public String getNazione(){return _nazione;}
    public ArrayList<Scuderia> getGriglia(){return _griglia;}
    public String getVincitore(){return _vincitore;}

    public void addScuderia(Scuderia scud){
        _griglia.add(scud);
    }

}