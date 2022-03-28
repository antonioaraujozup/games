package br.com.zup.edu.games.controller;

import br.com.zup.edu.games.repository.JogoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class CadastrarNovoJogoController {

    private final JogoRepository repository;

    public CadastrarNovoJogoController(JogoRepository repository) {
        this.repository = repository;
    }

}
