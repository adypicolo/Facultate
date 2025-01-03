import java.util.ArrayList;

public class PiataMuncii {
    public static void main(String[] args){
        ArrayList<Candidat> listaPiataMuncii = new ArrayList<Candidat>(5);

        Candidat gigel = new Candidat("Gigel", 9.50);
        Candidat dorel = new Candidat("Dorel", 8.75);
        Candidat marcel = new Candidat("Marcel", 9.15);
        Candidat ionel = new Candidat("Ionel", 10);

        listaPiataMuncii.add(gigel);
        listaPiataMuncii.add(dorel);
        listaPiataMuncii.add(marcel);
        listaPiataMuncii.add(ionel);

        Companie google = new Companie("Google", 9.50);
        Companie amazon = new Companie("Amazon", 8.25);
        Companie facebook = new Companie("Facebook", 7.99);
        Companie microsoft = new Companie("Microsoft", 8.75);

        google.alegeCandidatInterviu(listaPiataMuncii);
        amazon.alegeCandidatInterviu(listaPiataMuncii);
        facebook.alegeCandidatInterviu(listaPiataMuncii);
        microsoft.alegeCandidatInterviu(listaPiataMuncii);

        // Problema 3
        Candidat c1 = new Candidat("Vlad", 9.99);
        Candidat c2 = new Candidat("Bianca", 10);
        Candidat c3 = c1;

        System.out.println("Intre c1 si c2 equals este " + c1.equals(c2));
        System.out.println("Intre c1 si c3 equals este " + c1.equals(c3));

        c1.numeCandidat = "Liviu";
        System.out.println(c1.numeCandidat);
        System.out.println(c2.numeCandidat);
        System.out.println(c3.numeCandidat);

    }

}