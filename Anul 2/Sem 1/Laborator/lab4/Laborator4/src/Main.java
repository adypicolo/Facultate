import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Car mercedes1 = new Car(20000, Car.Masini.Mercedes, 2010);
        Car mercedes2 = new Car(35000, Car.Masini.Mercedes, 2015);

        Car fiat1 = new Car(3500, Car.Masini.Fiat, 2008);
        Car fiat2 = new Car(7000, Car.Masini.Fiat, 2010);

        Car skoda1 = new Car(12000, Car.Masini.Skoda, 2015);
        Car skoda2 = new Car(25000, Car.Masini.Mercedes, 2021);

        Dealership dealership = new Dealership();

        System.out.println("Pret final" + " mercedes1 " + "este " + dealership.getFinalPrice(mercedes1) + " euro.");
        System.out.println("Pret final" + " mercedes2 " + "este " + dealership.getFinalPrice(mercedes2) + " euro.");

        System.out.println("Pret final" + " fiat1 " + "este " + dealership.getFinalPrice(fiat1) + " euro.");
        System.out.println("Pret final" + " fiat2 " + "este " + dealership.getFinalPrice(fiat2) + " euro.");

        System.out.println("Pret final" + " skoda1 " + "este " + dealership.getFinalPrice(skoda1) + " euro.");
        System.out.println("Pret final" + " skoda2 " + "este " + dealership.getFinalPrice(skoda2) + " euro.");


        System.out.println("Incepem negocierea pentru: " + "mercedes3");

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(20000, Car.Masini.Mercedes, 2010));
        cars.add(new Car(35000, Car.Masini.Mercedes, 2015));

        cars.add(new Car(3500, Car.Masini.Fiat, 2008));
        cars.add(new Car(7000, Car.Masini.Fiat, 2010));

        cars.add(new Car(12000, Car.Masini.Skoda, 2015));
        cars.add(new Car(25000, Car.Masini.Skoda, 2021));

        System.out.println("Lista inițială de mașini:");
        cars.forEach(System.out::println);

        cars.removeIf(car -> car.getPret() > 25000);

        System.out.println(" ");
        System.out.println("Prețul final după aplicarea ofertelor:");
        for (Car car : cars) {
            int finalPrice = dealership.getFinalPrice(car);
            System.out.println("Prețul final pentru " + car + " este " + finalPrice + " euro.");
        }

    }
}