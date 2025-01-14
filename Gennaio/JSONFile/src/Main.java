import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Gson tgson = new Gson();
        Persona p = new Persona("Alessandro",57);
        String json = tgson.toJson(p); // Serializzazione
        System.out.println(json);
        Persona personaFromJson = tgson.fromJson(json,Persona.class);
        System.out.println(personaFromJson.toString());
        ArrayList<Persona> persone = new ArrayList<>();
        persone.add(p);
        persone.add(new Persona("Federico",61));
        persone.add(new Persona("Antonino",65));
        persone.add(new Persona("Maurizio",72));

        //serializzazione su file di PERSONE su file di tipo json
        Gson gsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        String gsonContent = gsonBuilder.toJson(persone);
        //System.out.println(gsonContent);
        try{
            Files.write(Paths.get("persone.json"),gsonContent.getBytes());
        }catch (Exception e){
            e.getMessage();
        }

        try{
            byte[] jsonData = Files.readAllBytes(Path.of("persone.json"));
            Persona[] collezione =tgson.fromJson(new String(jsonData),Persona[].class);
            ArrayList<Persona> archivio = new ArrayList<>(Arrays.asList(collezione));
            //ARCHIVIO DESERIALIZZATO
            System.out.println(archivio);
        }catch (Exception e){
            e.getMessage();
        }
    }
}