package com.cgi.tennis;

import java.util.Optional;

public class Step6 implements TennisGame {

    private final Player player1;
    private final Player player2;




    public Step6(String namePlayer1, String namePlayer2) {
        this.player1 = new Player(namePlayer1, 0);
        this.player2 = new Player(namePlayer2, 0);
    }
    
    public String getScore() {
        Player leadingPlayer;
        if (player1.getPoints() < 4 && player2.getPoints() < 4 && !(player1.getPoints() + player2.getPoints() == 6)) {
            return (player1.getPoints() == player2.getPoints()) ? player1.getScore() + "-All" : player1.getScore() + "-" + player2.getScore();
        }
        leadingPlayer = getLeadingPlayer(player1, player2);
        if (leadingPlayer == null)
            return "Deuce";
        return ((player1.getPoints() - player2.getPoints()) * (player1.getPoints() - player2.getPoints()) == 1) ? "Advantage " + leadingPlayer.getName() : "Win for " + leadingPlayer.getName();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.incrementPoints();
        if (playerName.equals(player2.getName()))
            player2.incrementPoints();
        
    }

    private Player getLeadingPlayer(Player player1, Player player2){
        if (player1.getPoints() > player2.getPoints())
            return player1;
        if (player2.getPoints() > player1.getPoints())
            return player2;
        return null;
    }

    private static class Player {
        private final String[] SCORE_MATRIX = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        private final String name;
        private int points;

        public Player(String name, int points){
            this.name=name;
            this.points=points;
        }

        public String getName() {
            return name;
        }

        public int getPoints() {
            return points;
        }
        public void incrementPoints() {
            this.points++;
        }
        public String getScore(){
            return SCORE_MATRIX[points];
        }
    }

}


