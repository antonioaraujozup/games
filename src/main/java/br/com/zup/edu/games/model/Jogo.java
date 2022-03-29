package br.com.zup.edu.games.model;

import javax.persistence.*;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    public Jogo(String nome, String descricao, String link) {
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Jogo() {
    }

    public Long getId() {
        return id;
    }
}
