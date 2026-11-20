import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual = 0;
    private int potenciaObjectiu = 0;
    private boolean haRebutOrdre = false;
    private Random random = new Random();

    public Motor(int id) {
        super("Motor " + id);
    }

    public void setPotencia(int p) {
        this.potenciaObjectiu = p;
        this.haRebutOrdre = true;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int interval = 1000 + random.nextInt(1001);
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!haRebutOrdre) {
                continue;
            }

            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                System.out.printf("%s: Incre. Objectiu: %d Actual: %d%n", 
                    getName(), potenciaObjectiu, potenciaActual);
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                System.out.printf("%s: Decre. Objectiu: %d Actual: %d%n", 
                    getName(), potenciaObjectiu, potenciaActual);
            } else {
                System.out.printf("%s: FerRes Objectiu: %d Actual: %d%n", 
                    getName(), potenciaObjectiu, potenciaActual);
                if (potenciaObjectiu == 0) {
                    break; 
                }
            }
        }
    }
}