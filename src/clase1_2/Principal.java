package clase1_2;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Inicio del hilo principal \n");

        Tarea tareaEjecutable = new Tarea(0, "multiplicar");
        // ahora debemos para la tarea a Thread para convertirlo en hilo
        Thread hilo = new Thread(tareaEjecutable);
        hilo.start();

        Tarea tareaEjecutable1 = new Tarea(1, "dividir");
        // ahora debemos para la tarea a Thread para convertirlo en hilo
        Thread hilo1 = new Thread(tareaEjecutable1);
        hilo1.start();

        System.out.println("\nFin del hilo principal \n");
    }
}
