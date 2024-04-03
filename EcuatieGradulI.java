//lab nr 4 Delia Soltanici - var.11

public class EcuatieGradulI {
    public static double rezolvaEcuatie(double a, double b) {
        if (a != 0) {
            return -b / a; 
        } else {
            if (b == 0) {
                System.out.println("Ecuatia este o identitate: orice valoare pentru x este solutie.");
                return Double.NaN; 
            } else {
                System.out.println("Ecuatia nu are solutie.");
                return Double.NaN; 
            }
        }
    }

    public static void main(String[] args) {
        double a = 2; 
        double b = -6;

        double solutie = rezolvaEcuatie(a, b);

        if (!Double.isNaN(solutie)) {
            System.out.println("Solutia ecuatiei " + a + "x + " + b + " = 0 este: x = " + solutie);
        }
    }
}
