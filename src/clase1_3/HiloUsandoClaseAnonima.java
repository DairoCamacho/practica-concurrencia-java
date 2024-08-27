package clase1_3;

public class HiloUsandoClaseAnonima {
    /**
     * No facilitar reutilizar código
     * <p>
     * Puede ser util cuando es muy complicado pasar la información a la otra tarea
     * */
    public static void main(String[] args) {
        System.out.println("Inicio del hilo principal \n");

        final int numeroVeces = 5;

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numeroVeces; i++) {
                    System.out.println("Soy el hilo: " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        hilo.start();

        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numeroVeces; i++) {
                    System.out.println("Soy el hilo: " + Thread.currentThread().getName());

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        hilo1.start();

        System.out.println("\nFin del hilo principal \n");
    }
}
