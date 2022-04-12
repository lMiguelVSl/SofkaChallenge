package com.softka.DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.softka.Domain.Question;

public class QuestionDAO {
    SQLConnection connection;

    public QuestionDAO(SQLConnection connection) {
        this.connection = connection;
    }

    public List<Question> getQuestionsFromRound(int id) { // funcion para obtener las respuestas de una ronda en
                                                          // especifico
        String sqlQuery = "select * from Question where RoundQuestion = " + id + ";"; // se genera el query para la BD
        List<Question> questions = new LinkedList<Question>(); // se genera una lista con Questions de tipo Question
        try {
            Statement statement = this.connection.connection.createStatement(); // preguntar a
                                                                                // saenz-------------------------------------------
            ResultSet results = statement.executeQuery(sqlQuery);
            while (results.next()) {
                int IdQuestion = results.getInt(1); // obtengo los atributos en la tabla RoundQuestion
                String option1 = results.getString(2); //
                String option2 = results.getString(3); //
                String option3 = results.getString(4); //
                String option4 = results.getString(5); //
                int correctOption = results.getInt(6); //
                String questionName = results.getString(7); //
                int RoundQuestion = results.getInt(8); //
                String[] options = { option1, option2, option3, option4 }; // genero un array para guardar las opciones
                                                                           // de las preguntas en la ronda
                Question question = new Question(questionName, options, correctOption, RoundQuestion); // generacion del
                                                                                                       // objeto
                                                                                                       // pregunta
                questions.add(question); // guardo en la lista la pregunta generada
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Question getQuestion(int questionId) { // obtengo una pregunta
        String sqlQuery = "select * from Question where IdQuestion = " + questionId + ";"; // query para los datos de la
                                                                                           // pregunta
        Question question = null;
        try {
            Statement statement = this.connection.connection.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            while (results.next()) {
                int id = results.getInt(1); // obtengo los atributos de question
                String option1 = results.getString(2); //
                String option2 = results.getString(3);//
                String option3 = results.getString(4); //
                String option4 = results.getString(5); //
                int correctOption = results.getInt(6); //
                String questionName = results.getString(7); //
                int RoundQuestion = results.getInt(8); //
                String[] options = { option1, option2, option3, option4 }; // genero un array con las opciones
                question = new Question(questionName, options, correctOption, RoundQuestion); // creo el objeto question
                return question; // retorno el objeto
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return question;
    }

}