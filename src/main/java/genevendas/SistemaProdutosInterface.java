package genevendas;

import genevendas.exceptions.ProdutoJaExisteException;
import genevendas.exceptions.ProdutoNaoExisteException;

import java.util.List;

public interface SistemaProdutosInterface {

    /**
     *
     * @param produto produto para cadastrar no sistema
     * @throws ProdutoJaExisteException lança exceção caso já exista um produto idêntico no sistema.
     */
    void cadastrarProduto (Produto produto) throws ProdutoJaExisteException;


    /**
     *
     * @param id id do produto que deseja apagar
     * @throws ProdutoNaoExisteException lança exceção caso o produto não exista no Sistema
     */
    void apagarProduto (int id) throws ProdutoNaoExisteException;


    /**
     *
     * @return retorna uma lista com todos os produtos
     */
    List<Produto> getProdutos ();

    /**
     *
     * @return retorna uma string com informações de cada produto da lista
     */
    public StringBuilder mostrarProdutos();


    /**
     *
     * @param id id do produto  que deseja buscar
     * @return retorna o produto com o id correspondente
     * @throws ProdutoNaoExisteException lança exceção caso não exista nenhum produto com o id informado
     */
    public Produto getProdutoByID(int id) throws ProdutoNaoExisteException;

}
