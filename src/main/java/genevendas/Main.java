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




        boolean sair = false;
        while (!sair) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n1- Cadastrar novo cliente\n2- Cadastrar novo produto\n3- Apagar produto/cliente\n4- Adicionar produto ao cliente\n5- Visualizar lista de produtos e clientes\n6- Apagar conta do cliente\n7- Sair"));
            switch (opcao) {
                case 1:
                    /* CRIAÇÂO DO CLIENTE:*/
                    String nome = JOptionPane.showInputDialog("Qual o nome do cliente? ");
                    Cliente cliente = new Cliente(nome, sistemaClientes.getClientes().size());
                    try {
                        sistemaClientes.cadastrarCliente(cliente);
                        JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso.");
                    }catch (ClienteJaExisteException e){
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse cliente, verifique se ele já existe.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    /* CRIAÇÃO DO PRODUTO:*/
                    String nomeP = JOptionPane.showInputDialog("Nome do produto: ");
                    Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: "));
                    String tipo = JOptionPane.showInputDialog("Tipo do produto: ");
                    Produto produto = new Produto(nomeP, valor, sistemaProdutos.getProdutos().size(), tipo);
                    try {
                        sistemaProdutos.cadastrarProduto(produto);
                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
                    }catch (ProdutoJaExisteException e){
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse produto, verifique se ele já existe.");
                        e.printStackTrace();
                    }
                    break;
                case 3:


                case 7:
                    sair = true;
                    break;

            }
        }


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
