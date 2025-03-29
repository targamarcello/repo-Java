package Scuole;

public class Tecnico extends ScuolaSuperiore{
    public Tecnico(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori, double contributoClasse, double contributoLaboratorio, double contributoSedeAggiuntiva) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori, contributoClasse, contributoLaboratorio, contributoSedeAggiuntiva);
    }

    @Override
    public double calcoloContributo(){
        return (3500*numeroClassi) + (6000*numeroLaboratori);
    }
    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }
}