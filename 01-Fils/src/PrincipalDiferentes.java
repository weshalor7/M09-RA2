public class PrincipalDiferentes {
    public static void main(String[] args) {
        System.out.println("Acaba thread main");

        Fil pepe = new Fil("Pepe", Thread.MIN_PRIORITY, 9, 1000, 0);
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, 9, 1000, 0);

        pepe.start();
        juan.start();
    }
}