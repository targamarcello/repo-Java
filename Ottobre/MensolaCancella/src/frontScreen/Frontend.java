package frontScreen;

import Mensola.Libro;
import Mensola.TipologiaLib;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Frontend {

    public void inserimento(ArrayList<Libro> mensola, Scanner tastiera) {
        Libro lib = new Libro();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            System.out.println("Inserisci Autore:");
            lib.Autore = tastiera.nextLine().toLowerCase();
            System.out.println("Inserisci Titolo:");
            lib.Titolo = tastiera.nextLine().toLowerCase();
        } while (ricercaAutTito(lib, mensola));

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

        lib.dataPubblicazione = pubblicazione(tastiera, formatter);
        /*do {
            try {
                System.out.println("Inserisci Data (dd-MM-yyyy):");
                String in = tastiera.nextLine();
                dataPubb = LocalDate.parse(in, formatter);
                lib.dataPubblicazione = dataPubb;
            } catch (DateTimeParseException e) {
                System.out.println("Data non valida. Riprova.");
            }
        } while (dataPubb == null);*/

        mensola.add(lib);
    }

    public void visualizza(ArrayList<Libro> mensola) {
        if (mensola.isEmpty()) {
            System.out.println("Nessun libro presente nella mensola.");
        } else {
            for (Libro lib : mensola) {
                System.out.println(lib.FormattaDati());
            }
        }
    }

    public boolean ricercaAutTito(Libro libControllo, ArrayList<Libro> mensola) {
        for (Libro lib : mensola) {
            if (lib.Autore.equals(libControllo.Autore) && lib.Titolo.equals(libControllo.Titolo)) {
                return true;
            }
        }
        return false;
    }

    public void ricerca2(ArrayList<Libro> mensola, String autRicerca) {
        boolean trovato = false;
        for (Libro lib : mensola) {
            if (lib.Autore.equalsIgnoreCase(autRicerca)) {
                System.out.println(lib.FormattaDati());
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato per l'autore: " + autRicerca);
        }
    }
    public boolean cancellazione(ArrayList<Libro> mensola, String autore, String titolo) {
        for (int i = 0; i < mensola.size(); i++) {
            Libro lib = mensola.get(i);
            if (lib.Autore.equalsIgnoreCase(autore) && lib.Titolo.equalsIgnoreCase(titolo)) {
                mensola.remove(i);
                return true;
            }
        }
        return false;
    }

    public void modificaData(ArrayList<Libro> mensola, String auto, Scanner tastiera) {
        for( Libro lib: mensola){
            if(lib.Autore.equalsIgnoreCase(auto)){
                lib.dataPubblicazione = pubblicazione(tastiera, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        }
    }
    public LocalDate pubblicazione(Scanner tastiera, DateTimeFormatter formatter){
        LocalDate dataPubb = null;
        do {
            try {
                System.out.println("Inserisci Data (dd-MM-yyyy):");
                String in = tastiera.nextLine();
                dataPubb = LocalDate.parse(in, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data non valida. Riprova.");
            }
        } while (dataPubb == null);
        return dataPubb;

    }

}