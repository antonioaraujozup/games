package br.com.zup.edu.games.controller;

import br.com.zup.edu.games.model.Jogo;
import br.com.zup.edu.games.model.Pessoa;
import br.com.zup.edu.games.repository.JogoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

public class PessoaComJogoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Set<Long> jogos;

    public PessoaComJogoRequest() {
    }

    public PessoaComJogoRequest(String nome, Set<Long> jogos) {
        this.nome = nome;
        this.jogos = jogos;
    }

    public Pessoa paraPessoa(JogoRepository jogoRepository) {
        Set<Jogo> games = this.jogos.stream()
                .map(idJogo -> jogoRepository.findById(idJogo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não cadastrado")))
                .collect(Collectors.toSet());

        Pessoa pessoa = new Pessoa(nome);

        pessoa.adicionar(games);

        return pessoa;
    }

    public String getNome() {
        return nome;
    }

    public Set<Long> getJogos() {
        return jogos;
    }
}
