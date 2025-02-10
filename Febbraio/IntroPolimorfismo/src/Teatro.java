import java.util.ArrayList;

public class Teatro {
    ArrayList<Persona> persone;
    final int POSTILIMITE = 3;

    public Teatro() {
        persone = new ArrayList<>();
    }

    public void ingressoTeatro(Persona p) {
           if(!persone.contains(p) && persone.size()<POSTILIMITE){
               persone.add(p);
           }else{
               System.out.println("Persona già presente a teatro o teatro pieno");
           }
    }
    public void stampa(){ // non si fa la stampa da dentro le classi, questo è solo un esempio...
        for (Persona pers: persone){
            System.out.println(pers.presentazione());
        }
    }
}
//non ci devono essere casi di omonimia a teatro