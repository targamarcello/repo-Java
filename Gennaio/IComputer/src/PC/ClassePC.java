package PC;

import java.lang.classfile.AnnotationValue;
import java.util.Objects;

public class ClassePC {
    private String _processore;
    private int _ram;
    private int _memoria;
    private String _marca;
    private String _modello;
    private String _OS;

    public ClassePC(String _processore, int _ram, int _memoria, String _marca, String _modello, String _OS) {
        this._processore = _processore;
        this._ram = _ram;
        this._memoria = _memoria;
        this._marca = _marca;
        this._modello = _modello;
        this._OS = _OS;
    }

    public String get_processore() {
        return _processore;
    }

    public int get_ram() {
        return _ram;
    }

    public int get_memoria() {
        return _memoria;
    }

    public String get_marca() {
        return _marca;
    }

    public String get_modello() {
        return _modello;
    }

    public String get_OS() {
        return _OS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassePC classePC = (ClassePC) o;
        return _ram == classePC._ram && _memoria == classePC._memoria && Objects.equals(_processore, classePC._processore) && Objects.equals(_marca, classePC._marca) && Objects.equals(_modello, classePC._modello) && Objects.equals(_OS, classePC._OS);
    }

    @Override
    public String toString(){
        return String.format("Marca: %s - Modello: %s - Sistema Operativo: %s - Processore: %s - RAM: %d - Memoria: %d",_marca,_modello,_OS,_processore,_ram,_memoria);
    }

}
/*Le caratteristiche generali di interesse sono: il tipo di processore, la dimensione della memoria RAM, la dimensione della memoria di massa, la marca, il modello e il sistema operativo.*/