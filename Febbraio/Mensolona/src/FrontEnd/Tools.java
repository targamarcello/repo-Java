// Tools.java
package FrontEnd;

import BackEnd.Libri.*;
import BackEnd.Mensola;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static Libro leggiLibro(Scanner tastiera) {
        System.out.print("Inserisci l'autore del libro: ");
        String autore = tastiera.nextLine();
        System.out.print("Inserisci il titolo del libro: ");
        String titolo = tastiera.nextLine();
        System.out.print("Inserisci il numero di pagine del libro: ");
        int nPagine = Integer.parseInt(tastiera.nextLine());
        System.out.println("Inserisci tipo di libro");
        System.out.println("[1] Generico\n[2] Manuale\n[3] Romanzo\n[4] Thriller");
        int tipo = Integer.parseInt(tastiera.nextLine());

        switch (tipo) {
            case 2 -> {
                Livello liv = null;
                System.out.println("Inserisci l'argomento del manuale");
                String arg = tastiera.nextLine();
                System.out.println("Inserisci il livello del manuale");
                System.out.println("[1] Base - [2] Principiante - [3] Esperto");
                switch (Integer.parseInt(tastiera.nextLine())) {
                    case 1 -> liv = Livello.BASE;
                    case 2 -> liv = Livello.PRINCIPIANTE;
                    case 3 -> liv = Livello.ESPERTO;
                    default -> System.out.println("INPUT ERRATO!!");
                }
                return new Manuale(autore, titolo, nPagine, arg, liv);
            }
            case 3 -> {
                GenereRomanzo gen = null;
                System.out.println("Inserisci genere del romanzo");
                System.out.println("[1] Storico - [2] Fantasy - [3] Armony");
                switch (Integer.parseInt(tastiera.nextLine())) {
                    case 1 -> gen = GenereRomanzo.STORICO;
                    case 2 -> gen = GenereRomanzo.FANTASY;
                    case 3 -> gen = GenereRomanzo.ARMONY;
                    default -> System.out.println("INPUT ERRATO!!");
                }
                return new Romanzo(autore, titolo, nPagine, gen);
            }
            case 4 -> {
                boolean derivato = false;
                System.out.println("È derivato da una serie TV? (true/false)");
                switch (tastiera.nextLine().toLowerCase()) {
                    case "true" -> derivato = true;
                    case "false" -> derivato = false;
                    default -> System.out.println("INPUT ERRATO!!");
                }
                return new Thriller(autore, titolo, nPagine, derivato);
            }
            default -> {
                return new Libro(autore, titolo, nPagine);
            }
        }
    }

    public static void visualizzaMensola(ArrayList<Libro> volumi) {
        for (Libro l : volumi) {
            clrScr();
            System.out.println(l.toString());
        }
    }

    public static void salvaInJson(Mensola libreria) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonContent = gson.toJson(libreria);
            Files.write(Paths.get("libro.json"), jsonContent.getBytes());
            System.out.println("Dati salvati con successo");
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    public static void esportaCSV(Mensola libreria) {
        libreria.scriviCSV("mensola.csv");
    }
}
