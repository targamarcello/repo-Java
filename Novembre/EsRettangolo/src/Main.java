import Rette.Punto;

public class Main {
    public static void main(String[] args) {
        try {
            Punto p = new Punto(1, 5);
            Rettangolo r = new Rettangolo(p, 3, 2);
            System.out.println(r);
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}