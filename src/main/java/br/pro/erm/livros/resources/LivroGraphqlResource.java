package br.pro.erm.livros.resources;

import java.util.List;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import br.pro.erm.livros.models.Livro;
import br.pro.erm.livros.services.LivroService;
import jakarta.inject.Inject;

@GraphQLApi
public class LivroGraphqlResource {

    @Inject
    LivroService livroService;

    @Query("allLivros")
    public List<Livro> getAll() {
        return livroService.getAll();
    }
}
