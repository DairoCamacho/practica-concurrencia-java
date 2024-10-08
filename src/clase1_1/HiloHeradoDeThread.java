package clase1_1;

public class HiloHeradoDeThread extends Thread {
    /**
     * https://youtu.be/CkzG3ysYzFA?list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728
     * https://youtu.be/oOVj1fGXQrc?list=PLI13k_SD5SxGQC3CtDWM-BMo2Atbm0nCI
     * Para lanzar hilo se hace desde
     * objetos creados a partir de la clase que heredan de Thread
     * <p>
     * Start() se usa para lanzar los hilos
     * <p>
     * Lo hilos no se tienen que ejecutar inmediatamente  cuando se lanzan
     * ya que tardan un poquito de tiempo en procesarlos la CPU
     * <p>
     * No sabemos el orden de ejecución de los hilos
     * <p>
     * se puede usar el método .stop() para detener un hilo pero está desaconsejado
     * <p>
     * la clase Thread nos brinda el método getName para conocer el número del hilo
     */

    private int id;
    private String nombreTarea;
    private boolean activado;

    public HiloHeradoDeThread(int id, String nombreTarea) {
        this.id = id;
        this.nombreTarea = nombreTarea;
        this.activado = true;
    }

    @Override
    public void run() {
/*

        while (activado) {
            System.out.println("Soy del hilo: " + getName());
            // REQUERIRÁ DE UN MÉTODO PARA DETENER EL HILO ya que el ciclo es infinito
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
*/

        for (int i = 0; i < 10; i++) {
            System.out.println("Soy la tarea: " + nombreTarea + ", con el id: " + id + ", del " + getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
