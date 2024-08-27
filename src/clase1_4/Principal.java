package clase1_3333;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Inicio del hilo principal \n");

        HilosDesdeVectoresYusoDeJoin[] vector = new HilosDesdeVectoresYusoDeJoin[5];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = new HilosDesdeVectoresYusoDeJoin(i);
            vector[i].start();
        }

        System.out.println("\nFin del hilo principal \n ");
    }
}
