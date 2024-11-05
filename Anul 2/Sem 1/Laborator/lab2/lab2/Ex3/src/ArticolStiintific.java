/*
Creați un program Java care permite modelarea unui articol științific.
Articolele științifice conțin următoarele metadate: numele
articol, autor, cuvinte cheie, numele publicației, anul și rezumatul.
Trebuiesc definiți trei constructori supraîncărcați:
        1. Primul inițializează un articol științific doar cu titlul și autorul acestuia.
      2. Al doilea constructor: un articol științific cu numele dvs., autor, cuvinte cheie, numele publicației și anul. Trebuie să invocați primul constructor.
3. Al treilea constructor: un articol științific cu numele dvs., autor,
        cuvinte cheie, numele publicației, anul și rezumatul. Trebuie invocat al doilea constructor.
Creați o metodă principală care să folosească al treilea constructor pentru
instanțiațierea unui articol științific și imprimați valorile atributelor sale.
*/
public class ArticolStiintific {
    private String nume, autor, cuvinteCheie, numelePublicatiei, rezumatul;
    private int anul;

    //Primul constructor
    public ArticolStiintific(String numelePublicatiei, String autor) {
        this.numelePublicatiei = numelePublicatiei;
        this.autor = autor;
    }

    //Al doilea constructor
    public ArticolStiintific(String nume, String autor, String cuvinteCheie, String numelePublicatiei, int anul) {
        this(numelePublicatiei, autor);
        this.nume = nume;
        this.cuvinteCheie = cuvinteCheie;
    }

    //Al treilea constructor
    public ArticolStiintific(String nume, String autor, String cuvinteCheie, String numelePublicatiei, int anul, String rezumatul) {
        this(nume, autor, cuvinteCheie, numelePublicatiei, anul);
        this.rezumatul = rezumatul;
    }

    public void afisare(){
        System.out.println("Nume = " + nume);
        System.out.println("Autor = " + autor);
        System.out.println("Cuvinte Cheie= " + cuvinteCheie);
        System.out.println("Numele publicatie = " + numelePublicatiei);
        System.out.println("Rezumatul = " + rezumatul);
    }
}
