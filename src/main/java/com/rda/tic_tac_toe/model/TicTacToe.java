package com.rda.tic_tac_toe.model;

import com.rda.tic_tac_toe.codetype.GameStatus;
import com.rda.tic_tac_toe.codetype.Player;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author amarnath-nitt 12/03/24
 */
public class TicTacToe implements Serializable {
    private String gameId;
    private String[][] board;
    private String player1;
    private String player2;
    private String winner;
    private String turn;
    private GameStatus gameStatus;

    public TicTacToe(String player1, String player2) {
        this.gameId = UUID.randomUUID().toString();
        this.player1 = player1;
        this.player2 = player2;
        this.turn = player1;
        this.board = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.board[i][j] = " ";
            }
        }
        gameStatus = GameStatus.WAITING_FOR_PLAYER;
    }

    /**
     * Makes a move in the specified position on the board.
     *
     * @param player the name of the player making the move
     * @param move   the position of the move
     */
    public void makeMove(String player, int move) {
        int row = move / 3;
        int col = move % 3;
        if (Objects.equals(board[row][col], " ")) {
            board[row][col] = Objects.equals(player, player1) ? Player.P1.toString() : Player.P2.toString();
            turn = player.equals(player1) ? player2 : player1;
            checkWinner();
            updateGameState();
        }
    }
    /**
     * Check if there is a winner. If a winning combination is found,
     * the winner is set to the corresponding player.
     */
    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[i][0], board[i][1]) && Objects.equals(board[i][0], board[i][2])) {
                if (!Objects.equals(board[i][0], " ")) {
                    setWinner(Objects.equals(board[i][0], Player.P1.toString()) ? player1 : player2);
                    return;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[0][i], board[1][i]) && Objects.equals(board[0][i], board[2][i])) {
                if (!Objects.equals(board[0][i], " ")) {
                    setWinner(Objects.equals(board[0][i], Player.P1.toString()) ? player1 : player2);
                    return;
                }
            }
        }

        if (Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[0][0], board[2][2])) {
            if (!Objects.equals(board[0][0], " ")) {
                setWinner(Objects.equals(board[0][0], Player.P1.toString()) ? player1 : player2);
                return;
            }
        }
        if (Objects.equals(board[0][2], board[1][1]) && Objects.equals(board[0][2], board[2][0])) {
            if (!Objects.equals(board[0][2], " ")) {
                setWinner(Objects.equals(board[0][2], Player.P1.toString()) ? player1 : player2);
            }
        }
    }

    /**
     * Updates the game state based on the current state of the game.
     */
    private void updateGameState() {
        if (winner != null) {
            gameStatus = winner.equals(player1) ? GameStatus.PLAYER1_WON : GameStatus.PLAYER2_WON;
        } else if (isBoardFull()) {
            gameStatus = GameStatus.TIE;
        } else {
            gameStatus = turn.equals(player1) ? GameStatus.PLAYER1_TURN : GameStatus.PLAYER2_TURN;
        }
    }

    /**
     * Check if the board is full.
     *
     * @return true if the board is full, false otherwise
     */
    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(board[i][j], " ")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return winner != null || isBoardFull();
    }

    /**
     * Getters and Setters
     */
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
}
