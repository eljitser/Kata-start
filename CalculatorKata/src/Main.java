import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Введите, что надо посчитать");
        Scanner in = new Scanner(System.in);
        String Str = in.nextLine();

        try {
            System.out.println(calc(Str));
        } catch (IllegalArgumentException e) {
            System.out.println("throws Exception");
        }

        System.exit(0);
    }

    public static String calc(String input) throws IllegalArgumentException {

        int a;                  //первое число
        int b;                  //второе число
        int p;                  //результат действия
        boolean Rome = false;   //индикатор римских чисел

        input = input.replaceAll(" ", "");          // Избавляемся от всех пробелов в строке
        input = input.toUpperCase();                                 // Переводим все символы в верхний регистр
        if (input.length() > 9) {                                    // Ограничили кол-во символов в строке
            return ("throws Exception");
        }
        String[] subStr;
        subStr = input.split("[-+*/]");

        if (!(subStr.length == 2)) {
            return ("throws Exception");
        }

        if (subStr[0].charAt(0) == 73 || subStr[0].charAt(0) == 86 || subStr[0].charAt(0) == 88) {    // 1ый символ 1ой строковой переменной (потенциально римские числа)


            Rome = true;

            Roman roman1 = Roman.valueOf(subStr[0]);
            a = roman1.getTranslation();

            Roman roman2 = Roman.valueOf(subStr[1]);
            b = roman2.getTranslation();




        } else {         // потенциально арабские числа


            a = Integer.parseInt(subStr[0]);
            if (a < 1 || a > 10) {
                return ("throws Exception");
            }

            b = Integer.parseInt(subStr[1]);
            if (b < 1 || b > 10) {
                return ("throws Exception");
            }



        }


        int Z = subStr[0].length();                           // Находим порядковую позицию оператора в строке

        char Znak = input.charAt(Z);                            // Определяем код Utf-16 оператора

        switch (Znak) {
            case 43:
                p = a + b;
                break;
            case 45:
                p = a - b;
                break;
            case 42:
                p = a * b;
                break;
            case 47:
                p = a / b;
                break;
            default:
                return ("throws Exception");
        }
        if (Rome) {                                             // Сценарий, когда вводятся римские числа

            if (p < 1) {                                           //  Результат с недопустимым значением
                return ("throws Exception");
            }

            if (p < 10) {
                String P1 = Integer.toString(p);
                P1 = P1.replaceAll("1", "I");
                P1 = P1.replaceAll("2", "II");
                P1 = P1.replaceAll("3", "III");
                P1 = P1.replaceAll("4", "IV");
                P1 = P1.replaceAll("5", "V");
                P1 = P1.replaceAll("6", "VI");
                P1 = P1.replaceAll("7", "VII");
                P1 = P1.replaceAll("8", "VIII");
                P1 = P1.replaceAll("9", "IX");
                return P1;
            }

            if (p < 100) {
                String P2 = Integer.toString(p);
                String[] P;
                P = P2.split("");

                P[0] = P[0].replaceAll("1", "X");
                P[0] = P[0].replaceAll("2", "XX");
                P[0] = P[0].replaceAll("3", "XXX");
                P[0] = P[0].replaceAll("4", "XL");
                P[0] = P[0].replaceAll("5", "L");
                P[0] = P[0].replaceAll("6", "LX");
                P[0] = P[0].replaceAll("7", "LXX");
                P[0] = P[0].replaceAll("8", "LXXX");
                P[0] = P[0].replaceAll("9", "XC");

                P[1] = P[1].replaceAll("0", "");
                P[1] = P[1].replaceAll("1", "I");
                P[1] = P[1].replaceAll("2", "II");
                P[1] = P[1].replaceAll("3", "III");
                P[1] = P[1].replaceAll("4", "IV");
                P[1] = P[1].replaceAll("5", "V");
                P[1] = P[1].replaceAll("6", "VI");
                P[1] = P[1].replaceAll("7", "VII");
                P[1] = P[1].replaceAll("8", "VIII");
                P[1] = P[1].replaceAll("9", "IX");
                return P[0] + P[1];
            }

            if (p == 100) {
                return ("C");
            }

        } else {                                                 // Сценарий, когда вводятся арабские числа
            return Integer.toString(p);

        }
        return input;
    }
}