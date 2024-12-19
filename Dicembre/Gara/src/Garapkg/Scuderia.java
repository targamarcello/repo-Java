package Garapkg;

public class Scuderia implements Comparable<Scuderia> {
    private String _scuderia;
    private Pilota _pilota;
    private int _numAuto;
    private Integer _tGiro = 0;

    public Scuderia(String scuderia, Pilota pilota, int numAuto) throws Exception {
        if (scuderia == null || scuderia.trim().isEmpty()) {
            throw new Exception("La scuderia è vuota o nulla.");
        }
        _scuderia = scuderia;
        _pilota = pilota;
        _numAuto = numAuto;
    }

    public String getScuderia() { return _scuderia; }
    public Pilota getPilota() { return _pilota; }
    public int getNumAuto() { return _numAuto; }
    public int getTGiro() { return _tGiro; }
    public void setTGiro(int tGiro) { _tGiro = tGiro; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Scuderia scuderia = (Scuderia) obj;
        return _numAuto == scuderia._numAuto &&
                _scuderia.equals(scuderia._scuderia) &&
                _pilota.equals(scuderia._pilota);
    }

    @Override
    public int compareTo(Scuderia s) {
        return Integer.compare(this._tGiro, s._tGiro);
    }

    @Override
    public String toString() {
        return String.format("Scuderia: %s - Pilota: %s - Numero Auto: %d\n",
                _scuderia, _pilota.toString(), _numAuto);
    }
}
