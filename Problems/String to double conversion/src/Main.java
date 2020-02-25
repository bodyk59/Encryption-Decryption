import java.util.Scanner;

public class Main {

    /**
     * It returns a double value or 0.0 if an exception occurred
     */
    public static double convertStringToDouble(String s) {
        return Double.parseDouble(s);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        line = "none".equalsIgnoreCase(line) ? null : line;

        try {
            double result = convertStringToDouble(line);
            System.out.println(result);
        } catch (Exception e) {
            double result = 0;
            System.out.println(result);
        }
    }
}