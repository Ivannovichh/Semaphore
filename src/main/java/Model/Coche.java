package Model;

import java.util.Random;

public class Coche implements Runnable {
    private final Aparcamiento aparcamiento; // Referencia al aparcamiento compartido
    private final String nombre;             // Nombre único del coche (ej: "Coche-1")
    private final Random random = new Random(); // Generador de números aleatorios

    // Constructor
    public Coche(Aparcamiento aparcamiento, String nombre) {
        this.aparcamiento = aparcamiento;
        this.nombre = nombre;
    }

    // Este método define lo que hace el hilo cuando se ejecuta
    @Override
    public void run() {
        aparcamiento.entrar(nombre); // Intenta entrar al aparcamiento (puede quedarse esperando)

        try {
            // Simula el tiempo que el coche está aparcado (1 a 4 segundos)
            Thread.sleep(1000 + random.nextInt(3000));
        } catch (InterruptedException e) {
            // Si el hilo es interrumpido mientras duerme, se marca como interrumpido de nuevo
            Thread.currentThread().interrupt();
        }

        aparcamiento.salir(nombre); // Sale del aparcamiento y libera una plaza
    }
}
