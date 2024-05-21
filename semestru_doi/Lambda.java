package semestru_doi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {

  public static void main(String[] args) {
    // Exemplu simplu de expresie lambda care adaugă două numere
    MathOperation addition = (int a, int b) -> a + b;
    System.out.println("Suma: " + addition.operation(10, 5));

    // Exemplu de utilizare a expresiilor lambda în cadrul unei colecții
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    numbers.forEach((Integer value) -> System.out.println(value));

    // Exemplu de sortare a unei liste de string-uri în funcție de lungimea acestora
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
    names.sort((String a, String b) -> a.length() - b.length());
    names.forEach((String name) -> System.out.println(name));

    // Exemplu de utilizare a unei expresii lambda ca parametru pentru un fir de
    // execuție
    Thread thread = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Executabil...");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    thread.start();

    // Exemplu de folosire a unei expresii lambda ca parametru pentru o funcție de
    // înalt nivel
    // (care primește o funcție lambda ca argument și o execută)
    greet("John", (name) -> System.out.println("Hello, " + name));
  }

  interface MathOperation {
    int operation(int a, int b);
  }

  private static void greet(String name, Consumer<String> greetingFunction) {
    greetingFunction.accept(name);
  }
}
