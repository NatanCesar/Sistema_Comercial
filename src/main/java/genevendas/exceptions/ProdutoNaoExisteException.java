package genevendas.exceptions;

public class ProdutoNaoExisteException extends Exception {
    public ProdutoNaoExisteException(String mensagem) {
        super(mensagem);
    }
}
