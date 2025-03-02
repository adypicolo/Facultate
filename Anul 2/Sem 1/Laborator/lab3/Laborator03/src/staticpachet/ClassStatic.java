package staticpachet;

public class ClassStatic {
    public static int staticId = 5;
    public static String staticNume = "Nume Comun Static";

    public int id;
    public String nume;

    static{
        System.out.println("Mesaj din blocul static");
        staticId = 6;
        staticNume = "Nume Comun Static Bloc";
        //id = 5;
        //nume = "Nume Comun Bloc"
    }

    static{
        System.out.println("Mesaj din al doilea bloc static");
    }

    public ClassStatic(int id, String nume, int sid, String snume){
        this.id = id;
        this.nume = nume;
        staticId = sid;
        staticNume = snume;

        System.out.println(metodaStatica() + " din constructor");
    }

    public ClassStatic(int id, String nume){
        this.id = id;
        this.nume = nume;
        System.out.println(metodaStatica() + " din constructorul cu 2 parametrii");
    }

    public static String metodaStatica(){
        return "Apel metoda statica";
    }
}
