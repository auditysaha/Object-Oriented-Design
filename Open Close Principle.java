//****************************************************************
// Title : A Java program to demonstrate Open Close Principle.
// Author: Audity Saha, Undergraduate student, Khulna University.
//****************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a grading strategy.
 */
abstract class GradingStrategy {
    /**
     * Apply grading to the student's marks.
     *
     * @param totalMarks The total marks of the student.
     * @return The graded marks.
     */
    abstract double calculateGrade(double totalMarks);
}

/**
 * Concrete grading strategy for percentage grading.
 */
class PercentageGrading extends GradingStrategy {
    private double percentage;

    /**
     * Constructs a PercentageGrading object with the given percentage.
     *
     * @param percentage The percentage grading to apply.
     */
    public PercentageGrading(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Apply percentage grading to the student's marks.
     *
     * @param totalMarks The total marks of the student.
     * @return The graded marks.
     */
    @Override
    public double calculateGrade(double totalMarks) {
        return totalMarks * (1 - percentage / 100);
    }
}

/**
 * Concrete grading strategy for fixed mark deduction.
 */
class FixedMarkDeduction extends GradingStrategy {
    private double marksToDeduct;

    /**
     * Constructs a FixedMarkDeduction object with the given marks to deduct.
     *
     * @param marksToDeduct The fixed marks to deduct.
     */
    public FixedMarkDeduction(double marksToDeduct) {
        this.marksToDeduct = marksToDeduct;
    }

    /**
     * Deduct fixed marks from the student's total marks.
     *
     * @param totalMarks The total marks of the student.
     * @return The graded marks.
     */
    @Override
    public double calculateGrade(double totalMarks) {
        return totalMarks - marksToDeduct;
    }
}

/**
 * Context class that applies grading based on the provided strategy.
 */
class GradingApplicator {
    private GradingStrategy gradingStrategy;

    /**
     * Constructs a GradingApplicator object with the given grading strategy.
     *
     * @param gradingStrategy The grading strategy to apply.
     */
    public GradingApplicator(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

    /**
     * Apply grading to the student's marks using the provided grading strategy.
     *
     * @param totalMarks The total marks of the student.
     * @return The graded marks.
     */
    public double applyGrade(double totalMarks) {
        return gradingStrategy.calculateGrade(totalMarks);
    }
}

/**
 * Demo class demonstrating the usage of different grading strategies.
 */
public class OpenClosePrincipleDemo {
    public static void main(String[] args) {
        List<GradingApplicator> gradingApplicators = new ArrayList<>();
        gradingApplicators.add(new GradingApplicator(new PercentageGrading(10))); // 10% deduction
        gradingApplicators.add(new GradingApplicator(new FixedMarkDeduction(5))); // 5 marks deduction

        double totalMarks = 100; // Total marks of the student

        for (GradingApplicator gradingApplicator : gradingApplicators) {
            totalMarks = gradingApplicator.applyGrade(totalMarks);
        }

        System.out.println("Final marks after grading: " + totalMarks);
    }
}

/**
 * In the above program, the calculateGrade method is different for
 * PercentageGrading and FixedMarkDeduction classes, but whenever we
 * need to apply any type of grading, we don't need to change anything
 * in the GradingStrategy class.
 */
