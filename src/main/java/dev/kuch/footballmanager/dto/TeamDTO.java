package dev.kuch.footballmanager.dto;

import dev.kuch.footballmanager.model.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @author Artur Kuch
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamDTO {

    private int teamId;

    private String teamName;

    private ArrayList<Player> players;

    private double balance;

    private int transferCommissionPercent;

}
