package staticpachet;

public class MainStatic {
    public static void main(String[] args){
        System.out.println("Campul staticId = " + ClassStatic.staticId);
        System.out.println("Campul staticNume = " + ClassStatic.staticNume);
        System.out.println(ClassStatic.metodaStatica());

        System.out.println();
        ClassStatic cs = new ClassStatic(2,"Ana",5,"Ionel");
        System.out.println("Campul id = " + cs.id);
        System.out.println("Campul nume = " + cs.nume);
        System.out.println("Campul staticId dupa apel constructor = " + ClassStatic.staticId);
        System.out.println("Campul staticNume duap apel constructor = " + ClassStatic.staticNume);

        System.out.println();
        ClassStatic cs2 = new ClassStatic(22, "Ana2");
        System.out.println("Campul id = " + cs2.id);
        System.out.println("Campul nume = " + cs2.nume);
        System.out.println("Campul staticId dupa apel constructor 2param = " + ClassStatic.staticNume);
    }
}
