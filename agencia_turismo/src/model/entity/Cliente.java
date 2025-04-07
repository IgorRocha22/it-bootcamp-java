package model.entity;

import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private Long id;
    private String nome;
    private Set<Long> idPacotes = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Long> getIdPacotes() {
        return idPacotes;
    }

    public void setIdPacotes(Set<Long> idPacotes) {
        this.idPacotes = idPacotes;
    }

    public boolean adicionarPacote(Long id) {
        return this.idPacotes.add(id);
    }
}
