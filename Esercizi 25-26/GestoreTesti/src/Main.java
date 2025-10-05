import Utility.Gestore;
import Utility.Gestore.*;
import Utility.Tools;
import Utility.Tools.*;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Gestore gestoreTesto = new Gestore();
        String frase = "";
        int scelta;

        do{
            String[]opz = {"============GESTORE TESTI============","Inserimento frase","Verifica lunghezza","Cerca parola","Sostituisci parola","Conta vocali/consonanti","Inverti frase","Estrai porzione","Mostra frase","Esci"};
            scelta = Tools.Menu(opz,tastiera);
            Tools.clrScr();
            switch (scelta){
                case 1->{
                    System.out.println("====INSERIMENTO====");
                    System.out.println("Inserisci frase: ");
                    frase = tastiera.nextLine();
                }
                case 2->{
                    System.out.println("====VERIFICA LUNGHEZZA====");
                    gestoreTesto.verificaLunghezza(frase);
                }
                case 3->{
                    System.out.println("Inserisci parola da cercare: ");
                    String parola = tastiera.nextLine();
                    gestoreTesto.cercaParola(frase,parola);
                }
                case 4->{
                    System.out.println("====SOSTITUZIONE PAROLA====");
                    System.out.println("Parola da sostituire: ");
                    String parolaVecchia = tastiera.nextLine();
                    System.out.println("Nuova parola: ");
                    String parolaNuova = tastiera.nextLine();
                    frase = gestoreTesto.sostituisciParola(frase,parolaVecchia,parolaNuova);
                }
                case 5->{
                    System.out.println("====CONTEGGIO VOCALI E CONSONANTI====");
                    gestoreTesto.contaVocaliConsonanti(frase);
                }
                case 6->{
                    System.out.println("====INVERSIONE FRASE====");
                    gestoreTesto.invertiFrase(frase);
                }
                case 7->{
                    System.out.println("====ESTRAZIONE PORZIONE FRASE====");
                    System.out.println("Inserire inizio: ");
                    int inizio = Integer.parseInt(tastiera.nextLine());
                    System.out.println("Inserire fine: ");
                    int fine = Integer.parseInt(tastiera.nextLine());
                    gestoreTesto.estraiPorzione(frase,inizio,fine);
                }
                case 8->{
                    System.out.println("====VISUALIZZAZIONE FRASE====");
                    System.out.println("Frase corrente: "+frase);
                }
                case 9->{
                    System.out.println("Uscita dal programma....");
                }
            }
        }while (scelta!=9);

    }
}