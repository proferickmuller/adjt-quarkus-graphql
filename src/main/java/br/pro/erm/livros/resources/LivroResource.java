package br.pro.erm.livros.resources;

import java.util.List;

import br.pro.erm.livros.models.Livro;
import br.pro.erm.livros.repositories.LivroRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/livros")
public class LivroResource {

    @Inject 
    LivroRepository livroRepository;

    @GET 
    public List<Livro> getLivros() {
        return livroRepository.listAll();
    }

    @POST 
    @Transactional
    public Livro addLivro(NovoLivroRequest request) {
        Livro livro = new Livro();
        livro.setTitulo(request.nome());
        livro.setAutor(request.autor());
        livro.setDataPublicacao(java.time.LocalDate.parse(request.dataPublicacao()));
        livro.setDisponivel(true);
        livroRepository.persist(livro);
        return livro;
    }

    @GET 
    @Path("/{id}")
    public Livro getLivroById(Long id) {
        return livroRepository.findById(id);
    }

}
