import BackEnd.Libro;
import BackEnd.Mensola;
import FrontEnd.Tools;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mensola mensola = new Mensola(0);
        String directoryPath = "./data"; // Directory dei file JSON

        // Creazione directory se non esiste
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        String[] opzioniMenu = {
                "Gestione Mensola",
                "Aggiungi libro",
                "Salva mensola in JSON",
                "Carica mensola da JSON",
                "Visualizza mensola",
                "Elenca file nella directory e visualizza contenuto",
                "Esci"
        };

        while (true) {
            int scelta = Tools.Menu(opzioniMenu, scanner);

            switch (scelta) {
                case 1 -> {
                    Libro libro = Tools.leggiLibro(scanner, true);
                    mensola.addLibro(libro);
                    System.out.println("Libro aggiunto con successo!");
                }
                case 2 -> salvaMensolaInJson(mensola, directoryPath);
                case 3 -> mensola = caricaMensolaDaJson(directoryPath);
                case 4 -> visualizzaMensola(mensola);
                case 5 -> elencaEVisualizzaFile(directoryPath, scanner);
                case 6 -> {
                    System.out.println("Uscita in corso...");
                    return;
                }
                default -> System.out.println("Opzione non valida. Riprova.");
            }
        }
    }

    private static void salvaMensolaInJson(Mensola mensola, String directoryPath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(mensola);

        try (FileWriter writer = new FileWriter(directoryPath + "/mensola.json")) {
            writer.write(json);
            System.out.println("Mensola salvata con successo in mensola.json.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }

    private static Mensola caricaMensolaDaJson(String directoryPath) {
        File file = new File(directoryPath + "/mensola.json");
        if (!file.exists()) {
            System.out.println("Nessun file JSON trovato.");
            return new Mensola(0);
        }

        try (FileReader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Mensola mensola = gson.fromJson(reader, Mensola.class);
            System.out.println("Mensola caricata con successo da mensola.json.");
            return mensola;
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento: " + e.getMessage());
            return new Mensola(0);
        }
    }

    private static void visualizzaMensola(Mensola mensola) {
        if (mensola.isEmpty()) {
            System.out.println("La mensola è vuota.");
        } else {
            System.out.println("\nLibri sulla mensola:");
            for (Libro libro : mensola.getMensola()) {
                System.out.println(libro);
            }
        }
    }

    private static void elencaEVisualizzaFile(String directoryPath, Scanner scanner) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Nessun file trovato nella directory.");
            return;
        }

        String[] fileMenu = new String[files.length + 1];
        fileMenu[0] = "Seleziona un file da visualizzare";
        for (int i = 0; i < files.length; i++) {
            fileMenu[i + 1] = files[i].getName();
        }

        int scelta = Tools.Menu(fileMenu, scanner);
        if (scelta < 1 || scelta > files.length) {
            System.out.println("Scelta non valida.");
            return;
        }

        File fileSelezionato = files[scelta - 1];

        // Lettura semplificata del file
        try (FileReader reader = new FileReader(fileSelezionato)) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character); // Stampa ogni carattere
            }
            System.out.println(); // Vai a capo dopo la lettura del file
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }
}
