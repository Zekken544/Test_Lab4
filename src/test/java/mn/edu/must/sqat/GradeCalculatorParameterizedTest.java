package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeCalculatorParameterizedTest {
    private final GradeCalculator calculator = new GradeCalculator();

    @ParameterizedTest(name = "score={0}, grade={1}")
    @DisplayName("Ердийн болон зааг утгын үсгэн дүн")
    @CsvSource({
        "95,A", "85,B", "75,C", "65,D", "30,F",
        "90,A", "89.99,B", "60,D", "59.99,F", "0,F", "100,A"
    })
    void letterGrade_variousScores_returnsExpectedGrade(
            double score, String expected) {
        // Arrange: inputs come from CsvSource.
        String actual = calculator.letterGrade(score); // Act
        assertEquals(expected, actual);                 // Assert
    }

    @ParameterizedTest(name = "total should be {5}")
    @DisplayName("Хүчинтэй хэсгийн оноонуудын нийлбэр")
    @CsvSource({
        "10,40,10,10,30,100",
        "0,0,0,0,0,0",
        "8,35,7,6,24,80",
        "0,40,0,0,0,40"
    })
    void totalScore_validComponents_returnsExpectedTotal(
            double att, double lab, double quiz1,
            double quiz2, double exam, double expected) {
        // Arrange: inputs come from CsvSource.
        double actual = calculator.totalScore(
                att, lab, quiz1, quiz2, exam); // Act
        assertEquals(expected, actual, 0.000001); // Assert
    }
}