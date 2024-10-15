import static utility.Tools.*;


import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String[] opzioni = {"Menù", "1-Genera Random", "2-Visualizzazione", "3-Ricerca","4-Rimuovi","5-Rimuovi Con Copia", "6-Fine"};
        boolean esci = true;
        final int MAXNUMERI = 100;
        int[] nEstratti = new int[MAXNUMERI];
        do {
            switch (Menu(opzioni, tastiera)) {
                case 1-> {
                    System.out.println("Generazione");
                    for (int i = 0; i < MAXNUMERI; i++) {
                        generaNumeri(nEstratti);
                    }
                }
                case 2 ->{
                    System.out.println("Visualizzazione");
                    VisualizzaRighe(nEstratti);
                }
                case 3->{
                    System.out.println("Ricerca");
                    int n = Integer.parseInt(tastiera.nextLine());
                    int ritorno =Ricerca(nEstratti, n);
                    if(ritorno > -1) {
                        System.out.println("Il numero esiste ed è in posizione " + ritorno);
                    }
                    else{
                        System.out.println("Il numero non esiste");
                    }
                }
                case 4->{
                    System.out.println("Rimuovi");
                    System.out.println("Inserisci numero da rimuovere:");
                    nEstratti = Rimuovi(nEstratti, Integer.parseInt(tastiera.nextLine()));
                }
                case 5->{
                    System.out.println("Rimuovi Con Copia");
                    System.out.println("Inserisci numero da rimuovere:");
                    int[]copiaRimozione = RimozioneConCopia(nEstratti, Integer.parseInt(tastiera.nextLine()));
                    System.out.println("ARRAY COPIA");
                    VisualizzaRighe(copiaRimozione);
                }
                case 6->{
                    System.out.println("Fine");
                    esci = false;
                }
                default->{
                    System.out.println("Opzione Sbagliata");}

            }
        } while (esci);
    }

    public static void generaNumeri(int[] nNumeri) {
        for (int i = 0; i < nNumeri.length; i++) {
            nNumeri[i] = i + 1;
        }
        Random numRandom = new Random();
        for (int i = nNumeri.length - 1; i > 0; i--) {
            int indice = numRandom.nextInt(i + 1);
            int temp = nNumeri[i];
            nNumeri[i] = nNumeri[indice];
            nNumeri[indice] = temp;
        }
    }

    public static void VisualizzaRighe(int[] vett) {
        int cont = 0;
        for (int i : vett) {
            System.out.printf("%-4d", i);
            cont++;
            if (cont == 10) {
                cont = 0;
                System.out.println();
            }
        }
        System.out.println();
    }

    public static int Ricerca(int [] vett, int n) {
        for(int i=0; i<vett.length; i++) {
            if (n == vett[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int [] Rimuovi(int[] vett, int numeroRimozione) {
        int count =0;
        for(int i: vett){
            if(i != numeroRimozione){
                count++;
            }
        }
        int[] vettCorrotto = new int[count];
        int indiceNuovo =0;
        for(int i: vett){
            if (i != numeroRimozione){
                vettCorrotto[indiceNuovo] = i;
                indiceNuovo++;
            }
        }
        return vettCorrotto;
    }
    public static int [] RimozioneConCopia(int[] vett, int numeroRimozione) {
        int[] nuovoVettore= new int[vett.length];
        for(int i=0; i<vett.length; i++){
            if(vett[i] == numeroRimozione){
                nuovoVettore[i] = 0;
            }else{
                nuovoVettore[i] = vett[i];
            }
        }
        return nuovoVettore;
    }
}