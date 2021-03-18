// https://github.com/wolferl42195/prog2-ss21-exercise1.git

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ResultTest {
    @Test
    public void testAllNegative() {
        List<Integer> rounded = Result.gradingStudents(Arrays.asList(37, 15, 12));
        assertEquals(37, rounded.get(0));
        assertEquals(15, rounded.get(1));
        assertEquals(12, rounded.get(2));
    }

    @Test
    public void testAllShouldBeRounded() {
        List<Integer> rounded = Result.gradingStudents(Arrays.asList(68, 43, 58));
        assertEquals( 70, rounded.get(0));
        assertEquals(45, rounded.get(1));
        assertEquals(60, rounded.get(2));
    }

    @Test
    public void testForRoundedGrades() {
        List<Integer> grades = Arrays.asList(45, 50, 60, 70, 80, 90, 100);
        List<Integer> rounded = Result.gradingStudents(grades);
        for (int i = 0; i < rounded.size(); i++) {
            assertEquals(grades.get(i), rounded.get(i));
        }
    }

    @Test
    public void test38Case() {
        List<Integer> rounded = Result.gradingStudents(Arrays.asList(38));
        assertEquals(rounded.get(0), 40);
    }

    @Test
    public void testIllegalInput() {
        try {
            Result.gradingStudents(Arrays.asList(38));
        } catch (Exception error) {
            assertTrue(error instanceof IllegalArgumentException);
        }
    }

    @Test
    public void testNullPointer() {
        try {
            Result.gradingStudents(null);
        } catch (Exception error) {
            assertTrue(error instanceof IllegalArgumentException);
            assertEquals("grades should not be null", error.getMessage());
        }
    }

    @Test
    public void testGradesCountEqual() {
        Random rand = new Random();
        List<Integer> grades = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            grades.add(rand.nextInt(100));
        }

        List<Integer> result = Result.gradingStudents(grades);
        assertEquals(result.size(), grades.size());
    }
}