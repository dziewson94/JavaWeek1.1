package com.sii.academy.javaweek1.main;

import com.sii.academy.javaweek1.polynominal.InequalityGenerator;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(InequalityGenerator.generateInequality(i));
            System.out.println("-------------------------------------------------------");
        }
    }

}
