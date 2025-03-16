package BackEnd;

import BackEnd.Libri.GenereRomanzo;
import BackEnd.Libri.Libro;
import BackEnd.Libri.Romanzo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Mensola {
    private int numeroLibri = 0;
    private int maxLibri;
    private ArrayList<Libro> mensola = new ArrayList<>();

    public Mensola(int numeroLibri) {
        this.maxLibri = numeroLibri;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public ArrayList<Libro> getMensola() {
        return mensola;
    }

    public boolean checkSpace() throws Exception {
        if (numeroLibri == maxLibri)
            throw new Exception("La mensola è piena");
        return false;
    }

    public void addLibro(Libro l) throws Exception {
        if (l != null && !mensola.contains(l)) {
            mensola.add(l);
            numeroLibri++;
        } else {
            throw new Exception("Il libro è presente nella mensola");
        }
    }

    public void removeBook(Libro l) throws Exception {
        if (l != null && mensola.contains(l)) {
            mensola.remove(l);
            numeroLibri--;
        } else {
            throw new Exception("Il libro non è presente nella mensola");
        }
    }

    public void setInto(Libro l, int posizione, Scanner tastiera) {
        System.out.println("In che posizione vuoi settare il libro: ");
        posizione = tastiera.nextInt();
        mensola.set(posizione, l);
    }

    public boolean containsBook(Libro l) {
        return mensola.contains(l);
    }

    public ArrayList<Libro> getVolumi() {
        return new ArrayList<>(mensola);
    }

    public boolean isEmpty() {
        return mensola.isEmpty();
    }

    public boolean findLibro(String autore, String titolo) {
        for (Libro l : mensola) {
            if (l.getAutore().equals(autore) && l.getTitolo().equals(titolo)) {
                System.out.println(l);
                return true;
            }
        }
        System.out.println("Libro non presente nella mensola");
        return false;
    }

    public void scriviCSV(String dirPath) {
        ArrayList<String> listaString = new ArrayList<>();
        try {
            for (Libro lib : mensola) {
                listaString.add(lib.csv());
            }
            Files.write(Paths.get(dirPath), listaString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Libro> leggiCSV(String dirPath) {
        ArrayList<Libro> libri = new ArrayList<>();
        try {
            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get(dirPath));
            for (String str : lines) {
                String[] attributi = str.split(";");
                libri.add(new Romanzo(attributi[0].trim(), attributi[1].trim(), Integer.parseInt(attributi[2].trim()), GenereRomanzo.FANTASY));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return libri;
    }

    @Override
    public String toString() {
        return "Mensola con " + numeroLibri + " libri: " + mensola.toString();
    }
}