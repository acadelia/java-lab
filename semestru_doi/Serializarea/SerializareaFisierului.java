package semestru_doi.Serializarea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private int number;
  private String name;
  private String unitOfMeasure;
  private double price;
  private String receivingDate;

  public Product(int number, String name, String unitOfMeasure, double price, String receivingDate) {
    this.number = number;
    this.name = name;
    this.unitOfMeasure = unitOfMeasure;
    this.price = price;
    this.receivingDate = receivingDate;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Product{" +
        "number=" + number +
        ", name='" + name + '\'' +
        ", unitOfMeasure='" + unitOfMeasure + '\'' +
        ", price=" + price +
        ", receivingDate='" + receivingDate + '\'' +
        '}';
  }
}

public class SerializareaFisierului {
  private static final String FILENAME = "products.dat";
  private static final List<Product> products = new ArrayList<>();

  public static void main(String[] args) {
    loadProductsFromFile();

    Scanner scanner = new Scanner(System.in);
    int option;
    do {
      System.out.println("1. Afisare produse cu pretul mai mic de 500 de lei");
      System.out.println("2. Iesire");
      System.out.print("Alegeti optiunea: ");
      option = scanner.nextInt();
      scanner.nextLine(); // Consuma newline

      switch (option) {
        case 1:
          displayProductsUnder500();
          break;
        case 2:
          saveProductsToFile();
          break;
        default:
          System.out.println("Optiune invalida!");
      }
    } while (option != 2);
  }

  private static void displayProductsUnder500() {
    products.stream()
        .filter(product -> product.getPrice() < 500)
        .forEach(System.out::println);
  }

  private static void saveProductsToFile() {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
      for (Product product : products) {
        outputStream.writeObject(product);
      }
      System.out.println("Produsele au fost salvate cu succes in fisier.");
    } catch (IOException e) {
      System.out.println("Eroare la salvarea in fisier: " + e.getMessage());
    }
  }

  private static void loadProductsFromFile() {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
      while (true) {
        try {
          Product product = (Product) inputStream.readObject();
          products.add(product);
        } catch (EOFException e) {
          break; // Am ajuns la sfarsitul fisierului
        }
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Eroare la citirea din fisier: " + e.getMessage());
    }
  }
}
