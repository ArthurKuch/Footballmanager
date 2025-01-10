package dev.kuch.footballmanager.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Kuch
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;

    private String teamName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "team")
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();

    private double balance;

    private int transferCommissionPercent;



}
