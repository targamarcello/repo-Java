
package Rette;

public class Punto {
    private int x;
    private int y;
    final private int MAX_XY = 25;

    public Punto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void setX(int x) throws Exception {
        if (x < MAX_XY)
        {
            this.x = x;
        }
        else
        {
            throw new Exception("Errore. Hai inserito una x superiore al massimo accettabile.");
        }
    }
    public void setY(int y) throws Exception {
        if (y < MAX_XY)
        {
            this.y = y;
        }
        else
        {
            throw new Exception("Errore. Hai inserito una y superiore al massimo accettabile.");
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String controlloQuadrante()
    {
        if (x > 0 && y > 0)
        {
            return "nel 1°";
        }
        else if (x < 0 && y > 0)
        {
            return "nel 2°";
        }
        else if (x < 0 && y < 0)
        {
            return "nel 3°";
        }
        else if (x > 0 && y < 0)
        {
            return "nel 4°";
        }
        else if (x == 0 && y == 0)
        {
            return "nell'origine del";
        }
        else if (x == 0)
        {
            return "sull'asse x del";
        }
        else
        {
            return "sull'asse y del";
        }
    }
    @Override
    public String toString()
    {
        return String.format("(x: %d, y: %d)", x, y);
    }
}
