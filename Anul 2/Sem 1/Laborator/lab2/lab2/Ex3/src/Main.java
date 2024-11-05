public class Main {
    public static void main(String[] args) {
        ArticolStiintific as1 = new ArticolStiintific("Ion", "Liviu Rebreanu");
        ArticolStiintific as2 = new ArticolStiintific("Vlad", "George Bacovia", "plumb", "Plumb", 1999);
        ArticolStiintific as3 = new ArticolStiintific("Vlad", "Tinjala Bianca", "Data mining", "Despre CriptoGrafie", 2024, "Criptografia este...");

        as1.afisare();
        as2.afisare();
        as3.afisare();
    }
}
