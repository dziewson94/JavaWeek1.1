package com.sii.academy.javaweek1.inequality;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InequalityGenerator {

    public static Inequality generateInequality(int degree) throws IllegalArgumentException {
        if (degree <= 0 || degree >= 4) {
            throw new IllegalArgumentException();
        }
        List<InequalityLine> result = new ArrayList<>(degree);
        for (int i = 0; i < degree; i++)
            result.add(buildInequality(degree));
        return new Inequality(degree, result);
    }

    private static List<Integer> generateCoefficients(int degree) {
        List<Integer> coefficients = new ArrayList<>(degree + 1);

        for (int i = 0; i < degree + 1; i++) {
            coefficients.add(ThreadLocalRandom.current().nextInt(-99, 100));
        }
        return coefficients;
    }


    private static InequalityLine buildInequality(int degree) {
        List<Integer> numbers = generateCoefficients(degree);
        return new InequalityLine(numbers, build(numbers), ThreadLocalRandom.current().nextInt(0, 4));
    }

    private static String build(List<Integer> numbers) {
        StringBuilder stringPolyRepresentation = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 0) {
                continue;
            }
            if (numbers.get(i) >= 1 && i != 0) {
                stringPolyRepresentation.append("+");
            }
            stringPolyRepresentation.append(numbers.get(i));
            if (i != numbers.size() - 1) {
                stringPolyRepresentation.append(getVariableName(i));
            }
        }
        return stringPolyRepresentation.toString();
    }

    private static String getVariableName(int index) {
        return switch (index) {
            case 0 -> "x";
            case 1 -> "y";
            case 2 -> "z";
            default -> null;
        };
    }

}
