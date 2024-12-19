package frontScreen;

import Concessionaria.Automobile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Frontend {
    //METODO INSERIMENTO
    public void Inserimento(ArrayList<Automobile> concessionaria, Scanner tastiera){
        Automobile auto = new Automobile();
        System.out.println("Inserisci marca");
        auto.marca = tastiera.nextLine();
        System.out.println("Inserisci modello");
        auto.modello = tastiera.nextLine();
        System.out.println("Inserisci cilindrata");
        auto.cilindrata = Integer.parseInt(tastiera.nextLine());
        System.out.println("Inserisci data produzione");
        auto.dataProduzione = LocalDate.parse(tastiera.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        concessionaria.add(auto);
    }
}