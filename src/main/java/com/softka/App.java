package com.softka;

import java.util.List;

import com.softka.DAO.RoundDAO;
import com.softka.DAO.SQLConnection;
import com.softka.Domain.Game;
import com.softka.Domain.Player;
import com.softka.Domain.Round;

public class App {
    // MAIN DE LA APLICACIÓN
    public static void main(String[] args){ 
        SQLConnection connection = new SQLConnection("localhost",1433,"mavs","password"); //conexion con SQL
        
        //Insertamos el usuario nuevo o obtenemos el id del usuario si ya existe        
        Player player = new Player("Miguel",connection);
        player.SaveUser();

        //Jugar un juego nuevo
        RoundDAO roundDao = new RoundDAO(connection); //se le envia como parametro la conexion para las rondas
        List<Round> rounds = roundDao.selectAll(); //se guarda en una lista de tipo ROund todas las rondas
        Game game = new Game(rounds,connection); //se le envian las rondas al nuevo juego

        //Vamos a mostrar los juegos historicos que ha jugado
        player.printSavedGames(game);

        game.playGame(player); //se pasa como parametro el jugador al juego para dar inicio
       }
}
    