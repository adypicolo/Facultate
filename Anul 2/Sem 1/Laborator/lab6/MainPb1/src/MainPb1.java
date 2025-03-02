public class MainPb1 {
    // Metodă care generează OutOfMemoryError
    public static void generateOutOfMemoryError() {
        try {
            int[][] largeArray = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError a fost prins: " + e.getMessage());
        }
    }

    // Metodă care generează StackOverflowError
    public static void generateStackOverflowError() {
        try {
            recursiveCall();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError a fost prins: " + e.getMessage());
        }
    }

    // Apel recursiv infinit pentru a genera StackOverflowError
    private static void recursiveCall() {
        recursiveCall();
    }

    public static void main(String[] args) {
        System.out.println("Testare OutOfMemoryError:");
        generateOutOfMemoryError();

        System.out.println("\nTestare StackOverflowError:");
        generateStackOverflowError();

        System.out.println("\nProgramul continuă execuția după prinderea erorilor.");
    }
}