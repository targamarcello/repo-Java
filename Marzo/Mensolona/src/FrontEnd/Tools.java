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
    } // Impedisce l'istanza della classe

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

    public static int Menu(String[] opzioni, Scanner tastiera) {
        int scelta;
        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "] " + opzioni[i]);
            }
            try {
                scelta = Integer.parseInt(tastiera.nextLine());
                if (scelta < 1 || scelta > opzioni.length - 1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Opzione non valida! Riprova.");
                Wait(2000);
                scelta = -1;
            }
        } while (scelta == -1);
        return scelta;
    }

    public static Libro leggiLibro(Scanner tastiera) {
        System.out.print("Inserisci l'autore del libro: ");
        String autore = tastiera.nextLine();
        System.out.print("Inserisci il titolo del libro: ");
        String titolo = tastiera.nextLine();
        System.out.print("Inserisci il numero di pagine del libro: ");
        int nPagine = Integer.parseInt(tastiera.nextLine());

        System.out.println("Seleziona il tipo di libro:");
        System.out.println("[1] Manuale\n[2] Romanzo\n[3] Thriller");

        int tipo = Integer.parseInt(tastiera.nextLine());

        switch (tipo) {
            case 1 -> {
                System.out.print("Inserisci l'argomento del manuale: ");
                String argomento = tastiera.nextLine();

                Livello livello = null;
                while (livello == null) {
                    System.out.println("Seleziona il livello del manuale:");
                    System.out.println("[1] Base - [2] Principiante - [3] Esperto");
                    int scelta = Integer.parseInt(tastiera.nextLine());
                    livello = switch (scelta) {
                        case 1 -> Livello.BASE;
                        case 2 -> Livello.PRINCIPIANTE;
                        case 3 -> Livello.ESPERTO;
                        default -> {
                            System.out.println("Scelta non valida, riprova.");
                            Wait(1000);
                            yield null;
                        }
                    };
                }
                return new Manuale(autore, titolo, nPagine, argomento, livello);
            }

            case 2 -> {
                GenereRomanzo genere = null;
                while (genere == null) {
                    System.out.println("Seleziona il genere del romanzo:");
                    System.out.println("[1] Storico - [2] Fantasy - [3] Armony");
                    int scelta = Integer.parseInt(tastiera.nextLine());
                    genere = switch (scelta) {
                        case 1 -> GenereRomanzo.STORICO;
                        case 2 -> GenereRomanzo.FANTASY;
                        case 3 -> GenereRomanzo.ARMONY;
                        default -> {
                            System.out.println("Scelta non valida, riprova.");
                            Wait(1000);
                            yield null;
                        }
                    };
                }
                return new Romanzo(autore, titolo, nPagine, genere);
            }

            case 3 -> {
                boolean derivato = false;
                System.out.println("Il thriller è derivato da una serie TV? (true/false)");
                while (true) {
                    String risposta = tastiera.nextLine().toLowerCase();
                    if (risposta.equals("true")) {
                        derivato = true;
                        break;
                    } else if (risposta.equals("false")) {
                        derivato = false;
                        break;
                    } else {
                        System.out.println("Risposta non valida! Inserisci 'true' o 'false'.");
                    }
                }
                return new Thriller(autore, titolo, nPagine, derivato);
            }

            default -> {
                System.out.println("Scelta non valida! Riprova.");
                return leggiLibro(tastiera);
            }
        }
    }

    public static void visualizzaMensola(ArrayList<Libro> volumi) {
        for (Libro l : volumi) {
            clrScr();
            System.out.println(l);
        }
    }

    public static void salvaInJson(Mensola libreria) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonContent = gson.toJson(libreria);
            Files.write(Paths.get("libro.json"), jsonContent.getBytes());
            System.out.println("Dati salvati con successo.");
        } catch (Exception e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    public static void esportaCSV(Mensola libreria) {
        libreria.scriviCSV("mensola.csv");
    }
}
