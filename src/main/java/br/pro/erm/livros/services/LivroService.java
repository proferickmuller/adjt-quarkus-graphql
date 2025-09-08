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

    public List<Livro> todos() {
        return livroRepository.listAll();
    }

    public Livro novoLivro(Livro livro) {
        livroRepository.persist(livro);
        return livro;
    }

    public void delete(Long id) {
        Livro livro = livroRepository.findById(id);
        if (livro != null) {
            livroRepository.delete(livro);
        }
    }

    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> livros = livroRepository.porNome(autor);
        return livros;
    }
}
