import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer[] arr = new Integer[1000000];

        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            String operation = scanner.next();
            int x = scanner.nextInt();

            if (operation.equals("+")) {
                int emptyCounter = 0;
                for (int j = 1; j < 100000; j++) {
                    if (arr[j] == null) {
                        emptyCounter = j;
                        arr[j] = x;
                        break;
                    }
                }
                System.out.println(emptyCounter);
            } else if (operation.equals("-")) {
                for (int j = 1; j < 100000; j++) {
                    if (arr[j] != null) {
                        if (arr[j] == x) {
                            arr[j] = null;
                            break;
                        }
                    }
                }
            }
        }
        scanner.close();
    }

}
