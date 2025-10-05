// Tools.java
package Utility;

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
}
