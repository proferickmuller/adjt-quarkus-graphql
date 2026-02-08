package br.pro.erm.livros.models;

import java.time.LocalDate;

import jakarta.persistence.*;


@Entity
public class Livro  {
    @Id @GeneratedValue
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name="autor_id", nullable = false)
    private Autor autor;

    private LocalDate dataPublicacao;
    private Boolean disponivel;

    public Livro() {    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
