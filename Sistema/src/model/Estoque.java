package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import javax.swing.DefaultListModel;

public class Estoque {

    private static Estoque instancia;

    private ArrayList<Produto> produtos;
    private HashSet<DefaultListModel> listModels;

    private Estoque() {
        produtos = new ArrayList<>();
        listModels = new HashSet<>();

        seed();
    }

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public ArrayList<Produto> buscaProdutos(String nome) {
        ArrayList<Produto> retorno = new ArrayList<>();

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                retorno.add(produto);
            }
        }

        return retorno;
    }

    public void adicionaProduto(Produto p) {

        //if buscaProduto()
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    public void updateListModel(DefaultListModel<Produto> produtosListModel) {
        produtosListModel.removeAllElements();
        // Adiciono os produtos do estoque no list model
        for (Produto produto : this.produtos) {
            produtosListModel.addElement(produto);
        }

        this.listModels.add(produtosListModel);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
        for (DefaultListModel listModel : this.listModels) {
            listModel.removeElement(produto);
        }
    }

    public void salvaProduto(Produto produto) {
        int i = this.produtos.indexOf(produto);
        // Se o produto não existir, adiciona o produto na lista
        if (i < 0) {
            this.produtos.add(produto);
        } // Se não, só altera o produto
        else {
            this.produtos.set(i, produto);
        }

        for (DefaultListModel listModel : this.listModels) {
            int j = listModel.indexOf(produto);
            // Se o produto não existir, adiciona o produto na lista
            if (j < 0) {
                listModel.addElement(produto);
            } // Se não, só altera o produto
            else {
                listModel.set(j, produto);
            }
        }
    }

    public void seed() {
        String[] feira = {
            "Pêra","Uva","Maçã","Banana","Laranja","Limão",
            "Abacate","Abacaxi","Tangerina","Melancia","Cereja"
        };
        
        Random rand = new Random();
        
        for (int i = 0; i < feira.length; i++) {
            Produto produto = new Produto();
            //produto.setCodigo(Integer.toString(Math.abs(rand.nextInt()%10000)));
            produto.setCodigo(Integer.toString(i+1));
            produto.setNome(feira[i]);
            produto.setValor(rand.nextFloat()*10);
            produto.setQuantidade(Math.abs(rand.nextInt()%100));
            produto.setTipoQuantidade(Produto.TIPO_QUILO);
            produto.setDescricao("");
            
            this.produtos.add(produto);
        }
    }
}
