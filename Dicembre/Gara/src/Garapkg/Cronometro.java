package Garapkg;

import java.time.LocalTime;

// Classe che rappresenta un Cronometro per misurare il tempo dei giri
public class Cronometro {
    private LocalTime startTime; // Orario di inizio del giro
    private LocalTime endTime;   // Orario di fine del giro
    private int tempoGiro;       // Tempo totale del giro in secondi

    // Costruttore della classe Cronometro
    public Cronometro() {
        // Nessuna inizializzazione specifica necessaria
    }

    // Metodo per impostare l'orario di inizio del giro
    public void setStartTime() {
        startTime = LocalTime.now(); // Registra l'orario corrente come inizio
    }

    // Metodo per impostare l'orario di fine del giro
    public void setEndTime() throws InterruptedException {
        Thread.sleep(1000);         // Introduce una pausa simulativa (1 secondo)
        endTime = LocalTime.now();  // Registra l'orario corrente come fine
    }

    // Metodo per calcolare il tempo del giro in secondi
    public int calcolaTempoGiro() {
        // Verifica se startTime o endTime non sono stati impostati
        if (startTime == null || endTime == null) {
            System.out.println("Errore: startTime o endTime non sono stati settati.");
            return -1; // Ritorna -1 in caso di errore
        }

        // Calcola il tempo del giro in secondi
        tempoGiro = endTime.toSecondOfDay() - startTime.toSecondOfDay();

        // Controlla se il tempo del giro è valido
        if (tempoGiro <= 0) {
            System.out.println("Errore: Il tempo di fine è uguale o precedente al tempo di inizio.");
            return -1; // Ritorna -1 in caso di errore
        }

        return tempoGiro; // Ritorna il tempo calcolato
    }

    // Metodo toString per rappresentare il tempo del giro come stringa
    @Override
    public String toString() {
        // Se il tempo del giro è invalido, restituisce un messaggio di errore
        if (tempoGiro < 0) {
            return "Errore nel calcolo del tempo.";
        }
        // Altrimenti, restituisce il tempo del giro formattato
        return String.format("Tempo del giro: %d secondi", tempoGiro);
    }
}
