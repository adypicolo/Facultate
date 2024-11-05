package constructori;

public class MainConstructori {
    public static void main(String[] args) {
        Student studentGeneral = new Student();

        System.out.println(studentGeneral.getNume());
        System.out.println("Media studentului general = " + studentGeneral.medie);
    }
}
