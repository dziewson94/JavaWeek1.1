package com.sii.academy.javaweek1.polynominal;

import java.util.List;

public class InequalityLine {
    private List<Integer> coefficients;
    private String stringRepresentation;
    private InequalitySign sign;

    public InequalityLine(List<Integer> coefficients, String stringRepresentation, int signIndex) {
        this.stringRepresentation = stringRepresentation;
        this.coefficients = coefficients;
        sign = InequalitySign.values()[signIndex];
        this.stringRepresentation += String.format(" %s 0\n", sign.getSing());
    }

    public double[] getCoefficientsAsDoubleArray() {
        return coefficients.stream().mapToDouble(d -> d).toArray();
    }

    public void setCoefficients(List<Integer> coefficients) {
        this.coefficients = coefficients;
    }


    @Override
    public String toString() {
        return stringRepresentation;
    }
}
