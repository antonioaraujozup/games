package br.com.zup.edu.games.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Jogo> jogos = new HashSet<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Pessoa() {
    }

    public void adicionar(Set<Jogo> novosJogos) {
        this.jogos.addAll(novosJogos);
        novosJogos.stream()
                .peek(jogo -> jogo.adicionar(this));
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
