package com.softka;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
public class QuestionDAO {
    SQLConnection connection;

    public QuestionDAO(SQLConnection connection){
        this.connection = connection;
    }
    public List<Question> getQuestionsFromRound(int id ){
        String sqlQuery = "select * from Question where RoundQuestion = " + id + ";";
        LinkedList<Question> questions = new LinkedList<Question>();
        try {
            Statement statement = this.connection.connection.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            while(results.next()){
                int IdQuestion = results.getInt(1);
                String option1 = results.getString(2);
                String option2 = results.getString(3);
                String option3 =results.getString(4);
                String option4 = results.getString(5);
                int correctOption = results.getInt(6);
                String questionName = results.getString(7);
                int RoundQuestion = results.getInt(8);
                String[] options = {option1, option2, option3, option4};
                Question question = new Question(questionName, options, correctOption,RoundQuestion);
                questions.push(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
    public Question getQuestion(int questionId){
        String sqlQuery = "select * from Question where IdQuestion = " + questionId + ";";
        Question question = null;
        try{
            Statement statement = this.connection.connection.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            while(results.next()){
                int id = results.getInt(1);
                String option1 = results.getString(2);
                String option2 = results.getString(3);
                String option3 =results.getString(4);
                String option4 = results.getString(5);
                int correctOption = results.getInt(6);
                String questionName = results.getString(7);
                int RoundQuestion = results.getInt(8);
                String[] options = {option1, option2, option3, option4};
                question = new Question(questionName, options, correctOption,RoundQuestion);
                return question;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return question;
    }

    public int[] getAllQuestionsFromRound(int roundId){
	    String sqlQuery = "select * from Round_Question where IdRound_ == " + roundId + ";";
        int[] allRounds = {};
        try{
            Statement statement = this.connection.connection.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            while(results.next()){
                int id = results.getInt(1);
                String name = results.getString(2);
                System.out.println(id + " " + name);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return allRounds;
    } 

    public static void main(String[] args) {
        SQLConnection connection = new SQLConnection("localhost",1433,"mavs","password");
        QuestionDAO questionDao = new QuestionDAO(connection);
        Question q = questionDao.getQuestion(1);
        q.printQuestion();
    }
}