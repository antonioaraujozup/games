package br.com.zup.edu.games.repository;

import br.com.zup.edu.games.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
