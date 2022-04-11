package com.softka;

import java.util.Random;

public class Round {
    public Question[] questions;
    public int reward = 0;
    public String name = "";
    public int id;

    public Round(Question[] questions, String name, int reward, int id){
        this.questions = questions;
        this.reward = reward;
        this.id = id;
        this.name = name;
    }

    public Question getQuestion(){
        
        Random random = new Random();
        int nQuestions = this.questions.length;
        int randomIndex = random.nextInt(nQuestions);
        Question selectedQuestion = this.questions[randomIndex];
        return selectedQuestion;
    }
    
}