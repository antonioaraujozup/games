package br.com.zup.edu.games.controller;

import br.com.zup.edu.games.model.Jogo;
import br.com.zup.edu.games.repository.JogoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/games")
public class CadastrarNovoJogoController {

    private final JogoRepository repository;

    public CadastrarNovoJogoController(JogoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar (@RequestBody @Valid JogoRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Jogo jogo = request.paraJogo();

        repository.save(jogo);

        URI location = uriComponentsBuilder.path("/games/{id}").buildAndExpand(jogo.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
