package br.pro.erm.livros.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Livro  {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private Boolean disponivel;
}
