package com.sii.academy.javaweek1.inequality;

import java.util.List;

public class Inequality {

    private final List<InequalityLine> inequalityLines;

    public Inequality(int numOfVariables, List<InequalityLine> inequalityLines) {
        this.inequalityLines = inequalityLines;
        double[][] coefficientMatrix = new double[numOfVariables][numOfVariables];
        for (int i = 0; i < numOfVariables; i++) {
            for (int j = 0; j < numOfVariables; j++) {
                coefficientMatrix[i][j] = inequalityLines.get(i).getCoefficientsAsDoubleArray()[j];
            }
        }
        for (int i = 0; i < numOfVariables; i++) {
            for (int j = 0; j < numOfVariables; j++) {
                System.out.println(coefficientMatrix[i][j]); // Just to remove waring
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Inequality{\n");
        inequalityLines.forEach(stringBuilder::append);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
