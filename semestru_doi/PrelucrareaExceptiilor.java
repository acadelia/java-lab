package semestru_doi;

import java.util.InputMismatchException;
import java.util.Scanner;

// Definim o excepție proprie
class MyCustomException extends Exception {
  public MyCustomException(String message) {
    super(message);
  }
}

public class PrelucrareaExceptiilor {
  public static void main(String[] args) {
    // Excepția pentru împărțire la zero
    try {
      int a = 10;
      int b = 0;
      int result = a / b;
    } catch (ArithmeticException e) {
      System.out.println("Împărțire la zero: " + e.getMessage());
    }

    // Excepția pentru radical din număr negativ
    try {
      double number = -25;
      if (number < 0) {
        throw new IllegalArgumentException("Nu se poate calcula radicalul unui număr negativ.");
      }
      double sqrt = Math.sqrt(number);
    } catch (IllegalArgumentException e) {
      System.out.println("Radical din număr negativ: " + e.getMessage());
    }

    // Excepția pentru accesarea unui element inexistent al unui tablou
    try {
      int[] array = { 1, 2, 3 };
      int element = array[5];
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Accesare element inexistent al unui tablou: " + e.getMessage());
    }

    // Excepția pentru introducerea de litere în loc de numere
    Scanner scanner = new Scanner(System.in);
    try {
      System.out.print("Introduceți un număr: ");
      int number = scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Introducerea de litere în loc de numere: " + e.getMessage());
      scanner.next(); // curăță intrarea incorectă
    }

    // Excepția pentru apelarea unei metode a unui obiect cu referință nulă
    try {
      String str = null;
      int length = str.length();
    } catch (NullPointerException e) {
      System.out.println("Apelarea unei metode a unui obiect cu referință nulă: " + e.getMessage());
    }

    // Excepția proprie
    try {
      checkValue(-5);
    } catch (MyCustomException e) {
      System.out.println("Excepție proprie: " + e.getMessage());
    }
  }

  // Metoda care generează o excepție proprie
  public static void checkValue(int value) throws MyCustomException {
    if (value < 0) {
      throw new MyCustomException("Valoarea nu poate fi negativă: " + value);
    }
  }
}
