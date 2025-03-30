// Tools.java
package FrontEnd;

import Scuole.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Tools {

    private Tools() {
    } // Prevents instantiation of the class

    public static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int Menu(String opzioni[], Scanner tastiera) {
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            scelta = Integer.parseInt(tastiera.nextLine());
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        } while ((scelta < 1) || (scelta > opzioni.length - 1));
        return scelta;
    }

    public static Scuola leggiScuola(Scanner scanner) {
        System.out.println("Inserisci codice scuola:");
        String codice = scanner.nextLine();
        System.out.println("Inserisci denominazione scuola:");
        String denomin = scanner.nextLine();
        System.out.println("Inserisci indirizzo scuola: ");
        String indirizzo = scanner.nextLine();
        System.out.println("Inserisci città scuola:");
        String citta = scanner.nextLine();
        System.out.println("Inserisci numero studenti:");
        int nStudenti = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci numero classi:");
        int nClassi = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci numero sedi aggiuntive:");
        int nSedi = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci numero laboratori:");
        int nLaboratori = Integer.parseInt(scanner.nextLine());

        System.out.println("Scegli tipo di scuola: \n[1]Scuola Elementare [2]Scuola Media [3]Liceo [4]Tecnico [5]Professionale");
        int scelta = Integer.parseInt(scanner.nextLine());

        switch(scelta){
            case 1->{
                return new ScuolaElementare(codice,denomin,indirizzo,citta,nStudenti,nClassi,nSedi,nLaboratori);
            }
            case 2->{
                return new ScuolaMedia(codice,denomin,indirizzo,citta,nStudenti,nClassi,nSedi,nLaboratori);
            }
            case 3->{
                return new Liceo(codice,denomin,indirizzo,citta,nStudenti,nClassi,nSedi,nLaboratori);
            }
            case 4->{
                return new Tecnico(codice,denomin,indirizzo,citta,nStudenti,nClassi,nSedi,nLaboratori);
            }
            case 5->{
                return new Professionale(codice,denomin,indirizzo,citta,nStudenti,nClassi,nSedi,nLaboratori);
            }
            default ->{
                System.out.println("SCELTA NON VALIDA!!");
                return null;
            }

        }
    }

    public static void visualizzaScuole(ArrayList<Scuola> scuole) {
        for (Scuola scuola : scuole) {
            System.out.println(scuola.toString());
        }
    }


}
