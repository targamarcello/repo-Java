package GestioneParco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class LunaPark {
    private final int MAXCLIENTI = 5;


    //METODO ACCESSO
    public Persona accesso(ArrayList<Persona> lunapark, Scanner tastiera){
        if(lunapark.size() >= MAXCLIENTI){
            System.out.println("NON POSSONO ENTRARE ALTRE PERSONE!!");
            return null;
        }
        Persona newPersona = new Persona();
        newPersona.dataEntrata = LocalDate.now();
        do{
        System.out.println("Inserisci giostra da visitare:[1]Ruota Panoramica - [2]Autoscontro - [3]Ottovolante - [4]Tagadà");
        int scelta = Integer.parseInt(tastiera.nextLine());
        switch (scelta) {
            case 1 -> {
                newPersona.entraGiostra(TipoGiostra.RUOTAPANORAMICA);
            }
            case 2 -> {
                newPersona.entraGiostra(TipoGiostra.AUTOSCONTRO);
            }
            case 3 -> {
                newPersona.entraGiostra(TipoGiostra.OTTOVOLANTE);
            }
            case 4 -> {
                newPersona.entraGiostra(TipoGiostra.TAGADA);
            }

        }
            System.out.println("Vuoi visitare altre giostre? (S/N)");
        }while (tastiera.nextLine().equalsIgnoreCase("s"));
        newPersona.biglietto ++;
        lunapark.add(newPersona);
        return newPersona;
    }

    //METODO USCITA
    public void uscita(ArrayList<Persona> lunapark, int biglietto){
        Persona persona = trovaPersona(biglietto,lunapark);
        if(persona == null){
            System.out.println("Biglietto non valido!!");
            return;
        }
        lunapark.remove(persona);
        persona.dataUscita = LocalDate.now();
    }

    //VISUALIZZA GIOSTRE PER PERSONA
    public void visualizzaGiostre(ArrayList<Persona> lunapark, int biglietto){
        Persona persona = trovaPersona(biglietto,lunapark);
        if(persona == null){
            System.out.println("CLIENTE NON TROVATO!!");
            return;
        }
        System.out.printf("Le giostre visitate dal cliente con biglietto: %d\n",biglietto);
        persona.mostraGiostre();
    }

    //ACCESSO GIOSTRA
    public void accediGiostra(int biglietto, ArrayList<Persona>lunapark, TipoGiostra tipo){
        Persona persona = trovaPersona(biglietto,lunapark);
        if(persona == null){
            System.out.println("PERSONA NON TROVATA!!");
            return;
        }
        persona.entraGiostra(tipo);
    }

    //METODO RICERCA
    private Persona trovaPersona(int nBiglietto, ArrayList<Persona>lunapark){
        for(Persona persona : lunapark){
            if(persona.biglietto == nBiglietto);
            return persona;
        }
        return null;
    }
}