package br.pro.erm.livros.models;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Livro extends PanacheEntity {
    public String titulo;
    public String autor;
    public LocalDate dataPublicacao;
    public Boolean disponivel;
}
