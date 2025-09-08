package br.pro.erm.livros.services;

import java.util.List;

import br.pro.erm.livros.models.Livro;
import br.pro.erm.livros.repositories.LivroRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LivroService {

    @Inject
    LivroRepository livroRepository;

    public List<Livro> getAll() {
        return livroRepository.listAll();
    }
}
