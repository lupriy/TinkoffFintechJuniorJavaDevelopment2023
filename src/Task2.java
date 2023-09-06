import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] grid = new int[m * n];
        int num = 1;

        StringBuilder sb = new StringBuilder();

        for (int sum = 0; sum <= n + m - 2; sum++) {
            for (int i = 0; i <= sum; i++) {
                int j = sum - i;
                if (i < m && j < n) {
                    int index = i * n + j;
                    grid[index] = num++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                sb.append(grid[index]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
