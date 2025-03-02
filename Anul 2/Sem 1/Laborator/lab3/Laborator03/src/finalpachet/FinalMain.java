package finalpachet;

public class FinalMain {
    //  public static void main(String[]args){
    //     ClasaFinal cf =new ClasaFinal();
    //     cf.MY_YD =7;
    //  }

    /*  public static void main(String[]args){
    final StringBuilder SB = new StringBuilder("Laborator");
    System.out.println (SB);
    SB.append("final static");
    System.out.println(SB);

    StringBuilder sb1 = new StringBuilder("NU");
    //case-sensitive,sb este alt obiect
    SB=sb;
     */
/*
    public static void main(String[]args){
        final StringBuilder SB = new StringBuilder("Laborator");
 final StringBuilder SB=sb;
        SB.append("final static");// modificare starii initiale
        System.out.println(SB);

        StringBuilder sb1 = new StringBuilder("Lab");

        SB=sb1;
     */
 /*
    public static void main(String[]args){
        final StringBuilder SB = new StringBuilder("Laborator");
        final StringBuilder SB;
        {SB=sb;}
        System.out.println(SB);
        SB.append("final static");
        System.out.println(SB);
*/
    /*
    public static void main(String[]args){
        final StringBuilder SB = new StringBuilder("Laborator");
        final StringBuilder SB;
        SB=sb;
        System.out.println(SB);
        SB.append("final static");
        System.out.println(SB);
     */
    /*
String s= "Laborator";
System.out.println(System.identityHashCode(s));
s = s.concat("Java");
System.out.println(System.identityHashCode(s));
*/
    /*
StringBuilder s= new StringBuilder("Laborator");
System.out.println(System.identityHashCode(s));
s.append("Java")
        System.out.println(System.identityHashCode(s));
*/
  /*
    public static void main(String[]args){
int  []vecotr={ 1,-4,5};
for (final  int i:vecotr){
    System.out.println(i);
    //i= 1+7;
    //eroare de compilare
        }
*/
    public static void main(String[]args)
    {
        ClasaFinal cf = new ClasaFinal(4);
        cf.metodaFinal();
        cf.metodaNefinal();
    }
}
