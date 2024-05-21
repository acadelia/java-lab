//lab nr 9 Delia Soltanici - var.11

public class Main {

    public static void main(String[] args) {
        exempluImpartireLaZero();
        exempluRadicalDinNegativ();
        exempluAccesareElementInexistent();
        exempluAccesareCaracterInafaraSir();
        exempluConversieTextInNumar();
        exempluApelareMetodaReferintaNula();
        exempluOperatieDepasireLimita();
    }

    public static void exempluImpartireLaZero() {
        try {
            int rezultat = impartireLaZero(10, 0);
            System.out.println("Rezultatul împărțirii este: " + rezultat);
        } catch (ArithmeticException e) {
            System.out.println("Eroare: Împărțirea la zero nu este permisă.");
        }
    }

    public static void exempluRadicalDinNegativ() {
        try {
            double rezultat = radicalDinNegativ(-9);
            System.out.println("Radicalul este: " + rezultat);
        } catch (IllegalArgumentException e) {
            System.out.println("Eroare: Nu se poate calcula radicalul dintr-un număr negativ.");
        }
    }

    public static void exempluAccesareElementInexistent() {
        try {
            int[] tablou = { 1, 2, 3 };
            int valoare = tablou[3];
            System.out.println("Valoarea din tablou este: " + valoare);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Eroare: Indexul este în afara limitelor tabloului.");
        }
    }

    public static void exempluAccesareCaracterInafaraSir() {
        try {
            String text = "Exemplu";
            char caracter = text.charAt(10);
            System.out.println("Caracterul este: " + caracter);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Eroare: Indexul este în afara limitelor șirului de caractere.");
        }
    }

    public static void exempluConversieTextInNumar() {
        try {
            String text = "abc";
            int numar = Integer.parseInt(text);
            System.out.println("Numărul este: " + numar);
        } catch (NumberFormatException e) {
            System.out.println("Eroare: Textul nu poate fi convertit în număr.");
        }
    }

    @SuppressWarnings("null")
    public static void exempluApelareMetodaReferintaNula() {
        try {
            String text = null;
            int lungime = text.length();
            System.out.println("Lungimea textului este: " + lungime);
        } catch (NullPointerException e) {
            System.out.println("Eroare: Referința către obiect este nulă.");
        }
    }

    public static void exempluOperatieDepasireLimita() {
        try {
            int rezultat = inmultire(500000000, 500000000);
            System.out.println("Rezultatul operației este: " + rezultat);
        } catch (ArithmeticException e) {
            System.out.println("Eroare: Operația nu poate fi realizată.");
        }
    }

    // public static void exempluImpartireLaZero() {
    // try {
    // int rezultat = impartireLaZero(10, 0);
    // System.out.println("Rezultatul împărțirii este: " + rezultat);
    // } catch (ArithmeticException e) {
    // System.out.println("Eroare: Împărțirea la zero nu este permisă.");
    // }
    // }

    public static int impartireLaZero(int x, int y) {
        return x / y;
    }

    public static int inmultire(int x, int y) {
        return x * y;
    }

    public static double radicalDinNegativ(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Numărul trebuie să fie pozitiv pentru a calcula radicalul.");
        }
        return Math.sqrt(x);
    }
}

class DepasireLimitaException extends Exception {
    public DepasireLimitaException(String mesaj) {
        super(mesaj);
    }
}
