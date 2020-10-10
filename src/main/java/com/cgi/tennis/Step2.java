package com.cgi.tennis;

public class Step2 implements TennisGame {

    private int pointsPlayer2;
    private int pointsPlayer1;
    private String namePlayer1;
    private String namePlayer2;

    public Step2(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }
    
    public String getScore() {
        String resultPlayer1;
        if (pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6)) {
            String[] resultMatrix = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            resultPlayer1 = resultMatrix[pointsPlayer1];
            return (pointsPlayer1 == pointsPlayer2) ? resultPlayer1 + "-All" : resultPlayer1 + "-" + resultMatrix[pointsPlayer2];
        }
        if (pointsPlayer1 == pointsPlayer2)
            return "Deuce";
        resultPlayer1 = pointsPlayer1 > pointsPlayer2 ? namePlayer1 : namePlayer2;
        return ((pointsPlayer1 -pointsPlayer2)*(pointsPlayer1 -pointsPlayer2) == 1) ? "Advantage " + resultPlayer1 : "Win for " + resultPlayer1;

    }
    
    public void wonPoint(String playerName) {
        if (playerName == this.namePlayer1)
            this.pointsPlayer1 += 1;
        if (playerName == this.namePlayer2)
            this.pointsPlayer2 += 1;
        
    }



}
