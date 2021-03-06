package com.softka.Domain;

import java.util.Random;
import java.util.List;

public class Round {
    public List<Question> questions;
    public int reward = 0;
    public String name = "";
    public int id;

    public Round(List<Question> questions, String name, int reward, int id){
        this.questions = questions;
        this.reward = reward;
        this.id = id;
        this.name = name;
    }

    public Question getQuestion(){  //selecciono la pregunta de forma aleatoria
        
        Random random = new Random();
        int nQuestions = this.questions.size();
        int randomIndex = Math.abs(random.nextInt(nQuestions)); //valor absoluto para que no se generen random negativos 
        Question selectedQuestion = this.questions.get(randomIndex); 
        return selectedQuestion; //retorno la pregunta
    }
    
}