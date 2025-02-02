package PC;

public class PCPortatili extends ClassePC{
    private int _peso;
    private double _altezza, _larghezza, _profondita;
    private int _pollici;

    public PCPortatili(String _processore, int _ram, int _memoria, String _marca, String _modello, String _OS, int _peso, double _altezza, double _larghezza, double _profondita, int _pollici) {
        super(_processore, _ram, _memoria, _marca, _modello, _OS);
        this._peso = _peso;
        this._altezza = _altezza;
        this._larghezza = _larghezza;
        this._profondita = _profondita;
        this._pollici = _pollici;
    }

    public int get_peso() {
        return _peso;
    }

    public double get_altezza() {
        return _altezza;
    }

    public double get_larghezza() {
        return _larghezza;
    }

    public double get_profondita() {
        return _profondita;
    }

    public int get_pollici() {
        return _pollici;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("- Peso: %d kg - Altezza: %.2f cm - Larghezza: %.2f cm - Profondità: %.2f cm - Pollici Monitor: %d\n", _peso, _altezza, _larghezza, _profondita, _pollici);
    }
}
/*I PC portatili sono caratterizzati dal peso, dalle dimensioni fisiche (altezza, larghezza e profondità) e dalle dimensioni del video.*/
