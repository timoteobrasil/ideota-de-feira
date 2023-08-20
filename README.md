# Ideota de feira

Projeto de criar uma lista de compra semi-automática a partir do monitoramento da utilização de produtos em casa.

## Banco de dados com docker (adiado):
MySQL de exemplo do tutorial do docker
```powershell
docker run -d `
    --network todo-app --network-alias mysql `
    -v todo-mysql-data:/var/lib/mysql `
    -e MYSQL_ROOT_PASSWORD=secret `
    -e MYSQL_DATABASE=todos `
    mysql:8.0
```

## Features planejadas

* CRUD de produtos
    * Ler código de barras pelo celular
        * Inclusão a partir de scan do código de barras e consulta a alguma api online.

* Gerenciamento de categorias/sub-categorias

* Manter variação de preço
    * Meter uma flag de brinde/presente pra não cagar as estatísticas
    * Colocar uma flag de promoção para indicar que o preço foi anunciado como promoção
    * CRUD de tipos de promoção?

* Gerenciamento de estoque e necessidades
    * Adicionar o item próximo de acabar à lista de compras aberta

* Lista de compras
    * Manter uma (ou mais) lista de compras aberta(s) e guardar o histórico de compras
    * Gravar os produtos substituídos ou faltantes quando a compra for entregue
    * Estimar o valor da feira fazendo consulta a alguma api online, caso exista
    * Possibilitar o CTRL-C/CTRL-V do carrinho quando a compra for realizada

* Saldo sodexo
    * Manter o saldo do cartão atualizado (manualmente, porque se até o app deles é uma bosta, imagina se vão ter api)