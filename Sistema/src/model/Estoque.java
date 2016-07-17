package model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author User
 */
public class Estoque implements ListDataListener{

    private static Estoque instancia;

    private ArrayList<Produto> produtos;

    private Estoque() {
        produtos = new ArrayList<>();   
    }

    public static Estoque getInstancia() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }

    public ArrayList<Produto> buscaProdutos(String nome) {
        ArrayList<Produto> retorno = new ArrayList<>();
        
        for(Produto produto : produtos){
            if(produto.getNome().equals(nome)){
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
        // Criar o listmodel dentro do estoque e instancia única
        // Passar essa instancia para as views
        // Deixar essa lógica encapsulada no estoque
        
        for(Produto produto : this.produtos){
            produtosListModel.addElement(produto);
        }
        
        // Altera o estoque quando muda
        produtosListModel.addListDataListener(this);
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
