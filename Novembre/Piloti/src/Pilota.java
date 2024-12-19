import java.util.ArrayList;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    private static ArrayList<Pilota> pilotiEsistenti = new ArrayList<>();

    public Pilota(String nome, String cognome, String nazionalita, int eta) throws Exception {
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Il nome è vuoto o nullo.");
        }
        if (cognome == null || cognome.trim().isEmpty()) {
            throw new Exception("Il cognome è vuoto o nullo.");
        }
        if (nazionalita == null || nazionalita.trim().isEmpty()) {
            throw new Exception("La nazionalità è vuota o nulla.");
        }
        if (eta <= 0) {
            throw new Exception("L'età deve essere maggiore di zero.");
        }

        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.eta = eta;
        if (pilotaEsiste(this)) {
            throw new Exception("Pilota già esistente ");
        }

        pilotiEsistenti.add(this);
    }

    private boolean pilotaEsiste(Pilota p) {
        for (Pilota pilota : pilotiEsistenti) {
            if (pilota.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public String getNazionalita() {return nazionalita;}

    public String getCognome() {return cognome;}

    public int getEta() {return eta;}

    public String getNome() {return nome;}

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Cognome: %s - Nazionalità: %s - Età: %d\n",nome,cognome,nazionalita,eta);
    }
}
