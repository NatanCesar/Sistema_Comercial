package genevendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nome;
    private int id;
    private double valorDaConta;
    private List<Produto> produtosAdquiridos;

    public Cliente(String nome){
        this.nome = nome;
        this.id = this.hashCode();
        this.valorDaConta = 0.0;
        this.produtosAdquiridos = new ArrayList<Produto>();
    }
    public Cliente(String nome, int id, double valorDaConta){
        this.nome = nome;
        this.id = id;
        this.valorDaConta = valorDaConta;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        return Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
    public void adquirirProduto(Produto produto){
                this.produtosAdquiridos.add(produto);
                this.valorDaConta += produto.getValor();
            }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorDaConta() {
        return valorDaConta;
    }

    public void setValorDaConta(double valorDaConta) {
        this.valorDaConta = valorDaConta;
    }

    public String getProdutosAdquiridos() {
        String produtosString = null;
        for (Produto p : produtosAdquiridos) {
            produtosString = p.getNome() + "!!!" + p.getId() + "!!!" + p.getTipoProduto() + "!!!" + p.getValor();
        }
        return produtosString;
    }


    @Override
    public String toString() {
        /*TODO*/
        return "" + this.nome;
    }
}
