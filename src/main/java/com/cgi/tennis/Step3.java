package com.cgi.tennis;

public class Step3 implements TennisGame {

    private int pointsPlayer2;
    private int pointsPlayer1;
    private String namePlayer1;
    private String namePlayer2;
    private final String[] RESULT_MATRIX = new String[]{"Love", "Fifteen", "Thirty", "Forty"};


    public Step3(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }
    
    public String getScore() {
        String resultPlayer1;
        String resultPlayer2;
        String nameAdvantageOrWinner;
        if (pointsPlayer1 < 4 && pointsPlayer2 < 4 && !(pointsPlayer1 + pointsPlayer2 == 6)) {
            resultPlayer1 = RESULT_MATRIX[pointsPlayer1];
            resultPlayer2 = RESULT_MATRIX[pointsPlayer2];
            return (pointsPlayer1 == pointsPlayer2) ? resultPlayer1 + "-All" : resultPlayer1 + "-" + resultPlayer2;
        }
        if (pointsPlayer1 == pointsPlayer2)
            return "Deuce";
        nameAdvantageOrWinner = pointsPlayer1 > pointsPlayer2 ? namePlayer1 : namePlayer2;
        return ((pointsPlayer1 -pointsPlayer2)*(pointsPlayer1 -pointsPlayer2) == 1) ? "Advantage " + nameAdvantageOrWinner : "Win for " + nameAdvantageOrWinner;

    }
    
    public void wonPoint(String playerName) {
        if (playerName == this.namePlayer1)
            this.pointsPlayer1 += 1;
        if (playerName == this.namePlayer2)
            this.pointsPlayer2 += 1;
        
    }



}
