public class Main {
    public static void main(String[] args) {
        try{
            Frazione f1 = new Frazione(1,4);
            Frazione f2 = new Frazione(2,3);
            Frazione risFrazione = f1.sommaFrazioni(f2);
            risFrazione.semplifica();
            System.out.println("Somma in forma di frazione "+ risFrazione.toString());
            float risValore = f1.sommaFrazioniValore(f2);
            System.out.printf("Somma in forma di valore %.2f\n",risValore);
            System.out.println("Frazione 1: "+f1.toString());
            System.out.println("Frazione 2: "+f2.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}