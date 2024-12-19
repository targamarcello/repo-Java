

package Mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {

    public String Autore;
    public String Titolo;
    final double PREZZOPAG = 0.05;
    public int pagine;
    public TipologiaLib tipologia;
    public LocalDate dataPubblicazione;
    private DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public String FormattaDati(){
        return String.format("Autore: %s - Titolo: %s - Prezzo Pagina: %.2f - Pagine: %d - Tipologia: %s - Data: %s",Autore, Titolo, PREZZOPAG*pagine, pagine, tipologia, dataPubblicazione.format(dataFormat));
    }
    public String NuovoVisualizza(){
        return String.format("Autore: %s - Titolo : %s - Prezzo Pagine: %.2f",Autore,Titolo,PREZZOPAG*pagine);
    }
}
