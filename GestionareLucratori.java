//lab nr 8 Delia Soltanici - var.11

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Lucrator {
    int nr;
    String nume;
    String prenume;
    String functie;
    double salariu;
    String localitate;

    public Lucrator(int nr, String nume, String prenume, String functie, double salariu, String localitate) {
        this.nr = nr;
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
        this.salariu = salariu;
        this.localitate = localitate;
    }

    @Override
    public String toString() {
        return "Nr: " + nr + ", Nume: " + nume + ", Prenume: " + prenume + ", Funcție: " + functie + ", Salariu: " + salariu + ", Localitate: " + localitate;
    }
}

public class GestionareLucratori {
    private static final String FISIER = "lucratori.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Lucrator> lucratori = new ArrayList<>();

    public static void main(String[] args) {
        citesteLucratoriDinFisier();

        meniu();
    }

    private static void meniu() {
        boolean ruleaza = true;
        while (ruleaza) {
            System.out.println("\n===== Meniu =====");
            System.out.println("1. Afișare lucrători cu salariu mai mic decât 1500");
            System.out.println("2. Adăugare lucrător nou");
            System.out.println("3. Afișare lucrători");
            System.out.println("4. Salvare lucrători în fișier");
            System.out.println("5. Ieșire");

            System.out.print("Alegeți o opțiune: ");
            int optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    afiseazaLucratoriCuSalariuMaiMic();
                    break;
                case 2:
                    adaugaLucrator();
                    break;
                case 3:
                    afiseazaLucratori();
                    break;
                case 4:
                    salveazaLucratoriInFisier();
                    break;
                case 5:
                    ruleaza = false;
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        }
        scanner.close();
    }

    private static void afiseazaLucratoriCuSalariuMaiMic() {
        System.out.println("Lucrătorii cu salariul mai mic decât 1500:");
        for (Lucrator lucrator : lucratori) {
            if (lucrator.salariu < 1500) {
                System.out.println(lucrator);
            }
        }
    }

    private static void adaugaLucrator() {
        System.out.print("Introduceți numărul lucrătorului: ");
        int nr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceți numele lucrătorului: ");
        String nume = scanner.nextLine();

        System.out.print("Introduceți prenumele lucrătorului: ");
        String prenume = scanner.nextLine();

        System.out.print("Introduceți funcția lucrătorului: ");
        String functie = scanner.nextLine();

        System.out.print("Introduceți salariul lucrătorului: ");
        double salariu = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Introduceți localitatea lucrătorului: ");
        String localitate = scanner.nextLine();

        Lucrator lucrator = new Lucrator(nr, nume, prenume, functie, salariu, localitate);
        lucratori.add(lucrator);

        System.out.println("Lucrător adăugat cu succes!");
    }

    private static void afiseazaLucratori() {
        System.out.println("Lista lucrătorilor:");
        for (Lucrator lucrator : lucratori) {
            System.out.println(lucrator);
        }
    }

    private static void salveazaLucratoriInFisier() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FISIER))) {
            for (Lucrator lucrator : lucratori) {
                writer.println(lucrator.nr + "," + lucrator.nume + "," + lucrator.prenume + "," + lucrator.functie + ","
                        + lucrator.salariu + "," + lucrator.localitate);
            }
            System.out.println("Lucrătorii au fost salvați în fișierul " + FISIER);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void citesteLucratoriDinFisier() {
        lucratori.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FISIER))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] elemente = linie.split(",");
                int nr = Integer.parseInt(elemente[0]);
                String nume = elemente[1];
                String prenume = elemente[2];
                String functie = elemente[3];
                double salariu = Double.parseDouble(elemente[4]);
                String localitate = elemente[5];
                Lucrator lucrator = new Lucrator(nr, nume, prenume, functie, salariu, localitate);
                lucratori.add(lucrator);
            }
            System.out.println("Lucrătorii au fost încărcați din fișierul " + FISIER);
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fișier: " + e.getMessage());
        }
    }
}
