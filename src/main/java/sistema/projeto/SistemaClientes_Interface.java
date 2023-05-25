package sistema.projeto;

import java.util.List;

public interface SistemaClientes_Interface {
    /**
     *
     * @param cliente cliente que vai ser cadastrado no sistema
     * @throws Exception lança exceção quando já existe o cliente no sistema
     */
    void cadastrarCliente (Cliente cliente) throws Exception;


    /**
     *
     * @param nome nome do cliente
     * @param id id (HashCode) do cliente
     * @throws Exception lança exceção quando o cliente tentado não existe no sistema
     */
    void apagarCliente (String nome, String id) throws Exception;


    /**
     *
     * @return retorna uma lista com todos os clientes
     */
    List<Cliente> getClientes ();


}
