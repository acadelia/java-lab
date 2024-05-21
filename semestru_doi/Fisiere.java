//ceva nu lucreaza, nu se salveaza in fisier
package semestru_doi;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.nio.file.Paths;

class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private int nr;
  private String denumire;
  private String unitateMasura;
  private double pret;
  private Date dataPrimire;

  public Product(int nr, String denumire, String unitateMasura, double pret, Date dataPrimire) {
    this.nr = nr;
    this.denumire = denumire;
    this.unitateMasura = unitateMasura;
    this.pret = pret;
    this.dataPrimire = dataPrimire;
  }

  public boolean isFromMarchThisYear() {
    Calendar cal = Calendar.getInstance();
    int currentYear = cal.get(Calendar.YEAR);
    cal.setTime(dataPrimire);
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH) + 1;
    System.out.println("Checking product date: " + dataPrimire + " (year: " + year + ", month: " + month + ")");
    return year == currentYear && month == 3;
  }

  @Override
  public String toString() {
    return "Product{" +
        "nr=" + nr +
        ", denumire='" + denumire + '\'' +
        ", unitateMasura='" + unitateMasura + '\'' +
        ", pret=" + pret +
        ", dataPrimire=" + dataPrimire +
        '}';
  }
}

public class Fisiere {
  private static final String FILENAME = "products.txt";
  private static List<Product> products = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println("Current working directory: " + Paths.get("").toAbsolutePath().toString());
    loadProducts();
    displayMenu();
  }

  private static void displayMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Display all products from March this year");
      System.out.println("2. Add a new product");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1:
          displayProductsFromMarchThisYear();
          break;
        case 2:
          addProduct();
          break;
        case 3:
          saveProducts();
          System.out.println("Exiting program...");
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void displayProductsFromMarchThisYear() {
    for (Product product : products) {
      if (product.isFromMarchThisYear()) {
        System.out.println(product);
      }
    }
  }

  private static void addProduct() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter product number: ");
    int nr = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.print("Enter product name: ");
    String denumire = scanner.nextLine();
    System.out.print("Enter unit of measure: ");
    String unitateMasura = scanner.nextLine();
    System.out.print("Enter price: ");
    double pret = scanner.nextDouble();
    scanner.nextLine(); // Consume newline
    System.out.print("Enter received date (yyyy-mm-dd): ");
    String dateStr = scanner.nextLine();
    Date dataPrimire;
    try {
      dataPrimire = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
    } catch (ParseException e) {
      System.out.println("Invalid date format. Product not added.");
      return;
    }
    Product product = new Product(nr, denumire, unitateMasura, pret, dataPrimire);
    products.add(product);
    System.out.println("Product added successfully. Current products list size: " + products.size());
  }

  private static void loadProducts() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
      products = (List<Product>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("No existing file found. Starting with an empty list.");
    }
  }

  // private static void saveProducts() {
  // try (ObjectOutputStream oos = new ObjectOutputStream(new
  // FileOutputStream(FILENAME))) {
  // oos.writeObject(products);
  // } catch (IOException e) {
  // e.printStackTrace();
  // }
  // }
  private static void saveProducts() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
      oos.writeObject(products);
      System.out.println("Products saved to file.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
