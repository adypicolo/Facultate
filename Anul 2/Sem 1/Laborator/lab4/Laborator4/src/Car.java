public class Car {
    enum Masini{
        Mercedes, Fiat, Skoda
    }
    int pret;
    int anFabricatie;
    Masini tip;

    public Car(int pret, Masini tip, int anFabricatie) {
        this.pret = pret;
        this.tip = tip;
        this.anFabricatie = anFabricatie;
    }

    public int getPret() {
        return pret;
    }

    public Masini getTip() {
        return tip;
    }
    public int getAnFabricatie() {
        return anFabricatie;
    }

    @Override
    public String toString() {
        return "Masina " + tip + " are pretul " +pret + " si a fost fabricata in anul " + anFabricatie;
    }

}
