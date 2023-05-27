package sistema.projeto;

import sistema.projeto.exceptions.ClienteJaExisteException;
import sistema.projeto.exceptions.ClienteNaoExisteException;

import java.util.List;

public interface SistemaClientes_Interface {
    /**
     *
     * @param cliente cliente que vai ser cadastrado no sistema
     * @throws ClienteJaExisteException lança exceção quando já existe o cliente no sistema
     */
    void cadastrarCliente (Cliente cliente) throws ClienteJaExisteException;


    /**
     *
     * @param nome nome do cliente
     * @param id id (HashCode) do cliente
     * @throws ClienteNaoExisteException lança exceção quando o cliente tentado não existe no sistema
     */
    void apagarCliente (String nome, String id) throws ClienteNaoExisteException;


    /**
     *
     * @return retorna uma lista com todos os clientes
     */
    List<Cliente> getClientes ();


}
