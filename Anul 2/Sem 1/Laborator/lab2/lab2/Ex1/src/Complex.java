import java.util.concurrent.CompletionException;

public class Complex {
    private int real, imaginar;

    //Constructor cu parametrii
    public Complex(int real, int imaginar) {
        this.real = real;
        this.imaginar = imaginar;
    }

    //Constructori fara parametrii
    public Complex() {
        this.real = -3;
        this.imaginar = 4;
    }

    //Constructor de copiere
    public Complex(Complex st){
        this.real = st.real;
        this.imaginar = st.imaginar;
    }

    public int getReal(){
        return real;
    }

    public int getImaginar(){
        return imaginar;
    }

    public void setReal(int real){
        this.real = real;
    }

    public void setImaginar(int imaginar){
        this.imaginar = imaginar;
    }

    public void showNumber(){
        if (imaginar > 0) System.out.println(real + " + " + "i * " + imaginar);
            else if (imaginar < 0) System.out.println(real + " - " + "i * " + (-1 * imaginar));
        else System.out.println(real);

        System.out.println();
    }

    public void addWithComplex(Complex c){
        this.real += c.real;
        this.imaginar += c.imaginar;
    }
}
