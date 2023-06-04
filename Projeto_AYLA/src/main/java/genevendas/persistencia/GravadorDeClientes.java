package genevendas.persistencia;
import genevendas.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeClientes {
    private String arquivoClientes = "clientes.txt";
    private GravadorDeDados gravador;

    public GravadorDeClientes(){
        this.gravador = new GravadorDeDados();
    }

    public void gravaClientes(List<Cliente> clienteList) throws IOException {
        List<String> textoAGravar = new ArrayList<>();
        for (Cliente c: clienteList){
            String linha = c.getNome()+"###"+c.getId()+"###"+c.getValorDaConta();
            textoAGravar.add(linha);
        }
        this.gravador.gravaTextoEmArquivo(textoAGravar,this.arquivoClientes);
    }


    public List<Cliente> recuperaClientes() throws IOException{
        List<String> dadosDosClientes = this.gravador.recuperaTextoDeArquivo(this.arquivoClientes);
        List<Cliente> clienteList = new ArrayList<>();
        for (String s: dadosDosClientes){
            String [] dados = s.split("###");
            Cliente cliente = new Cliente(dados[0],Integer.parseInt(dados[1]),Double.parseDouble(dados[2]));
            clienteList.add(cliente);
        }
        return clienteList;
    }

}
