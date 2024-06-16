
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program do obliczeń. \n");
        try (Scanner scanner = new Scanner(System.in)) {
            String choice;
            do {
                System.out.println("\nWybierz działanie: ");
                System.out.println("\n1. Oblicz 2 do potęgi n. ");
                System.out.println("\n2. Oblicz sume liczb z przedziału między a i b. ");
                System.out.println("\nWybierz działanie(1/2): ");
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> {
                        System.out.println("\nPodaj wykładnik: ");
                        int n = scanner.nextInt();
                        int result1 = Obliczenia.obliczPotege(n);
                        System.out.println("\nWynik: 2^" + n + " = " + result1);
                    }
                    case 2 -> {
                        System.out.println("\nPodaj liczbę a: ");
                        int a = scanner.nextInt();
                        System.out.println("\nPodaj liczbę b: ");
                        int b = scanner.nextInt();
                        int result2 = Obliczenia.obliczSume(a, b);
                        System.out.println("Suma liczb z zakresu od a do b = " + result2);
                    }
                    default ->
                        System.out.println("Zła wartość");
                }
                System.out.print("\n Chcesz obliczyć kolejne działanie? (T/N): ");
                choice = scanner.next();
            } while (choice.equals("T") || choice.equals("t"));
            System.out.println("\nKoniec programu");
        }

    }
}

class Obliczenia {

    public static int obliczPotege(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;
        }
        return result;
    }

    public static int obliczSume(int a, int b) {
        int result = 0;
        for (int i = a; i <= b; i++) {
            result += i;
        }
        return result;
    }
}
