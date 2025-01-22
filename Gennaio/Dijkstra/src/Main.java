import PacchettoSbusto.Nodo;

import javax.xml.transform.Source;
import java.awt.*;
import java.util.List;
import java.util.Scanner;
import static utility.Tools.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GrafoDijkstra grafo = new GrafoDijkstra();
        boolean esci = false;
        String[]opz = {"DIJKSTRA","1.Aggiungi Nodo","2.Aggiungi Arco","3. Visualizza nodi","4. Esegui Dijkstra","5. Esci"};
        do{
            switch (Menu(opz,sc)){
                case 1->{
                    System.out.println("Inserisci nome nodo");
                    String hostname = sc.nextLine();
                    System.out.println("Inserisci indice nodo");
                    int indice = Integer.parseInt(sc.nextLine());
                    System.out.println("Inserisci classe nodo");
                    String classe = sc.nextLine();
                    grafo.aggiungiNodo(hostname,indice,classe);
                }
                case 2->{
                    try {
                        System.out.println("Inserisci nodo partenza");
                        String da = sc.nextLine();
                        System.out.println("Inserisci nodo destinazione");
                        String a = sc.nextLine();
                        System.out.println("Inserisci costo arco");
                        int costo = Integer.parseInt(sc.nextLine());
                        grafo.aggiungiArco(da, a, costo);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
                case 3->{
                    List<Nodo> nodi = grafo.get_nodi();
                    System.out.println("NODI DEL GRAFO:");
                    for(Nodo nodo : nodi){
                        System.out.println(nodo +" | Collegamenti: "+nodo._collegamenti);
                    }
                }
                case 4->{
                    System.out.println("Inserisci il nodo di partenza per Dijkstra");
                    String noodIniz = sc.nextLine();
                    try{
                        int[] distanza = grafo.dijkstra(noodIniz);
                        List<Nodo> nodoDijkstra = grafo.get_nodi();
                        System.out.println("Distanze minime da "+noodIniz+":");
                        for (int i=0; i<nodoDijkstra.size(); i++){
                            System.out.println("A "+ nodoDijkstra.get(i)._hostname+":"+(distanza[i]==Integer.MAX_VALUE ? "Inf":distanza[i]));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5->{
                    esci = true;
                    System.out.println("Fine programma!!");
                }
                default -> System.out.println("ERROE SCELTA!!");
            }
        }while (!esci);
    }
}