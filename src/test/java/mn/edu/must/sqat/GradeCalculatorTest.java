

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mn.edu.must.sqat.GradeCalculator;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {
    // Arrange: JUnit creates a fresh test instance for each test.
    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("90 оноо A байна")
    void letterGrade_exactly90_returnsA() {
        double score = 90;                       // Arrange
        String actual = calculator.letterGrade(score); // Act
        assertEquals("A", actual);               // Assert
    }

    @Test
    @DisplayName("60 оноо D байна")
    void letterGrade_exactly60_returnsD() {
        double score = 60;                       // Arrange
        String actual = calculator.letterGrade(score); // Act
        assertEquals("D", actual);               // Assert
    }

    @Test
    @DisplayName("Тэг оноо F байна")
    void letterGrade_zero_returnsF() {
        double score = 0;                        // Arrange
        String actual = calculator.letterGrade(score); // Act
        assertEquals("F", actual);               // Assert
    }

    @Test
    @DisplayName("100 оноо A байна")
    void letterGrade_exactly100_returnsA() {
        double score = 100;                      // Arrange
        String actual = calculator.letterGrade(score); // Act
        assertEquals("A", actual);               // Assert
    }

    @Test
    @DisplayName("Хязгаараас гадуурх оноонд алдаа шиднэ")
    void letterGrade_outsideRange_throws() {
        double below = -1, above = 101;          // Arrange
        assertAll(                              // Act and Assert
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.letterGrade(below)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.letterGrade(above))
        );
    }

    @Test
    @DisplayName("Бүх хэсгийн дээд онооны нийлбэр 100 байна")
    void totalScore_maximumComponents_returns100() {
        double att = 10, lab = 40, q1 = 10, q2 = 10, exam = 30; // Arrange
        double actual = calculator.totalScore(att, lab, q1, q2, exam); // Act
        assertEquals(100, actual, 0.000001);       // Assert
    }

    @Test
    @DisplayName("Хэсэг бүрийн сөрөг оноонд алдаа шиднэ")
    void totalScore_negativeComponent_throws() {
        double invalid = -1;                    // Arrange
        assertAll(                              // Act and Assert
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(invalid, 0, 0, 0, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, invalid, 0, 0, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, 0, invalid, 0, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, 0, 0, invalid, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, 0, 0, 0, invalid))
        );
    }

    @Test
    @DisplayName("Хэсэг бүрийн дээд хязгаарыг хэтрүүлэхэд алдаа шиднэ")
    void totalScore_excessiveComponent_throws() {
        double att = 11, lab = 41, quiz = 11, exam = 31; // Arrange
        assertAll(                              // Act and Assert
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(att, 0, 0, 0, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, lab, 0, 0, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, 0, quiz, 0, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, 0, 0, quiz, 0)),
            () -> assertThrows(IllegalArgumentException.class,
                    () -> calculator.totalScore(0, 0, 0, 0, exam))
        );
    }
}