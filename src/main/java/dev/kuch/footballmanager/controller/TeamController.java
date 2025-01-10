package dev.kuch.footballmanager.controller;


import dev.kuch.footballmanager.dto.TeamDTO;
import dev.kuch.footballmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Artur Kuch
 */

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO createdTeam = teamService.createTeam(teamDTO);

        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable int teamId) {
        TeamDTO teamDTO = teamService.getTeamById(teamId);
        if(teamDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(teamDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teamDTOList = teamService.getAllTeams();

        return new ResponseEntity<>(teamDTOList, HttpStatus.OK);
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable int teamId, @RequestBody TeamDTO teamDTO) {
        TeamDTO updatedTeam = teamService.updateTeam(teamDTO, teamId);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<?> deleteTeam(@PathVariable int teamId) {
        teamService.deleteTeamById(teamId);

        return ResponseEntity.ok(teamId);
    }


}
