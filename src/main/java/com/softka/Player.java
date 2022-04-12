package com.softka;

import java.util.List;

public class Player {
    public String nickname;
    public double accumulatedReward;
    public int idPlayer;
    private PlayerDAO playerDAO;
 
    public Player(String nickname, SQLConnection connection){
        this.nickname = nickname;
        this.accumulatedReward = 0;
        this.playerDAO = new PlayerDAO(connection);
    }

    public void SaveUser(){
        this.playerDAO.createPlayer(this);
    }

    public void printSavedGames(Game game){
       List<Game> playedGames = game.gameDao.getGamesByUser(this.idPlayer);
       if(playedGames.size() >= 1)
       {
           System.out.println("Se han encontrado los siguientes registros de juego: \n");
           for(Game playedGame : playedGames){
               System.out.println(String.format("Premio obtenido:%d - Ronda:%d",playedGame.accumulatedReward,playedGame.CurrentRound));
            }
       } 
    }

}