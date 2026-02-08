# Queries GraphQL 

Mais queries em docs/api/requests, usar com o [api client Bruno](https://www.usebruno.com).

## Criar um autor 

```graphql
mutation NovoAutor($nomeAutor: String) {
    novoAutor(nome: $nomeAutor) {
        id
    }
}


{ "nomeAutor": "Nome do Autor" }
```

## Listar todos os autores 

```
query {
  allAutores {
    id
    nome
  }
}
```

## Criar um novo Livro

```
mutation NovoLivro($req:NovoLivroRequestInput) {
  novoLivro(livro: $req) {
    id
    titulo
    autor {
      nome
    }
  }
}


{"req": {
  "titulo":"Ensaio sobre a cegueira",
  "autor":"1",
  "dataPublicacao":"1990-01-01"
}}
```