package Scuole;

public abstract class ScuolaSuperiore extends Scuola{
    protected double contributoClasse;
    protected double contributoLaboratorio;
    protected double contributoSedeAggiuntiva;

    public ScuolaSuperiore(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori, double contributoClasse, double contributoLaboratorio, double contributoSedeAggiuntiva) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
        this.contributoClasse = contributoClasse;
        this.contributoLaboratorio = contributoLaboratorio;
        this.contributoSedeAggiuntiva = contributoSedeAggiuntiva;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo classe: %.2f - Contributo Lab: %.2f - Contributo Sede: %.2f",contributoClasse,contributoLaboratorio,contributoSedeAggiuntiva);
    }
}