package br.pro.erm.livros.resources;

public record NovoLivroRequest(
    String nome, 
    String autor,
    String dataPublicacao
) {

}
