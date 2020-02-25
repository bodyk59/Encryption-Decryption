import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();

        while (!"0".equals(line)) {
            try {
                System.out.println(Integer.parseInt(line) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + line);
            }
            line = scanner.next();
        }
    }
}