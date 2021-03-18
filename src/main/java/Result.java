import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
    public static void main(String[] args) {

    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        if (grades == null) {
            throw new IllegalArgumentException("grades should not be null");
        }

        List<Integer> roundedGrades = new ArrayList<>();
        for (int grade: grades) {
            if (grade < 0 || grade > 100) {
                throw new IllegalArgumentException(grade + " is not a valid grade");
            }

            if (grade < 38) {
                roundedGrades.add(grade);
            } else {
                int nextFiveMultiplier = 5 * ((grade / 5) + 1);

                if (Math.abs(nextFiveMultiplier - grade) < 3) {
                    roundedGrades.add(nextFiveMultiplier);
                } else {
                    roundedGrades.add(grade);
                }
            }
        }

        return roundedGrades;
    }
}
