package mn.edu.must.sqat;

public class GradeCalculator {

    public String letterGrade(double score) {
        validateRange(score, 100, "score");

        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public double totalScore(
            double att, double lab, double quiz1,
            double quiz2, double exam) {

        validateRange(att, 10, "attendance");
        validateRange(lab, 40, "lab");
        validateRange(quiz1, 10, "quiz1");
        validateRange(quiz2, 10, "quiz2");
        validateRange(exam, 30, "exam");

        return att + lab + quiz1 + quiz2 + exam;
    }

    private void validateRange(double value, double maximum, String field) {
        if (!Double.isFinite(value) || value < 0 || value > maximum) {
            throw new IllegalArgumentException(
                    field + " must be between 0 and " + maximum);
        }
    }
}