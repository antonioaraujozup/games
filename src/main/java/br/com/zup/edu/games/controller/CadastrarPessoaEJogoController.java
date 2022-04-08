package br.com.zup.edu.games.controller;

import br.com.zup.edu.games.model.Pessoa;
import br.com.zup.edu.games.repository.JogoRepository;
import br.com.zup.edu.games.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class CadastrarPessoaEJogoController {

    private PessoaRepository pessoaRepository;
    private JogoRepository jogoRepository;

    public CadastrarPessoaEJogoController(PessoaRepository pessoaRepository, JogoRepository jogoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.jogoRepository = jogoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PessoaComJogoRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Pessoa novaPessoa = request.paraPessoa(jogoRepository);

        pessoaRepository.save(novaPessoa);

        URI location = uriComponentsBuilder.path("/pessoas/{id}")
                .buildAndExpand(novaPessoa.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
