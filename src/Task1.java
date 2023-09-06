import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int occupiedCells = calculate(n);
        System.out.println(occupiedCells);
    }

    public static int calculate(int n) {
        if (n == 1) {
            return 1;
        }
        int newCells = 4 * (n - 1);
        return newCells;
    }
}
