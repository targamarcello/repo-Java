
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

        String[]opzioni= {"Menù", "Inserimento", "Visualizza","Visualizza Prezzo","Ricerca","Remove","Remove All","Modifica Data","Modifica Pagine","Esci"};
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
                case 3->{
                    System.out.println("VISUALIZZA DIVERSO");
                    f.visualizza2(mensola);
                }
                case 4-> {
                    System.out.println("RICERCA");
                }
                case 5 ->{
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
                case 6->{
                    System.out.println("REMOVE ALL");
                    System.out.println("Inserisci autore da cancellare");
                    String aut = tastiera.nextLine();
                    f.removeAll(mensola,aut);
                }
                case 7->{
                    System.out.println("MODIFICA DATA");
                    System.out.println("Inserisci autore libro da modificare");
                    String aut = tastiera.nextLine();
                    f.modificaData(mensola,aut,tastiera);
                }
                case 8->{
                    Libro newLib = new Libro();
                    System.out.println("MODIFICA PAGINE");
                    System.out.println("Inserisci autore libro da modificare");
                    newLib.Titolo= tastiera.nextLine();
                    System.out.println("Inserisci titolo da modificare");
                    newLib.Autore = tastiera.nextLine();
                    System.out.println("Inserisci nuovo numero pagine");
                    newLib.pagine = Integer.parseInt(tastiera.nextLine());
                    f.modificaPagine(mensola,newLib);
                }
                case 9 -> {
                    System.out.println("Fine Programma");
                    esci = false;
                }
            }
        }while (esci);
    }
}