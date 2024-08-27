package clase1_1;

import java.util.Random;

public class EjemRendimientoConcurrencia extends Thread {
  private static double[] vec = new double[80000000];//80.000.000
  private int inicio, fin;

  public EjemRendimientoConcurrencia(int inicio, int fin) {
    this.inicio = inicio;
    this.fin = fin;
  }

  public static void main(String[] args) {
    iniciavec();

    //opción NO concurrente:
    vec_NOconcurrente();

    //opción concurrente:
    vec_concurrente();
  }

  //Método que inicia el vector estático con valores aleatorios
  private static void iniciavec() {
    Random rand = new Random(System.nanoTime());

    for (int i = 0; i < vec.length; i++) {
      vec[i] = rand.nextInt();
    }
  }

  //Método que NO utiliza el paralelismo y por tanto se ejecuta de forma secuencial
  private static void vec_NOconcurrente() {
    double tiempo = System.nanoTime();
    for (int i = 0; i < vec.length; i++) {
      vec[i] /= 10;
      vec[i] *= 10;
      vec[i] /= 10;
    }
    System.out.println("Version NO concurrente: " + ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
  }

  //Método que ejecuta los hilos que que se lanzan
  public void run() {
    for (int i = inicio; i < fin; i++) {
      vec[i] /= 10;
      vec[i] *= 10;
      vec[i] /= 10;
    }
  }

  //Método que ejecuta nproc hilos en paralelo y que llaman al método run para realizar la multiplicación del
  //vector de forma paralela
  private static void vec_concurrente() {
    int nproc = Runtime.getRuntime().availableProcessors(); //Devuelve cuantos núcleos tiene la CPU
    int inicio = 0, fin = 0;
    EjemRendimientoConcurrencia[] prin = new EjemRendimientoConcurrencia[nproc];

    double tiempo = System.nanoTime(); //Comienzo para capturar el tiempo que tarda en ejecutarse 
                                       //este método

    for (int i = 0; i < nproc; i++) {//Multiplicación del vector por los nproc hilos
      inicio = fin;
      fin += vec.length / nproc;
      prin[i] = new EjemRendimientoConcurrencia(inicio, fin);
      prin[i].start();
    }

    for (int i = 0; i < nproc; i++) {
      try {
        prin[i].join();
      } catch (Exception e) {
      }
    }
    System.out.println("Version Concurrente: " + ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
  }
}