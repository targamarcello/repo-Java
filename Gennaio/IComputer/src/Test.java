import PC.ClassePC;
import PC.DImCase;
import PC.Fissi.PCDesktop;
import PC.Fissi.Server;
import PC.PCPortatili;

public class Test {
    public static void main(String[] args) {
        ClassePC pc1 = new PCDesktop("Intel i7",16,512,"Dell","XPS","Windows 10", DImCase.MEDIO,"NVIDIA RTX 3060");
        ClassePC pc2 = new Server("AMD EPYC",64,2048,"HP","ProLiant","Linux",DImCase.GRANDE,2,true);
        ClassePC pc3 = new PCPortatili("M1",16,512,"MelaMangiata","MacBook Pro","macOS",1,1.5,30,20,16);
        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(pc3);

        // Upcasting
        ClassePC pcUpcasted = new PCDesktop("Intel i9",32,1024,"Asus","ROG","Windows 11",DImCase.GRANDE,"NVIDIA RTX 4090");
        System.out.println(pcUpcasted);
        // Downcasting
        if (pcUpcasted instanceof PCDesktop) {
            PCDesktop desktop = (PCDesktop) pcUpcasted;
            System.out.println("Downcasting riuscito: " + desktop);
        }
    }
}