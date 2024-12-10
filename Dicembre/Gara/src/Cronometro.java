import java.time.LocalTime;

public class Cronometro {
    private LocalTime startTime;
    private LocalTime endTime;
    private int tempoGiro;

    public Cronometro() {
        setStartTime();
        setEndTime();
    }

    void setStartTime() {
        startTime = LocalTime.now();
    }

    void setEndTime() {
        endTime = LocalTime.now();
    }

    public int getTempoGiro() {
        return tempoGiro;
    }

    void calcolaIntTimer() throws Exception {
        int tempoGiro;
        tempoGiro = this.endTime.toSecondOfDay() - this.startTime.toSecondOfDay();
        if (tempoGiro == 0)
            throw new Exception("Cronometro stop");
        this.tempoGiro = tempoGiro;
    }

    @Override
    public String toString() {
        return String.format("Tempo: %d", tempoGiro);
    }
}
