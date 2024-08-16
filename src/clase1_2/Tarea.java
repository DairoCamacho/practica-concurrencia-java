package clase1_2;

// https://youtu.be/w883bDxMgS8?list=PLI13k_SD5SxGQC3CtDWM-BMo2Atbm0nCI
public class Tarea extends ClaseBase implements Runnable {
    /**
     * La ventaja más grande es que
     * Implementar la interface Runnable nos permite poder hacer herencia de otro clase base
     * <p>
     * otra forma de lograr lo mismo, si hacemos que la clase base herede de Thread
     * <p>
     * para usar getName debemos hacerlo un poco más largo Thread.currentThread().getName()
     */
    private int id;
    private String nombreTarea;
    private boolean activado;

    public Tarea(int id, String nombreTarea) {
        this.id = id;
        this.nombreTarea = nombreTarea;
        this.activado = true;
    }

    public void desactivar() {
        activado = false;
    }

    @Override
    public void run() {
        while (activado) {
            System.out.println("Soy la tarea: " + nombreTarea + ", del ID : " + id + ", del hilo : " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
