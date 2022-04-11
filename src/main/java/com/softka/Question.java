package com.softka;

import java.util.Scanner;

public class Question {
    public String question;
    public String[] options;
    public int correctOption;

    public Question(String question, String[] options, int correctOption){
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void printQuestion(){
        System.out.println(this.question);
        for (int i=0; i < options.length; i++){
            int index = i+1;
            String option = options[i];
            System.out.println(index+") "+option);
        }
    }

    public boolean askQuestion(){
        this.printQuestion();
        Scanner scanner = new Scanner(System.in);
        boolean waitingAnswer = true;
        int selectedOption = -1;
        while(waitingAnswer){
            System.out.println("Enter a valid option :");
            try{
                String input = scanner.next();
                selectedOption = Integer.parseInt(input);
                waitingAnswer = false;
            } catch(Exception e){}
        }
        scanner.close();

        selectedOption -= 1;
        if (this.correctOption != selectedOption){
            return false;
        } else {
            return true;
        }
    }
}