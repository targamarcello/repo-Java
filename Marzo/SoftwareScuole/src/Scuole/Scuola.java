package Scuole;

public abstract class Scuola {
    protected String codice;
    protected String denominazione;
    protected String indirizzo;
    protected String citta;
    protected int numeroStudenti;
    protected int numeroClassi;
    protected int numeroSediAggiunte;
    protected int numeroLaboratori;

    public Scuola(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        this.codice = codice;
        this.denominazione = denominazione;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.numeroStudenti = numeroStudenti;
        this.numeroClassi = numeroClassi;
        this.numeroSediAggiunte = numeroSediAggiunte;
        this.numeroLaboratori = numeroLaboratori;
    }

    public String getCodice() {
        return codice;
    }

    abstract double calcoloContributo();

    @Override
    public String toString(){
        return String.format("Codice: %s - Descrizione: %s - Indirizzo: %s - Città: %s - Numero Studenti: %d - Numero Classi: %d - Numero Sedi Aggiuntive: %d - Numero Laboratori: %d",codice,denominazione, indirizzo, citta, numeroStudenti,numeroClassi, numeroSediAggiunte,numeroLaboratori);
    }
}