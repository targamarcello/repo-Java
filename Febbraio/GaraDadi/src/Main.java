public class Main {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Mazzullo");
        Giocatore g2 = new Giocatore("Melon");
        Gara gara = new Gara(g1,g2,5);
        System.out.println("INIZIO GARA");
        while(!gara.isFineGara()){
            gara.round();
        }
    }
}