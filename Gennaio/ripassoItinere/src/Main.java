import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Automobile> listona = new ArrayList<>();
        listona.add(new Automobile("Marcona","Modellone", 2000));
        listona.add(new Automobile("Marcona2","Modellone2", 1000));
        listona.add(new Automobile("Marcona3","Modellone3",600));
        listona.add(new Automobile("Marcona4","Modellone4",300));


    }
}
/*creare una classe automobile -> marca - modello - cilindrata (get e set a scelta)
*un costruttore che accetta un tipo Automobile
*metodo toString
*metodo equals
*metodo compare sulla cilindrata
*fai lista auto di auto e stamparla
*ordinare la lista in ordine crescente di cilindrata e stampare
*   */