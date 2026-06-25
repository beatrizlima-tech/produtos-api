package br.com.cotiinformatica.produtos_api.repositories;

import br.com.cotiinformatica.produtos_api.entities.Produto;
import br.com.cotiinformatica.produtos_api.factories.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    /*
        Método para inserir um produto na tabela do banco de dados
     */
    public void inserir(Produto produto) throws Exception {

        //Abrir conexão com o banco de dados
        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        //Executar o comando SQL para inserir um registro na tabela de produtos
        var statement = connection.prepareStatement("""
            insert into produtos(nome, descricao, preco, quantidade)
            values(?,?,?,?)
        """);

        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setInt(4, produto.getQuantidade());
        statement.execute();

        //Fechar a conexão com o banco de dados
        connection.close();
    }

    /*
        Método para atualizar os dados do produto
     */
    public boolean atualizar(Produto produto) throws Exception {

        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        var statement = connection.prepareStatement("""
            update produtos 
            set nome = ?, descricao = ?, preco = ?, quantidade = ?, data_atualizacao = now()
            where id = ?
        """);

        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setInt(4, produto.getQuantidade());
        statement.setInt(5, produto.getId());
        var result = statement.executeUpdate();

        connection.close();

        return result > 0; //true ou false
    }

    /*
        Método para excluir um produto (exclusão lógica)
     */
    public boolean excluir(Integer id) throws Exception {

        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        var statement = connection.prepareStatement("""
            update produtos 
            set ativo = 0, data_exclusao = now()
            where ativo = 1 and id = ?
        """);

        statement.setInt(1, id);
        var result = statement.executeUpdate();

        connection.close();

        return result > 0; //true ou false
    }

    /*
        Método para retornar uma lista com produtos ativos do banco de dados
        e filtrando pelo nome do produto.
     */
    public List<Produto> obterPorNome(String nome) throws Exception {

        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        var statement = connection.prepareStatement("""
            select id, nome, descricao, preco, quantidade
            from produtos
            where ativo = 1 and nome ilike ?
            order by nome
        """);

        statement.setString(1, "%" + nome + "%");
        var result = statement.executeQuery();

        var lista = new ArrayList<Produto>(); //Lista de produtos vazia

        while(result.next()) { //Lendo cada produto obtido do banco de dados

            var produto = new Produto(); //Criando uma instância de produto

            produto.setId(result.getInt("id"));
            produto.setNome(result.getString("nome"));
            produto.setDescricao(result.getString("descricao"));
            produto.setPreco(result.getDouble("preco"));
            produto.setQuantidade(result.getInt("quantidade"));

            lista.add(produto); //Adicionando o produto na lista
        }

        connection.close();

        return lista;
    }

    /*
        Método para consultar 1 produto através do ID
     */
    public Produto obterPorId(Integer id) throws Exception {

        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        var statement = connection.prepareStatement("""
            select id, nome, descricao, preco, quantidade
            from produtos
            where ativo = 1 and id = ?
        """);

        statement.setInt(1, id);
        var result = statement.executeQuery();


        Produto produto = null;

        if(result.next()) {
            produto = new Produto();

            produto.setId(result.getInt("id"));
            produto.setNome(result.getString("nome"));
            produto.setDescricao(result.getString("descricao"));
            produto.setPreco(result.getDouble("preco"));
            produto.setQuantidade(result.getInt("quantidade"));
        }

        connection.close();

        return produto;
    }
}
