package genevendas;

import java.util.ArrayList;
import java.util.List;

public class ProdutosList  implements SistemaProdutosInterface {

    private List<Produto> produtosList;

    public ProdutosList() {
        this.produtosList = new ArrayList<Produto>();
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        this.produtosList.add(produto);
    }

    @Override
    public void apagarProduto(String nome, String id) throws Exception {
        /*TODO*/
    }

    @Override
    public List<Produto> getProdutos() {
        return produtosList;
    }
}
