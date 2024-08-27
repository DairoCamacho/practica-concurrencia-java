package clase1_4;

public class HilosDesdeVectoresYusoDeJoin extends Thread {
    private int id;

    // constructor
    public HilosDesdeVectoresYusoDeJoin(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Soy el hilo: " + id);
    }


}
