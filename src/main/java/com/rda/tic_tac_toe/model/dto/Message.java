package com.rda.tic_tac_toe.model.dto;

/**
 * @author amarnath-nitt 12/03/24
 */
public interface Message {
    String getType();
    String getGameId();
    String getContent();
}
