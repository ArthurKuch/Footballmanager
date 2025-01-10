package dev.kuch.footballmanager.service;

import dev.kuch.footballmanager.dto.PlayerDTO;

import java.util.List;

/**
 * @author Artur Kuch
 */

public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    PlayerDTO getPlayerById(int playerId);

    List<PlayerDTO> getAllPlayers();

    PlayerDTO updatePlayer(PlayerDTO playerDTO, int playerId);

    PlayerDTO transferPlayer(int playerId, int toTeamId);

    void deletePlayerById(int playerId);

}
