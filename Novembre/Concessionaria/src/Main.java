import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import utility.Tools.*;
import frontScreen.Frontend;
import Concessionaria.Automobile;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        final int MAXAUTO = 30;

        ArrayList<Automobile> concessionaria = new ArrayList<>();
        Automobile auto = new Automobile();
        Frontend front = new Frontend();

        for(int i=0; i<3; i++){
            if(concessionaria.size()<MAXAUTO) {
              front.Inserimento(concessionaria,tastiera);
            }
            else{
                System.out.println("Concessionaria piena!!");
            }
        }
    }
}