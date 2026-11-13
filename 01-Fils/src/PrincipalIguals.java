public class PrincipalIguals {
    public static void main(String[] args) {
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, 9, 1000, 0);
        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, 9, 1000, 0);

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}