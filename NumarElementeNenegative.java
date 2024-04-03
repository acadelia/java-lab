//lab nr 5 Delia Soltanici - var.11

import java.util.Scanner;

public class NumarElementeNenegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți dimensiunea vectorului: ");
        int dimensiune = scanner.nextInt();

        int[] vector = new int[dimensiune];

        for (int i = 0; i < dimensiune; i++) {
            System.out.print("Introduceți elementul " + (i + 1) + ": ");
            vector[i] = scanner.nextInt();
        }

        int numarElementeNenegative = 0;
        for (int i = 0; i < dimensiune; i++) {
            if (vector[i] >= 0) {
                numarElementeNenegative++;
            }
        }

        System.out.println("Vectorul conține " + numarElementeNenegative + " elemente nenegative.");

        scanner.close();
    }
}
