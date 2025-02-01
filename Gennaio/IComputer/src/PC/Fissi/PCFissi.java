package PC.Fissi;

import PC.ClassePC;
import PC.DImCase;

public class PCFissi extends ClassePC {
    private DImCase dimensione;

    public PCFissi(String _processore, int _ram, int _memoria, String _marca, String _modello, String _OS, DImCase dimensione) {
        super(_processore, _ram, _memoria, _marca, _modello, _OS);
        this.dimensione = dimensione;
    }
    public DImCase getDimensione(){
        return dimensione;
    }

    @Override
    public String toString(){
        return super.toString() + "- Dimensione: "+ dimensione;
    }
}
/*I PC fissi sono caratterizzati dal tipo di contenitore (grande, medio, piccolo)*/