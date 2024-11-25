
package Rette;

public class Segmento {
    Punto p1;
    Punto p2;

    public Segmento(Punto p1, Punto p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }
    public double distanzaTra2Punti()
    {
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
    }
}
