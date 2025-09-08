package br.pro.erm.livros.resources;

import java.util.List;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import br.pro.erm.livros.models.Livro;
import br.pro.erm.livros.services.LivroService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DefaultValue;

@GraphQLApi
public class LivroGraphqlResource {

    @Inject
    LivroService livroService;

    @Query("allLivros")
    public List<Livro> getAll() {
        return livroService.todos();
    }

    @Mutation 
    @Transactional
    public Livro novoLivro(NovoLivroRequest livro) {
        Livro novoLivro = new Livro();
        novoLivro.setTitulo(livro.nome());
        novoLivro.setAutor(livro.autor());
        novoLivro.setDataPublicacao(java.time.LocalDate.parse(livro.dataPublicacao()));
        novoLivro.setDisponivel(true);
        var l = livroService.novoLivro(novoLivro);
        return l;
    }

    @Mutation
    @Transactional
    public RemoveLivroResponse deleteLivro(Long id) {
        livroService.delete(id);
        return new RemoveLivroResponse(true);
    }

    @Query 
    public List<Livro> livroPorAutor(@DefaultValue("") String autor ) {
        return livroService.buscarPorAutor(autor);
    }

    
}
