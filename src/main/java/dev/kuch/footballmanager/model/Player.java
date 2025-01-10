package dev.kuch.footballmanager.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;



/**
 * @author Artur Kuch
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;

    private String name;

    private String surname;

    private int age;

    private int experience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonBackReference
    private Team team;

}
