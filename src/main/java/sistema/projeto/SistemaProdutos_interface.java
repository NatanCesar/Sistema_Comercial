package sistema.projeto;

import java.util.List;

public interface SistemaProdutos_interface {

    /**
     *
     * @param produto produto para cadastrar no sistema
     * @throws Exception lança exceção caso já exista um produto idêntico no sistema.
     */
    void cadastrarProduto (Produto produto) throws Exception;


    /**
     *
     * @param nome nome do produto
     * @param id id (hashCode) do produto
     * @throws Exception lança exceção caso o produto já não exista no Sistema
     */
    void apagarProduto (String nome, String id) throws Exception;


    /**
     *
     * @return retorna uma lista com todos os produtos
     */
    List<Produto> getProdutos ();

}
