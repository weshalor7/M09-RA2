public class PrincipalEstricte {
    public static void main(String[] args) {
        
        System.out.println("Termina thread main");

        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, 9, 0, 1);
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, 9, 0, 1);

        juan.start();
        pepe.start();
    }
}