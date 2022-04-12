package com.softka.Domain;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Question {
    public String question;
    public String[] options;
    public int correctOption;
    public int RoundQuestion;

    public Question(String question, String[] options, int correctOption,int RoundQuestion){ //constructor
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
        this.RoundQuestion = RoundQuestion;
    }

    public void printQuestion(){ //metodo para imprimir la pregunta que se encuentra dentro del array options
        System.out.println(this.question);
        for (int i=0; i < options.length; i++){
            int index = i+1;
            String option = options[i];
            System.out.println(index+") "+option); //se muestra la pregunta con formato numerado
        }
    }

    public boolean askQuestion(){ //funcion para imprimir la pregunta por consola
        this.printQuestion(); //se imprime la pregunta
        boolean waitingAnswer = true;
        int selectedOption = -1; //se resta 1 a la opcion ingresada por el usuario ya que en la base de datos commienaz con indice 0 en la posicion, para evitar que el usuario tenga opcion desde 0
        Scanner scanner;
        while(waitingAnswer){ //si la respuesta es ingresada
            System.out.println("Enter a valid option :");
            scanner = new Scanner(System.in);
            try{
                    selectedOption = scanner.nextInt(); //se escanea la  resspuesta del usuario
                    if(selectedOption <= 0 || selectedOption >= 5){ //si ingresa un valor por fuera del rango estipulado
                        throw new InputMismatchException(); //LANZAR UNA EXCEPCIÓN POR UN DATO MAL INTRODUCIDO
                    }
                    System.out.println(String.format("you choose the option: %d ",selectedOption));
                    waitingAnswer = false; //se cambia la variable bandera para no generar un bucle infinito
            } catch(Exception e){
                selectedOption = -1; 
                scanner.reset(); //se reinicia el scanner para que no tenga registros previos
                System.out.println("Not valid option, retry again please.");
            }
            if(waitingAnswer == false) //si ya erspondio se cambia la bandera para que no ingrese de nuevo al while
            scanner.reset(); //se reinia el scanner para borrar cualquier registro previo para que no afecte la siguiente ejecucion
        }
        selectedOption -= 1;
        if (this.correctOption != selectedOption){ //se compara la respuesta correcta con la respuesta ingresada por el usuario
            return false;
        } else {
            return true;
        }
    }
}