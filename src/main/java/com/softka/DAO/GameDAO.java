package com.softka.DAO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

import com.softka.Domain.*;

import java.util.ArrayList;

public class GameDAO {

    // DEPENDENCIA, PORQUE EL DAO NECESITA SU CONEXIÓN PARA PODER INTERACTUAR CON LA
    // DB
    SQLConnection connection;

    // INYECCIÓN DE DEPENDENCIA
    public GameDAO(SQLConnection connection) {
        this.connection = connection;
    }

    public List<Game> getGamesByUser(int idPlayer) {
        String sqlStatementSearchPlayer = "SELECT IdRondaActual,accumulateReward FROM Game WHERE IdJugador IN ('"
                + idPlayer + "')";
        List<Game> games = new ArrayList<Game>();
        try {
            Statement statementInsert = this.connection.connection.createStatement();
            ResultSet result = statementInsert.executeQuery(sqlStatementSearchPlayer);

            // Recorremos los juegos que ha jugado el jugador y los metemos en una lista
            while (result.next()) {
                Game game = new Game();
                game.CurrentRound = result.getInt(1);
                game.accumulatedReward = result.getInt(2);
                games.add(game);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return games;
    }

    public void saveGame(Game game) {
        // Queremos guardar un usuario, un juego (un puntaje), ronda actual
        String executeInsert = "INSERT INTO Game (IdRondaActual,IdJugador,accumulateReward) ";
        executeInsert += "VALUES (" + game.CurrentRound + "," + game.player.idPlayer + "," + game.accumulatedReward
                + ")";
        try {
            Statement statementInsert = this.connection.connection.createStatement();
            statementInsert.execute(executeInsert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}