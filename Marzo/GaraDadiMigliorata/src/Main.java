import BackEnd.Gara;
import BackEnd.Giocatore;
import BackEnd.Partita;
import BackEnd.PartitaBase;
import BackEnd.PartitaAvanzata;
import Utility.Tools;

import java.util.Scanner;

import static Utility.Tools.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Partita partita = null; // Usato per gestire sia PartitaBase che PartitaAvanzata
        Giocatore g1 = null;
        Giocatore g2 = null;
        boolean esci = false;
        String[] opz = {"GARA-DEI-DADI", "Inserisci giocatori", "Scegli tipo di partita", "Inizia", "Vedi Vincitore", "Round vinti", "Fine"};

        do {
            int scelta = Menu(opz, sc); // Usa la funzione Menu definita sotto
            switch (scelta) {
                case 1 -> {
                    // Inserisci i giocatori
                    g1 = Tools.leggiPlayer(sc);
                    g2 = Tools.leggiPlayer(sc);
                    System.out.println("Quanti round verranno giocati?");
                    int round = Integer.parseInt(sc.nextLine());
                    partita = new PartitaBase(g1, g2, round); // Di default creiamo una PartitaBase
                }
                case 2 -> {
                    // Scegli il tipo di partita
                    System.out.println("Scegli il tipo di partita:");
                    System.out.println("1. Partita Base");
                    System.out.println("2. Partita Avanzata");
                    int sceltaPartita = Integer.parseInt(sc.nextLine());
                    if (sceltaPartita == 1) {
                        partita = new PartitaBase(g1, g2, partita.getnRound()); // Usa nRound per il numero di round
                    } else if (sceltaPartita == 2) {
                        partita = new PartitaAvanzata(g1, g2, partita.getnRound()); // Usa nRound per il numero di round
                    } else {
                        System.out.println("Scelta non valida!");
                    }
                }
                case 3 -> {
                    // Inizia la partita
                    if (partita != null) {
                        do {
                            partita.giocaRound(); // La chiamata al metodo giocaRound
                        } while (!partita.isFinePartita());
                    } else {
                        System.out.println("Non hai ancora creato una partita!");
                    }
                }
                case 4 -> {
                    // Vedi il vincitore
                    if (partita != null) {
                        System.out.println(partita.getWinner());
                    } else {
                        System.out.println("Non hai ancora giocato una partita!");
                    }
                }
                case 5 -> {
                    // Mostra i round vinti
                    try {
                        if (g1 != null && g2 != null) {
                            System.out.printf("Il giocatore %s ha vinto %d round\n", g1.getNome(), g1.getVittorie());
                            System.out.printf("Il giocatore %s ha vinto %d round\n", g2.getNome(), g2.getVittorie());
                        } else {
                            System.out.println("I giocatori non sono stati ancora impostati.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {
                    // Fine del programma
                    System.out.println("Fine programma...");
                    esci = true;
                }
            }
        } while (!esci);
    }

}
