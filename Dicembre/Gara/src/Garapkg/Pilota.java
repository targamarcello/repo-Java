package Garapkg;

public class Pilota {

    private String nome;
    private String cognome;
    private String nazionalità;

    public Pilota(String nome,String cognome,String nazionalità)throws Exception{
        if(isValue(nome)&&isValue(cognome)&&isValue(nazionalità)){
            this.nome = nome;
            this.cognome = cognome;
            this.nazionalità = nazionalità;
        }else{
            throw new Exception("Invalid data");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Cognome: %s, Nazionalità: %s",nome,cognome,nazionalità) ;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pilota)) {
            return false;
        }
        else{
             Pilota p = (Pilota)obj ;
           return this.nome.equals(p.nome) && this.cognome.equals(p.cognome) && this.nazionalità.equals(p.nazionalità);
        }

    }
    private boolean isValue(String valore){
        return valore!= null && !valore.isEmpty();
    }
}
