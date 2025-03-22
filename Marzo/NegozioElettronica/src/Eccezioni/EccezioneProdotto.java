package Eccezioni;

public class EccezioneProdotto extends RuntimeException{
    public EccezioneProdotto(String messaggio){
        super(messaggio);
    }
}
