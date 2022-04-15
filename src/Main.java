import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        int number1 = 0;
        int number2 = 0;
        int result;

        String[] strings = input.split("\\W");
        String[] operator = input.split("\\w");
        Metods.inputChecker(operator);
        if (strings.length > 2)
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        String oper = operator[operator.length - 1];

        if ((Metods.isDigit(strings[0]) && !Metods.isDigit(strings[1])) || (Metods.isDigit(strings[1]) && !Metods.isDigit(strings[0])))
            throw new Exception("т.к. используются одновременно разные системы счисления");


        try {
            number1 = Integer.parseInt(strings[0]);//получили арабские числа
            number2 = Integer.parseInt(strings[1]);//получили арабские числа

        } catch (Exception e) {
            try {
                number1 = Converter.toArabic(strings[0]); //конвертируем арабские в римские
                number2 = Converter.toArabic(strings[1]); //конвертируем арабские в римские
            } catch (Exception e1) {
                System.out.println("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }

        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10)
            throw new Exception("вводить можно только числа от 1 до 10 включительно");

        if (strings[0].matches("[-+]?\\d+")) { // проверяем являются ли числа арабскими
            number1 = Integer.parseInt(strings[0]);
            number2 = Integer.parseInt(strings[1]);
            result = calculated(number1, number2, oper);
            return String.valueOf(result);
        } else {
            result = calculated(number1, number2, oper);
            if (result < 1) throw new Exception("т.к. в римской системе нет отрицательных чисел");
            return Converter.converterArabToRome(result);
        }
    }

     static int calculated(int a, int b, String op) {
        return switch (op) {
            case "*" -> a * b;
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}