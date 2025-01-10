package dev.kuch.footballmanager.service.implementation;

import dev.kuch.footballmanager.dto.TeamDTO;
import dev.kuch.footballmanager.exception.EntityNotFoundException;
import dev.kuch.footballmanager.model.Team;
import dev.kuch.footballmanager.repository.TeamRepository;
import dev.kuch.footballmanager.service.TeamService;
import dev.kuch.footballmanager.utilities.TeamMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Artur Kuch
 */

@Service
@RequiredArgsConstructor
public class TeamServiceImplementation implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = TeamMapper.INSTANCE.toTeam(teamDTO);
        Team savedTeam = teamRepository.save(team);
        return TeamMapper.INSTANCE.toTeamDTO(savedTeam);
    }

    @Override
    public TeamDTO getTeamById(int teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with id " + teamId + " not found"));
        return TeamMapper.INSTANCE.toTeamDTO(team);
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();

        return teams.stream().map(TeamMapper.INSTANCE::toTeamDTO).collect(Collectors.toList());
    }

    @Override
    public TeamDTO updateTeam(TeamDTO teamDTO, int teamId) {
        Team existingTeam = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team with id " + teamId + " not found"));
        existingTeam.setTeamName(teamDTO.getTeamName());
        existingTeam.setBalance(teamDTO.getBalance());
        existingTeam.setTransferCommissionPercent(teamDTO.getTransferCommissionPercent());
        Team updatedTeam = teamRepository.save(existingTeam);
        return TeamMapper.INSTANCE.toTeamDTO(updatedTeam);
    }

    @Override
    public void deleteTeamById(int teamId) {
        teamRepository.deleteById(teamId);
    }
}
