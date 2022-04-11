package com.softka;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class RoundDAO {
    SQLConnection connection;
    QuestionDAO questionDao;

    public RoundDAO(SQLConnection connection){
        this.connection = connection;
        this.questionDao = new QuestionDAO(connection);
    }

    public Round[] selectAll(){
        String sqlQuery = "select * from Round_;";
        LinkedList<Round> allRounds = new LinkedList<Round>();
        try{
            Statement statement = this.connection.connection.createStatement();
            ResultSet results = statement.executeQuery(sqlQuery);
            while(results.next()){
                int id = results.getInt(1);
                String name = results.getString(2);
                int reward = results.getInt(3);
                /**
                 *  Question[] =  questionDao.getQuestionsFromRound(id);
                 */
                Question[] questions = {};
                Round round = new Round(questions, name, reward, id);
                System.out.println(id+" "+name+" "+reward);
                allRounds.push(round);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        Round[] rounds = allRounds.toArray(new Round[0]);
        return rounds;
    }

    public static void main(String[] args) {
        SQLConnection connection = new SQLConnection("localhost",1433,"mavs","password");
        RoundDAO dao = new RoundDAO(connection);
        dao.selectAll();
    }
}