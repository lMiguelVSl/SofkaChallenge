package com.softka;

import java.sql.Statement; //SELECT, UPDATE, DELETE, INSERT//sentencia SQL
import java.sql.ResultSet;

public class PlayerDAO{
    private SQLConnection connection;

    public PlayerDAO(SQLConnection connection){
       this.connection = connection;
    }

    public int getIdUser(String nickName){
       String sqlStatementSearchPlayer= "SELECT IdJugador FROM JUGADOR WHERE NickName IN ('" + nickName + "')";
       int IdPlayer = 0;
       try{
        Statement statement = this.connection.connection.createStatement();
        ResultSet resultPlayer = statement.executeQuery(sqlStatementSearchPlayer);

        while(resultPlayer.next()){
           IdPlayer = resultPlayer.getInt(1);
        }
       }catch(Exception e){
           e.printStackTrace();
       }
       return IdPlayer;
    }

    public void createPlayer(Player player)
    {
        try{
             player.idPlayer = this.getIdUser(player.nickname);

             if(player.idPlayer == 0){
                String sqlStatement = "INSERT INTO Jugador (Nickname) VALUES ('" + player.nickname + "')";
                Statement statementInsert = this.connection.connection.createStatement();
                statementInsert.execute(sqlStatement);
                player.idPlayer = this.getIdUser(player.nickname);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}