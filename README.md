# testJavaJUnit5
Utilizacao de Testes Junit 5 

Criado Serviço de busca de Usuario com <b>Spring Data</b> e <b>H2</b>. 

URL GET http://localhost:8080/lista-usuarios

Resposta : 
```json
[
    {
        "id": 1,
        "nome": "Leandro",
        "telefone": 1524574856
    },
    {
        "id": 2,
        "nome": "Ariane",
        "telefone": 1197485964
    }
]
```

URL GET http://localhost:8080/lista-usuarios/1

Resposta :
```json
{
    "id": 1,
    "nome": "Leandro",
    "telefone": 1524574856
}
```

URL POST : http://localhost:8080/adicionar

Content-Type : application/json 

Requisição : 

```json 
{
    "nome": "Kubernetes",
    "telefone": 3565414856
}
``` 

Resposta :  

```json 
{
    "id": 3,
    "nome": "Kubernetes",
    "telefone": 3565414856
}
``` 

Executar sonar : 

mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=002a0d3f220befafb446cc77bfe5bd487f26b7d0
