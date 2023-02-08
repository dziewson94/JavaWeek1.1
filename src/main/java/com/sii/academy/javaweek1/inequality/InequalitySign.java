package com.sii.academy.javaweek1.inequality;

public enum InequalitySign {
    MORE(">"),
    LESS("<"),
    MORE_EQ(">="),
    LESS_EQ("<=");

    private final String sing;

    InequalitySign(String sign) {
        this.sing = sign;
    }

    public String getSing() {
        return sing;
    }
}
