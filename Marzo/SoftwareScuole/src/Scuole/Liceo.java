package Scuole;

public class Liceo extends ScuolaSuperiore{
    public Liceo(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori, double contributoClasse, double contributoLaboratorio, double contributoSedeAggiuntiva) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori, contributoClasse, contributoLaboratorio, contributoSedeAggiuntiva);
    }

    @Override
    public double calcoloContributo(){
        return (150*numeroStudenti) + (1100*numeroLaboratori);
    }
    @Override
    public String toString(){
        return super.toString() + String.format(" - Contributo: %.2f",calcoloContributo());
    }
}