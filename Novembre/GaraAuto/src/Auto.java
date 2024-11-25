
public class Auto {
    private String scuderia;
    private Pilota pilota;
    private double cilindrata;

    public Auto(String scuderia, Pilota pilota, int cilindrata) throws Exception {
        if (scuderia == null || scuderia.trim().isEmpty()) {
            throw new Exception("La scuderia è vuota o nulla.");
        }
        if (cilindrata <= 0) {
            throw new Exception("La cilindrata deve essere maggiore di zero.");
        }

        this.scuderia = scuderia;
        this.pilota = pilota;
        this.cilindrata = cilindrata;
    }
    public String getScuderia() {return scuderia;}

    public Pilota getPilota() {return pilota;}

    public double getCilindrata() {return cilindrata;}
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("Scuderia: %s - Pilota: %s - Cilindrata: %.2f\n",scuderia,pilota,cilindrata);
    }
}
