import BackEnd.Gara;
import BackEnd.Giocatore;
import Utility.Tools;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static Utility.Tools.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gara gara = null;
        boolean esci = false;
        Giocatore g1 = null;
        Giocatore g2 = null;
        String[] opz = {"GARA-DEI-DADI", "Inserisci giocatori","Inizia", "Vedi Vincitore","Round vinti","Fine"};
        do{
            int scelta = Menu(opz,sc);
            switch (scelta){
                case 1->{
                    g1 = Tools.leggiPlayer(sc);
                    g2 = Tools.leggiPlayer(sc);
                    System.out.println("Quanti round verranno giocati?");
                    int round = Integer.parseInt(sc.nextLine());
                    gara = new Gara(g1,g2,round);
                }
                case 2->{
                   do{
                        System.out.println(gara.round());
                    } while (!gara.isFineGara());
                }
                case 3->{
                    System.out.println(gara.getWinner());
                }
                case 4->{
                    try {
                        System.out.printf("Il giocatore %s ha vinto %d round\n", g1.getNome(), g1.getVittorie());
                        System.out.printf("Il giocatore %s ha vinto %d round\n", g2.getNome(), g2.getVittorie());
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                case 5->{
                    System.out.println("Fine programma...");
                    esci = true;
                }
            }
        }while (!esci);


    }
}