package br.com.zup.edu.games.repository;

import br.com.zup.edu.games.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
