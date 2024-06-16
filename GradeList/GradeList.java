
import java.util.ArrayList;

public class GradeList {

    private final ArrayList<Double> grades = new ArrayList<>();

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAvg() {
        if (grades.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public double findMax() {
        if (grades.isEmpty()) {
            return 0;
        }

        double max = grades.get(0);
        for (double grade : grades) {
            if (max < grade) {
                max = grade;
            }
        }
        return max;

    }

    public double findMin() {
        if (grades.isEmpty()) {
            return 0;
        }

        double min = grades.get(0);
        for (double grade : grades) {
            if (min < grade) {
                min = grade;
            }
        }
        return min;

    }

}
