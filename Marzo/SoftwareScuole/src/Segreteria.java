import FrontEnd.Tools;
import Scuole.Scuola;

import java.util.ArrayList;
import java.util.Scanner;

public class Segreteria {
    private ArrayList<Scuola> scuole;
    public Segreteria(){
        scuole = new ArrayList<>();
    }
    public void addScuola(Scanner scanner){
        Scuola scuola = Tools.leggiScuola(scanner);
        if(scuola!= null){
            scuole.add(scuola);
            System.out.println("Scuola aggiunta con successo!!");
        }
    }
    public void removeScuola(String codice){
        scuole.removeIf(scuola -> scuola.getCodice().equals(codice));
    }
    public ArrayList<Scuola> getScuole(){
        return new ArrayList<Scuola>(scuole);
    }
}
