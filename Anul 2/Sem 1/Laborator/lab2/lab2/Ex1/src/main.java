public class main {
    public static void main(String[] args) {
        Complex z1 = new Complex(1, 2);
        Complex z2 = new Complex();
        Complex z3 = new Complex(2 , 0);

        z1.addWithComplex(z2);
        System.out.print("z1 = ");
        z1.showNumber();

        System.out.print("z3 = ");
        z3.showNumber();
    }
}
