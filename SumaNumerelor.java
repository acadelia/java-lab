//lab nr 3 Delia Soltanici - var.11

import java.util.Scanner;

public class SumaNumerelor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numar, suma = 0;

        do {
            System.out.print("Introduceți un număr (0 pentru a opri): ");
            numar = scanner.nextInt();
            suma += numar;
        } while (numar != 0);

        System.out.println("Suma numerelor introduse este: " + suma);
        scanner.close();
    }
}