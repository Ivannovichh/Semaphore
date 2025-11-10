package View;

import Model.Aparcamiento;
import Model.Coche;

public class PrincipalParking {
    public static void main(String[] args) {
        // Crea el aparcamiento con 3 plazas
        Aparcamiento aparcamiento = new Aparcamiento(3);

        // Define el número total de coches que van a intentar entrar
        int totalCoches = 7;

        // Bucle que crea y lanza 7 coches
        for (int i = 1; i <= totalCoches; i++) {
            // Crea un nuevo coche con su nombre y el mismo aparcamiento compartido
            Coche coche = new Coche(aparcamiento, "Coche - " + i);

            // Crea un nuevo hilo que ejecutará el método run() del coche
            Thread hilo = new Thread(coche);

            // Inicia el hilo (comienza su ejecución concurrente)
            hilo.start();

            // Espera 0,2 segundos para ordenar los coches que salen
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
