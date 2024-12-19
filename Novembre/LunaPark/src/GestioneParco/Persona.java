package GestioneParco;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persona {
    private ArrayList<TipoGiostra> giostreProvate = new ArrayList<>();
    public LocalDate dataEntrata;
    public LocalDate dataUscita;
    public int biglietto = 0;


    public void entraGiostra(TipoGiostra tipo){
        giostreProvate.add(tipo);
        System.out.printf("Il cliente ha provato la giostra: %s\n",tipo);
    }
    public void mostraGiostre(){
        for(TipoGiostra giostra : giostreProvate){
            System.out.printf(" - %s - ",giostra);
        }
    }
}