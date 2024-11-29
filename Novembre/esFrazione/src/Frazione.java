public class Frazione {
    private int numeratore;
    private int denominatore;
    public Frazione(int numeratore, int denominatore) throws Exception {
        if(denominatore == 0){
            throw new Exception("Denominatore non può essere zero!!");
        }
        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public Frazione sommaFrazioni(Frazione altraFrazione) throws Exception {
        int numComb = (this.numeratore * altraFrazione.denominatore) + (this.denominatore * altraFrazione.numeratore);
        int denomComb = (this.denominatore*altraFrazione.denominatore);
        return new Frazione(numComb,denomComb);
    }
    public float sommaFrazioniValore (Frazione altraFrazione) throws Exception {
        Frazione ris = sommaFrazioni(altraFrazione);
        return(float) ris.numeratore/ris.denominatore;
    }
    public void semplifica(){
        int mcd = mcd(numeratore,denominatore);
        numeratore /= mcd;
        denominatore /= mcd;
    }
    private int mcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString(){
        return String.format("%d / %d",numeratore,denominatore);
    }
}
