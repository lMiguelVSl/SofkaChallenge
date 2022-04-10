package com.softka;

import java.util.LinkedList;

public class Question {
    public String question;
    public String[] options;
    public int correctOption;

    public Question(String question, String[] options, int correctOption){
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}