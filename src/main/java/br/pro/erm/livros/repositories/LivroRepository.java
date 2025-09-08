package br.pro.erm.livros.repositories;

import java.util.List;

import br.pro.erm.livros.models.Livro;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepository<Livro> {
    public Livro findById(Long id) {
        return find("id", id).firstResult();
    }

    public List<Livro> porNome(String autor) {
        return list("autor", autor);
    }

}
