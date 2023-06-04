package genevendas.exceptions;

public class ProdutoJaExisteException extends Exception {
    public ProdutoJaExisteException(String mensagem) {
        super(mensagem);
    }
}
