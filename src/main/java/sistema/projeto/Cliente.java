package sistema.projeto;

import java.util.Objects;

public class Cliente {
    private String nome;
    private int id;
    private double valorDaConta;

    public Cliente(String nome){
        this.nome = nome;
        this.id = this.hashCode();
        this.valorDaConta = 0.0;
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
}
