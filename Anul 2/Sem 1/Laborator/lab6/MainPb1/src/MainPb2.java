// Interfața Calculator
interface Calculator {
    double add(Double a, Double b) throws Exception;
    double divide(Double a, Double b) throws Exception;
    double average(Double[] numbers) throws Exception;
}

// Excepțiile definite de utilizator
class NullParameterException extends Exception {
    public NullParameterException(String message) {
        super(message);
    }
}

class OverflowException extends Exception {
    public OverflowException(String message) {
        super(message);
    }
}

class UnderflowException extends Exception {
    public UnderflowException(String message) {
        super(message);
    }
}

// Clasa DoubleCalculator
class DoubleCalculator implements Calculator {
    @Override
    public double add(Double a, Double b) throws Exception {
        if (a == null || b == null) throw new NullParameterException("Parametru null");
        double result = a + b;
        if (result == Double.POSITIVE_INFINITY) throw new OverflowException("Overflow");
        if (result == Double.NEGATIVE_INFINITY) throw new UnderflowException("Underflow");
        return result;
    }

    @Override
    public double divide(Double a, Double b) throws Exception {
        if (a == null || b == null) throw new NullParameterException("Parametru null");
        if (b == 0) throw new ArithmeticException("Împărțire la zero");
        return a / b;
    }

    @Override
    public double average(Double[] numbers) throws Exception {
        if (numbers == null || numbers.length == 0) throw new NullParameterException("Colecție null sau goală");
        double sum = 0;
        for (Double number : numbers) {
            if (number == null) throw new NullParameterException("Element null în colecție");
            sum += number;
        }
        return divide(sum, (double) numbers.length);
    }
}

// Clasa principală Main
public class MainPb2 {
    public static void generateOutOfMemoryError() {
        try {
            int[][] largeArray = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError prins");
        }
    }

    public static void generateStackOverflowError() {
        try {
            recursiveCall();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError prins");
        }
    }

    private static void recursiveCall() {
        recursiveCall();
    }

    public static void main(String[] args) {
        System.out.println("Testare OutOfMemoryError:");
        generateOutOfMemoryError();

        System.out.println("\nTestare StackOverflowError:");
        generateStackOverflowError();

        System.out.println("\nTestare DoubleCalculator:");
        Calculator calculator = new DoubleCalculator();
        try {
            System.out.println("Adunare: " + calculator.add(1.0, 2.0));
            System.out.println("Împărțire: " + calculator.divide(10.0, 2.0));
            System.out.println("Media: " + calculator.average(new Double[]{1.0, 2.0, 3.0}));
            calculator.add(null, 2.0);
        } catch (Exception e) {
            System.out.println("Excepție prinsă: " + e.getMessage());
        }
    }
}