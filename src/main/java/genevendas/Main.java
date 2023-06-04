package genevendas;

import genevendas.exceptions.ClienteJaExisteException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClienteJaExisteException {

        ProdutosList produtosList = new ProdutosList();
        ClientesList clientesList = new ClientesList();

        /* CRIAÇÂO DO CLIENTE:*/
        String nomeC = JOptionPane.showInputDialog("Qual o nome do cliente? ");

        Cliente cliente = new Cliente(nomeC);
        clientesList.cadastrarCliente(cliente); /* AQUI TERIA UM TRY CATCH*/



        /* CRIAÇÃO DO PRODUTO:*/
        String nomeP = JOptionPane.showInputDialog("Nome do produto: ");
        Double valorP = Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: "));
        String tipoP = JOptionPane.showInputDialog("Tipo do produto: ");

        Produto produto = new Produto(nomeP,valorP,tipoP);
        produtosList.cadastrarProduto(produto); /* AQUI TERIA UM TRY CATCH*/



        /*ADICIONANDO PRODUTO AO CLIENTE*/
        /* No sistema final vai ser feito pergutando qual cliente e qual produto, nesse caso
         vou fazer com oq tem ai já msm
         */
        cliente.adquirirProduto(produto);



        JOptionPane.showMessageDialog(null,cliente.toString());





    }
}
