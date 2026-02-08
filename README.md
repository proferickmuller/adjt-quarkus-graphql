# Projeto GraphQL usado em apresentação. 

Antes, suba o banco de dados com o docker compose

```bash
docker compose up -d
```

## Pre-requisitos: 

- java >= 21
- maven 
- quarkus-cli (opcional)

> Caso use o mise, as ferramentas já estão pré instaladas no path, apenas roda `mise trust` e depois `mise install`.


## Para rodar a aplicação localmente

Usando quarkus-cli

```bash
quarkus dev
```

Usando maven

```bash
./mvnw quarkus:dev
```
