
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GradeList gradeList = new GradeList();
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("Pogram obsługujący oceny studenta. ");
                System.out.println("1. Dodaj nową ocenę. ");
                System.out.println("2. Wylicz średnią ocen. ");
                System.out.println("3. Znajdź najwyższą ocenę. ");
                System.out.println("4. Znajdź najniższą ocenę. ");
                System.out.println("5. Wyjdź z programu. ");
                System.out.println("Wpisz liczbę aby wybrać(1-5): ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Podaj nową ocene (2, 2,5; 3, 3,5; 4, 4,5; 5): ");
                        double newGrade = scanner.nextDouble();
                        if (isValidGrade(newGrade)) {
                            gradeList.addGrade(newGrade);
                            System.out.println("Dodano ocene. ");
                        } else {
                            System.out.println("Niepoprawna ocena. ");
                        }

                    }
                    case 2 ->
                        System.out.println("Średnia ocen wynosi: " + gradeList.calculateAvg());
                    case 3 ->
                        System.out.println("Najwyższa ocena wynosi: " + gradeList.findMax());
                    case 4 ->
                        System.out.println("Najniższa ocena wynosi: " + gradeList.findMin());
                    case 5 ->
                        System.out.println("Koniec programu.");
                }
            } while (choice != 5);
        }

    }

    public static boolean isValidGrade(double grade) {
        double[] validGrades = {2, 2.5, 3, 3.5, 4, 4.5, 5};
        for (double validGrade : validGrades) {
            if (grade == validGrade) {
                return true;
            }
        }
        return false;
    }
}
