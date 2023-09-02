# Ideota de feira

Lista de compras simples que pode evoluir no futuro. Ainda tenho expectativa de usar algum dia.

## Tecnologias atuais

* Linguagem Java (JDK 17) com Maven (3.8.5)
* Framework Spring Boot (3.0.2)
* Banco de dados HSQLDB em memória (2.7.1)

## Tecnologias pretendidas

* Banco HSQLDB em arquivo inicialmente
* Banco Postgres quando crescer
* Frontend decente. Se não quiser aprender um decente, vou de React mesmo. *Criar um repo novo para esse front*.

## Features implementadas

### Iniciadas

* CRUD de produtos (CRUD rústico OK).
* CRUD de categorias (CRUD rústico OK).
    * Atualmente, o método de alterar está criando categorias novas se eu passar um ID que não está no banco. Cuidar disso quando estiver lidando com os erros.
* Criação e listagem de tags (falta RUD).
    * Associação de tags e produtos, mas o mapper não está mostrando o relacionamento.

### Concluídas

## Features Pretendidas

* CRUD de marcas
* Histórico de preços
* Lista de compras
    * Estimativa de valor das compras
* Tratamento de erros decente
* Testes unitários 😩
* Acompanhamento de consumo
* Sugestão de itens para a lista de compras
* Procurar alguma api gratuita de comparação de preços e tentar usar