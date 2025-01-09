public class Automobile {
    private String _marca;
    private String _modello;
    private Integer _cilindrata;

    public Automobile(String marca, String modello, int cilindrata) {
        _marca = marca;
        _modello = modello;
        _cilindrata = cilindrata;
    }

    public Automobile(Automobile auto) {
        this._marca = auto.getMarca();
        this._modello = auto.getModello();
        this._cilindrata = auto.getCilindrata();
    }

    public String getMarca() { return _marca; }

    public String getModello() { return _modello; }

    public int getCilindrata() { return _cilindrata; }


    @Override
    public String toString() {
        return String.format("La marca della macchina è: %s\nIl modello della macchina è: %s\nLa cilindrata della macchina è: %d", _marca, _modello, _cilindrata);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Automobile) {
            return this._marca.equals(((Automobile) obj)._marca) && this._modello.equals(((Automobile) obj)._modello) && this._cilindrata.equals(((Automobile) obj)._cilindrata);
        }
        return false;
    }
    public int compareTo(Automobile auto){
        return Integer.compare(this._cilindrata,auto._cilindrata);
    }

}