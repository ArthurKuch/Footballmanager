package dev.kuch.footballmanager.repository;

import dev.kuch.footballmanager.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Artur Kuch
 */

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
