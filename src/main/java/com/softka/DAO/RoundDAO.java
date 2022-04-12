package com.softka.DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.softka.Domain.Question;
import com.softka.Domain.Round;

public class RoundDAO {
    SQLConnection connection;
    QuestionDAO questionDao;

    public RoundDAO(SQLConnection connection) {
        this.connection = connection;
        this.questionDao = new QuestionDAO(connection);
    }

    public List<Round> selectAll() {
        String sqlQuery = "select * from Round_ ORDER BY IdRound"; //selecciono todo de la ronda ordenado en orden ascendente
        List<Round> allRounds = new LinkedList<Round>(); //creo una lista allRound de tipo Round
        try {
            Statement statement = this.connection.connection.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            while (results.next()) {
                int id = results.getInt(1); //obtengo el id de la ronda
                String name = results.getString(2); //obtengo el nivel de la ronda
                int reward = results.getInt(3); //obtengo el reward perteneciente a esta ronda
                List<Question> questions = questionDao.getQuestionsFromRound(id); //creo la lista questions de tipo Question para obtener las preguntas de este roun en especifico
                Round round = new Round(questions, name, reward, id); //creo el objeto ronda
                allRounds.add(round); //agrego en la lista allROunds la ronda generada
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allRounds;
    }
}