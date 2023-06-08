package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.exceptions.ClienteNaoExisteException;
import genevendas.exceptions.ProdutoJaExisteException;
import genevendas.exceptions.ProdutoNaoExisteException;
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
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n\n1 - Cadastrar novo cliente\n2 - Cadastrar novo produto\n3 - Apagar produto ou cliente\n4 - Adicionar produto ao cliente\n5 - Visualizar lista de produtos \n6 - Visualizar lista de clientes \n7 - Pagar conta do cliente\n\n8 - Salvar e sair\n\n"));
            switch (opcao) {
                case 1 -> {
                    /* CRIAÇÂO DO CLIENTE:*/
                    String nome = JOptionPane.showInputDialog("Qual o nome do cliente? ");
                    Cliente cliente = new Cliente(nome, sistemaClientes.getClientes().size());
                    if (sistemaClientes.IdJaExistente(cliente)){
                        cliente.setId(cliente.getId() + 1);
                    }
                    try {
                        sistemaClientes.cadastrarCliente(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
                    } catch (ClienteJaExisteException e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse cliente, verifique se ele já existe.");
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    /* CRIAÇÃO DO PRODUTO:*/
                    String nomeP = JOptionPane.showInputDialog("Nome do produto: ");
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: "));
                    String tipo = JOptionPane.showInputDialog("Tipo do produto: ");
                    Produto produto = new Produto(nomeP, valor, sistemaProdutos.getProdutos().size(), tipo);
                    try {
                        sistemaProdutos.cadastrarProduto(produto);
                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
                    } catch (ProdutoJaExisteException e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse produto, verifique se ele já existe.");
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    boolean continuar = true;
                    while (continuar) {

                        int deletar = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da opção desejada:\n1- Deletar cliente\n2- Deletar produto\n3- Voltar"));

                        if (deletar == 1) {
                            int idClienteDeletar = Integer.parseInt(JOptionPane.showInputDialog(null, sistemaClientes.mostrarClientes() + "\nInfome o ID de quem deseja apagar da lista de clientes: "));

                            try {
                                sistemaClientes.apagarCliente(idClienteDeletar);
                                JOptionPane.showMessageDialog(null, "Cliente deletado");
                            } catch (ClienteNaoExisteException e) {
                                JOptionPane.showMessageDialog(null, "Não foi possível deletar esse cliente. Verifique se ele realmente existe no sistema.");
                                e.printStackTrace();

                            }

                        } else if (deletar == 2) {
                            int idProdutoDeletar = Integer.parseInt(JOptionPane.showInputDialog(null, sistemaProdutos.mostrarProdutos() + "\nInfome o ID de quem deseja apagar da lista de produtos: "));

                            try {
                                sistemaProdutos.apagarProduto(idProdutoDeletar);
                                JOptionPane.showMessageDialog(null, "Produto deletado");
                            } catch (ProdutoNaoExisteException e) {
                                JOptionPane.showMessageDialog(null, "Não foi possível deletar esse produto. Verifique se ele realmente existe no sistema.");
                                e.printStackTrace();

                            }


                        } else if (deletar == 3) {
                            continuar = false;
                        } else {
                            JOptionPane.showMessageDialog(null, "Tente denovo e digite corretamente");
                        }
                    }
                }
                case 4 -> {
                    Cliente clienteCompra = null;
                    Produto produtoCompra = null;

                    int idClienteCompra = Integer.parseInt(JOptionPane.showInputDialog(null,sistemaClientes.mostrarClientes()+ "\nDigite o id do cliente que deseja adicionar produto: "));

                    try{
                        clienteCompra = sistemaClientes.getClienteByID(idClienteCompra);
                    } catch (ClienteNaoExisteException c){
                        JOptionPane.showMessageDialog(null,"Nenhum cliente com o id informado foi encontrado.");
                        c.printStackTrace();
                    }

                    int idProdutoCompra = Integer.parseInt(JOptionPane.showInputDialog(null, sistemaProdutos.mostrarProdutos()+ "\nDigite o id do produto que deseja adionar ao cliente: "));

                    try{
                        produtoCompra = sistemaProdutos.getProdutoByID(idProdutoCompra);
                    } catch (ProdutoNaoExisteException p){
                        JOptionPane.showMessageDialog(null,"Nenhum produto com o id informado foi encontrado.");
                    }

                    if (clienteCompra != null && produtoCompra != null){
                        clienteCompra.adquirirProduto(produtoCompra);
                        JOptionPane.showMessageDialog(null, "Produto Adquirido com sucesso!");
                    }


                }

                case 5 ->
                        JOptionPane.showMessageDialog(null,sistemaProdutos.mostrarProdutos());

                case 6 ->
                    JOptionPane.showMessageDialog(null,sistemaClientes.mostrarClientes());

                case 7 -> {

                    Cliente clienteApagar = null;
                    int idClientePagar = Integer.parseInt(JOptionPane.showInputDialog(null,sistemaClientes.mostrarClientes()+ "\nDigite o id do cliente que deseja pagar: "));
                    int valorAbater = Integer.parseInt(JOptionPane.showInputDialog(null,"Qual valor o cliente deseja abater da sua conta? "));

                    try {
                        clienteApagar = sistemaClientes.getClienteByID(idClientePagar);
                        clienteApagar.setValorDaConta(clienteApagar.getValorDaConta() - valorAbater);
                        JOptionPane.showMessageDialog(null,"Conta paga com sucesso, novo valor da conta do cliente: " + clienteApagar.getValorDaConta());
                    } catch (ClienteNaoExisteException c){
                        JOptionPane.showMessageDialog(null,"Não existe nenhum cliente com o ID digitado.");
                    }


                }

                case 8 -> sair = true;
            }
        }


        /* GRAVA CLIENTES */
        try {
            gravadorClientes.gravaClientes(sistemaClientes.getClientes());
            JOptionPane.showMessageDialog(null,"Dados dos clientes salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados dos clientes");
        }

        /* GRAVA PRODUTOS */
        try {
            gravadorProdutos.gravaProduto(sistemaProdutos.getProdutos());
            JOptionPane.showMessageDialog(null,"Dados dos produtos salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados dos produtos");
        }


    }
}
