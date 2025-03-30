package Scuole;

public abstract class ScuolaSuperiore extends Scuola{

    public ScuolaSuperiore(String codice, String denominazione, String indirizzo, String citta, int numeroStudenti, int numeroClassi, int numeroSediAggiunte, int numeroLaboratori) {
        super(codice, denominazione, indirizzo, citta, numeroStudenti, numeroClassi, numeroSediAggiunte, numeroLaboratori);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}