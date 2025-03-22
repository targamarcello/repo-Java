package Eccezioni;

public class EccezioneProdottoNonTrovato extends RuntimeException {
    public EccezioneProdottoNonTrovato(String message) {
        super(message);
    }
}
