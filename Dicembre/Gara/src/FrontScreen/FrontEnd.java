package FrontScreen;

import Garapkg.Cronometro;
import Garapkg.Gara;
import Garapkg.Pilota;
import Garapkg.Scuderia;
import static utility.Tools.*;

import java.awt.*;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class FrontEnd {
    private Gara gara;
    private Scanner sc;

    public FrontEnd() {
        sc = new Scanner(System.in);
        this.gara = new Gara("Gran Premio", "Italia");
    }

    //metodo per inserimento dei dati del pilota e della sua scuderia
    public void inserimentoDati() {
        try {
            System.out.println("Inserisci nome pilota:");
            String nome = sc.nextLine();
            System.out.println("Inserisci cognome pilota:");
            String cognome = sc.nextLine();
            System.out.println("Inserisci nazionalità pilota:");
            String nazionalita = sc.nextLine();
            Pilota p = new Pilota(nome, cognome, nazionalita);
            System.out.println("Inserisci scuderia del pilota:");
            String scud = sc.nextLine();
            System.out.println("Inserisci numero auto:");
            int numAuto = Integer.parseInt(sc.nextLine());
            Scuderia scuderia = new Scuderia(scud, p, numAuto);
            gara.addScuderia(scuderia);
            System.out.println("Scuderia aggiunta alla gara!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //metodo per correre la gara
    public void corriGara() {
        try {
            for (Scuderia scud : gara.getGriglia()) {
                Cronometro c = new Cronometro();
                c.setStartTime();
                Thread.sleep(2000);
                c.setEndTime();
                //int tempoGiro = c.calcolaTempoGiro();     //metodo senza random
                Random random = new Random();
                int tempoGiro = random.nextInt(100)+1;      //metodo col random
                scud.setTGiro(tempoGiro);
                System.out.println(scud.getScuderia() + " ha finito il giro in " + tempoGiro + "secondi");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //stampa della classifica
    public void visualizzaClassifica(){
        Collections.sort(gara.getGriglia());
        System.out.println("Classifica finale:");
        for(Scuderia scud : gara.getGriglia()){
            System.out.println(scud + " - Tempo "+scud.getTGiro());
        }
    }

    //metodo per vedere la griglia di partenza
    public void visualizzaGriglia(){
        Collections.sort(gara.getGriglia());
        System.out.println("Griglia di partenza");
        for(Scuderia scud : gara.getGriglia()){
            System.out.println(scud + "- Tempo Giro: " + scud.getTGiro());
        }
    }

    //metodo per il menù
    public void startFrontEnd(){
        boolean esci = true;
        String []opz = {"Opzioni","Aggiungi concorrente","Corri Gara","Visualizza classifica","Visualizza griglia partenza","Esci"};
        do{
            switch (Menu(opz,sc)){
                case 1->{
                    inserimentoDati();
                }
                case 2->{
                    corriGara();
                }
                case 3->{
                    visualizzaClassifica();
                } case 4->{
                    visualizzaGriglia();
                }
                case 5->{
                    esci = false;
                    System.out.println("Programma finito!");
                }
                default -> {
                    System.out.println("OPZIONE NON VALIDA!!");
                }
            }
        }while (esci);

    }

}
