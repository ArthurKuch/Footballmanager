package dev.kuch.footballmanager.controller;

import dev.kuch.footballmanager.dto.PlayerDTO;
import dev.kuch.footballmanager.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Artur Kuch
 */
@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO createdPlayer = playerService.createPlayer(playerDTO);

        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PlayerDTO>> getPlayers(){
        List<PlayerDTO> playerDTOs = playerService.getAllPlayers();

        return new ResponseEntity<>(playerDTOs, HttpStatus.OK);
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable int playerId) {
        PlayerDTO playerDTO = playerService.getPlayerById(playerId);
        if(playerDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable int playerId, @RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayer = playerService.updatePlayer(playerDTO, playerId);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @PutMapping("/transfer/{playerId}")
    public ResponseEntity<PlayerDTO> transferPlayer(@PathVariable int playerId, @RequestParam int toTeamId) {

        PlayerDTO transferredPlayer = playerService.transferPlayer(playerId, toTeamId);

        return new ResponseEntity<>(transferredPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> deletePlayer(@PathVariable int playerId) {
        playerService.deletePlayerById(playerId);

        return ResponseEntity.ok(playerId);
    }

}
