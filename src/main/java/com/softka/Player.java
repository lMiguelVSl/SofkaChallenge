package com.softka;

public class Player {
    public String nickname;
    public double accumulatedReward;
    public int id;

    public Player(int id, String nickname){
        this.nickname = nickname;
        this.accumulatedReward = 0;
    }

    public Player(String nickname, int accumulatedReward){
        this.nickname = nickname;
        this.accumulatedReward = accumulatedReward;
    }
}