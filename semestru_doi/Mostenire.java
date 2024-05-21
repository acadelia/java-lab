package semestru_doi;

public class Mostenire {
  public static void main(String[] args) {
    // Crearea unui obiect al clasei de bază
    MagazinInternet magazin = new MagazinInternet("Generic Store", "generic.com");
    System.out.println(magazin);

    // Crearea unui obiect al clasei derivate MagazinInternetDeElectrocasnice
    MagazinInternetDeElectrocasnice magazinElectrocasnice = new MagazinInternetDeElectrocasnice("Electro Store",
        "electro.com", "Electronics", "Home Appliances");
    System.out.println(magazinElectrocasnice);

    // Crearea unui obiect al clasei derivate MagazinInternetDeCalculatoare
    MagazinInternetDeCalculatoare magazinCalculatoare = new MagazinInternetDeCalculatoare("Comp Store", "comp.com", 3.5,
        16);
    System.out.println(magazinCalculatoare);
  }
}

class MagazinInternet {
  private String nume;
  private String domeniu;

  public MagazinInternet(String nume, String domeniu) {
    this.nume = nume;
    this.domeniu = domeniu;
  }

  @Override
  public String toString() {
    return "MagazinInternet{" +
        "nume='" + nume + '\'' +
        ", domeniu='" + domeniu + '\'' +
        '}';
  }
}

class MagazinInternetDeElectrocasnice extends MagazinInternet {
  private String subdomeniu;

  public MagazinInternetDeElectrocasnice(String nume, String domeniu, String subdomeniu, String specific) {
    super(nume, domeniu);
    this.subdomeniu = subdomeniu;
  }

  @Override
  public String toString() {
    return "MagazinInternetDeElectrocasnice{" +
        "nume='" + super.toString() + '\'' +
        ", subdomeniu='" + subdomeniu + '\'' +
        '}';
  }
}

class MagazinInternetDeCalculatoare extends MagazinInternet {
  private double frecventaProcesor;
  private int memorieOperativa;

  public MagazinInternetDeCalculatoare(String nume, String domeniu, double frecventaProcesor, int memorieOperativa) {
    super(nume, domeniu);
    this.frecventaProcesor = frecventaProcesor;
    this.memorieOperativa = memorieOperativa;
  }

  @Override
  public String toString() {
    return "MagazinInternetDeCalculatoare{" +
        "nume='" + super.toString() + '\'' +
        ", frecventaProcesor=" + frecventaProcesor +
        ", memorieOperativa=" + memorieOperativa +
        '}';
  }
}
