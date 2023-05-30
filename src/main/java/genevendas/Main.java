package genevendas;

import genevendas.persistencia.GravadorDeClientes;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SistemaClientesInterface sistemaClientes = new ClientesList();

        GravadorDeClientes gravadorClientes = new GravadorDeClientes();
        try{
            List<Cliente> clientesList = gravadorClientes.recuperaClientes();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Não foi possível recuperar dados de nenhum Cliente.");
        }
    }
}
