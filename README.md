# API de gerenciamento de pessoas

- Produzido como forma de avaliação para vaga de Desenvolvedor Back-end Attornatus Procuradoria Digital

## ✒️ Autor

* José Alan Vieira Sales
 - E-mail: salesalan854@gmail.com

## 🛠️ Construído com

* P.O.O
* [Hibernate](https://hibernate.org) 
* [Maven](https://maven.apache.org/) 
* [Spring](https://spring.io/projects/spring-boot)
* [H2](https://www.h2database.com/html/quickstart.html)
* [Postman](https://www.postman.com/product/what-is-postman/)

## ⭐ Uma breve descrição
* O sistema possui duas entidades: Pessoa e Endereco:
- 👤 Pessoa -> id (Long/AutoGerado), nome, data_nascimento, end_logradouro, cep, numero, cidade (todas são do tipo String)

- 🏡 Endereco -> id(Long/AutoGerado), logradouro, cep, numero, cidade (todas String's), pessoa (Pessoa)

 - obs: A pessoa possui um endereço como requisito porque este será seu endereço padrão e depois, por meio das requisições de <Endereco> ela pode adicionar outros

## ⚙️ Operações
* Pessoa
  * Adicionar
  * Atualizar
  * Listar
  * Consulta por contenção
  * Consulta por nome
  * Consulta por id 
  * Deletar
* Endereco
  * Adicionar
  * Listar por pessoa
  * Endereco principal
  
Obs.1: A consulta por contenção acontece da seguinte maneira: O consumidor digita _http://localhost:8080/pessoas/K_ e surgirá uma lista de todas as pessoas com a letra K maiúscula. Além disso, não necessariamente deve ser uma letra, mas uma sequencia ou nome completo. Lembrando que a posição da letra/palavra no nome cadastrado não faz diferença, o que importa é se contém aquela letra/palavra

Obs.2: Quando requisitado o endereço principal, irá exibir o cadastro completo da pessoa, tal qual uma consulta dentro das requisições de pessoa. No entanto, a diferença é que através de um DTO o programador decide o que será exibido para o consumidor da api. Deixei tudo, mas você já entendeu que isso pode ser resolvido facilmente. Por exemplo: Poderia mostrar apenas o nome da pessoa e seu endereço principal.

* Observações: 
1. É possível criar uma pessoa sem um endereço, mas não pode ser feito o inverso
2. Você pode alterar apenas um, vários ou todos os campos na atualização
3. A consulta por nome retornam todos os cadastros com aquele nome, se quiser um filtro mais direto, digite o nome completo da pessoa
4. Caso didite um ID que não existe em uma consulta, o sistema retornará uma lista vazia ou um NotFound
5. Todos os campos estão validados por anotações do tipo @NotBlank e @NotNull, então caso você deixe de inserir um valor será disparado um erro com o status, campo associado ao erro (ex: nome) e a menssagem (ex: nome não pode estar em branco")
