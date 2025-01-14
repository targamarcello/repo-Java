import BackEnd.Libro;
import FrontEnd.Tools;
import static FrontEnd.Tools.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sol = false;
        Libro l1 = Tools.leggiLibro(sc,sol);
        String[] opz = {"----LIBRERIA----", "1-Inserimento","2-Visualizza","3-Fine"};
        int scelta = Menu(opz,sc);
        switch (scelta){
            case 1->{
                System.out.println("Inserimento");
                Libro lib = Tools.leggiLibro(sc,sol);
            }
            case 2->{
                System.out.println("Visualizza");
            }
            case 3->{
                System.out.println("Fine programma");
            }
        }
    }
}