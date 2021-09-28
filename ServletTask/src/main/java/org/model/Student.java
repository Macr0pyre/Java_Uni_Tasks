package org.model;

public class Student {
    private String name;
    private Float averageScore;
    private Boolean knowsBlockchain;

    public Student() {
    }

    public Student(String name, Float averageScore, Boolean knowsBlockchain) {
        this.name = name;
        this.averageScore = averageScore;
        this.knowsBlockchain = knowsBlockchain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Boolean isKnowsBlockchain() {
        return knowsBlockchain;
    }

    public void setKnowsBlockchain(Boolean knowsBlockchain) {
        this.knowsBlockchain = knowsBlockchain;
    }

    @Override
    public String toString() {
        return name + ", " + averageScore + ", " + knowsBlockchain;
    }
}
