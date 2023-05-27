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
        if (clienteRepetido(cliente)){
            throw new Exception("Cliente já existe no Sistema");
        }
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

    public boolean clienteRepetido(Cliente cliente){
        for (Cliente c: this.clientesList){
            if (c.equals(cliente)){
                return true;
            }
        }
        return false;
    }
}
