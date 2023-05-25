package sistema.projeto;

import java.util.ArrayList;
import java.util.List;

public class ClientesList implements SistemaClientes_Interface {
    private List<Cliente> clientesList;


    public ClientesList (){
        this.clientesList = new ArrayList<Cliente>();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) throws Exception {
        /*TODO*/

    }

    @Override
    public void apagarCliente(String nome, String id) throws Exception {
        /*TODO*/
    }

    @Override
    public List<Cliente> getClientes() {
        return clientesList;
    }
}
