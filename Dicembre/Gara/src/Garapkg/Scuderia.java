package Garapkg;

// Classe che rappresenta una Scuderia e implementa l'interfaccia Comparable
public class Scuderia implements Comparable<Scuderia> {
    private String _scuderia; // Nome della scuderia
    private Pilota _pilota; // Pilota associato alla scuderia
    private int _numAuto; // Numero dell'auto della scuderia
    private Integer _tGiro = 0; // Tempo di giro in secondi

    // Costruttore della classe Scuderia
    public Scuderia(String scuderia, Pilota pilota, int numAuto) throws Exception {
        // Controlla che il nome della scuderia sia valido
        if (scuderia == null || scuderia.trim().isEmpty()) {
            throw new Exception("La scuderia è vuota o nulla.");
        }
        _scuderia = scuderia;
        _pilota = pilota;
        _numAuto = numAuto;
    }

    // Getter per il nome della scuderia
    public String getScuderia() {
        return _scuderia;
    }

    // Getter per il pilota associato
    public Pilota getPilota() {
        return _pilota;
    }

    // Getter per il numero dell'auto
    public int getNumAuto() {
        return _numAuto;
    }

    // Getter per il tempo di giro
    public int getTGiro() {
        return _tGiro;
    }

    // Setter per il tempo di giro
    public void setTGiro(int tGiro) {
        _tGiro = tGiro;
    }

    // Metodo equals per verificare se due oggetti Scuderia sono uguali
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Controlla se è lo stesso oggetto
        if (obj == null || getClass() != obj.getClass()) return false; // Controlla la classe
        Scuderia scuderia = (Scuderia) obj;
        return _numAuto == scuderia._numAuto && // Confronta numero auto
                _scuderia.equals(scuderia._scuderia) && // Confronta il nome della scuderia
                _pilota.equals(scuderia._pilota); // Confronta il pilota
    }

    // Metodo compareTo per confrontare i tempi di giro delle scuderie
    @Override
    public int compareTo(Scuderia s) {
        return Integer.compare(this._tGiro, s._tGiro); // Ordina in base al tempo di giro
    }

    // Metodo toString per rappresentare la scuderia come stringa
    @Override
    public String toString() {
        return String.format("Scuderia: %s - Pilota: %s - Numero Auto: %d\n",
                _scuderia, _pilota.toString(), _numAuto); // Usa toString del pilota per dettagli
    }
}
