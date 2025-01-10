package dev.kuch.footballmanager.service.implementation;

import dev.kuch.footballmanager.dto.PlayerDTO;
import dev.kuch.footballmanager.exception.EntityNotFoundException;
import dev.kuch.footballmanager.exception.ServiceException;
import dev.kuch.footballmanager.model.Player;
import dev.kuch.footballmanager.model.Team;
import dev.kuch.footballmanager.repository.PlayerRepository;
import dev.kuch.footballmanager.repository.TeamRepository;
import dev.kuch.footballmanager.service.PlayerService;
import dev.kuch.footballmanager.utilities.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Artur Kuch
 */

@Service
@RequiredArgsConstructor
public class PlayerServiceImplementation implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = PlayerMapper.INSTANCE.toPlayer(playerDTO);
        Player savedPlayer = playerRepository.save(player);
        return PlayerMapper.INSTANCE.toPlayerDTO(savedPlayer);
    }

    @Override
    public PlayerDTO getPlayerById(int playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player with id " + playerId + " not found"));
        return PlayerMapper.INSTANCE.toPlayerDTO(player);
    }

    @Override
    public PlayerDTO updatePlayer(PlayerDTO playerDTO, int playerId) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player with id " + playerId + " not found"));
        existingPlayer.setName(playerDTO.getName());
        existingPlayer.setSurname(playerDTO.getSurname());
        existingPlayer.setAge(playerDTO.getAge());
        existingPlayer.setExperience(playerDTO.getExperience());
        Player updatedPlayer = playerRepository.save(existingPlayer);
        return PlayerMapper.INSTANCE.toPlayerDTO(updatedPlayer);
    }

    @Override
    public void deletePlayerById(int playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        List<Player> players = playerRepository.findAll();

        return players.stream().map(PlayerMapper.INSTANCE::toPlayerDTO).collect(Collectors.toList());
    }

    @Override
    public PlayerDTO transferPlayer(int playerId, int toTeamId) {
        Player currentPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException("Player with id " + playerId + " not found"));
        Team currentTeam = currentPlayer.getTeam();
        Team toTeam = teamRepository.findById(toTeamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with id " + toTeamId + " not found"));

        double transferPrice = (double) (currentPlayer.getExperience() * 100000) / currentPlayer.getAge();
        double commission= transferPrice * (currentTeam.getTransferCommissionPercent() / 100.0);
        double totalPrice = transferPrice + commission;

        if(toTeam.getBalance() < totalPrice){
            throw new ServiceException("Insufficient funds");
        }
        currentTeam.setBalance(currentTeam.getBalance() + transferPrice);
        toTeam.setBalance(toTeam.getBalance() - totalPrice);

        currentPlayer.setTeam(toTeam);
        playerRepository.save(currentPlayer);

        return PlayerMapper.INSTANCE.toPlayerDTO(currentPlayer);
    }

}
