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
     * @param nome nome do produto
     * @param id id (hashCode) do produto
     * @throws ProdutoNaoExisteException lança exceção caso o produto não exista no Sistema
     */
    void apagarProduto (String nome, String id) throws ProdutoNaoExisteException;


    /**
     *
     * @return retorna uma lista com todos os produtos
     */
    List<Produto> getProdutos ();

}
