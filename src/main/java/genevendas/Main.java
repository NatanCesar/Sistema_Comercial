package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.persistencia.GravadorDeClientes;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClienteJaExisteException {

        String Fnome = "NAT";
        SistemaClientesInterface sistemaClientes = new ClientesList();
        GravadorDeClientes gravadorClientes = new GravadorDeClientes();
        SistemaProdutosInterface sistemaProdutos = new ProdutosList();

        try{
            List<Cliente> recuperaListCliente = gravadorClientes.recuperaClientes();
            for (Cliente c: recuperaListCliente){
                sistemaClientes.cadastrarCliente(c);
                JOptionPane.showMessageDialog(null,c.getNome());

            }
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Não foi possível recuperar dados de nenhum Cliente.");
        }


        String nome = JOptionPane.showInputDialog("Nome do cliente: ");
        Double valorDaConta = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da conta: "));

        int quantProdutos = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produtos: "));

        List<Produto> produtosAdiquiridosPeloCliente = new ArrayList<>();
        for(int k=0; k < quantProdutos; k++) {
            String nomeProduto = JOptionPane.showInputDialog("Nome do produto: ");
            Double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto: "));
            String tipoProduto = JOptionPane.showInputDialog("Tipo do produto: ");
            Produto p = new Produto(nomeProduto, valorProduto, tipoProduto);
            produtosAdiquiridosPeloCliente.add(p);
        }


        Cliente c = new Cliente(nome, valorDaConta, produtosAdiquiridosPeloCliente);
        sistemaClientes.cadastrarCliente(c);

        String produtosCliente = c.getProdutosAdquiridos(produtosAdiquiridosPeloCliente);


        gravadorClientes.gravaClientes(sistemaClientes.getClientes(),produtosAdiquiridosPeloCliente);

    }
}
