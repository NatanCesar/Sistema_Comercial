package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.exceptions.ClienteNaoExisteException;
import genevendas.exceptions.ProdutoNaoExisteException;

import java.util.List;

public interface SistemaClientesInterface {

    /**
     * @param cliente cliente que vai ser cadastrado no sistema
     * @throws ClienteJaExisteException lança exceção quando já existe o cliente no sistema
     */
    void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException;



    /**
     * @param id   id do cliente que deseja apagar
     * @throws ClienteNaoExisteException lança exceção quando o cliente tentado não existe no sistema
     */
    void apagarCliente(int id) throws ClienteNaoExisteException;



    /**
     * @return retorna uma lista com todos os clientes
     */
    List<Cliente> getClientes();


    /**
     *
     * @return uma string com informações de todos os clientes
     */
    StringBuilder mostrarClientes();


    /**
     *
     * @param clienteTeste recebe um cliente novo para testar
     * @return retorna true caso já existe um id igual ao do cliente teste no sistema e false caso não exista
     */
    Boolean IdJaExistente (Cliente clienteTeste);


    /**
     *
     * @param id id do cliente  que deseja buscar
     * @return retorna o cliente com o id correspondente
     * @throws ClienteNaoExisteException lança exceção caso não exista nenhum cliente com o id informado
     */
    Cliente getClienteByID(int id) throws ClienteNaoExisteException;



}
