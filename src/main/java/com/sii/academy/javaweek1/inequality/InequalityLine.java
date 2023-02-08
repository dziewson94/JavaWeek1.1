package com.sii.academy.javaweek1.inequality;

import java.util.List;

public class InequalityLine {
    private final List<Integer> coefficients;
    private String stringRepresentation;

    public InequalityLine(List<Integer> coefficients, String stringRepresentation, int signIndex) {
        this.stringRepresentation = stringRepresentation;
        this.coefficients = coefficients;
        InequalitySign sign = InequalitySign.values()[signIndex];
        this.stringRepresentation += String.format(" %s 0\n", sign.getSing());
    }

    public double[] getCoefficientsAsDoubleArray() {
        return coefficients.stream().mapToDouble(d -> d).toArray();
    }


    @Override
    public String toString() {
        return stringRepresentation;
    }
}
