package genevendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nome;
    private int id;
    private double valorDaConta;
    private List<Produto> produtosAdquiridos;

    public Cliente(String nome, int ID){
        this.nome = nome;
        this.id = ID;
        this.valorDaConta = 0.0;
        this.produtosAdquiridos = new ArrayList<Produto>();
    }
    public Cliente(String nome, int ID, double valorDaConta){
        this.nome = nome;
        this.id = ID;
        this.valorDaConta = valorDaConta;
        this.produtosAdquiridos = new ArrayList<>();
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



    @Override
    public String toString() {
        return this.nome + ", Valor da conta R$" + this.valorDaConta + ", Id: " +this.id + "\n";
    }
}
