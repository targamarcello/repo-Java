import FrontEnd.Tools;
import Negozio.GestioneNegozio;
import Negozio.Prodotti.Smartphone;

import java.util.Scanner;
/**
 * @author Marcello Targa
 * @version 1.0
 * @since 31/032025
 */
public class Main {
    public static void main(String[] args) {
        boolean uscita = false;
        GestioneNegozio negozio = new GestioneNegozio(4);
        Scanner sc = new Scanner(System.in);
        String[] opz = {"--- NEGOZIO ELETTRONICA ---", "1. Inserimento", "2. Visualizzazione", "3. Cancellazione", "4. Inserimento manuale", "5. Fine"};

        do {
            int scelta = Tools.Menu(opz, sc);
            try {
                switch (scelta) {
                    case 1 -> {
                        System.out.println("Inserimento Prodotto");
                        if (!negozio.checkSpace()) {
                            negozio.addProdotto(Tools.leggiSmartphone(sc));
                        }
                    }
                    case 2 -> {
                        System.out.println("Visualizzazione Inventario");
                        if (!negozio.getInventario().isEmpty()) {
                            Tools.visualizzaProdotti(negozio.getInventario());
                        }
                    }
                    case 3 -> {
                        System.out.println("Cancellazione Prodotto");
                        System.out.println("Inserisci codice:");
                        String codice = sc.nextLine();
                        negozio.removeProdotto(new Smartphone(0, "", codice, "", 0));
                        System.out.println("Prodotto eliminato");
                    }
                    case 4 -> {
                        System.out.println("Inserimento Manuale");
                        if (!negozio.checkSpace()) {
                            negozio.addProdotto(Tools.leggiManuale(sc));
                        }
                    }
                    case 5 -> {
                        System.out.println("Fine programma...");
                        uscita = true;
                    }

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!uscita);
    }
}