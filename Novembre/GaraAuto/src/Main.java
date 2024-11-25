import java.util.Scanner;

import static Tools.Utility.*;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        boolean esci = true;

        Gara garaAuto = new Gara();
        garaAuto.setNomeGara("MONDIALE");

        try {
            garaAuto.AggiungiAuto(new Auto("Ferrari", new Pilota("Marios", "Rossi", "Argentino", 30), 1000));
            garaAuto.AggiungiAuto(new Auto("Mercedes", new Pilota("Giuseppe", "Verdi", "Coreano", 28), 2000));
            garaAuto.AggiungiAuto(new Auto("Alfa Romeo", new Pilota("Franco", "Piano", "Cileno", 42), 2300));
            garaAuto.AggiungiAuto(new Auto("BMW", new Pilota("Alfonso", "Gesuiti", "Italiano", 33), 1900));

            String[] opzioni = {"GARA FORMULA 1", "Corri Gara", "Visualizza Partecipanti", "Esci"};

            do {
                switch (Menu(opzioni, tastiera)) {
                    case 1 -> {
                        try {
                            int indiceVincitore = garaAuto.corriGara();
                            Auto vincitore = garaAuto.getAutoPartecipanti().get(indiceVincitore);
                            System.out.println("Il Vincitore della gara è: " + vincitore.toString());
                        } catch (Exception e) {
                            System.out.println("Errore durante la gara: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.println("Lista delle auto partecipanti:");
                        garaAuto.getAutoPartecipanti().forEach(auto -> System.out.println(auto.toString()));
                    }
                    case 3 -> {
                        System.out.println("Fine Programma");
                        esci = false;
                    }
                    default -> {
                        System.out.println("Scelta non valida!");
                    }
                }
            } while (esci);

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
