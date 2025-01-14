package BackEnd;

import java.util.ArrayList;
import java.util.Scanner;

public class Mensola {

    Scanner tastiera = new Scanner(System.in);
    private int numeroLibri;
    private ArrayList<Libro> mensola = new ArrayList<>();

    public Mensola(int numeroLibri) {
        this.numeroLibri = numeroLibri;
    }

    public void addLibro(Libro l) {
        mensola.add(l);
    }

    public void findLibro(String autore, String titolo) {
        System.out.println("Inserisci un'autore: ");
        autore = tastiera.nextLine();
        System.out.println("Inserisci un titolo: ");
        titolo = tastiera.nextLine();
        boolean trovato = false;
        for (Libro l : mensola) {
            if (l.getAutore().equals(autore) && l.getTitolo().equals(titolo)) {
                l.toString();
                trovato = true;
            }
        }
        if (!trovato)
            System.out.println("Il libro non è presente nella mensola");
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public ArrayList<Libro> getMensola() {
        return mensola;
    }

    public boolean isEmpty() {
        return mensola.isEmpty();
    }

    public void removeBookPos(Libro l) {
        mensola.remove(l);
    }

    public void setInto(Libro l, int posizione) {
        System.out.println("In che posizione vuoi settare il libro: ");
        posizione = tastiera.nextInt();
        mensola.set(posizione, l);
    }

    public boolean containsBook(Libro l) {
        return mensola.contains(l);
    }

    public void removeAllAuthor(String autore) {
        System.out.println("Inserisci un'autore: ");
        autore = tastiera.nextLine();
        for (Libro l : mensola) {
            if (l.getAutore().equals(autore)) {
                mensola.remove(l);
            }
        }
    }
}
