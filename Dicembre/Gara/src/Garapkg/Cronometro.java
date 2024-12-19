package Garapkg;

import java.time.LocalTime;

public class Cronometro {
    private LocalTime startTime;
    private LocalTime endTime;
    private int tempoGiro;

    public Cronometro() {

    }

    public void setStartTime() {
        startTime = LocalTime.now();
    }

    public void setEndTime() throws InterruptedException {
        Thread.sleep(1000);
        endTime = LocalTime.now();
    }

    public int calcolaTempoGiro() {
        if (startTime == null || endTime == null) {
            System.out.println("Errore: startTime o endTime non sono stati settati.");
            return -1;
        }
        tempoGiro = endTime.toSecondOfDay() - startTime.toSecondOfDay();

        if (tempoGiro <= 0) {
            System.out.println("Errore: Il tempo di fine è uguale o precedente al tempo di inizio.");
            return -1;
        }

        return tempoGiro;
    }

    @Override
    public String toString() {
        if (tempoGiro < 0) {
            return "Errore nel calcolo del tempo.";
        }
        return String.format("Tempo del giro: %d secondi", tempoGiro);
    }
}
