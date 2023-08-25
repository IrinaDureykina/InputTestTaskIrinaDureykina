import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;

        while (true) {
            System.out.print("Введите текст: ");
            str = scanner.nextLine();

            if (!str.isEmpty()) {
                break;
            }

            System.out.println("Введите текст!");
        }

        List<Character> result = howManyRepeated(str);

        if (result.isEmpty()) {
            System.out.println("В тексте нет повторяющихся символов");
        } else {
            System.out.print("В тексте: " + str + " Повторяющиеся символы: " + result);
        }
    }

    private static List<Character> howManyRepeated(String str) {
        List<Character> result = new ArrayList<>();
        char[] strArr = str.toLowerCase().toCharArray();
        Arrays.sort(strArr);

        for (int i = 0; i < strArr.length - 1; i++) {
            if (strArr[i] == strArr[i + 1]) {
                if (!result.contains(strArr[i])) {
                    result.add(strArr[i]);
                }
            }
        }

        return result;
    }
}
