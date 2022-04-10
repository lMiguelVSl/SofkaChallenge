package com.softka;

import java.util.LinkedList;
import java.util.Random;

public class Round {
    public LinkedList<Question> questions;
    public int reward;

    public Round(LinkedList<Question> questions, int reward){
        this.questions = questions;
        this.reward = reward;
    }

    public Question getQuestion(){
        Random random = new Random();
        int nQuestions = this.questions.size();
        int randomIndex = random.nextInt(nQuestions);
        Question selectedQuestion = this.questions.get(randomIndex);
        return selectedQuestion;
    }
    
}