public class Candidat {
    String numeCandidat;
    double notaCandidat;

    //Constructor fara parametrii
    public Candidat() {
        notaCandidat = 0;
        numeCandidat = " ";
    }

    //Constructor cu parametrii
    public Candidat(String numeCandidat, double notaCandidat) {
        this.notaCandidat = notaCandidat;
        this.numeCandidat = numeCandidat;
    }


}