
import static utility.Tools.*;

import Mensola.Libro;
import frontScreen.Frontend;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        boolean esci = true;
        int maxLibri = 3;

        ArrayList<Libro> mensola = new ArrayList<>();
        Frontend f = new Frontend();

        String[]opzioni= {"Menù", "Inserimento", "Visualizza","Ricerca","Remove","Remove All","Modifica Data","Esci"};

        do {
            switch (Menu(opzioni, tastiera)) {
                case 1 -> {
                    System.out.println("INSERIMENTO");
                    if(mensola.size()!=maxLibri){
                        f.inserimento(mensola, tastiera);
                    }
                }
                case 2 -> {
                    System.out.println("VISUALIZZA");
                    f.visualizza(mensola);
                }
                case 3-> {
                    System.out.println("RICERCA");
                }
                case 4 ->{
                    System.out.println("REMOVE");
                    Libro lib = new Libro();
                    System.out.println("Inserisci autore da cancellare");
                    lib.Autore= tastiera.nextLine();
                    System.out.println("Inserisci titolo da cancellare");
                    lib.Titolo= tastiera.nextLine();
                    if(f.cancellazione(mensola,lib))
                        System.out.println("CANCELLATO");
                    else
                        System.out.println("Non cancellato");
                }
                case 5->{
                    System.out.println("REMOVE ALL");
                }
                case 6->{
                    System.out.println("MODIFICA DATA");
                }
                case 7 -> {
                    System.out.println("Fine Programma");
                    esci = false;
                }
            }
        }while (esci);
    }
}