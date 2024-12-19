package Garapkg;

// Classe che rappresenta un Pilota
public class Pilota {

    private String nome;        // Nome del pilota
    private String cognome;     // Cognome del pilota
    private String nazionalità; // Nazionalità del pilota

    // Costruttore che inizializza un Pilota
    public Pilota(String nome, String cognome, String nazionalità) throws Exception {
        // Verifica che tutti i parametri siano validi
        if (isValue(nome) && isValue(cognome) && isValue(nazionalità)) {
            this.nome = nome;
            this.cognome = cognome;
            this.nazionalità = nazionalità;
        } else {
            throw new Exception("Invalid data"); // Lancia un'eccezione se i dati sono invalidi
        }
    }

    // Getter per il nome del pilota
    public String getNome() {
        return nome;
    }

    // Getter per il cognome del pilota
    public String getCognome() {
        return cognome;
    }

    // Getter per la nazionalità del pilota
    public String getNazionalità() {
        return nazionalità;
    }

    // Setter per aggiornare la nazionalità del pilota
    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    // Metodo toString per rappresentare il pilota come stringa
    @Override
    public String toString() {
        return String.format("Nome: %s, Cognome: %s, Nazionalità: %s", nome, cognome, nazionalità);
    }

    // Metodo equals per confrontare due oggetti Pilota
    @Override
    public boolean equals(Object obj) {
        // Controlla se l'oggetto è dello stesso tipo
        if (!(obj instanceof Pilota)) {
            return false;
        } else {
            Pilota p = (Pilota) obj; // Cast dell'oggetto
            // Confronta nome, cognome e nazionalità
            return this.nome.equals(p.nome) && this.cognome.equals(p.cognome) && this.nazionalità.equals(p.nazionalità);
        }
    }

    // Metodo privato per validare i valori di input
    private boolean isValue(String valore) {
        // Ritorna true se il valore non è null e non è vuoto
        return valore != null && !valore.isEmpty();
    }
}
