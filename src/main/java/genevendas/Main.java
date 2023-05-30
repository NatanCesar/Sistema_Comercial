package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.persistencia.GravadorDeClientes;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClienteJaExisteException {

        SistemaClientesInterface sistemaClientes = new ClientesList();

        GravadorDeClientes gravadorClientes = new GravadorDeClientes();
        try{
            List<Cliente> clientesList = gravadorClientes.recuperaClientes();
            JOptionPane.showMessageDialog(null,sistemaClientes.getClientes());
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Não foi possível recuperar dados de nenhum Cliente.");
        }


        String nome = JOptionPane.showInputDialog("Nome do cliente: ");
        Cliente c = new Cliente(nome);
        sistemaClientes.cadastrarCliente(c);


        gravadorClientes.gravaClientes(sistemaClientes.getClientes());

    }
}
