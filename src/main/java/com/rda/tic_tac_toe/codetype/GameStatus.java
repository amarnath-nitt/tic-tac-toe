package com.rda.tic_tac_toe.codetype;

/**
 * @author amarnath-nitt 11/03/24
 */
public enum GameStatus {
    WAITING_FOR_PLAYER("Waiting for player."),
    PLAYER1_TURN("Player 1's turn."),
    PLAYER2_TURN("Player 2's turn."),
    PLAYER1_WON("Player 1 won."),
    PLAYER2_WON("Player 2 won."),
    TIE("Tie.");
    String description;
    GameStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
