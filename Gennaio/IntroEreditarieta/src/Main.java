public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Pippo", "Pluto", 99, "Rovigo", "Rosso", "Inter");
        Studente s = new Studente("Bazaj", "Francesco", 33, "Napoli", "Nero", "Milan");
        Persona p3;
        p3 = s; //up-casting posso assegnare un oggetto della sottoclasse ad una variabile della superclasse
        //cast implicito
        Persona p4 = new Studente("Guezam","Mohamed",231,"Palermo","nero","Napoli");


        //down-casting
        Persona p5 = new Persona("Vittorio","Alfieri",433,"Rovigo","verde","Bari");
        Studente s5;
        s5 = (Studente) p5;
        //IL DOWN CASTING DA ERRORE PERCHè NON LECITA, ANCHE SE IL COMPILATORE LO PERMETTE
        //binding dinamico, il compilatore prende il metodo corretto anche se su 2 classi derivate diverse
    }
}