package Garapkg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Classe che rappresenta una Gara
public class Gara {
    private String _nome;                     // Nome della gara
    private String _nazione;                  // Nazione in cui si svolge la gara
    private ArrayList<Scuderia> _griglia;     // Lista delle scuderie partecipanti
    private String _vincitore;                // Nome della scuderia vincitrice

    // Costruttore della classe Gara
    public Gara(String nome, String nazione) {
        _nome = nome;                         // Inizializza il nome della gara
        _nazione = nazione;                   // Inizializza la nazione
        _griglia = new ArrayList<>();         // Inizializza la lista delle scuderie come vuota
    }

    // Getter per il nome della gara
    public String getNome() {
        return _nome;
    }

    // Getter per la nazione della gara
    public String getNazione() {
        return _nazione;
    }

    // Getter per la lista delle scuderie partecipanti
    public ArrayList<Scuderia> getGriglia() {
        return _griglia;
    }

    // Getter per il vincitore della gara
    public String getVincitore() {
        return _vincitore;
    }

    // Metodo per aggiungere una scuderia alla griglia
    public void addScuderia(Scuderia scud) {
        _griglia.add(scud);                   // Aggiunge la scuderia alla lista
    }
}
