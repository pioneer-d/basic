package com.snaptag.labcode_china.navigation.more.data;

public class QuestionData {

    private int questionImage;
    private String questionText;
    private int arrowImage;

    public QuestionData(int questionImage, String questionText, int arrowImage){
        this.questionImage = questionImage;
        this.questionText = questionText;
        this.arrowImage = arrowImage;
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
}
