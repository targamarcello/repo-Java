import FrontEnd.Tools;
import Negozio.GestioneNegozio;
import Negozio.ProdottoElettronico;
import Negozio.Smartphone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean uscita = false;
        GestioneNegozio negozio = new GestioneNegozio(4);
        Scanner sc = new Scanner(System.in);
        String[]opz = {"--- NEGOZIO ELETTRONICA ---","1. Inserimento","2. Visualizzazione","3. Ricerca","4. Cancellazione","5. Fine"};

        do{
            int scelta = Tools.Menu(opz,sc);
            try{
                switch (scelta){
                    case 1->{
                        System.out.println("Inserimento Prodotto");
                        if(!negozio.checkSpace()){
                            negozio.addProdotto(Tools.leggiSmartphone(sc));
                        }
                    }
                    case 2->{
                        System.out.println("Visualizzazione Inventario");
                        if(!negozio.getInventario().isEmpty()){
                            Tools.visualizzaProdotti(negozio.getInventario());
                        }
                    }
                    case 3->{
                        System.out.println("Ricerca Inventario");
                        if(!negozio.getInventario().isEmpty()){
                            System.out.println("Inserisci codice:");
                            String codice = sc.nextLine();
                            System.out.println("Il prodotto è presente: "+negozio.cercaProdotto(codice));
                        }
                    }
                    case 4->{
                        System.out.println("Cancellazione Prodotto");
                        System.out.println("Inserisci codice:");
                        String codice = sc.nextLine();
                        if(negozio.cercaProdotto(codice) != null){
                            negozio.removeProdotto(new Smartphone(0,"",codice,"",0));
                            System.out.println("Prodotto eliminato");
                        }
                    }
                    case 5->{
                        System.out.println("Fine programma...");
                        uscita = true;
                    }

                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (!uscita);
    }
}