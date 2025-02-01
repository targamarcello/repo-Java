package PC.Fissi;

import PC.DImCase;

public class Server extends PCFissi{
    private int _nProcessori;
    private boolean _dischiRAID;

    public Server(String _processore, int _ram, int _memoria, String _marca, String _modello, String _OS, DImCase dimensione, int nProcessori, boolean dischiRAID) {
        super(_processore, _ram, _memoria, _marca, _modello, _OS, dimensione);
        _nProcessori = nProcessori;
        _dischiRAID = dischiRAID;
    }
    public int get_nProcessori(){
        return _nProcessori;
    }

    public boolean is_dischiRAID() {
        return _dischiRAID;
    }

    @Override
    public String toString(){
        return super.toString() + "- Numero Processori: " + _nProcessori + " - Dischi RAID: " + _dischiRAID;
    }
}
/*mentre per i PC fissi di tipo server
è necessario sapere il numero dei processori e se hanno o meno dischi di tipo RAID.*/