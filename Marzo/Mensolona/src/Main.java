// Main.java
import BackEnd.Libri.*;
import BackEnd.Mensola;
import FrontEnd.Tools;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean uscita = false;
        Scanner tastiera = new Scanner(System.in);
        Mensola libreria = new Mensola(3); // Creazione della mensola

        String[] opzioni = {"---LIBRERIA---", "1. Inserimento", "2. Visualizzazione", "3. Ricerca", "4. Cancellazione", "5. JSON", "6. Esporta CSV", "7. Importa CSV", "8. Fine"};

        do {
            int scelta = Tools.Menu(opzioni, tastiera); // Utilizza il menu definito in Tools
            try {
                switch (scelta) {
                    case 1 -> {
                        System.out.println("Inserimento libro");
                        if (!libreria.checkSpace()) {
                            libreria.addLibro(Tools.leggiLibro(tastiera)); // Legge e aggiunge il libro
                        }
                    }

                    case 2 -> {
                        System.out.println("Visualizzazione mensola");
                        if (!libreria.isEmpty()) {
                            Tools.visualizzaMensola(libreria.getVolumi());
                        }
                    }

                    case 3 -> {
                        System.out.println("Ricerca libro");
                        if (!libreria.isEmpty()) {
                            System.out.println("Inserisci autore: ");
                            String autore = tastiera.nextLine();
                            System.out.println("Inserisci titolo: ");
                            String titolo = tastiera.nextLine();
                            System.out.println("Il libro è presente: " + libreria.findLibro(autore, titolo));
                        }
                    }

                    case 4 -> {
                        System.out.println("Cancellazione libro");
                        if (!libreria.isEmpty()) {
                            System.out.println("Inserisci autore: ");
                            String autore = tastiera.nextLine();
                            System.out.println("Inserisci titolo: ");
                            String titolo = tastiera.nextLine();
                            if (libreria.findLibro(autore, titolo)) {
                                libreria.removeBook(new Romanzo(autore, titolo, 0, GenereRomanzo.FANTASY));
                                System.out.println("Libro eliminato");
                            }
                        }
                    }

                    case 5 -> Tools.salvaInJson(libreria); // Salvataggio in JSON

                    case 6 -> Tools.esportaCSV(libreria); // Esporta in CSV

                    case 7 -> {
                        System.out.println("Importazione CSV");
                        libreria.getMensola().addAll(Tools.importaCSV("libri.csv"));
                    }

                    case 8 -> {
                        System.out.println("Uscita");
                        uscita = true;
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (!uscita);
    }
}
