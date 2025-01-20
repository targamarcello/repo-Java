import BackEnd.Genere;
import BackEnd.Libro;
import BackEnd.Mensola;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import FrontEnd.Tools;

import static FrontEnd.Tools.*;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean uscita = false;

        Scanner tastiera = new Scanner(System.in);
        boolean soluzioni = false;
        Mensola libreria = new Mensola(3);

        String[] opzioni = {"---LIBRERIA---", "1. Inserimento", "2. Visualizzazione", "3. Ricerca", "4. Cancellazione", "5. JSON","6. Esporta CSV","7. Importa CSV", "8. Fine"};
        do {
            clrScr();
            int scelta = Menu(opzioni, tastiera);
            switch (scelta) {
                case 1 -> {
                    try {
                        System.out.println("Inserimento");
                        if (!libreria.checkSpace()) {
                            libreria.addLibro(Tools.leggiLibro(tastiera, soluzioni));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("Visualizzazione");
                    if (!libreria.isEmpty()) {
                        visualizzaMensola(libreria.getVolumi());
                    }
                }

                case 3 -> {
                    System.out.println("Ricerca");
                    if (!libreria.isEmpty()) {
                        System.out.println("Inserisci un'autore: ");
                        String autore = tastiera.nextLine();
                        System.out.println("Inserisci un titolo: ");
                        String titolo = tastiera.nextLine();

                        System.out.println("Il libro è presente nella mensola: " + libreria.findLibro(autore, titolo));
                    }
                }

                case 4 -> {
                    System.out.println("Cancellazione");
                    int i = 0;

                    if (!libreria.isEmpty()) {
                        System.out.println("Inserisci l'autore del libro");
                        String autore = tastiera.nextLine();
                        System.out.println("Inserisci il titolo del libro");
                        String titolo = tastiera.nextLine();

                        if (libreria.findLibro(autore, titolo)) {
                            for (i = 0; i < libreria.getMensola().size(); i++) {
                                Libro libro1 = libreria.getMensola().get(i);
                                if (libro1.getAutore().equals(autore) && libro1.getTitolo().equals(titolo)) {
                                    try {
                                        libreria.removeBook(libro1);
                                        System.out.println("Libro eliminato");
                                    } catch (Exception e) {
                                        System.out.println("Errore: " + e.getMessage());
                                    }
                                }
                            }
                        }
                    }

                }

                case 5 -> {
                    try {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        String jsonContent = gson.toJson(libreria);
                        Files.write(Paths.get("libro.json"), jsonContent.getBytes());
                        System.out.println("Dati salvati con successo");
                    } catch (Exception e) {
                        System.out.println("Errore durante il salvataggio: " + e.getMessage());
                    }
                }

                case 6->{
                    libreria.scriviCSV("mensola.csv");
                }

                case 7->{

                }

                case 8 -> {
                    System.out.println("Fine");
                    uscita = true;
                }
            }
        }
        while (!uscita);
    }
}