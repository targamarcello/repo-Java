
package frontScreen;

import Mensola.Libro;
import Mensola.TipologiaLib;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Frontend {

    //METODO INSERIMENTO
    public void inserimento(ArrayList<Libro> mensola, Scanner tastiera) {
        Libro lib = new Libro();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            System.out.println("Inserisci Autore:");
            lib.Autore = tastiera.nextLine().toLowerCase();
            System.out.println("Inserisci Titolo:");
            lib.Titolo = tastiera.nextLine().toLowerCase();
        }while (ricercaAutTito(lib,mensola));
        System.out.println("Inserisci Pagine:");
        lib.pagine = Integer.parseInt(tastiera.nextLine());
        System.out.println("Inserisci Tipologia: [1] Romanzo - [2] Manuale - [3] Thriller");

        do {
            switch (Integer.parseInt(tastiera.nextLine())) {
                case 1 -> lib.tipologia = TipologiaLib.Romanzo;
                case 2 -> lib.tipologia = TipologiaLib.Manuale;
                case 3 -> lib.tipologia = TipologiaLib.Thriller;
                default -> System.out.println("TIPOLOGIA NON VALIDA!!");
            }
        } while (lib.tipologia == null);

        lib.dataPubblicazione = pubblicazione(tastiera, formatter);//metodo per verificare che la data sia accettabile
        mensola.add(lib);
    }

    //METODO VISUALIZZA
    public void visualizza(ArrayList<Libro> mensola) {
        if (mensola.isEmpty()) {
            System.out.println("Nessun libro presente nella mensola.");
        } else {
            for (Libro lib : mensola) {
                System.out.println(lib.FormattaDati());
            }
        }
    }

    //METODO VISUALIZZA DIVERSO
    public void visualizza2(ArrayList<Libro> mensola) {
        if (mensola.isEmpty()) {
            System.out.println("Nessun libro presente nella mensola.");
        } else {
            for (Libro lib : mensola) {
                System.out.println(lib.NuovoVisualizza());
            }
        }
    }

    //METODO RICERCA CON AUTORE E TITOLO
    public boolean ricercaAutTito(Libro libControllo, ArrayList<Libro> mensola) {
        for (Libro lib : mensola) {
            if (lib.Autore.equalsIgnoreCase(libControllo.Autore) && lib.Titolo.equalsIgnoreCase(libControllo.Titolo)) {//controllo del libro già esistente
                return true;
            }
        }
        return false;
    }

    //METODO RICERCA GENERICA
    public int ricerca2(ArrayList<Libro> mensola, String autRicerca) {
        for (int i=0; i< mensola.size(); i++) {
            if (mensola.get(i).Autore.equalsIgnoreCase(autRicerca)) {
                System.out.println(mensola.get(i).FormattaDati());
                return i;
            }
        }
        return -1;
    }

    //METODO REMOVE
    public boolean cancellazione(ArrayList<Libro> mensola, Libro lib) {
        if (!mensola.isEmpty()){
            mensola.removeIf(m->m.Autore.equalsIgnoreCase(lib.Autore) && m.Titolo.equalsIgnoreCase(lib.Titolo)); //remove usando il metodo removeIf
            return true;
        }
        return false;
    }

    //METODO REMOVE ALL
    public void removeAll(ArrayList<Libro> mensola, String autore) {
        if (!mensola.isEmpty()){
            mensola.removeIf(m->m.Autore.equalsIgnoreCase(autore) && m.Titolo.equalsIgnoreCase(autore)); //remove usando il metodo removeIf
        }
    }

    //METODO MODIFICA DELLA DATA
    public void modificaData(ArrayList<Libro> mensola, String auto, Scanner tastiera) {
        for( Libro lib: mensola){
            if(lib.Autore.equalsIgnoreCase(auto)){
                lib.dataPubblicazione = pubblicazione(tastiera, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        }
    }

    //MODIFICA NUMERO PAGINE
    public void modificaPagine(ArrayList<Libro> mensola,Libro newLib){
        for (Libro lib : mensola){
            if(lib.Autore.equalsIgnoreCase(newLib.Autore)){
                lib.pagine = newLib.pagine;
            }
        }
    }

    //METODO VERIFICA DATA PUBBLICAZIONE
    public LocalDate pubblicazione(Scanner tastiera, DateTimeFormatter formatter){//metodo che verifica l'accettabilità della data e ritorna un eccezione
        LocalDate dataPubb = null;
        LocalDate dataOggi = LocalDate.now();
        do {
            try {
                System.out.println("Inserisci Data (dd-MM-yyyy):");
                String in = tastiera.nextLine();
                dataPubb = LocalDate.parse(in, formatter);
                if(dataPubb.getYear()>dataOggi.getYear()) {
                    dataPubb = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data non valida. Riprova.");
            }
        } while (dataPubb == null);
        return dataPubb;
    }
}
//metodo scorri mensola precedente e successivo
