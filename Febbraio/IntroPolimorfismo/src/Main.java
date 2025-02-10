public class Main {
    public static void main(String[] args) {
        Studente s1 = new Studente("Alessandro", "Manzoni", 10, "Palermo", "Nero", "Napoli");
        Docente d1 = new Docente("Iginio", "Massari", 502, "Venezia", "Azzurro", "Napoli");
        Studente s2 = new Studente("Alessandro", "Moscardi", 16, "Milano", "Giallo", "Bari");
        Teatro t = new Teatro();
        try{
            t.ingressoTeatro(s1);
            t.ingressoTeatro(d1);
            t.ingressoTeatro(s2);
            t.stampa();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}