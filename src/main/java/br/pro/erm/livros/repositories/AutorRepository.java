package br.pro.erm.livros.repositories;

import br.pro.erm.livros.models.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<Autor> {
    public Autor findById(Long id) { return find("id", id).firstResult(); }
}
