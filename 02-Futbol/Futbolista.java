import java.util.Random;

public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;

    public Futbolista(String nom) {
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (random.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNigols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) {
        String[] nombres = {
            "Piqué", "Vinicius", "Torres", "Ramos", 
            "Ronaldo", "Lewan", "Belli", "Arnau", 
            "Aspas", "Messi", "MBapé"
        };

        Futbolista[] futbolistes = new Futbolista[NUM_JUGADORS];
        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i] = new Futbolista(nombres[i]);
        }

        System.out.println("Inici dels xuts -----------------------------");
        
        for (int i = 0; i < NUM_JUGADORS; i++) {
            futbolistes[i].start();
        }

        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                futbolistes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fi dels xuts -----------------------------");
        System.out.println("--- Estadístiques ------");

        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.println(futbolistes[i].getName() + " -> " + futbolistes[i].getNigols() + " gols");
        }
    }
}
