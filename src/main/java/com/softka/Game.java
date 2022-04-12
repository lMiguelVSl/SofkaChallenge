package com.softka;

import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

//acumulado 4, jugar alejandro, current 3; --> this
//acumulado 10, jugar miguel, current 1; --> this

public class Game {
    List<Round> rounds; //rondas
    int accumulatedReward; //puntaje del jugador
    Player player; //información del jugador
    GameDAO gameDao; //Data Access Object de interacción con la tabla de Game.
    int CurrentRound; //Flag 

    public Game(){}

    public Game(List<Round> rounds, SQLConnection connection){
        this.rounds = rounds;
        this.accumulatedReward = 0;
        gameDao = new GameDAO(connection);
    }
    //metodo para llamar getQuestion y askQuestion 
    public void playGame(Player player) 
    { 
        //Especificamos el juegador del juego
        this.player = player;

        //El juego inicia con todas las rondas
        for(Round round : this.rounds)
        { 
            this.CurrentRound = round.id; //guardar la ronda actual

            Question currentQuestion = round.getQuestion();//Solo coloca el punto de interrupción aqui, el resto lo quitas
            boolean isCorrect = currentQuestion.askQuestion();
            if (!isCorrect) //se verifica la respuesta ingresada por el usuairio
            {
                
                //termina el juego
                this.gameOver(); //si es falsa la opcion ingresada se termina el juego
                this.accumulatedReward = 0; //se reinician los puntos ya que respondio erroneamente 
                
                return;
            } else //si la respuesta ingresada es correcta 
            { 
                System.out.println("Congratulations :) ");
                this.accumulatedReward += round.reward; //se acumula el premio de la ronda 
            }
            System.out.println("Accumulated Reward: " + this.accumulatedReward); //se le muestra el acumulado del momento
            askNext(); //si contesta correctamente se le pregunta si quiere continuar o no 
        }
        //gano el juego
        success(); //al pasar los 5 niveles se le indica el premio total 
    }

    public void askNext(){
        System.out.println("Do you want continue with the next question? \n write 1 to continue or 2 to end the game");
        Scanner in = new Scanner(System.in);

        try{

            int respuesta = in.nextInt(); //se lee el valor ingresado por el usuario
            if(respuesta <= 0 || respuesta >= 3){ //no se permiten valores por fuera del rango
                throw new InputMismatchException(); //LANZAR UNA EXCEPCIÓN POR UN DATO MAL INTRODUCIDO
            } else if(respuesta == 1){ //si desea seguir con el juego no se ejecuta nada
                return;
            } else if(respuesta == 2 ){
                System.out.println(String.format("you decided finish the game, thank you for your time. Your reward is %d",this.accumulatedReward));
                
                gameOver();
                

         }

        } catch (Exception e) {
            e.printStackTrace(); //se muestra si hay algun error
        }
        
    }

    public void success(){
        System.out.println("Game Over :) you are winner");
        System.out.println("Your Accumulated Reward is: " + this.accumulatedReward);
        saveGame();
    }

    public void gameOver(){ //cuando responde erroneamente se termina la ejecucion
        System.out.println("Game Over :(");
        System.out.println("Your Accumulated Reward is: " + this.accumulatedReward);
        saveGame();
        System.exit(0);
        
    }

    public void saveGame(){
      this.gameDao.saveGame(this);
    }

}