package br.pro.erm.livros.resources;

public record NovoLivroRequest(
    String titulo, 
    String autor,
    String dataPublicacao
) {

}
