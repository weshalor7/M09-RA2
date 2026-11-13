public class Fil extends Thread {
    
    private int iteracions; 
    private int feinaSimulada; 
    private long retard; 

    public Fil(String nom, int prioritat, int iteracions, int feinaSimulada, long retard) {
        super(nom); 
        this.setPriority(prioritat); 
        this.iteracions = iteracions;
        this.feinaSimulada = feinaSimulada;
        this.retard = retard;
    }

    @Override
    public void run() { 
        for (int i = 1; i <= iteracions; i++) {
            System.out.println(this.getName() + " " + i);
            
            if (feinaSimulada > 0) {
                int comptador = 0;
                for (int j = 0; j < feinaSimulada; j++) {
                    comptador++; 
                }
            }
            
            if (retard > 0) {
                try {
                    Thread.sleep(retard); 
                } catch (InterruptedException e) {
                    System.out.println("El fil " + this.getName() + " ha estat interromput.");
                }
            }
        }
        
        System.out.println("Acaba el fil " + this.getName());
    }
}