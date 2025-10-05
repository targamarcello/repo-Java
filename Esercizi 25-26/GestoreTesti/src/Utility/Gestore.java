package Utility;

public class Gestore {
    public Gestore(){}

    /**
     * Verifica la lunghezza di una frase inserita
     * utilizzando il metodo .length()
     * @param frase la frase su cui si calcola la lunghezza
     */
    public  void verificaLunghezza(String frase){
        if(frase.isEmpty()){
            System.out.println("Frase inesistente!!");
            return;
        }
        System.out.println("La frase è lunga " + frase.length() +"caratteri");
    }

    /**
     * Verifica se una parola precisa è presente nella frase
     * utilizzando il metodo .contains()
     * @param frase la frase in cui si farà la ricerca
     * @param parola la parola da cercare nella frase
     */
    public  void cercaParola(String frase, String parola){
        if(frase.isEmpty()){
            System.out.println("Frase inesistente!!");
            return;
        }
        if(frase.toLowerCase().contains(parola.toLowerCase())){
            System.out.println("La parola" + parola + " è presente nella frase");
        }else{
            System.out.println("La parola non è presente nella frase");
        }
    }

    /**
     * Sostituisce una parola nella frase con un'altra
     * utilizzando il metodo .replaceAll()
     * @param frase la frase iniziale
     * @param exFrase la paroal da sostituire
     * @param newFrase la parola che sostituisce
     * @return la frase modificata
     */
    public  String sostituisciParola(String frase, String exFrase, String newFrase){
        if(frase.isEmpty()){
            System.out.println("Frase inesistente!!");
            return frase;
        }
        String frase2 = frase.replaceAll(exFrase,newFrase);
        System.out.println("Frase sostituita "+frase2);
        return frase2;
    }

    /**
     * Conta il numero di vocali e consonanti nella frase
     * @param frase la frase su cui si fa il conteggio
     */
    public  void contaVocaliConsonanti(String frase){
        if(frase.isEmpty()){
            System.out.println("Frase inesistente!!");
            return;
        }
        int vocali =0, consonanti =0;
        String vocaliStr = "aeiouAEIOU";
        for(int i=0; i<frase.length(); i++){
            char c = frase.charAt(i);
            if((c>='a'&& c<='z') || (c>='A'&& c<='z')){
                boolean voc = false;
                for(int j=0; j<vocaliStr.length(); j++){
                    if(c== vocaliStr.charAt(j)){
                        voc = true;
                        break;
                    }
                }
                if(voc){
                    vocali++;
                }else{
                    consonanti++;
                }
            }
        }
        System.out.println("Vocali: "+vocali);
        System.out.println("Consonanti: "+consonanti);
    }

    /**
     * Inverte una frase
     * utilizzando il metodo .subString()
     * @param frase la frase da invertire
     */
    public  void invertiFrase(String frase){
        if(frase.isEmpty()){
            System.out.println("Frase inesistente!!");
            return;
        }
        String invertita = "";
        for(int i=frase.length()-1; i>=0; i--){
            invertita+= frase.substring(i,i+1);
        }
        System.out.println("Frase invertita: "+invertita);
    }

    /**
     * Estrae una porzione della frase
     * usando il metodo .subString()
     * @param frase la frase da cui estrarre
     * @param inizio indice da cui iniziare
     * @param fine indice in cui si finisce
     */
    public void estraiPorzione(String frase,int inizio, int fine){
        if(frase.isEmpty()){
            System.out.println("Frase inesistente!!");
            return;
        }
        if(inizio<0 || fine> frase.length() || inizio>=fine){
            System.out.println("Indici non validi");
            return;
        }
        String sub = frase.substring(inizio,fine);
        System.out.println("Porzione estratta: "+sub);
    }
    }
