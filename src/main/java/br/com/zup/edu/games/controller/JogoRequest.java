package br.com.zup.edu.games.controller;

import br.com.zup.edu.games.model.Jogo;

import javax.validation.constraints.NotBlank;

public class JogoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private String link;

    public Jogo paraJogo() {
        return new Jogo(nome,descricao,link);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
