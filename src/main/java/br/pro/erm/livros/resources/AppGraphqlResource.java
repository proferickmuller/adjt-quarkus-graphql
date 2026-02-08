package br.pro.erm.livros.resources;

import java.util.List;

import br.pro.erm.livros.models.Autor;
import br.pro.erm.livros.services.AutorService;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import br.pro.erm.livros.models.Livro;
import br.pro.erm.livros.services.LivroService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DefaultValue;

@GraphQLApi
public class AppGraphqlResource {

    @Inject
    LivroService livroService;

    @Inject
    AutorService autorService;

    @Query("allLivros")
    public List<Livro> getAll() {
        return livroService.todos();
    }

    @Mutation 
    @Transactional
    public Livro novoLivro(NovoLivroRequest livro) {
        Autor autor = autorService.buscarPorId(livro.autor());

        Livro novoLivro = new Livro();
        novoLivro.setTitulo(livro.titulo());
        novoLivro.setAutor(autor);
        novoLivro.setDataPublicacao(java.time.LocalDate.parse(livro.dataPublicacao()));
        novoLivro.setDisponivel(true);
        var l = livroService.novoLivro(novoLivro);
        return l;
    }

    @Mutation
    @Transactional
    public Autor novoAutor(String nome) {
        Autor novoAutor = new Autor();
        novoAutor.setNome(nome);
        var a = autorService.novoAutor(novoAutor);
        return a;
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

    @Query 
    public Livro livroPorId(Long id) {
        return livroService.buscarPorId(id);
    }

    @Query("allAutores")
    public List<Autor> getAllAutores() {return  autorService.todos();}
}
