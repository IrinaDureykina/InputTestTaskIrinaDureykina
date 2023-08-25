import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Укажите Час от '0' до '23': ");
        int hours = scanner.nextInt();

        System.out.print("Укажите Минуты от '0' до '59': ");
        int minutes = scanner.nextInt();

        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
            System.out.println("Недопустимое значение");
            return;
        }

        double angle = calculateAngle(hours, minutes);
        System.out.println("Угол между часовой и минутной стрелками в " + hours + ":" + minutes + " составляет: " + angle + " градусов.");
    }

    private static double calculateAngle(int hours, int minutes) {
        hours = hours >= 12 ? hours - 12 : hours;
        double angle = Math.abs(((hours * 30) + (minutes * 0.5)) - (minutes * 6));
        angle = angle > 180 ? 360 - angle : angle;
        return angle;
    }
}

