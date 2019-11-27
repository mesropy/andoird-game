package com.example.ourgame.Games;

import com.example.ourgame.Statistics.WriteData;

public abstract class Game {

    private WriteData data;
    private String username;
    private String gameName;

    private int pointsEarned; // points for this game, not total points
    private int playTime;

    protected Game(String gameName, WriteData data) {
        this.data = data;
        this.username = data.getCurrentUser();
        this.gameName = gameName;
        this.pointsEarned = 0;
        this.playTime = 0;
    }

    protected int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }


    public int getPointsEarned() {
        return pointsEarned;
    }
    protected void addPointsEarned(int points) {
        pointsEarned += points;
    }


    /**
     * Update the statistics of this game, as well as the overall game. Call this at the
     * end of each level or at the end of the game
     */
    public void updateStatistics() {
        if (canUpdateRanking()) {
            data.increaseRanking();
        }
        data.addLastGame(gameName);
        data.addPlayTime(playTime);
        data.addPoints(pointsEarned);
    }

    public abstract boolean canUpdateRanking();


    public String getLanguage() {
        return data.getLanguage();
    }

    public String getTheme() {
        return data.getThemeData();
    }

}
