import java.util.Scanner;

public class Task1 {

    /*
    * 1. Напишите метод, который принимает на вход строку (String) и
    * определяет является ли строка палиндромом (возвращает boolean значение).
    * шалаш
    * abcdedcba
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(new Task1().isPolindrom(str));
    }

    public boolean isPolindrom(String source) {
        boolean flag = true;
        for (int i = 0; i < source.length() / 2; i++) {
            if (source.charAt(i) != source.charAt(source.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}