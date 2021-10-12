import java.util.Arrays;
import java.util.Scanner;

public class Calculate {
    static char oper = 0;
    static int numberOne;
    static int numberTwo;
    static int result;
    static String[] room = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) {
        System.out.println("Введите пример");
        Scanner sc = new Scanner(System.in);
        String vvod = sc.nextLine();
        vvod = vvod.replaceAll("\\s", "");
        char[] charPrimer = vvod.toCharArray();
        int whereOper = 0;
        for (int i = 0; i < charPrimer.length; i++) { //получаем знак
            if (charPrimer[i] == '+') {
                oper = '+';
                whereOper = i;
            }
            if (charPrimer[i] == '-') {
                oper = '-';
                whereOper = i;
            }
            if (charPrimer[i] == '/') {
                oper = '/';
                whereOper = i;
            }
            if (charPrimer[i] == '*') {
                oper = '*';
                whereOper = i;
            }

        }
        if (oper == 0) {
            System.out.println("Ошибка. Невыполнения условия задачи");
            System.exit(1);
        }
        String number1 = String.valueOf(Arrays.copyOf(charPrimer, whereOper));
        String number2 = String.valueOf(Arrays.copyOfRange(charPrimer, whereOper + 1, charPrimer.length));
        if ((romanToNumber(number1) >= 0 && romanToNumber(number2) < 0) || (romanToNumber(number1) < 0 && romanToNumber(number2) >= 0)) {
            System.out.println("Ошибка. Невыполнения условия задачи");
            System.exit(1);
        }
        numberOne = Transform(number1);
        numberTwo = Transform(number2);
        result = calculate(numberOne, numberTwo, oper);
        if (romanToNumber(number1) < 0)
            System.out.println(result);
        if (romanToNumber(number1) > 0) {
            if (result > 0) {
                String resultRoom = room[result];
                System.out.println(resultRoom);
            } else {
                System.out.println("Ошибка. Невыполнения условия задачи");
                System.exit(1);
            }
        }
    }

    public static int romanToNumber(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }

    public static int calculate(int num1, int num2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
        }
        return result;
    }

    public static int Transform(String number) {
        int num = 0;
        int m = romanToNumber(number);  //для проверки каким способом ввели числа
        if (m >= 0) {
            num = romanToNumber(number);
        }
        if (m < 0) {
            num = Integer.parseInt(number);
        }
        if (num > 10) {
            System.out.println("Ошибка. Невыполнения условия задачи");
            System.exit(1);
        } //проверка на числа до 10


        return num;
    }
}
