import java.util.ArrayList;

public class Companie {
    String numeCompanie;
    double notaMinima;

    //Contructor fara parametrii
    public Companie(){
        numeCompanie = " ";
        notaMinima = 5;
    }

    //Constructor cu parametrii
    public Companie(String numeCompanie, double notaMinima) {
        this.notaMinima = notaMinima;
        this.numeCompanie = numeCompanie;
    }

    ArrayList<Candidat> alegeCandidatInterviu(ArrayList<Candidat> listaPiataMuncii) {
        ArrayList<Candidat> listaCompanie = new ArrayList<Candidat>();

        for (int i = 0; i < listaPiataMuncii.size(); i++) {
            if (listaPiataMuncii.get(i).notaCandidat >= notaMinima) {
                listaCompanie.add(listaPiataMuncii.get(i));  // Schimbare aici
                System.out.println("Candidatul " + listaPiataMuncii.get(i).numeCandidat
                        + " a obtinut un interviu telefonic la compania " + numeCompanie);
            }
        }
        return listaCompanie;
    }
}