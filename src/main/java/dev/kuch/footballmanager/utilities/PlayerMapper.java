package dev.kuch.footballmanager.utilities;

import dev.kuch.footballmanager.dto.PlayerDTO;
import dev.kuch.footballmanager.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

/**
 * @author Artur Kuch
 */

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
@Component
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "team.teamId", source = "playerTeamId")
    Player toPlayer(PlayerDTO playerDTO);

    @Mapping(target = "playerTeamId", source = "team.teamId")
    PlayerDTO toPlayerDTO(Player player);

}
