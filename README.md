# Pizzaria Massa GIGA

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Muriloabreu/pizzariamassagiga/blob/main/LICENCE) 

# Sobre o projeto


Pizzaria Massa GIGA é uma API REST.

 API - Java utilizando Spring boot com o proposito de realizar Vários CRUDs para serviços de uma Pizzaria.  

Os CRUD são:
- Pedidos, 
- Bebidas, 
- Adicional Refeição, 
- Clientes, 
- Item do pedido 
- Entrega

#### - A API Pizzaria Massa GIGA faz uma ligação com uma API externa Pública VIACEP https://viacep.com.br/ onde no endpoint salvar uma entrega, realiza uma consulta do cep e trás todo o endereço. 

# Tecnologias utilizadas
## Back end
- Java
- Maven
- Spring Boot



## Implantação em produção

- Banco de dados: Postgres 9.5

## Back end
- Pré-requisitos: Java 17

# Como executar o projeto

Necessário ter um servidor Tomcat para poder rodar o projeto Java

##  Utilize uma plataforma de consultas de API's e faça a requisição de acordo os modelos disponíveis na sessão abaixo.
</code></pre>
 - Modelos de requisição JSON
</p>

</P>
<h5>Tipo de Refeição</h5>

```json
{
        "id": 1,
        "nome": "Pizza Pequena  ",
        "tamanho": "P",
        "valor": 20.0,
        "tipoFormatado": "Pequeno"
    },
    {
        "id": 2,
        "nome": "Pizza Media  ",
        "tamanho": "M",
        "valor": 40.0,
        "tipoFormatado": "Medio"
    }
```
</p>
<h5>Clientes</h5>

```json
{
    "nome": "André",
    "sobrenome": "Silva",
    "cpf": 31673948030,
    "email": "AndréBac4no9@teste.com",
    "telefone": 99999999999
}
```
</p>
<h5>Bebidas</h5>

```json
{
        "id": 105,
        "nome": "Refrigerante Coca Cola 2l",
        "quantidade": 1,
        "valorUnitario": 12.0,
        "valorTotal": 12.0
    }
```
</p>

<h5>Adicional Refeição</h5>

```json
 
    {
        "id": 152,
        "nome": "Borda recheada com queijo Gorgozola",
        "quantidade": 1,
        "valorUnitario": 8.0,
        "valorTotal": 8.0
    }
```    
</p>

<h5>Refeição(Pedido)</h5>

```json
{
    "id": 552,
    "tipoRefeicao": {
        "id": 202,
        "nome": "Pizza Media  ",
        "tamanho": "M",
        "valor": 40.0,
        "tipoFormatado": "Medio"
    },
    "adicionalRefeicoes": [
        {
            "id": 155,
            "nome": "Borda recheada com queijo do Reino ",
            "quantidade": 1,
            "valorUnitario": 10.0,
            "valorTotal": 10.0
        }
    ],
    "bebidas": [
        {
            "id": 102,
            "nome": "Cerveja R 330ml",
            "quantidade": 5,
            "valorUnitario": 10.0,
            "valorTotal": 50.0
        },
        {
            "id": 104,
            "nome": "Refrigerante Coca Cola 600ml",
            "quantidade": 1,
            "valorUnitario": 6.0,
            "valorTotal": 6.0
        }
    ],
    "cliente": {
        "id": 1,
        "nome": "José",
        "sobreNome": "da Silva",
        "cpf": "01673948131",
        "telefone": "999945035"
    },
    "entrega": false,
    "valorTotal": 106.0,
    "valorTotalBebidas": 56.0,
    "valorTotalAdicional": 10.0
}
```
</p>
<h5>Entrega</h5>

```json
{
        "id": 103,
        "refeicaoModel": {
            "id": 552,
            "tipoRefeicao": {
                "id": 202,
                "nome": "Pizza Media  ",
                "tamanho": "M",
                "valor": 40.0,
                "tipoFormatado": "Medio"
            },
            "adicionalRefeicoes": [
                {
                    "id": 155,
                    "nome": "Borda recheada com queijo do Reino ",
                    "quantidade": 1,
                    "valorUnitario": 10.0,
                    "valorTotal": 10.0
                }
            ],
            "bebidas": [
                {
                    "id": 102,
                    "nome": "Cerveja R 330ml",
                    "quantidade": 5,
                    "valorUnitario": 10.0,
                    "valorTotal": 50.0
                },
                {
                    "id": 104,
                    "nome": "Refrigerante Coca Cola 600ml",
                    "quantidade": 1,
                    "valorUnitario": 6.0,
                    "valorTotal": 6.0
                }
            ],
            "cliente": {
                "id": 1,
                "nome": "José",
                "sobreNome": "da Silva",
                "cpf": "01673948131",
                "telefone": "999945035"
            },
            "entrega": false,
            "valorTotal": 106.0,
            "valorTotalBebidas": 56.0,
            "valorTotalAdicional": 10.0
        },
        "cep": "51020-280",
        "logradouro": "Rua Padre Carapuceiro",
        "complemento": "",
        "bairro": "Boa Viagem",
        "localidade": "Recife",
        "uf": "PE"
    }
    
```
</p>   

```bash

# clonar repositório
git clone git@github.com:Muriloabreu/pizzariamassagiga.git

```

# Autor

Murilo Abreu do Nascimento

https://www.linkedin.com/in/murilo-abreu-07544973/
