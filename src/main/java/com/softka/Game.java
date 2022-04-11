package com.softka;

public class Game {
    Round[] rounds;
    int accumulatedReward;

    public Game(Round[] rounds){
        this.rounds = rounds;
        this.accumulatedReward = 0;
    }

    public void success(){

        // Modify in DB data from Player
        // UPDATE reward in table Player
    }

    public void playGame(Player player){
        for (Round round: this.rounds){
            Question currentQuestion = round.getQuestion();
            boolean isCorrect = currentQuestion.askQuestion();
            if (!isCorrect){
                this.gameOver();
                this.accumulatedReward = 0; // Remove all the points
                return;
            } else {
                System.out.println("Congratulations :) ");
                this.accumulatedReward += round.reward;
            }
            System.out.println("Accumulated Reward: " + this.accumulatedReward);
        }
        success();
    }

    public void gameOver(){
        System.out.println("Game Over :(");
    }



    public static void main(String[] args){
        
        
        Player player = new Player("Miguel",1);
        SQLConnection connection = new SQLConnection("localhost",1433,"mavs","password");
        RoundDAO roundDao = new RoundDAO(connection);
        Round[] rounds = roundDao.selectAll();
        Game game = new Game(rounds);
        game.playGame(player);
    }
}