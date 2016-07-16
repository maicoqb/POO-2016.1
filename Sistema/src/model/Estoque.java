package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class Estoque {

    private static Estoque instancia;

    private HashMap<Produto, Integer> produtos;

    private Estoque() {
        produtos = new HashMap<>();   
    }

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public ArrayList<Produto> buscaProdutos(String nome) {
        ArrayList<Produto> retorno = new ArrayList<>();
        
        for(Produto produto : produtos.keySet()){
            if(produto.getNome().equals(nome)){
                retorno.add(produto);
            }
        }
        
        return retorno;
    }

    public void adicionaProduto(Produto p) {

        //if buscaProduto()
    }

}
