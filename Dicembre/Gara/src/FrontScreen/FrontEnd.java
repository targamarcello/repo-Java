package FrontScreen;

import Garapkg.Cronometro;
import Garapkg.Gara;
import Garapkg.Pilota;
import Garapkg.Scuderia;
import Garapkg.CarSound;
import static utility.Tools.*;

import java.awt.*;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FrontEnd {
    private Gara gara; // Oggetto che rappresenta la gara
    private Scanner sc; // Scanner per input utente

    // Costruttore che inizializza la gara e lo scanner
    public FrontEnd() {
        sc = new Scanner(System.in);
        this.gara = new Gara("Gran Premio", "Italia");
    }

    // Metodo per l'inserimento dei dati del pilota e della sua scuderia
    public void inserimentoDati() {
        try {
            System.out.println("Inserisci nome pilota:");
            String nome = sc.nextLine();
            System.out.println("Inserisci cognome pilota:");
            String cognome = sc.nextLine();
            System.out.println("Inserisci nazionalità pilota:");
            String nazionalita = sc.nextLine();

            // Creazione dell'oggetto Pilota
            Pilota p = new Pilota(nome, cognome, nazionalita);

            System.out.println("Inserisci scuderia del pilota:");
            String scud = sc.nextLine();
            System.out.println("Inserisci numero auto:");
            int numAuto = Integer.parseInt(sc.nextLine());

            // Creazione dell'oggetto Scuderia e aggiunta alla gara
            Scuderia scuderia = new Scuderia(scud, p, numAuto);
            gara.addScuderia(scuderia);
            System.out.println("Scuderia aggiunta alla gara!!");
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Gestione di eventuali errori
        }
    }

    // Metodo per simulare la corsa della gara
    public void corriGara() {
        CarSound sounoBrum = new CarSound();
        try {
            for (Scuderia scud : gara.getGriglia()) { // Iterazione su tutte le scuderie della gara
                Cronometro c = new Cronometro(); // Oggetto per calcolare i tempi
                c.setStartTime(); // Inizio del cronometro
                sounoBrum.startEngineSound();
                Thread.sleep(2000); // Simulazione di tempo di attesa
                c.setEndTime(); // Fine del cronometro

                // Generazione casuale del tempo di giro (metodo semplificato)
                Random random = new Random();
                int tempoGiro = random.nextInt(100) + 1;

                // Impostazione del tempo di giro per la scuderia
                scud.setTGiro(tempoGiro);
                System.out.println(scud.getScuderia() + " ha finito il giro in " + tempoGiro + " secondi");
            }
            sounoBrum.stopEngineSound();
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Gestione di eventuali errori
        }
    }

    // Metodo per visualizzare la classifica finale della gara
    public void visualizzaClassifica() {
        Collections.sort(gara.getGriglia()); // Ordinamento delle scuderie in base al tempo di giro
        System.out.println("Classifica finale:");
        for (Scuderia scud : gara.getGriglia()) {
            System.out.println(scud + " - Tempo " + scud.getTGiro());
        }
    }

    // Metodo per visualizzare la griglia di partenza
    public void visualizzaGriglia() {
        Collections.sort(gara.getGriglia()); // Ordinamento della griglia
        System.out.println("Griglia di partenza");
        for (Scuderia scud : gara.getGriglia()) {
            System.out.println(scud + " - Tempo Giro: " + scud.getTGiro());
        }
    }

    // Metodo per visualizzare il menu e gestire le opzioni dell'utente
    public void startFrontEnd() {
        boolean esci = true; // Variabile per controllare il ciclo del menu
        String[] opz = {"Opzioni", "Aggiungi concorrente", "Corri Gara", "Visualizza classifica", "Visualizza griglia partenza", "Esci"};

        do {
            switch (Menu(opz, sc)) { // Scelta dell'opzione dal menu
                case 1 -> {
                    inserimentoDati(); // Aggiungi un concorrente
                }
                case 2 -> {
                    corriGara(); // Esegui la corsa
                }
                case 3 -> {
                    visualizzaClassifica(); // Mostra la classifica
                }
                case 4 -> {
                    visualizzaGriglia(); // Mostra la griglia di partenza
                }
                case 5 -> {
                    esci = false; // Esci dal programma
                    System.out.println("Programma finito!");
                }
                default -> {
                    System.out.println("OPZIONE NON VALIDA!!"); // Opzione non valida
                }
            }
        } while (esci); // Continua fino a quando l'utente decide di uscire
    }
}
