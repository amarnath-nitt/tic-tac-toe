package com.rda.tic_tac_toe.model.dto;

/**
 * @author amarnath-nitt 12/03/24
 */
public class PlayerMessage implements Message{
    private String type;
    private String gameId;
    private String content;
    private String player;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getGameId() {
        return gameId;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
