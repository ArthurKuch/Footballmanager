package dev.kuch.footballmanager.repository;

import dev.kuch.footballmanager.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Artur Kuch
 */

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

}
