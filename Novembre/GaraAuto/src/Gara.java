import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gara {
    private String nomeGara;
    private int risultato;
    private ArrayList<Auto> autoPartecipanti;

    public Gara() {
        autoPartecipanti = new ArrayList<>();
        this.nomeGara = null;
        this.risultato = 0;
    }

    public Gara(String nome, int ris, ArrayList<Auto> veicoli) {
        this.nomeGara = nome;
        this.risultato = ris;
        autoPartecipanti = veicoli;
    }

    public String getNomeGara() {return nomeGara;}

    public void setNomeGara(String nomeGara) {this.nomeGara = nomeGara;}

    public ArrayList<Auto> getAutoPartecipanti() {return autoPartecipanti;}

    public void setAutoPartecipanti(ArrayList<Auto> autoPartecipanti) {this.autoPartecipanti = autoPartecipanti;}

    public int getRisultato() {return risultato;}

    public int corriGara() throws Exception {
        if (autoPartecipanti.size() > 1) {
            Random random = new Random();
            return this.risultato = random.nextInt(autoPartecipanti.size());
        }
        throw new Exception("Macchine insufficienti per effettuare una corsa");
    }

    public void AggiungiAuto(Auto veicolo) {
        autoPartecipanti.add(veicolo);
    }

    public void stampaVincitore() {
        try {
            int indiceVincitore = corriGara();
            Auto vincitore = autoPartecipanti.get(indiceVincitore);
            System.out.println("Il Vincitore della gara è: " + vincitore.toString());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
