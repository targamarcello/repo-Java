// Tools.java
package FrontEnd;

import Negozio.Prodotti.*;

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

    /**
     *
     * @param scanner
     * @return Oggetto di tipo Smartphone
     */
    public static Smartphone leggiSmartphone(Scanner scanner) {
        System.out.println("Inserire codice:");
        String codice = scanner.nextLine();
        System.out.println("Inserire marca:");
        String marca = scanner.nextLine();
        double prezzo = 0;
        boolean prezzoValido = false;
        while (!prezzoValido) {
            try {
                System.out.println("Inserire prezzo:");
                prezzo = Double.parseDouble(scanner.nextLine());
                prezzoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: Il prezzo inserito non è valido!!");
            }
        }

        System.out.println("Inserire modello:");
        String modello = scanner.nextLine();
        System.out.println("Inserire memoria:");
        int memoria = Integer.parseInt(scanner.nextLine());
        return new Smartphone(prezzo, marca, codice, modello, memoria);
    }

    /**
     *
     * @param scanner
     * @return Oggetto di tipo Manuale
     */
    public static Prodotto leggiManuale(Scanner scanner) {
        System.out.println("Inserisci nome manuale:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci descrizione manuale:");
        String desc = scanner.nextLine();
        System.out.println("Inserisci autore manuale:");
        String aut = scanner.nextLine();
        System.out.println("Inserisci ISBN:");
        String isbn = scanner.nextLine();
        double prez = 0;
        boolean prezzoValido = false;
        while (!prezzoValido) {
            try {
                System.out.println("Inserisci prezzo manuale:");
                prez = Double.parseDouble(scanner.nextLine());
                prezzoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: Il prezzo inserito non è valido!!");
            }
        }
        System.out.println("Inserisci quantità:");
        int quant = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci argomento manuale:");
        String argomento = scanner.nextLine();
        Manuale manuale = new Manuale(nome, desc, aut, isbn, prez, quant, argomento);
        return manuale;
    }

    /**
     *
     * @param inventario
     */
    public static void visualizzaProdotti(ArrayList<Prodotto> inventario) {
        for (Prodotto p : inventario) {
            System.out.println(p);
        }
    }



}
