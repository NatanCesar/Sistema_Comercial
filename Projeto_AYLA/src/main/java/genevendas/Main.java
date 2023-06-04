package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.exceptions.ProdutoJaExisteException;
import genevendas.persistencia.GravadorDeClientes;
import genevendas.persistencia.GravadorDeProdutos;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClienteJaExisteException, ProdutoJaExisteException {


        SistemaClientesInterface sistemaClientes = new ClientesList();
        SistemaProdutosInterface sistemaProdutos = new ProdutosList();
        GravadorDeClientes gravadorClientes = new GravadorDeClientes();
        GravadorDeProdutos gravadorProdutos = new GravadorDeProdutos();


        /* RECUPERAR CLIENTES */
        try {
            List<Cliente> recuperarListCLiente = gravadorClientes.recuperaClientes();
            for (Cliente c : recuperarListCLiente) {
                sistemaClientes.cadastrarCliente(c);
            }
            JOptionPane.showMessageDialog(null, "Clientes Recuperados com Sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar dados de nenhum Cliente.");
        }

        /* RECUPERA PRODUTO */
        try {
            List<Produto> recuperaListProduto = gravadorProdutos.recuperaProdutos();
            for (Produto p : recuperaListProduto) {
                sistemaProdutos.cadastrarProduto(p);
            }
            JOptionPane.showMessageDialog(null, "Produtos Recuperados com Sucesso!");
        } catch (IOException IO) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar dados de nenhum produto.");
        }



            /* CRIAÇÂO DO CLIENTE:*/
            String nomeC = JOptionPane.showInputDialog("Qual o nome do cliente? ");
            Cliente cliente = new Cliente(nomeC, sistemaClientes.getClientes().size());
            sistemaClientes.cadastrarCliente(cliente); /* AQUI TERIA UM TRY CATCH*/



            /* CRIAÇÃO DO PRODUTO:*/
            String nomeP = JOptionPane.showInputDialog("Nome do produto: ");
            double valorP = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: "));
            String tipoP = JOptionPane.showInputDialog("Tipo do produto: ");
            Produto produto = new Produto(nomeP, valorP, sistemaProdutos.getProdutos().size(), tipoP);
            sistemaProdutos.cadastrarProduto(produto);




            /* GRAVA CLIENTES */
            try {
                gravadorClientes.gravaClientes(sistemaClientes.getClientes());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados dos clientes");
            }

            /* GRAVA PRODUTOS */
            try {
                gravadorProdutos.gravaProduto(sistemaProdutos.getProdutos());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados dos produtos");
            }





            /*OUTPUT*/
            for (Cliente c : sistemaClientes.getClientes()) {
                JOptionPane.showMessageDialog(null, "CLIENTES ---->");
                JOptionPane.showMessageDialog(null, c);
            }

            for (Produto p : sistemaProdutos.getProdutos()) {
                JOptionPane.showMessageDialog(null, "PRODUTOS ---->");
                JOptionPane.showMessageDialog(null, p.toString());
            }




    }
}
