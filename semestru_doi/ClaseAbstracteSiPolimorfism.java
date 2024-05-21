package semestru_doi;

// Definim interfata CalculArie cu metoda calculArie()
interface CalculArie {
  double calculArie();
}

// Definim clasa abstracta FiguraGeometrica cu metoda abstracta aria()
abstract class FiguraGeometrica {
  protected double lungime;
  protected double latime;

  public FiguraGeometrica(double lungime, double latime) {
    this.lungime = lungime;
    this.latime = latime;
  }

  abstract double aria();
}

// Clasa Dreptunghi extinde FiguraGeometrica si implementeaza CalculArie
class Dreptunghi extends FiguraGeometrica implements CalculArie {

  public Dreptunghi(double lungime, double latime) {
    super(lungime, latime);
  }

  @Override
  double aria() {
    return lungime * latime;
  }

  @Override
  public double calculArie() {
    return aria();
  }
}

// Clasa Patrat extinde FiguraGeometrica si implementeaza CalculArie
class Patrat extends FiguraGeometrica implements CalculArie {

  public Patrat(double latura) {
    super(latura, latura);
  }

  @Override
  double aria() {
    return lungime * latime;
  }

  @Override
  public double calculArie() {
    return aria();
  }
}

// Clasa principala pentru testarea polimorfismului
public class ClaseAbstracteSiPolimorfism {
  public static void main(String[] args) {
    FiguraGeometrica dreptunghi = new Dreptunghi(5, 10);
    FiguraGeometrica patrat = new Patrat(7);

    System.out.println("Aria dreptunghiului: " + dreptunghi.aria());
    System.out.println("Aria patratului: " + patrat.aria());

    // Polimorfism prin interfata
    CalculArie calcArieDreptunghi = new Dreptunghi(3, 6);
    CalculArie calcAriePatrat = new Patrat(4);

    System.out.println("Aria calculata a dreptunghiului: " + calcArieDreptunghi.calculArie());
    System.out.println("Aria calculata a patratului: " + calcAriePatrat.calculArie());
  }
}
