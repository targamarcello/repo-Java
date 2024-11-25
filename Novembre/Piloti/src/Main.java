public class Main {
    public static void main(String[] args) {
        try {
            Pilota pilota1 = new Pilota("Mario", "Rossi", "Italiana", 30);
            Pilota pilota2 = new Pilota("Luigi", "Verdi", "Italiana", 35);

            try {
                Pilota pilotaInvalido = new Pilota("", "Bianchi", "Italiana", 28);
            } catch (Exception e) {
                System.out.println( e.getMessage());
            }

            try {
                Pilota pilotaDuplicato = new Pilota("Mario", "Rossi", "Italiana", 30);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Auto auto1 = new Auto("Ferrari", pilota1, 3000.0);
            System.out.println(auto1);

        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }
}
