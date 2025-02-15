import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[]opz = {"START","ESCI"};
        Scanner scanner = new Scanner(System.in);
        Menu(opz,scanner);

    }


    static void Menu(String[]opz, Scanner sc){
        int scelta;
        do{
            System.out.println("=====GIOCO DADI CONSOLE=====");
            for(int i=0; i<opz.length; i++){
                System.out.println(String.format("[%d] %s",i+1,opz[i] ));
            }
            scelta = Integer.parseInt(sc.nextLine());
            switch (scelta){
                case 1->{
                    InizioPartita(sc);
                }
                default -> System.out.println("ERRORE NELLA SCELTA!!");
            }
        }while (scelta != opz.length);
    }

    static void InizioPartita(Scanner scanner){
        String n1, n2,risp;
        System.out.println("Inserisci il numero dei round:");
        int nRound = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci nome giocatore1");
        n1 = scanner.nextLine();
        System.out.println("Inserisci nome giocatore2");
        n2 = scanner.nextLine();
        Gara gara = new Gara(nRound,n1,n2,6);
        do{
            while (!gara.FineGara()){
                System.out.println(gara.Winner());
            }
            System.out.println(gara.GameWin());
            System.out.println("Vuoi giocare ancora? (S/N)");
            do{
                risp = scanner.nextLine().toUpperCase();
            }while (risp == null || risp == "");
            if(risp == "S"){
                gara.ResetGame();
            }
        }while (risp !="N");

    }
}