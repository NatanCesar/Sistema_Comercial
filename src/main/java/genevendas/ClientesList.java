package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.exceptions.ClienteNaoExisteException;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
    public void apagarCliente(int id) throws ClienteNaoExisteException {

        for (Cliente c : this.clientesList) {
            if (c.getId() == id) {
                this.clientesList.remove(c);
                return;
            }
        }
        throw new ClienteNaoExisteException("Cliente não existe.");

    }

    @Override
    public List<Cliente> getClientes() {
        return clientesList;
    }


    public boolean clienteJaExiste(Cliente cliente){
        for (Cliente c: this.clientesList){
            if (c.equals(cliente)){
                return true;
            }
        }
        return false;
    }

    public StringBuilder mostrarClientes(){
        StringBuilder mensagem = new StringBuilder();
        for (Cliente c: clientesList){
            mensagem.append(c.toString());
        }
        return mensagem;
    }

    public Boolean IdJaExistente (Cliente clienteTeste){
        for (Cliente c: this.clientesList){
            if (c.getId() == clienteTeste.getId()){
                return true;
            }
        }
        return false;
    }

    public Cliente getClienteByID(int id) throws ClienteNaoExisteException{
        for (Cliente c: clientesList){
            if (c.getId() == id){
                return c;
            }
        }
        throw new ClienteNaoExisteException("Cliente não existe no sistema");
    }
}



