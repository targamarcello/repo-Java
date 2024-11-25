import static utility.Tools.*;
import GestioneParco.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        boolean esci = true;

        ArrayList<Persona> lunaPark =new ArrayList<>();
        LunaPark l = new LunaPark();

        String[] opzioni = {"Menù","Accesso","Uscita", "Visualizza Giostre", "Visualizza giorno e accesso", "Esci"};
        do{
            switch (Menu(opzioni,tastiera)){
                case 1->{
                    System.out.println("INSERIMENTO DATI DI ACCESSO");
                    lunaPark.add(l.accesso(lunaPark,tastiera));
                }
                case 2->{
                    System.out.println("USCITA");
                    System.out.println("Inserisci numero biglietto della persona");
                    int bigliettoUscita = Integer.parseInt(tastiera.nextLine());
                    l.uscita(lunaPark,bigliettoUscita);
                }
                case 3->{
                    System.out.println("VISUALIZZA GIOSTRE");
                    System.out.println("Inserisci numero biglietto della persona");
                    int numBiglietto = Integer.parseInt(tastiera.nextLine());
                    l.visualizzaGiostre(lunaPark,numBiglietto);
                }
                case 4->{
                    System.out.println("VISUALIZZA GIORNO E ORARI");
                }
                case 5->{
                    System.out.println("Fine Programma");
                    esci = false;
                }
            }
        }while (esci);
    }
}