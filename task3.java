import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение в градусах C: ");
        double value = readValidDouble(scanner);

        int units;
        while (true) {
            System.out.print("Введите 1 для Фаренгейтов, 0 для Кельвинов: ");
            units = scanner.nextInt();

            if (units == 0 || units == 1) {
                break;
            } else {
                System.out.println("Введено недопустимое значение. Пожалуйста, введите 0 или 1.");
            }
        }

        BaseConverter conversion = new BaseConverter(value, units);
        String titleUnits = (units == 1) ? "градусов по Фаренгейту" : "градусов по Кельвину";

        System.out.println(value + " градусов по Цельсию = " + conversion.convertedValue + " " + titleUnits);
    }

    private static double readValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введено недопустимое значение. Пожалуйста, введите число.");
            }
        }
    }
}

class BaseConverter {
    double value;
    int units;
    double convertedValue;

    public BaseConverter(double value, int units) {
        this.value = value;
        this.units = units;
        this.convertedValue = convert();
    }

    public double convert() {
        if (units == 1) {
            return (value * 1.8) + 32;
        } else {
            return value + 273.15;
        }
    }
}
