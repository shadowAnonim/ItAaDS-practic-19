import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InnFormatException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ИНН");
        String inn = sc.nextLine();
        if(!inn.matches("\\d{12}"))
            throw new InnFormatException("Входная строка не соответствует формату номера инн");

        int[] coefs = new int[] {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int sum = 0;
        for (int i = 0; i < 10; i++)
            sum += coefs[i] * Integer.parseInt(inn.substring(i, i+1));
        if (sum % 11 % 10 != Integer.parseInt(inn.substring(10, 11)))
            throw new InnFormatException("Входная строка не соответствует формату номера инн");

        coefs = new int[] {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        sum = 0;
        for (int i = 0; i < 11; i++)
            sum += coefs[i] * Integer.parseInt(inn.substring(i, i+1));;
        if (sum % 11 % 10 != Integer.parseInt(inn.substring(11, 12)))
            throw new InnFormatException("Не сходится контрольная сумма во введённом номере инн");
        System.out.println("Инн подтверждён!");
    }
}