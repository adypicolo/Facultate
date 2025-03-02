import java.util.Random;

public class Dealership {
    Random random = new Random(20);

    private class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int discount = 0;
            switch (car.getTip()) {
                case Mercedes -> discount = (int) (car.getPret() * 0.05);
                case Fiat -> discount = (int) (car.getPret() * 0.10);
                case Skoda -> discount = (int) (car.getPret() * 0.15);
            }
            System.out.println("Se aplica oferta Brand, rezultand " + discount + " euro discount.");
            return discount;
        }
    }

    private class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int anCurebt = 2024;
            int discount = 0;
            switch (car.getTip()) {
                case Mercedes -> discount = (anCurebt - car.getAnFabricatie()) * 300;
                case Fiat -> discount =  (anCurebt - car.getAnFabricatie()) * 100;
                case Skoda -> discount =  (anCurebt - car.getAnFabricatie()) * 150;
            }
            System.out.println("Se aplica oferta Dealer, rezultand " + discount + " euro discount.");
            return discount;
        }
    }

    private class SpecialOffer implements Offer {
        private final int discount;

        public SpecialOffer() {
            discount = random.nextInt(1000);
        }

        @Override
        public int getDiscount(Car car) {
            System.out.println("Se aplica oferta Special, rezultand " + discount + " euro discount.");
            return discount;
        }
    }

    public int getFinalPrice(Car car) {
        int pretInitial = car.getPret();
        pretInitial -= new BrandOffer().getDiscount(car);
        pretInitial -= new DealerOffer().getDiscount(car);
        pretInitial -= new SpecialOffer().getDiscount(car);
        return pretInitial;
    }
    public void negotiate(Car car, double procent) {
        Offer clientOffer = new Offer() {
            @Override
            public int getDiscount(Car car) {
                int discount = (int) (car.getPret() * procent / 100);
                System.out.println("Se aplica oferta clientului, rezultand " + discount + " euro discount.");
                return discount;
            }
        };
        int pretInitial = car.getPret();
        int pretFinal = pretInitial - clientOffer.getDiscount(car);
        System.out.println("Pretul dupa negociere pentru " + car + " este " + pretFinal + " euro.");
    }
}