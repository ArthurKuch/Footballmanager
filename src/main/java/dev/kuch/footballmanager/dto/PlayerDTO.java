package dev.kuch.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Artur Kuch
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlayerDTO {

    private int playerId;

    private String name;

    private String surname;

    private int age;

    private int experience;

    private int playerTeamId;

}
