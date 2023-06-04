package genevendas;

import genevendas.exceptions.ProdutoJaExisteException;
import genevendas.exceptions.ProdutoNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class ProdutosList  implements SistemaProdutosInterface {

    private List<Produto> produtosList;

    public ProdutosList() {
        this.produtosList = new ArrayList<Produto>();
    }

    @Override
    public void cadastrarProduto(Produto produto) throws ProdutoJaExisteException {
        if (produtoJaExiste(produto)){
            throw new ProdutoJaExisteException("Produto já existe no sistema");
        } else {
            produtosList.add(produto);
        }


    }

    public boolean produtoJaExiste(Produto produto){
        for (Produto p : this.produtosList){
            if (p.equals(produto)){
                return true;
            }
        }
        return false;
    }


    @Override
    public void apagarProduto(String nome, String id) throws ProdutoNaoExisteException {
        /*TODO*/
    }

    @Override
    public List<Produto> getProdutos() {
        return produtosList;
    }
}
