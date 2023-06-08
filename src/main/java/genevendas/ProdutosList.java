package genevendas;

import genevendas.exceptions.ClienteNaoExisteException;
import genevendas.exceptions.ProdutoJaExisteException;
import genevendas.exceptions.ProdutoNaoExisteException;

import javax.sound.sampled.Port;
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
    public void apagarProduto(int id) throws ProdutoNaoExisteException {

        for (Produto p : this.produtosList) {
            if (p.getId() == id) {
                this.produtosList.remove(p);
                return;
            }
        }
        throw new ProdutoNaoExisteException("Cliente não existe.");

    }


    @Override
    public List<Produto> getProdutos() {
        return produtosList;
    }


    public StringBuilder mostrarProdutos(){
        StringBuilder mensagem = new StringBuilder();
        for (Produto p: produtosList){
            mensagem.append(p.toString());
        }
        return mensagem;
    }


    public Produto getProdutoByID(int id) throws ProdutoNaoExisteException {
        for (Produto p: produtosList){
            if (p.getId() == id){
                return p;
            }
        }
        throw new ProdutoNaoExisteException("Cliente não existe no sistema");
    }
}
