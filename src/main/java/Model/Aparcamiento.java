package Model;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Aparcamiento {
    private final Semaphore semaforo; // Objeto Semaphore que limita cuántos coches pueden entrar a la vez
    private int plazasOcupadas = 0;
    private final int capacidad;
    private final CountDownLatch primerosEnLog; // Sirve para controlar entradas y salidas de hilo

    // Constructor
    public Aparcamiento(int capacidad) {
        this.capacidad = capacidad;
        this.semaforo = new Semaphore(capacidad, true);
        this.primerosEnLog = new CountDownLatch(capacidad);
    }

    // Método para que un coche intente entrar al aparcamiento
    public void entrar(String nombreCoche) {
        try {
            // Intenta coger un permiso sin bloquear inmediatamente
            if (semaforo.tryAcquire()) {
                // Sección sincronizada para modificar el contador de plazas de forma segura
                synchronized (this) {
                    plazasOcupadas++; // Incrementa el número de coches dentro
                    System.out.printf("%s ha entrado. Plazas ocupadas: %d%n", nombreCoche,  plazasOcupadas);
                }
                // Contador inverso para bloquear cuando estén todas las plazas ocupadas
                primerosEnLog.countDown();
            } else {
                // Si no hay permisos disponibles, el coche debe esperar
                // Espera (bloquea) a que los 3 primeros impriman el mensaje de haber entrado
                primerosEnLog.await();

                System.out.println(nombreCoche + " está esperando...");

                // Espera (bloquea) hasta que haya una plaza libre
                semaforo.acquire();

                synchronized (this) {
                    plazasOcupadas++; // Incrementa el número de coches dentro
                    System.out.printf("%s ha entrado. Plazas ocupadas: %d%n", nombreCoche,  plazasOcupadas);
                }
            }


        } catch (InterruptedException e) {
            // Si el hilo es interrumpido mientras espera, se marca como interrumpido otra vez
            Thread.currentThread().interrupt();
        }
    }

    // Método para que un coche salga del aparcamiento
    public void salir(String nombreCoche) {
        semaforo.release(); // Libera un permiso (una plaza más disponible)

        // Bloque sincronizado para modificar el contador de forma segura
        synchronized (this) {
            plazasOcupadas--; // Decrementa el número de coches dentro
            System.out.println(nombreCoche + " ha salido. Plazas ocupadas: " + plazasOcupadas);
        }
    }
}
