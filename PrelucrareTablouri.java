//lab nr 7 Delia Soltanici - var.11

import java.util.Scanner;

public class PrelucrareTablouri {
    public int numarElementeNenegative(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                count++;
            }
        }
        return count;
    }

    public void afiseazaTablou(int[] array) {
        System.out.print("Tabloul introdus este: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți lungimea tabloului:");
        int lungime = scanner.nextInt();

        int[] tablou = new int[lungime];
        System.out.println("Introduceți elementele tabloului:");

        for (int i = 0; i < lungime; i++) {
            tablou[i] = scanner.nextInt();
        }

        PrelucrareTablouri prelucrare = new PrelucrareTablouri();
        prelucrare.afiseazaTablou(tablou);
        int numarElementeNenegative = prelucrare.numarElementeNenegative(tablou);
        System.out.println("Numărul de elemente nenegative din tablou este: " + numarElementeNenegative);

        scanner.close();
    }
}
