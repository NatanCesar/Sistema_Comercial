package sistema.projeto;

import java.util.Objects;

public class Produto {

    private String nome;
    private double valor;
    private int id;
    private String tipoProduto;

    public Produto(String nome, double valor, String tipoProduto) {
        this.nome = nome;
        this.valor = valor;
        this.tipoProduto = tipoProduto;
        this.id = this.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (Double.compare(produto.valor, valor) != 0) return false;
        if (!Objects.equals(nome, produto.nome)) return false;
        return Objects.equals(tipoProduto, produto.tipoProduto);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nome != null ? nome.hashCode() : 0;
        temp = Double.doubleToLongBits(valor);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (tipoProduto != null ? tipoProduto.hashCode() : 0);
        return result;
    }
}
