package genevendas;

import genevendas.exceptions.ClienteJaExisteException;
import genevendas.exceptions.ClienteNaoExisteException;

import java.util.List;

public interface SistemaClientesInterface {
    /**
     * @param cliente cliente que vai ser cadastrado no sistema
     * @throws ClienteJaExisteException lança exceção quando já existe o cliente no sistema
     */
    void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException;

    /**
     * @param nome nome do cliente
     * @param id   id do cliente
     * @throws ClienteNaoExisteException lança exceção quando o cliente tentado não existe no sistema
     */
    void apagarCliente(String nome, String id) throws ClienteNaoExisteException;


    /**
     * @return retorna uma lista com todos os clientes
     */
    List<Cliente> getClientes();







}
