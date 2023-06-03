package genevendas.persistencia;

import genevendas.Cliente;
import genevendas.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeClientes {
    private String arquivoClientes = "clientes.txt";
    private GravadorDeDados gravador;

    public GravadorDeClientes(){
        this.gravador = new GravadorDeDados();
    }

    public void gravaClientes(List<Cliente> clienteList, List<Produto> produtosAdquiridos) throws IOException {
        List<String> textoAGravar = new ArrayList<>();
        String linhaInteira = "";
        for (Cliente c : clienteList){
            linhaInteira = c.getNome()+"###"+c.getId()+"###"+c.getValorDaConta()+"###";

        }
        for (Produto p : produtosAdquiridos) {
            linhaInteira += p.getNome()+"###"+p.getValor()+"###";
        }
        textoAGravar.add(linhaInteira);
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
