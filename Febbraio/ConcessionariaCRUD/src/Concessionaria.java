import Veicoli.Veicolo;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class Concessionaria {
    private ArrayList<Veicolo> officina = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void addVeicolo(Veicolo v){
        officina.add(v);
    }
    public void stampaVeicolo(){
        if(officina.isEmpty()){
            System.out.println("OFFICINA VODA!!");
        }
        for(Veicolo v: officina){
            System.out.println(v);
        }
    }
    public void aggiornaPrezzo(String marca, String modello, int nuovoPrezzo){
        for(Veicolo v:officina){
            if(v.getMarca().equalsIgnoreCase(marca) && v.getModello().equalsIgnoreCase(modello)){
                v.setPrezzo(nuovoPrezzo);
                System.out.println("Prezzo aggiornato!");
                return;
            }
        }
        System.out.println("Veicolo non trovato!!");;
    }
    public void rimuoviVeicolo(String marca, String modello){
        for(int i=0; i<officina.size(); i++){
            Veicolo v= officina.get(i);
            if(v.getMarca().equalsIgnoreCase(marca) && v.getModello().equalsIgnoreCase(modello)){
                officina.remove(i);
                System.out.println("Veicolo rimosso!!");
                return;
            }
        }
        System.out.println("Veicolo non trovato");
    }
    public int numeroVeicoli(){
        return officina.size();
    }
}