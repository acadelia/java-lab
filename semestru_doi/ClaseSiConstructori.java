package semestru_doi;

public class ClaseSiConstructori {
  private int nr;
  private String denumireProdus;
  private String unitateDeMasura;
  private double pret;
  private String dataPrimire; // format: YYYY-MM-DD

  public ClaseSiConstructori() {
    this.nr = 0;
    this.denumireProdus = "Necunoscut";
    this.unitateDeMasura = "Unitate";
    this.pret = 0.0;
    this.dataPrimire = "0000-00-00";
  }

  public ClaseSiConstructori(int nr, String denumireProdus, String unitateDeMasura, double pret, String dataPrimire) {
    this.nr = nr;
    this.denumireProdus = denumireProdus;
    this.unitateDeMasura = unitateDeMasura;
    this.pret = pret;
    this.dataPrimire = dataPrimire;
  }

  public ClaseSiConstructori(int nr, String denumireProdus, double pret) {
    this.nr = nr;
    this.denumireProdus = denumireProdus;
    this.unitateDeMasura = "Unitate";
    this.pret = pret;
    this.dataPrimire = "0000-00-00";
  }

  public int getNr() {
    return nr;
  }

  public void setNr(int nr) {
    this.nr = nr;
  }

  public String getDenumireProdus() {
    return denumireProdus;
  }

  public void setDenumireProdus(String denumireProdus) {
    this.denumireProdus = denumireProdus;
  }

  public String getUnitateDeMasura() {
    return unitateDeMasura;
  }

  public void setUnitateDeMasura(String unitateDeMasura) {
    this.unitateDeMasura = unitateDeMasura;
  }

  public double getPret() {
    return pret;
  }

  public void setPret(double pret) {
    this.pret = pret;
  }

  public String getDataPrimire() {
    return dataPrimire;
  }

  public void setDataPrimire(String dataPrimire) {
    this.dataPrimire = dataPrimire;
  }

  public double calculPretEuro(double cursEuro) {
    return this.pret / cursEuro;
  }

  @Override
  public String toString() {
    return "MagazinInternet{" +
        "nr=" + nr +
        ", denumireProdus='" + denumireProdus + '\'' +
        ", unitateDeMasura='" + unitateDeMasura + '\'' +
        ", pret=" + pret +
        ", dataPrimire='" + dataPrimire + '\'' +
        '}';
  }

  public static void main(String[] args) {
    ClaseSiConstructori produs1 = new ClaseSiConstructori();
    ClaseSiConstructori produs2 = new ClaseSiConstructori(1, "Laptop", "Bucata", 3000, "2024-05-21");
    ClaseSiConstructori produs3 = new ClaseSiConstructori(2, "Telefon", 1500);

    produs1.setNr(3);
    produs1.setDenumireProdus("Televizor");
    produs1.setUnitateDeMasura("Bucata");
    produs1.setPret(2500);
    produs1.setDataPrimire("2024-06-01");

    System.out.println(produs1);
    System.out.println(produs2);
    System.out.println(produs3);

    double cursEuro = 4.9;
    System.out.println("Preț în EURO pentru " + produs1.getDenumireProdus() + ": " + produs1.calculPretEuro(cursEuro));
    System.out.println("Preț în EURO pentru " + produs2.getDenumireProdus() + ": " + produs2.calculPretEuro(cursEuro));
  }
}
