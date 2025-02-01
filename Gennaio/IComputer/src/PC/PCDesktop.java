package PC;

public class PCDesktop extends ClassePC{
    private String _gpu;

    public PCDesktop(String _processore, int _ram, int _memoria, String _marca, String _modello, String _OS, String _gpu) {
        super(_processore, _ram, _memoria, _marca, _modello, _OS);
        this._gpu = _gpu;
    }
    public String get_gpu(){
        return _gpu;
    }
    @Override
    public String toString(){
        return super.toString() + "- GPU: " + _gpu;
    }
}
/*per quelli desktop è necessario registrare il tipo di scheda video*/