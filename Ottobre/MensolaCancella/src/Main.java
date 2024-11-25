import static utility.Tools.*;

import Mensola.Libro;
import frontScreen.Frontend;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        boolean esci = true;

        ArrayList<Libro> mensola = new ArrayList<>();
        Frontend f = new Frontend();

        String[] opzioni = {"Menù", "Inserimento", "Visualizza", "Cancella", "Ricerca", "Modifica Data", "Fine"};

        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {
                    System.out.println("INSERIMENTO");
                    f.inserimento(mensola, tastiera);
                }
                case 2 -> {
                    System.out.println("VISUALIZZA");
                    f.visualizza(mensola);
                }
                case 3 -> {
                    System.out.println("CANCELLA");
                    f.visualizza(mensola);
                    System.out.println("Inserisci autore");
                    String aut = tastiera.nextLine();
                    System.out.println("Inserisci titolo");
                    String tit = tastiera.nextLine();
                    if(f.cancellazione(mensola,aut,tit)){
                        System.out.println("CANCELLAZIONE RIUSCITA!!!");
                    }else{
                        System.out.println("Nessun libro cancellato!!");
                    }
                }
                case 4 -> {
                    System.out.println("RICERCA");
                    System.out.println("Inserisci nome autore di libri da cercare");
                    String autoreRicerca = tastiera.nextLine();
                    f.ricerca2(mensola, autoreRicerca);
                }
                case 5 -> {
                    System.out.println("MODIFICA DATA");
                    System.out.println("Inserisci autore libro da modificare");
                    String aut = tastiera.nextLine();
                    f.modificaData(mensola,aut,tastiera);
                }
                case 6 -> {
                    System.out.println("Fine programma");
                    esci = false;
                }
            }
        } while (esci);
    }
}
