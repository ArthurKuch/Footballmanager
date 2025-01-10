package dev.kuch.footballmanager.utilities;

import dev.kuch.footballmanager.dto.TeamDTO;
import dev.kuch.footballmanager.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @author Artur Kuch
 */

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    Team toTeam(TeamDTO teamDTO);
    TeamDTO toTeamDTO(Team team);

}
