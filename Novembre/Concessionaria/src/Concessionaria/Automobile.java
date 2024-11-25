package Concessionaria;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Automobile {
    public String marca;
    public String modello;
    public int cilindrata;
    public LocalDate dataProduzione;
    private DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //override del metodo toString per ritornare i dati
    @Override
    public String toString(){
        return String.format("Marca: %s - Modello: %s - Cilindrata: %s - Data Produzione: %s",marca,modello,cilindrata,dataFormat.format(dataProduzione));
    }
}