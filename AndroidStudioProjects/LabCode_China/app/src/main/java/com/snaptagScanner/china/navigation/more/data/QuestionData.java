package com.snaptagScanner.china.navigation.more.data;

public class QuestionData {

    private String position;
    private int questionImage;
    private String questionText;
    private int arrowImage;

    private int childText;

    public QuestionData(String position, int questionImage, String questionText, int arrowImage, int childText){
        this.position = position;
        this.questionImage = questionImage;
        this.questionText = questionText;
        this.arrowImage = arrowImage;
        this.childText = childText;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(int questionImage) {
        this.questionImage = questionImage;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getArrowImage() {
        return arrowImage;
    }

    public void setArrowImage(int arrowImage) {
        this.arrowImage = arrowImage;
    }

    public int getChildText() {
        return childText;
    }

    public void setChildText(int childText) {
        this.childText = childText;
    }
}
