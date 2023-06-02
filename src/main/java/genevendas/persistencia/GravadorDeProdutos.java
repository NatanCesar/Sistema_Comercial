package genevendas.persistencia;
import genevendas.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeProdutos {

    private String arquivosProduto = "produtos.txt";
    private GravadorDeDados gravador;

    public GravadorDeProdutos() {
        this.gravador = new GravadorDeDados();
    }

    public void gravaProduto(List<Produto> produtoList)
        throws IOException{
        List<String> textoGravar = new ArrayList<>();
        for(Produto p : produtoList) {
            String criarLinha = p.getNome()+"###"+p.getValor()+"###"+p.getId()+"###"+p.getTipoProduto();
            textoGravar.add(criarLinha);
        }
        this.gravador.gravaTextoEmArquivo(textoGravar, arquivosProduto);
    }

    public List<Produto> recuperaProdutos()
        throws IOException {
        List<String> dadosProdutos = this.gravador.recuperaTextoDeArquivo(arquivosProduto);
        List<Produto> produtosList = new ArrayList<>();
        for(String s : dadosProdutos) {
            String [] dados = s.split("###");
            Produto produto = new Produto(dados[0], Double.parseDouble(dados[1]), dados[3]);
            produtosList.add(produto);
        }
        return produtosList;
    }
}
