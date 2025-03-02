public class RaportVeterinar {
    int cats;
    int dogs;

    public int getAnimalsCount(){
        return cats + dogs;
    }
    public void showStats(){
        System.out.println("Total number of animals is = " + getAnimalsCount());
    }
}
