import java.util.Random;
import static utility.Tools.*;
public class Main {
    public static void main(String[] args) {
        Random rn = new Random();
        int tempo;
        try {
            Pilota p1 = new Pilota("Mario", "Andretti", "America");
            Pilota p2 = new Pilota("Michael", "Schumacher", "Tedesco");
            System.out.println(p1);
            System.out.println(p2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Cronometro cr = new Cronometro();
            tempo = rn.nextInt(1000, 5000) + 1;
            cr.setStartTime();
            Wait(tempo);
            cr.setEndTime();
            cr.calcolaIntTimer();
            System.out.println(cr.getTempoGiro());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}