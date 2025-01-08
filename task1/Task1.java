import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        int n = 0;
        int m = 0;

        while (n < 1 || m < 1) {
            System.out.print("Введите 2 числа для n и m: ");
            Scanner scanner = new Scanner(System.in);
            String[] n_m = scanner.nextLine().split(" ");
            try {
                n = Integer.parseInt(n_m[0]);
                m = Integer.parseInt(n_m[1]);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }

        StringBuilder result = new StringBuilder("1");

        for (int i = 1; i < n; i++) {

            int index = (m - 1) * i;
            int element = (index + 1) % n;
            element = (element == 0) ? n : element;

            if (element == 1) break;

            result.append(element);
        }
        System.out.print(result);
    }
}
