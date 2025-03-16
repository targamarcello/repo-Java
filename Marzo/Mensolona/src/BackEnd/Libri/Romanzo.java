package BackEnd.Libri;

public class Romanzo extends Libro{
    private GenereRomanzo genereLetterario;

    public Romanzo(String autore, String titolo, int nPagine, GenereRomanzo genereLetterario) {
        super(autore, titolo, nPagine);
        this.genereLetterario = genereLetterario;
    }
    @Override
    public String toString() {
        return super.toString() + "\nGenere: " + genereLetterario;
    }
}
