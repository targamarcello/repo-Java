
import Rette.Punto;

public class Rettangolo {
    private Punto altoSinistra;
    private int base, altezza;

    public Rettangolo(Punto altoSinistra, int base, int altezza) throws Exception {
        if (altoSinistra.getX() < 0 || altoSinistra.getY() < 0 ||
                altoSinistra.getX() + base < 0 || altoSinistra.getY() - altezza < 0) {
            throw new Exception("Il rettangolo esce dal primo quadrante!");
        }

        this.altoSinistra = altoSinistra;
        this.base = base;
        this.altezza = altezza;
        //this.segmenti = calcolaSegmenti();
    }

    public int getAltezza() {return altezza;}

    public int getBase() {return base;}

    public int Area(){
        return (base * altezza);
    }
    public int Perimetro(){
        return (base+2)*(altezza+2);
    }

    public boolean isRettangolo(){
        if(base!=altezza){
            return true;
        }
        return false;
    }

    /*private ArrayList<Segmento> calcolaSegmenti() {
        ArrayList<Segmento> segmenti = new ArrayList<>();
        Punto altoDestra = new Punto(altoSinistra.getX() + base, altoSinistra.getY());
        Punto bassoSinistra = new Punto(altoSinistra.getX(), altoSinistra.getY() - altezza);
        Punto bassoDestra = new Punto(altoDestra.getX(), bassoSinistra.getY());

        segmenti.add(new Segmento(altoSinistra, altoDestra));   // Lato superiore
        segmenti.add(new Segmento(altoSinistra, bassoSinistra)); // Lato sinistro
        segmenti.add(new Segmento(bassoSinistra, bassoDestra)); // Lato inferiore
        segmenti.add(new Segmento(altoDestra, bassoDestra));    // Lato destro

        return segmenti;
    }*/

    @Override
    public String toString() {
       return String.format("Rettangolo: %s - Base: %d - Altezza: %d - Area: %d - Perimetro: %d\n", altoSinistra, base, altezza, Area(), Perimetro());
    }
}
