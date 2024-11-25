import static utility.Tools.*;
import Mensola.Libro;
import Mensola.TipologiaLib;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        boolean esci = true;
        //final int MAXLIBRI = 3;

        ArrayList<Libro> mensola = new ArrayList<>();
        String[]opzioni = {"Menù","Inserimento","Visualizza", "Fine"};

        do{
            switch (Menu(opzioni,tastiera)){
                case 1 ->{
                    System.out.println("Inserimento");
                    Inserimento(mensola, tastiera);
                }
                case 2 ->{
                    System.out.println("Visualizza");
                    Visualizza(mensola);
                }
                case 3 ->{
                    System.out.println("Fine programma");
                    esci=false;
                }
            }
        }while (esci);

    }

    public static void Inserimento(ArrayList<Libro> mensola, Scanner tast){
        Libro lib = new Libro();
        boolean ver = true;
        LocalDate dataPubb = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            System.out.println("Inserisci Autore:");
            lib.Autore = tast.nextLine().toLowerCase();
            System.out.println("Inserisci Titolo:");
            lib.Titolo = tast.nextLine().toLowerCase();
        }while (Ricerca(mensola, lib.Autore, lib.Titolo));

        System.out.println("Inserisci Pagine:");
        lib.pagine = Integer.parseInt(tast.nextLine());
        System.out.println("Inserisci Tipologia: [1] Romanzo - [2] Manuale - [3] Thriller");
        do{
            switch (Integer.parseInt(tast.nextLine())){
                case 1 ->{
                    lib.tipologia = TipologiaLib.Romanzo;
                    ver = false;
                }
                case 2 ->{
                    lib.tipologia = TipologiaLib.Manuale;
                    ver = false;
                }
                case 3 ->{
                    lib.tipologia = TipologiaLib.Thriller;
                    ver = false;
                }
                default -> {
                    System.out.println("TIPOLOGIA NON VALIDA!!");
                }
            }
        }while (ver);
        do {
            try{
                System.out.println("Inserisci Data:");
                String in = tast.nextLine();
                dataPubb = LocalDate.parse(in, formatter);
                lib.dataPubblicazione = dataPubb;
            }catch (DateTimeParseException e){
                System.out.println(e.toString());
            }
        }while (dataPubb==null);

        mensola.add(lib);
    }

    public static void Visualizza(ArrayList<Libro> mensola){
        for (Libro lib: mensola){
            System.out.println(lib.FormattaDati());
        }
    }

    public static boolean Ricerca(ArrayList<Libro> nomAutore, String autore, String titolo){
        for(Libro lib : nomAutore){
            if(lib.Autore.equals(autore) && lib.Titolo.equals(titolo)){
                return true;
            }
        }
        return false;
    }
}