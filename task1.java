import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел в массиве => 2: ");
        int x = readValidInteger(scanner);
        if (x < 2) {
            x = 2;
        }

        List<Double> arr = new ArrayList<>();
        System.out.print(" 0 - целые числа в массиве, 1 - дробные числа в массиве: ");
        int num = readValidIntegerInRange(scanner, 0, 1);

        Random random = new Random();
        if (num == 0) {
            for (int step = 0; step < x; step++) {
                int c = random.nextInt(11); // генерируем целое число от 0 до 10
                arr.add((double) c);
            }
        } else {
            for (int step = 0; step < x; step++) {
                double c = random.nextDouble(); // генерируем дробное число от 0 до 1
                arr.add(c);
            }
        }

        double avg = calculateAverage(arr);
        double min = arr.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
        double max = arr.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);

        System.out.println("Заполнен массив: " + arr);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg);
    }

    private static double calculateAverage(List<Double> arr) {
        double sum = 0;
        for (Double num : arr) {
            sum += num;
        }
        return sum / arr.size();
    }

    private static int readValidInteger(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введено недопустимое значение. Пожалуйста, введите целое число.");
            }
        }
    }

    private static int readValidIntegerInRange(Scanner scanner, int min, int max) {
        while (true) {
            int value = readValidInteger(scanner);
            if (value >= min && value <= max) {
                return value;
            } else {
                System.out.println("Введено недопустимое значение. Пожалуйста, введите  0 - целые числа в массиве, 1 - дробные числа в массиве ");
            }
        }
    }
}
