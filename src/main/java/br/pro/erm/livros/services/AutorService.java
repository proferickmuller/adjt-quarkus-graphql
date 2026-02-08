package br.pro.erm.livros.services;

import br.pro.erm.livros.models.Autor;
import br.pro.erm.livros.models.Livro;
import br.pro.erm.livros.repositories.AutorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AutorService {
    @Inject
    AutorRepository autorRepository;

    public List<Autor> todos() { return autorRepository.listAll(); }

    public Autor buscarPorId(Long id) { return autorRepository.findById(id); }

    public Autor novoAutor(Autor autor) {
        autorRepository.persist(autor);
        return autor;
    }
}
