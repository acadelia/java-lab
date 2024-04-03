//lab nr 6 Delia Soltanici - var.11

import java.util.Scanner;

public class VerificareProgramare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți un șir de caractere:");
        String text = scanner.nextLine();

        if (text.contains("programare")) {
            System.out.println("Șirul introdus conține cuvântul 'programare'.");
        } else {
            System.out.println("Șirul introdus nu conține cuvântul 'programare'.");
        }

        scanner.close();
    }
}


