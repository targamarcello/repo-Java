import Veicoli.Automobile;
import Veicoli.Moto;

public class Main {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria();
        concessionaria.addVeicolo(new Automobile("Fiat","Panda",10000,5));
        concessionaria.addVeicolo(new Moto("Ducati","Monster",12000,900));
        System.out.println("Veicoli presenti:");
        concessionaria.stampaVeicolo();
        concessionaria.aggiornaPrezzo("Fiat","Panda",95032);
        System.out.println("Veicolo post aggiornamento");
        concessionaria.stampaVeicolo();
        concessionaria.rimuoviVeicolo("Ducati","Monster");
        System.out.println("Post rimozione:");
        concessionaria.stampaVeicolo();
    }
}