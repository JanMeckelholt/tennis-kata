package com.cgi.tennis;

public class Step9 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public Step9(String namePlayer1, String namePlayer2) {
        this.player1 = new Player(namePlayer1, 0);
        this.player2 = new Player(namePlayer2, 0);
    }

    public String getScore() {
        Player leadingPlayer;
        if (player1.getPoints() < 4 && player2.getPoints() < 4 && !(statusDeuce(player1.getPoints(), player2.getPoints()))) {
            return scoreString(player1, player2);
        }
        if (statusDeuce(player1.getPoints(), player2.getPoints()))
            return "Deuce";
        leadingPlayer = getLeader(player1, player2);
        if (gameEnded(player1.getPoints(), player2.getPoints()))
            return "Win for " + leadingPlayer.getName();
        return "Advantage " + leadingPlayer.getName();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.incrementPoints();
        if (playerName.equals(player2.getName()))
            player2.incrementPoints();
    }

    private String scoreString(Player player1, Player player2) {
        if (player1.getPoints() == player2.getPoints())
            return player1.getScore() + "-All";
        return player1.getScore() + "-" + player2.getScore();
    }


    private Player getLeader(Player player1, Player player2){
        if (player1.getPoints() > player2.getPoints())
            return player1;
        if (player2.getPoints() > player1.getPoints())
            return player2;
        return null;
    }

    private boolean statusDeuce(int pointsPlayer1, int pointsPlayer2){
        return (pointsPlayer1==pointsPlayer2) && (pointsPlayer1>2);
    }

    private boolean gameEnded(int pointsPlayer1, int pointsPlayer2){
        int higherPoints = Integer.max(pointsPlayer1, pointsPlayer2);
        int lowerPoints = Integer.min(pointsPlayer1, pointsPlayer2);
        return (higherPoints - lowerPoints) > 1 && (higherPoints>3);
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


