package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.exceptions.ClienteNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class ClientesList implements SistemaClientesInterface {

    private List<Cliente> clientesList;


    public ClientesList (){
        this.clientesList = new ArrayList<Cliente>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException {
        if (clienteJaExiste(cliente)){
            throw new ClienteJaExisteException("Cliente já existe no Sistema");
        } else {
            clientesList.add(cliente);
        }


    }

    @Override
    public void apagarCliente(String nome, String id) throws ClienteNaoExisteException {
        /*TODO*/
    }

    @Override
    public List<Cliente> getClientes() {
        return clientesList;
    }


    @Override
    public void carregarClientes(List<Cliente> clienteList) throws ClienteJaExisteException {
        this.clientesList = clienteList;
    }

    public boolean clienteJaExiste(Cliente cliente){
        for (Cliente c: this.clientesList){
            if (c.equals(cliente)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String stringClientes = null;
        for (Cliente c : clientesList) {
            stringClientes = c.toString() + "###";
        }
        return stringClientes;
    }
}
