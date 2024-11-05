package constructori;

public class Student {
    private String nume;
    public int medie;

    //Constructori fara parametrii
    public Student() {
        this.nume = "";
        this.medie = 0;
    }

    //Consturctori cu parametrii
    public Student(String nume, int medie){
        this.nume = nume;
        this.medie = medie;
    }

    String getNume(){
        return nume;
    }

    void setNume(String nume){
        this.nume = nume;
    }
}
