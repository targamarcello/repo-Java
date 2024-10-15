import static utility.Tools.*;

import java.util.Scanner;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String[] opzioni = {"Menù", "1 Genera Random", "2 Visualizzazione", "3 Fine"};
        boolean esci = true;
        final int MAXNUMERI = 100;
        int [] nEstratti = new int[MAXNUMERI];
        do{
            switch(Menu(opzioni, tastiera)){
                case 1:
                    System.out.println("Generazione");
                    for (int i =0; i < MAXNUMERI; i++){
                        generaNumeri(nEstratti);
                    }
                    break;
                case 2:
                    System.out.println("Visualizzazione");
                    for (int i =0; i < MAXNUMERI; i++){
                        System.out.println(nEstratti[i]);
                    }
                    break;
                case 3:
                    System.out.println("Fine");
                    esci = false;
                    break;
            }
        }while(esci);
    }
    public static void generaNumeri(int [] nNumeri){
        for (int i =0; i<nNumeri.length; i++){
            nNumeri[i] = i+1;
        }
        Random numRandom = new Random();
        for (int i =nNumeri.length-1 ; i> 0; i--){
            int indice = numRandom.nextInt(i+1);
            int temp = nNumeri[i];
            nNumeri[i] = nNumeri[indice];
            nNumeri[indice] = temp;
        }
    }
}