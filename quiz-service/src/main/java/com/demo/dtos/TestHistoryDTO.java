package com.demo.dtos;

public class TestHistoryDTO {
    private int id;
    private int testID;
    private int userID;
    private String contentAnswer;
    private String timeSubmit;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getContentAnswer() {
        return contentAnswer;
    }

    public void setContentAnswer(String contentAnswer) {
        this.contentAnswer = contentAnswer;
    }

    public String getTimeSubmit() {
        return timeSubmit;
    }

    public void setTimeSubmit(String timeSubmit) {
        this.timeSubmit = timeSubmit;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
