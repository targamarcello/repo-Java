package Garapkg;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class CarSound {
    private Clip engineClip;

    // Carica e inizializza il suono del motore
    public CarSound() {
        try {
            // Carica il suono del motore
            File soundFile = new File("resources/engine.wav"); // Modifica il percorso del file se necessario
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            engineClip = AudioSystem.getClip();
            engineClip.open(audioStream);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Avvia il suono del motore
    public void startEngineSound() {
        if (engineClip != null) {
            engineClip.loop(Clip.LOOP_CONTINUOUSLY);  // Riproduce il suono in loop
        }
    }

    // Ferma il suono del motore
    public void stopEngineSound() {
        if (engineClip != null && engineClip.isRunning()) {
            engineClip.stop();
        }
    }

    // Modifica la frequenza del suono in base al tempo di giro
    public void changeEnginePitch(int tempoGiro) {
        if (engineClip != null) {
            // Aumenta o diminuisci la velocità del motore in base al tempo di giro
            FloatControl control = (FloatControl) engineClip.getControl(FloatControl.Type.SAMPLE_RATE);
            float newSampleRate = control.getValue() * (1 + (100 - tempoGiro) / 100.0f); // Più veloce è, più alto sarà il suono
            control.setValue(newSampleRate);
        }
    }
}
