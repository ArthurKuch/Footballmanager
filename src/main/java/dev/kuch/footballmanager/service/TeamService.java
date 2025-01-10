package dev.kuch.footballmanager.service;

import dev.kuch.footballmanager.dto.TeamDTO;

import java.util.List;

/**
 * @author Artur Kuch
 */

public interface TeamService {

    TeamDTO createTeam(TeamDTO teamDTO);

    TeamDTO getTeamById(int teamId);

    List<TeamDTO> getAllTeams();

    TeamDTO updateTeam(TeamDTO teamDTO, int teamId);

    void deleteTeamById(int teamId);

}
