package clase1;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Inicio del hilo principal \n");

        // Para lanzar hilos se hace desde objetos que heredan de Thread
        HiloHeradoDeThread hilo1 = new HiloHeradoDeThread(0, "procedimiento");
        HiloHeradoDeThread hilo2 = new HiloHeradoDeThread(1, "suma");
        HiloHeradoDeThread hilo3 = new HiloHeradoDeThread(2, "concatenar");

        hilo1.start(); // ejecuta el contenido del método run()
        hilo2.start();
        hilo3.start();

        System.out.println("\nFin del hilo principal \n ");
    }
}
