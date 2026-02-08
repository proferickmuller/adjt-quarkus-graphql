package br.pro.erm.livros.resources;

public record NovoLivroRequest(
    String titulo, 
    Long autor,
    String dataPublicacao
) {

}
