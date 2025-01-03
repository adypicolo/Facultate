public class VeterinaryTest {
    public static void main(String[] args) {
        RaportVeterinar vr = new RaportVeterinar();
        vr.cats = 3;
        vr.dogs = 5;
        vr.showStats();
        System.out.println("The class method says there are " + vr.getAnimalsCount() + " animals");
    }
}
